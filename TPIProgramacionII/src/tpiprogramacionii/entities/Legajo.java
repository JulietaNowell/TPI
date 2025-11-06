/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpiprogramacionii.entities;

/**
 *
 * @author jnowell
 */
public class Legajo extends Base  {
    private String nroLegajo;
    private String categoria;
    private Enum estado;
    private localdate fechaAlta;
    private String observaciones;

    private static class localdate {

        public localdate() {
        }
    }
}
