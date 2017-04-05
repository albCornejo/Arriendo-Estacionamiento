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
public class Estacionamiento {

    private int EST_CUENTA_ID;
    private String DIR_CALLE;
    private String NUMERO;
    private String P_NOMBRE;
    private String P_APELLIDO;
    private String TELEFONO;
    private String EMAIL;
    private int VALOR_HORA;
    private int Longitud;
    private int Latitud;

    public Estacionamiento() {
    }

    public Estacionamiento(int EST_CUENTA_ID, String DIR_CALLE, String NUMERO, String P_NOMBRE, String P_APELLIDO, String TELEFONO, String EMAIL, int VALOR_HORA, int Longitud, int Latitud) {
        this.EST_CUENTA_ID = EST_CUENTA_ID;
        this.DIR_CALLE = DIR_CALLE;
        this.NUMERO = NUMERO;
        this.P_NOMBRE = P_NOMBRE;
        this.P_APELLIDO = P_APELLIDO;
        this.TELEFONO = TELEFONO;
        this.EMAIL = EMAIL;
        this.VALOR_HORA = VALOR_HORA;
        this.Longitud = Longitud;
        this.Latitud = Latitud;
    }

    public int getEST_CUENTA_ID() {
        return EST_CUENTA_ID;
    }

    public void setEST_CUENTA_ID(int EST_CUENTA_ID) {
        this.EST_CUENTA_ID = EST_CUENTA_ID;
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

    public String getP_NOMBRE() {
        return P_NOMBRE;
    }

    public void setP_NOMBRE(String P_NOMBRE) {
        this.P_NOMBRE = P_NOMBRE;
    }

    public String getP_APELLIDO() {
        return P_APELLIDO;
    }

    public void setP_APELLIDO(String P_APELLIDO) {
        this.P_APELLIDO = P_APELLIDO;
    }

    public String getTELEFONO() {
        return TELEFONO;
    }

    public void setTELEFONO(String TELEFONO) {
        this.TELEFONO = TELEFONO;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public int getVALOR_HORA() {
        return VALOR_HORA;
    }

    public void setVALOR_HORA(int VALOR_HORA) {
        this.VALOR_HORA = VALOR_HORA;
    }

    public int getLongitud() {
        return Longitud;
    }

    public void setLongitud(int Longitud) {
        this.Longitud = Longitud;
    }

    public int getLatitud() {
        return Latitud;
    }

    public void setLatitud(int Latitud) {
        this.Latitud = Latitud;
    }

   
}
