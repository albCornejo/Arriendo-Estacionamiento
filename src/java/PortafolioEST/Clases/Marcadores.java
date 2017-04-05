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
public class Marcadores {
    
    private int idMarcador;
    private double Longitud;
    private double Latitud;
    private int VALOR_HORA;
    private String DIR_CALLE;
    private String NUMERO;
    private String COMUNA_NOMBRE;
    private String PROVINCIA_NOMBRE;
    private int EST_CUENTA_ID;
    

    public Marcadores() {
    }

    public Marcadores(int idMarcador, double Longitud, double Latitud, int VALOR_HORA, String DIR_CALLE, String NUMERO, String COMUNA_NOMBRE, String PROVINCIA_NOMBRE, int EST_CUENTA_ID) {
        this.idMarcador = idMarcador;
        this.Longitud = Longitud;
        this.Latitud = Latitud;
        this.VALOR_HORA = VALOR_HORA;
        this.DIR_CALLE = DIR_CALLE;
        this.NUMERO = NUMERO;
        this.COMUNA_NOMBRE = COMUNA_NOMBRE;
        this.PROVINCIA_NOMBRE = PROVINCIA_NOMBRE;
        this.EST_CUENTA_ID = EST_CUENTA_ID;
    }

    public int getIdMarcador() {
        return idMarcador;
    }

    public void setIdMarcador(int idMarcador) {
        this.idMarcador = idMarcador;
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

    public int getVALOR_HORA() {
        return VALOR_HORA;
    }

    public void setVALOR_HORA(int VALOR_HORA) {
        this.VALOR_HORA = VALOR_HORA;
    }

    public String getDIR_CALLE() {
        return DIR_CALLE;
    }

    public void setDIR_CALLE(String DIR_CALLE) {
        this.DIR_CALLE = DIR_CALLE;
    }

    public String getNUMERO() {
        return NUMERO;
    }

    public void setNUMERO(String NUMERO) {
        this.NUMERO = NUMERO;
    }

    public String getCOMUNA_NOMBRE() {
        return COMUNA_NOMBRE;
    }

    public void setCOMUNA_NOMBRE(String COMUNA_NOMBRE) {
        this.COMUNA_NOMBRE = COMUNA_NOMBRE;
    }

    public String getPROVINCIA_NOMBRE() {
        return PROVINCIA_NOMBRE;
    }

    public void setPROVINCIA_NOMBRE(String PROVINCIA_NOMBRE) {
        this.PROVINCIA_NOMBRE = PROVINCIA_NOMBRE;
    }

    public int getEST_CUENTA_ID() {
        return EST_CUENTA_ID;
    }

    public void setEST_CUENTA_ID(int EST_CUENTA_ID) {
        this.EST_CUENTA_ID = EST_CUENTA_ID;
    }

   
}
