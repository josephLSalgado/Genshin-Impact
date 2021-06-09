package com.example.genshinimpact;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

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
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
