/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpiprogramacionii.entities;

/**
 *
 * @author jnowell
 */
public abstract class Base {
    private long id;
    private Boolean eliminado;

    public Base(long id, Boolean eliminado) {
        this.id = id;
        this.eliminado = eliminado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }

    public Base() {
    }
    
}
