package com.example.genshinimpact;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tabla_personaje")
public class Personaje {
    @PrimaryKey
    @NonNull
    private String nombre;
    private int rareza;
    private String elemento;
    private String arma;
    private String nacion;
    @ColumnInfo(name = "material_personaje")
    private String materialPersonaje;
    @ColumnInfo(name = "piedra_elemental")
    private String piedraElemental;
    @ColumnInfo(name = "especialidad_local")
    private String especialidadLocal;
    @ColumnInfo(name = "material_talento")
    private String materialTalento;
    @ColumnInfo(name = "material_boss_semanal")
    private String materialBossSemanal;
    @ColumnInfo(name = "material_comun")
    private String materialComun;

    public Personaje(@NonNull String nombre, int rareza, String elemento, String arma,
                     String nacion, String materialPersonaje, String piedraElemental,
                     String especialidadLocal, String materialTalento, String materialBossSemanal,
                     String materialComun) {
        this.nombre = nombre;
        this.rareza = rareza;
        this.elemento = elemento;
        this.arma = arma;
        this.nacion = nacion;
        this.materialPersonaje = materialPersonaje;
        this.piedraElemental = piedraElemental;
        this.especialidadLocal = especialidadLocal;
        this.materialTalento = materialTalento;
        this.materialBossSemanal = materialBossSemanal;
        this.materialComun = materialComun;
    }

    public @NonNull String getNombre() {return this.nombre;}
    public int getRareza() {return this.rareza;}
    public String getElemento() {return this.elemento;}
    public String getArma() {return this.arma;}
    public String getNacion() {return this.nacion;}
    public String getMaterialPersonaje() {return this.materialPersonaje;}
    public String getPiedraElemental() {return this.piedraElemental;}
    public String getEspecialidadLocal() {return this.especialidadLocal;}
    public String getMaterialTalento() {return this.materialTalento;}
    public String getMaterialBossSemanal() {return this.materialBossSemanal;}
    public String getMaterialComun() {return this.materialComun;}
}
