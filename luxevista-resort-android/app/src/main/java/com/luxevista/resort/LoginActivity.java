package com.luxevista.resort;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText edtEmail, edtPassword;
    private ImageView imgPasswordToggle;
    private Button btnLogin, btnRegister;
    private TextView tvForgotPassword;

    private boolean isPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        imgPasswordToggle = findViewById(R.id.imgPasswordToggle);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);

        // Password show/hide toggle
        imgPasswordToggle.setOnClickListener(v -> {
            if (isPasswordVisible) {
                edtPassword.setInputType(android.text.InputType.TYPE_CLASS_TEXT | android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD);
                imgPasswordToggle.setImageResource(R.drawable.ic_visibility_off);
            } else {
                edtPassword.setInputType(android.text.InputType.TYPE_CLASS_TEXT | android.text.InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                imgPasswordToggle.setImageResource(R.drawable.ic_visibility);
            }
            isPasswordVisible = !isPasswordVisible;
            edtPassword.setSelection(edtPassword.getText().length());
        });

        // Inline validation for email
        edtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!Patterns.EMAIL_ADDRESS.matcher(s).matches()) {
                    edtEmail.setError("Invalid email address");
                }
            }
            @Override
            public void afterTextChanged(Editable s) { }
        });

        btnLogin.setOnClickListener(v -> {
            if (validateInputs()) {
                Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                // Proceed to Home or Dashboard
            }
        });

        btnRegister.setOnClickListener(v -> {
            Toast.makeText(LoginActivity.this, "Register clicked", Toast.LENGTH_SHORT).show();
            // Navigate to Register screen or handle registration
        });

        tvForgotPassword.setOnClickListener(v -> {
            Toast.makeText(LoginActivity.this, "Forgot password clicked", Toast.LENGTH_SHORT).show();
            // Handle forgot password flow
        });
    }

    private boolean validateInputs() {
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString();

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edtEmail.setError("Invalid email address");
            return false;
        }
        if (password.isEmpty()) {
            edtPassword.setError("Password cannot be empty");
            return false;
        }
        return true;
    }
}
