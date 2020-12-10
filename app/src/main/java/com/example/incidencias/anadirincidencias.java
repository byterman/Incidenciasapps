package com.example.incidencias;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.incidencias.DB.Incidencia;
import com.example.incidencias.DB.IncidenciaDBHelper;

public class anadirincidencias extends Fragment implements AdapterView.OnItemSelectedListener{
    private IncidenciaDBHelper dbHelper;
    private SQLiteDatabase db;


    Spinner spinner;
    EditText imputtitulo;
    Button btnincidencias;
    int id=1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dbHelper = new IncidenciaDBHelper(getContext());
        db = dbHelper.getWritableDatabase();

        View fandir =  inflater.inflate(R.layout.fragment_anadirincidencias, container, false);

        imputtitulo = (EditText)fandir.findViewById(R.id.imputtitulo);
        btnincidencias = (Button)fandir.findViewById(R.id.btnincidencias);
        spinner = fandir.findViewById(R.id.inputprioridad);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        // Inflate thelayout for this fragment
        /*test*/
        final IncidenciaDBHelper incidenciaDBHelper=new IncidenciaDBHelper(requireActivity().getApplicationContext());

        btnincidencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                incidenciaDBHelper.insertIncidencia(id,imputtitulo.getText().toString(),spinner.getSelectedItem().toString());
                Toast.makeText(requireActivity().getApplicationContext(), "Se ha añadido con exito",Toast.LENGTH_SHORT).show();

                 */
                String prioridad,texto;
                
                prioridad = spinner.getSelectedItem().toString();
                texto = imputtitulo.getText().toString();

                comprobacion(texto);
                if (texto.length() > 0){
                    Incidencia incidencia = new Incidencia(texto,prioridad);
                    incidenciaDBHelper.insertIncidencia(db, incidencia);
                }
            }
        });
        return fandir;

    }

    @Override
    public void onDestroy() {
        dbHelper.close();
        db.close();
        super.onDestroy();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    public void comprobacion(String descripcion){
        AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
        if (descripcion.length() > 0){
            alertDialog.setTitle(getResources().getString(R.string.alerta_titulo));

        }else{
            alertDialog.setTitle(getResources().getString(R.string.alerta_titulo_error));
            alertDialog.setMessage(getResources().getString(R.string.alert_mensaje_error));
        }
    }
    

}
