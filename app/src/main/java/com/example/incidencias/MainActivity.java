package com.example.incidencias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.BTregistrarse);
        final EditText username = findViewById(R.id.UsernameIN);
        final EditText password = findViewById(R.id.PasswordIN);
        /*final TextView texto = findViewById(R.id.textView2);*/
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("btn clicats", "El boton de login ha sido pulsado");

                String txtusername = username.getText().toString();
                String txtpassword = password.getText().toString();

                if (txtusername.equals("") && txtpassword.equals("")) {

                    /*texto.setText("correcto");*/
                    goToMenu();
                } else {


                    /*texto.setText("incorrecto");*/


                }
            }
        });
    }

    public void goToMenu(){
        Intent intentMenu = new Intent (this, menu.class);
        startActivity(intentMenu);
    }
}