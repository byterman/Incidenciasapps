package com.example.incidencias;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.incidencias.DB.Incidencia;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder> {

    private ArrayList<Incidencia> arrincidencias;
    private Context context;



    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView texto, prioridad, id;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            texto=(TextView)itemView.findViewById(R.id.rvtexto);
            prioridad=(TextView)itemView.findViewById(R.id.rvprioridad);
            id=(TextView)itemView.findViewById(R.id.rvid);
        }
    }

    public List<Incidencia> incidenciaslista;

    public RecyclerViewAdaptador(Context context, ArrayList<Incidencia> incidenciaarray) {
        arrincidencias = incidenciaarray;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.disenorv,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.texto.setText(incidenciaslista.get(position).getTitulo());
        holder.prioridad.setText(incidenciaslista.get(position).getPrioridad());
    }

    @Override
    public int getItemCount() {
        return incidenciaslista.size();
    }
}
