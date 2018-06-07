package com.example.pff.segundoentregable;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecetasFragment extends Fragment implements RecetasAdapter.NotificadorRecetaCelda{

    private RecyclerView recyclerView;
    private List<Receta> recetas;
    private NotificadorReceta notificadorReceta;



    public RecetasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recetas, container, false);
        recyclerView = view.findViewById(R.id.recycler_id);
        armarListadoRecetas();
        RecetasAdapter adapter = new RecetasAdapter(recetas, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        notificadorReceta = (NotificadorReceta) context;
    }

    private void armarListadoRecetas() {
        recetas = new ArrayList<>();
        recetas.add(new Receta("Atún Rojo Asiático",R.drawable.asian_tuna2,
                "ingredientes,ingredientes,ingredientes,ingredientes," +
                        "ingredientes,ingredientes,ingredientes,ingredientes,ingredientes," +
                        "ingredientes,ingredientes,ingredientes,ingredientes,ingredientes," +
                        "ingredientes,ingredientes, ",
                "descripción,descripción,descripción,descripción,descripción," +
                        "descripción,descripción,"));
        recetas.add(new Receta("Atún b",R.drawable.asian_tuna2,"ingredientes b", "descripción b"));
        recetas.add(new Receta("Atún c",R.drawable.asian_tuna2,"ingredientes c", "descripción c"));
        }

    @Override
    public void notificarRecetaClickeada(Receta receta) {
    notificadorReceta.notificar(receta);
    }

    public interface NotificadorReceta {
        public void notificar(Receta receta);
    }
}
