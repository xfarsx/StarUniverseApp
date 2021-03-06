package br.com.digitalhouse.staruniverse.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.interfaces.RecyclerViewClickListenerFilmes1;
import br.com.digitalhouse.staruniverse.model.Favoritos.Favoritos;

public class FavoritosAdapter extends RecyclerView.Adapter<FavoritosAdapter.ViewHolder> {

    private List<Favoritos> listaFavoritos;
    private RecyclerViewClickListenerFilmes1 listener;


    public FavoritosAdapter(List<Favoritos> filmeFavotitos, RecyclerViewClickListenerFilmes1 listener) {
        this.listaFavoritos = filmeFavotitos;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recyclerview_favoritos, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final Favoritos novoFavorito = listaFavoritos.get(i);
        viewHolder.textViewTipoFavorito.setText(novoFavorito.getTipoFavorito());
        viewHolder.bind(novoFavorito);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(novoFavorito);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaFavoritos.size();
    }

    public void update(List<Favoritos> listaFavoritos) {
        this.listaFavoritos = listaFavoritos;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewFilmeNome;
        private TextView textViewTipoFavorito;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewFilmeNome = itemView.findViewById(R.id.textViewFavoritoNome);
            textViewTipoFavorito = itemView.findViewById(R.id.textViewTipoFavorito);
        }

        public void bind(Favoritos filmeAdapter) {
            textViewTipoFavorito.setText(filmeAdapter.getTipoFavorito());

            if (filmeAdapter.getTipoFavorito().equals("Nave")) {
                textViewFilmeNome.setText(filmeAdapter.getNaveFavorita().getName());
            }
            if (filmeAdapter.getTipoFavorito().equals("Filme")) {
                textViewFilmeNome.setText(filmeAdapter.getFilmeFavorito().getTitle());
            }
            if (filmeAdapter.getTipoFavorito().equals("Personagem")) {
                textViewFilmeNome.setText(filmeAdapter.getPersonagemFavorito().getName());
            }
        }
    }

}
