package com.musarif.cobalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button masuk;
    String usernameKey, passwordKey;
    private SharedPreferences remember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        masuk = findViewById(R.id.btnLogin);
        usernameKey = username.getText().toString();

        remember = MainActivity.this.getSharedPreferences("token", Context.MODE_PRIVATE);
        String uname = remember.getString("user","kosong");
        if (uname.isEmpty()){

        }else{
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            intent.putExtra("user",usernameKey);
            startActivity(intent);
        }
        usernameKey = username.getText().toString();
        passwordKey = password.getText().toString();
        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (usernameKey.equals("msyaifullahalarief@gmail.com") && passwordKey.equals("123")){
                    SharedPreferences.Editor editor = remember.edit();
                    editor.putString("user", usernameKey);
                    editor.apply();
                    Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                    intent.putExtra("user", usernameKey);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "hai" + usernameKey, Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(MainActivity.this, "username or password invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}