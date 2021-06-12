package com.example.genshinimpact;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class PersonajesActivity extends AppCompatActivity {
    private PersonajeViewModel personajeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personajes);

        RecyclerView recyclerView = findViewById(R.id.recyclerviewPersonajes);
        final PersonajeListAdapter personajeListAdapter = new PersonajeListAdapter(this);

        recyclerView.setAdapter(personajeListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        personajeViewModel = new ViewModelProvider(this,
                new ViewModelProvider.AndroidViewModelFactory(getApplication()))
                .get(PersonajeViewModel.class);

        personajeViewModel.getTodosLosPersonajes().observe(this, new Observer<List<Personaje>>() {
            @Override
            public void onChanged(@Nullable final List<Personaje> personajes) {
                personajeListAdapter.setPersonajes(personajes);
            }
        });
    }
}