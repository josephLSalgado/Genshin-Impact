package com.example.genshinimpact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class PersonajesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personajes);

        RecyclerView recyclerView = findViewById(R.id.recyclerviewPersonajes);
        final PersonajeListAdapter personajeListAdapter = new PersonajeListAdapter(this);

        recyclerView.setAdapter(personajeListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}