package com.silmood.project2_fragmentssample.ui.domain;

/**
 * Created by Pedro Antonio Hernández on 01/07/2015.
 *
 */
public class Pokemon {

    String nombre;
    int atk;
    int def;
    int vel;

    public Pokemon(String nombre, int atk, int def, int vel) {
        this.nombre = nombre;
        this.atk = atk;
        this.def = def;
        this.vel = vel;
    }

    public Pokemon(String nombre) {
        this.nombre = nombre;
        this.atk = 100;
        this.def = 100;
        this.vel = 100;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getVel() {
        return vel;
    }

    public void setVel(int vel) {
        this.vel = vel;
    }


    @Override
    public String toString() {
        return "Pokemon{" +
                "nombre='" + nombre + '\'' +
                ", atk=" + atk +
                ", def=" + def +
                ", vel=" + vel +
                '}';
    }
}
