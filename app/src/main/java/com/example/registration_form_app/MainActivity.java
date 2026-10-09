package com.example.registration_form_app;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import androidx.appcompat.app.AlertDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText username=findViewById(R.id.username);
        EditText fullname=findViewById(R.id.fullname);
        EditText country=findViewById(R.id.country);
        EditText email=findViewById(R.id.email);
        EditText phonenumber=findViewById(R.id.phonenumber);
        EditText password=findViewById(R.id.password);
        Button create = findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Preberemo besedilo iz definiranih spremenljivk
                String vnesenUsername = username.getText().toString().trim();
                String vnesenFullname = fullname.getText().toString().trim();
                String vnesenCoutry = country.getText().toString().trim();
                String vnesenEmail = email.getText().toString().trim();
                String vnesenPhone = phonenumber.getText().toString().trim();
                String vnesenoGeslo = password.getText().toString();

                String sporocilo = "Uporabnik: " + vnesenUsername + "\n" +
                        "Ime in priimek: " + vnesenFullname + "\n" +
                        "Država: " + vnesenCoutry + "\n" +
                        "Email: " + vnesenEmail + "\n" +
                        "Telefon: " + vnesenPhone + "\n" +
                        "Geslo: " + vnesenoGeslo;

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Registration Details")
                        .setMessage(sporocilo)
                        .setPositiveButton("OK", null)
                        .show();
            }
        });
    }
}