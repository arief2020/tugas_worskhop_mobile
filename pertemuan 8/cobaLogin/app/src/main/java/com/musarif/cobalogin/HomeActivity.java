package com.musarif.cobalogin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    TextView halo;
    Button ig, calculator, locations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        halo = findViewById(R.id.hi);
        ig = findViewById(R.id.instagram);
        calculator = findViewById(R.id.calculator);
        locations = findViewById(R.id.location);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("user");
        halo.setText("Email: " + name);

        ig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.instagram.com/m_syaifullah_al_arief/";
                Intent implisist = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(implisist);
            }
        });

        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent incalculator = new Intent();
                incalculator.setAction(Intent.ACTION_MAIN);
                incalculator.addCategory(Intent.CATEGORY_APP_CALCULATOR);
                startActivity(incalculator);
            }
        });

        locations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lokasi = new Intent(HomeActivity.this, locationActivity.class);
                startActivity(lokasi);
            }
        });

    }
}
