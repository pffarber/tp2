package com.example.pff.segundoentregable;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecetasAdapter extends RecyclerView.Adapter {

    private List<Receta> recetas;
    private NotificadorRecetaCelda notificadorRecetaCelda;

    public RecetasAdapter(List<Receta> recetas, NotificadorRecetaCelda notificadorRecetaCelda){
        this.recetas = recetas;
        this.notificadorRecetaCelda = notificadorRecetaCelda;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.celda_recycler_receta, parent, false);
        ViewHolderReceta viewHolderReceta = new ViewHolderReceta (view);
        return viewHolderReceta;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Receta receta = recetas.get(position);
        ViewHolderReceta  viewHolderReceta = (ViewHolderReceta) holder;
        viewHolderReceta.cargarReceta(receta);

    }

    @Override
    public int getItemCount() {
        if (recetas != null) {
            return recetas.size();
        } else {
            return 0;
        }
    }

    public class ViewHolderReceta extends RecyclerView.ViewHolder{
        private TextView textViewTitulo;
        private ImageView imagenReceta;

        public ViewHolderReceta(View itemView) {
            super(itemView);
            textViewTitulo = itemView.findViewById(R.id.titulo_receta_id);
            imagenReceta = itemView.findViewById(R.id.imagen_receta_id);

            imagenReceta.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int posicionRecetaClickeada = getAdapterPosition();
                    Receta receta = recetas.get(posicionRecetaClickeada);
                    notificadorRecetaCelda.notificarRecetaClickeada(receta);
                }
            });
        }

        public void cargarReceta(Receta receta) {
            //el contacto que recibe deberia sacarle sus datos y pegarlos en la celda
            textViewTitulo.setText(receta.getTitulo());
            imagenReceta.setImageResource(receta.getFoto());
        }
    }

    public interface NotificadorRecetaCelda {
        public void notificarRecetaClickeada(Receta receta);
    }


}
