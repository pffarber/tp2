package com.example.pff.segundoentregable;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleRecetaFragment extends Fragment {
    public static final String RECETA_CLAVE = "Receta_clave";
    private ImageView imagenReceta;
    private TextView tituloReceta;
    private TextView ingredientesReceta;
    private TextView preparacionReceta;



    public DetalleRecetaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_detalle_receta, container, false);
        imagenReceta = view.findViewById(R.id.imagen_receta_detalle_id);
        tituloReceta = view.findViewById(R.id.titulo_receta_detalle_id);
        ingredientesReceta = view.findViewById(R.id.ingredientes_receta_detalle_id);
        preparacionReceta = view.findViewById(R.id.preparacion_receta_detalle_id);

        Bundle bundle = getArguments();
        Receta receta = (Receta) bundle.getSerializable(RECETA_CLAVE);
        imagenReceta.setImageResource(receta.getFoto());
        tituloReceta.setText(receta.getTitulo());
        ingredientesReceta.setText(receta.getIngredientes());
        preparacionReceta.setText(receta.getPreparación());

        return view;
    }

}


