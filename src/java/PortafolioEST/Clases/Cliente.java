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
public class Cliente {
    
    private String cliente_id;
    private String sexo;
    private String p_nombre;
    private String s_nombre;
    private String p_apellido;
    private String s_apellido;
    private String telefono;
    private String email;
    private String user;
    private String pass;
    private String patente;
    private String metodoPago;
    private String tarj_num;
    private String tarj_fecha;
    private String tarj_num_seg;

    public Cliente() {
    }

    public Cliente(String cliente_id, String sexo, String p_nombre, String s_nombre, String p_apellido, String s_apellido, String telefono, String email, String user, String pass, String patente, String metodoPago, String tarj_num, String tarj_fecha, String tarj_num_seg) {
        this.cliente_id = cliente_id;
        this.sexo = sexo;
        this.p_nombre = p_nombre;
        this.s_nombre = s_nombre;
        this.p_apellido = p_apellido;
        this.s_apellido = s_apellido;
        this.telefono = telefono;
        this.email = email;
        this.user = user;
        this.pass = pass;
        this.patente = patente;
        this.metodoPago = metodoPago;
        this.tarj_num = tarj_num;
        this.tarj_fecha = tarj_fecha;
        this.tarj_num_seg = tarj_num_seg;
    }

    public String getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(String cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getP_nombre() {
        return p_nombre;
    }

    public void setP_nombre(String p_nombre) {
        this.p_nombre = p_nombre;
    }

    public String getS_nombre() {
        return s_nombre;
    }

    public void setS_nombre(String s_nombre) {
        this.s_nombre = s_nombre;
    }

    public String getP_apellido() {
        return p_apellido;
    }

    public void setP_apellido(String p_apellido) {
        this.p_apellido = p_apellido;
    }

    public String getS_apellido() {
        return s_apellido;
    }

    public void setS_apellido(String s_apellido) {
        this.s_apellido = s_apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getTarj_num() {
        return tarj_num;
    }

    public void setTarj_num(String tarj_num) {
        this.tarj_num = tarj_num;
    }

    public String getTarj_fecha() {
        return tarj_fecha;
    }

    public void setTarj_fecha(String tarj_fecha) {
        this.tarj_fecha = tarj_fecha;
    }

    public String getTarj_num_seg() {
        return tarj_num_seg;
    }

    public void setTarj_num_seg(String tarj_num_seg) {
        this.tarj_num_seg = tarj_num_seg;
    }

   
    
}
