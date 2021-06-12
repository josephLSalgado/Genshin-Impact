package com.example.genshinimpact;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.HashMap;
import java.util.Map;

// Se enumeran todas las entities de la app
// Solo se necesita una instancia de la base de datos Room para toda la app
@Database(entities = {Personaje.class}, version = 1, exportSchema = false)
public abstract class AppRoomDatabase extends RoomDatabase {
    // Se definen las DAOs que trabajan con la base de datos
    // Se proporciona un getter abstracto para cada DAO
    public abstract PersonajeDao personajeDao();

    private static AppRoomDatabase INSTANCE;

    // Singleton - previene que solo exista una instancia de la base de datos
    public static AppRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppRoomDatabase.class) {
                if (INSTANCE == null) {
                    // Crea un objeto RoomDatabase llamado 'base_de_datos' en el contexto de la
                    // aplicación de la clase AppRoomDatabase
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppRoomDatabase.class, "base_de_datos")
                            // Limpia y reconstruye en lugar de migrar si no hay un objeto Migration
                            .fallbackToDestructiveMigration()
                            .addCallback(roomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
            super.onOpen(supportSQLiteDatabase);
            new LlenaDbAsync(INSTANCE).execute();
        }
    };

    // Se llena la base de datos en segundo plano
    private static class LlenaDbAsync extends AsyncTask<Void, Void, Void> {
        private final PersonajeDao personajeDao;
        // Sustituir por una lista / arreglo de diccionarios
        Map<Integer, Personaje> hashMap = new HashMap<Integer, Personaje>();

        LlenaDbAsync(AppRoomDatabase appRoomDatabase) {
            personajeDao = appRoomDatabase.personajeDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {

            // Inicia la app con la base de datos siempre limpia
            // No se necesita si se llena la base de datos cuando se crea por primera vez
            personajeDao.deleteAll();

            hashMap.put(0, new Personaje("Zongli", 5, "Geo", "Lanza",
                    "Liyue", "Prithiva Topaz", "Basalt Pillar",
                    "Cor Lapis", "Gold", "Tusk",
                    "Slime"));
            hashMap.put(1, new Personaje("Xiao", 5, "Anemo", "Lanza",
                    "Liyue", "Vayuda Turquoise", "Juvenile Jade",
                    "Qingxin", "Prosperity", "Shadow",
                    "Slime"));
            hashMap.put(2, new Personaje("Bennet", 4, "Pyro", "Espada",
                    "Mondstadt", "Agnidus Agate", "Everflame Seed",
                    "Windwheel Aster", "Resistance", "Dvalin's plume",
                    "Insignia"));

            for (Map.Entry<Integer, Personaje> hm : hashMap.entrySet()) {
                Personaje personaje = hm.getValue();
                personajeDao.insert(personaje);
            }

            return null;
        }

    }
}
