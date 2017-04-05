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
public class EstadoCuenta {
    private int Estado_cuenta_id;
    private String desc;
    
    
    
    boolean editable;

    public boolean isEditable() {
        return editable;
    }


        public void setEditable(boolean editable) {
        this.editable = editable;
    }
    

    public int getEstado_cuenta_id() {
        return Estado_cuenta_id;
    }

    
    
    
    
    public void setEstado_cuenta_id(int Estado_cuenta_id) {
        this.Estado_cuenta_id = Estado_cuenta_id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public EstadoCuenta(int Estado_cuenta_id, String desc) {
        this.Estado_cuenta_id = Estado_cuenta_id;
        this.desc = desc;
    }

    public EstadoCuenta() {
    }
    
    
    
    
}
