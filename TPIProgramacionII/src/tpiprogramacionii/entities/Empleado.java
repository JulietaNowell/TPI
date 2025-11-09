/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpiprogramacionii.entities;

/**
 *
 * @author jnowell
 */

public class Empleado extends Base {
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private localdate fechaIngreso;
    private String area;
    private Legajo legajo;

    private static class localdate {

        public localdate() {
        }
    }
}
