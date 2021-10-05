package com.example.selectionwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    TextView textV, txt_makan;
    String[] makanan = {"sate", "rawon", "soto", "ramen", "sushi", "bakso", "cake"};
    ArrayAdapter<String> adapter_makanan;
    AutoCompleteTextView ac_makan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        textV = findViewById(R.id.pendTerakhir);
        ac_makan = findViewById(R.id.ac_makanan);
        txt_makan = findViewById(R.id.txt_makanan);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.pendidikan, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        adapter_makanan = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, makanan);
        ac_makan.setThreshold(1);
        ac_makan.setAdapter(adapter_makanan);

        ac_makan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                txt_makan.setText(adapter_makanan.getItem(i));
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String txt =parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), txt ,Toast.LENGTH_SHORT).show();
        textV.setText(txt);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}