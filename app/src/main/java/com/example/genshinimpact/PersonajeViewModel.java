package com.example.genshinimpact;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import java.util.List;

public class PersonajeViewModel extends AndroidViewModel {
    private PersonajeRepository personajeRepository;
    private List<Personaje> todosLosPersonajes;

    public PersonajeViewModel(Application application) {
        super(application);
        personajeRepository = new PersonajeRepository(application);
        todosLosPersonajes = personajeRepository.getTodosLosPersonajes();
    }

    public void insert(Personaje personaje) {
        personajeRepository.insert(personaje);
    }

    public List<Personaje> getTodosLosPersonajes() {
        return todosLosPersonajes;
    }
}
