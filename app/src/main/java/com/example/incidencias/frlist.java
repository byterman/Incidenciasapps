package com.example.incidencias;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.incidencias.DB.IncidenciaDBHelper;

public class frlist extends Fragment {
    private RecyclerView recyclerViewincidencias;
    private RecyclerViewAdaptador recyclerViewAdaptador;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View flistar =  inflater.inflate(R.layout.fragment_frlist, container, false);
        /*
        recyclerViewincidencias=(RecyclerView)flistar.findViewById(R.id.recyclelist);
        recyclerViewincidencias.setLayoutManager(new LinearLayoutManager(getContext()));

        IncidenciaDBHelper incidenciaDBHelper=new IncidenciaDBHelper(getContext());

        recyclerViewAdaptador=new RecyclerViewAdaptador( getContext(), incidenciaDBHelper.mostrarincidencias());
        recyclerViewincidencias.setAdapter(recyclerViewAdaptador);
        */

        recyclerViewincidencias = (RecyclerView)flistar.findViewById(R.id.recyclelist);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerViewincidencias.setLayoutManager(manager);
        recyclerViewincidencias.setHasFixedSize(true);

        IncidenciaDBHelper incidenciaDBHelper=new IncidenciaDBHelper(getContext());

        recyclerViewAdaptador=new RecyclerViewAdaptador( getContext(), incidenciaDBHelper.mostrarincidencias());
        recyclerViewincidencias.setAdapter(recyclerViewAdaptador);

        return inflater.inflate(R.layout.fragment_frlist, container, false);
    }
}