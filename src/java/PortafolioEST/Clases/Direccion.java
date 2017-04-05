/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PortafolioEST.Clases;


public class Direccion {
    
    private int direccion_id;
    private int comuna_id;
    private String dir_calle;
    private String numeracion;
    private String user;
    private int valorHora;
    private String Comuna;
    private String EStadoDesc;
    private double Longitud;
    private double Latitud;

    public Direccion() {
    }

    public Direccion(int direccion_id, int comuna_id, String dir_calle, String numeracion, String user, int valorHora, String Comuna, String EStadoDesc, double Longitud, double Latitud) {
        this.direccion_id = direccion_id;
        this.comuna_id = comuna_id;
        this.dir_calle = dir_calle;
        this.numeracion = numeracion;
        this.user = user;
        this.valorHora = valorHora;
        this.Comuna = Comuna;
        this.EStadoDesc = EStadoDesc;
        this.Longitud = Longitud;
        this.Latitud = Latitud;
    }

    public int getDireccion_id() {
        return direccion_id;
    }

    public void setDireccion_id(int direccion_id) {
        this.direccion_id = direccion_id;
    }

    public int getComuna_id() {
        return comuna_id;
    }

    public void setComuna_id(int comuna_id) {
        this.comuna_id = comuna_id;
    }

    public String getDir_calle() {
        return dir_calle;
    }

    public void setDir_calle(String dir_calle) {
        this.dir_calle = dir_calle;
    }

    public String getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(String numeracion) {
        this.numeracion = numeracion;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getValorHora() {
        return valorHora;
    }

    public void setValorHora(int valorHora) {
        this.valorHora = valorHora;
    }

    public String getComuna() {
        return Comuna;
    }

    public void setComuna(String Comuna) {
        this.Comuna = Comuna;
    }

    public String getEStadoDesc() {
        return EStadoDesc;
    }

    public void setEStadoDesc(String EStadoDesc) {
        this.EStadoDesc = EStadoDesc;
    }

    public double getLongitud() {
        return Longitud;
    }

    public void setLongitud(double Longitud) {
        this.Longitud = Longitud;
    }

    public double getLatitud() {
        return Latitud;
    }

    public void setLatitud(double Latitud) {
        this.Latitud = Latitud;
    }

    
}
