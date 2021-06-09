package com.example.genshinimpact;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PersonajeDao {
    @Insert
    void insert(Personaje personaje);

    @Query("SELECT * FROM tabla_personaje ORDER BY nombre ASC")
    List<Personaje> getTodosLosPersonajes();
}
