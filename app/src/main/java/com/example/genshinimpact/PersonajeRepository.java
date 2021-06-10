package com.example.genshinimpact;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

public class PersonajeRepository {
    private PersonajeDao personajeDao;
    private List<Personaje> todosLosPersonajes;

    PersonajeRepository(Application application) {
        AppRoomDatabase appRoomDatabase = AppRoomDatabase.getDatabase(application);
        personajeDao = appRoomDatabase.personajeDao();
        todosLosPersonajes = personajeDao.getTodosLosPersonajes();
    }

    public List<Personaje> getTodosLosPersonajes() {
        return todosLosPersonajes;
    }

    public void insert(Personaje personaje) {
        new insertAsyncTask(personajeDao).execute(personaje);
    }

    private static class insertAsyncTask extends AsyncTask<Personaje, Void, Void> {
        private PersonajeDao asyncTaskDao;

        insertAsyncTask(PersonajeDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Personaje... params) {
            asyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
