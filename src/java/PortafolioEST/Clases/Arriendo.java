/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PortafolioEST.Clases;

/**
 *
 * @author Alberto
 */
public class Arriendo {

    private int estCuenta_id;
    private String user;
    private String hora_i;
    private String hora_f;
   

    public Arriendo() {
    }

    public Arriendo(int estCuenta_id, String user, String hora_i, String hora_f) {
        this.estCuenta_id = estCuenta_id;
        this.user = user;
        this.hora_i = hora_i;
        this.hora_f = hora_f;
    }

    public int getEstCuenta_id() {
        return estCuenta_id;
    }

    public void setEstCuenta_id(int estCuenta_id) {
        this.estCuenta_id = estCuenta_id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getHora_i() {
        return hora_i;
    }

    public void setHora_i(String hora_i) {
        this.hora_i = hora_i;
    }

    public String getHora_f() {
        return hora_f;
    }

    public void setHora_f(String hora_f) {
        this.hora_f = hora_f;
    }

    

    
}
