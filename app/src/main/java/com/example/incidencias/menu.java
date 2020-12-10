package com.example.incidencias;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.incidencias.DB.Incidencia;

import java.util.ArrayList;

public class menu extends AppCompatActivity {

    ArrayList<Incidencia> incidenciaArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }
}