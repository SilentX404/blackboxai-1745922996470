package com.luxevista.resort;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BookingActivity extends AppCompatActivity {

    private EditText edtName, edtDate, edtService;
    private Button btnSubmit;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        edtName = findViewById(R.id.edtName);
        edtDate = findViewById(R.id.edtDate);
        edtService = findViewById(R.id.edtService);
        btnSubmit = findViewById(R.id.btnSubmit);

        dbHelper = new DatabaseHelper(this);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitBooking();
            }
        });
    }

    private void submitBooking() {
        String name = edtName.getText().toString().trim();
        String date = edtDate.getText().toString().trim();
        String service = edtService.getText().toString().trim();

        if (TextUtils.isEmpty(name)) {
            edtName.setError("Name is required");
            return;
        }
        if (TextUtils.isEmpty(date)) {
            edtDate.setError("Date is required");
            return;
        }
        if (TextUtils.isEmpty(service)) {
            edtService.setError("Service is required");
            return;
        }

        boolean inserted = dbHelper.insertBooking(name, date, service);
        if (inserted) {
            Toast.makeText(this, "Booking submitted successfully", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Failed to submit booking", Toast.LENGTH_SHORT).show();
        }
    }
}
