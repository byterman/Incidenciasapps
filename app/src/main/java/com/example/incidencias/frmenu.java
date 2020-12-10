package com.example.incidencias;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link frmenu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class frmenu extends Fragment {

    public frmenu() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fMenu = inflater.inflate(R.layout.fragment_frmenu, container, false);

        Button btnafegir = fMenu.findViewById(R.id.btnanadir);
        btnafegir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Log.i("proves","button afegir click");
                FragmentManager menuManager = getFragmentManager();
                FragmentTransaction menuTransaction= menuManager.beginTransaction();

                Fragment anadirincidencias = new anadirincidencias();

                menuTransaction.replace(R.id.fragment_menu, anadirincidencias);

                menuTransaction.commit();
            }
        });

        Button btnlista = fMenu.findViewById(R.id.btnlista);
        btnlista.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Log.i("proves","button afegir click");
                FragmentManager menuManager = getFragmentManager();
                FragmentTransaction menuTransaction= menuManager.beginTransaction();

                Fragment frlist = new frlist();

                menuTransaction.replace(R.id.fragment_menu, frlist);

                menuTransaction.commit();
            }
        });

        Button btninfo = fMenu.findViewById(R.id.btninfo);
        btninfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Log.i("proves","button afegir click");
                FragmentManager menuManager = getFragmentManager();
                FragmentTransaction menuTransaction= menuManager.beginTransaction();

                Fragment frinfo = new frinfo();

                menuTransaction.replace(R.id.fragment_menu, frinfo);

                menuTransaction.commit();
            }
        });



        return fMenu;
    }
}