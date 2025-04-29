package com.luxevista.resort;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {

    private Button btnBrowseRooms, btnBookSpa, btnReserveDining, btnPoolsideCabanas, btnPromotions, btnNearbyAttractions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBrowseRooms = findViewById(R.id.btnBrowseRooms);
        btnBookSpa = findViewById(R.id.btnBookSpa);
        btnReserveDining = findViewById(R.id.btnReserveDining);
        btnPoolsideCabanas = findViewById(R.id.btnPoolsideCabanas);
        btnPromotions = findViewById(R.id.btnPromotions);
        btnNearbyAttractions = findViewById(R.id.btnNearbyAttractions);

btnBrowseRooms.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, BrowseRoomsActivity.class);
        startActivity(intent);
    }
});

btnBookSpa.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, BookSpaActivity.class);
        startActivity(intent);
    }
});

btnReserveDining.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, ReserveDiningActivity.class);
        startActivity(intent);
    }
});

btnPoolsideCabanas.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, PoolsideCabanasActivity.class);
        startActivity(intent);
    }
});

btnPromotions.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, PromotionsActivity.class);
        startActivity(intent);
    }
});

btnNearbyAttractions.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, NearbyAttractionsActivity.class);
        startActivity(intent);
    }
});

btnHome.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
    }
});

btnBookings.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, BookingsActivity.class);
        startActivity(intent);
    }
});

btnServices.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, ServicesActivity.class);
        startActivity(intent);
    }
});

btnProfile.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
        startActivity(intent);
    }
});

        // Other buttons can have similar click listeners to navigate to respective activities
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_toggle_theme) {
            int currentNightMode = getResources().getConfiguration().uiMode & android.content.res.Configuration.UI_MODE_NIGHT_MASK;
            if (currentNightMode == android.content.res.Configuration.UI_MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
