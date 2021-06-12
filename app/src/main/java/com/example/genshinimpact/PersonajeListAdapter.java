package com.example.genshinimpact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonajeListAdapter extends RecyclerView.Adapter<PersonajeListAdapter.PersonajeViewHolder> {
    private final LayoutInflater layoutInflater;
    private List<Personaje> personajes; // Copia de los personajes en caché

    PersonajeListAdapter(Context context) {layoutInflater = LayoutInflater.from(context);}

    @Override
    public PersonajeViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = layoutInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new PersonajeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PersonajeViewHolder holder, int position) {
        if (personajes != null) {
            Personaje actual = personajes.get(position);
            holder.personajeItemView.setText(actual.getNombre());
        }

        else {
            // Cubre el caso de que los datos aún no estén listos
            holder.personajeItemView.setText("No personaje");
        }
    }

    void setPersonajes(List<Personaje> listPersonajes) {
        personajes = listPersonajes;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (personajes != null)
            return personajes.size();
        else
            return 0;
    }

    class PersonajeViewHolder extends RecyclerView.ViewHolder {
        private final Button personajeItemView;

        private PersonajeViewHolder(View itemView) {
            super(itemView);
            personajeItemView = itemView.findViewById(R.id.botonSeleccionPersonaje);
        }
    }
}
