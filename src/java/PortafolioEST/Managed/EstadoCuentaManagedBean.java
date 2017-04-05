/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PortafolioEST.Managed;

import PortafolioEST.Clases.EstadoCuenta;
import PortafolioEST.Dao.EstadoCuentaDAO;
import static com.sun.faces.facelets.util.Path.context;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Alberto
 */
@ManagedBean
@SessionScoped
public class EstadoCuentaManagedBean {

    List<EstadoCuenta> lista;
    private EstadoCuenta currentEstadoCuenta;

    
    private int idEstCuenta;

    public int getIdEstCuenta() {
        return idEstCuenta;
    }
    
    
//  static Integer id_estCuenta = new Integer ((String)context.getExternalContext().getRequestParamenterMap().get("id_estCuenta"));
    
    

    public void setIdEstCuenta(int idEstCuenta) {
        this.idEstCuenta = idEstCuenta;
    }
    /**
     * Creates a new instance of PortafolioManagedBean
     */
    public EstadoCuentaManagedBean() {
        try {
            this.currentEstadoCuenta = new EstadoCuenta();
        } catch (Exception ee) {
            System.out.print(ee.getMessage());
        }
        
    }

    public EstadoCuenta getCurrentEstadoCuenta() {
        return currentEstadoCuenta;
    }

    public void setCurrentEstadoCuenta(EstadoCuenta currentEstadoCuenta) {
        this.currentEstadoCuenta = currentEstadoCuenta;
    }

    public List<EstadoCuenta> getLista() {
        
        EstadoCuentaDAO objEstadoCuentaDAO = new EstadoCuentaDAO();
        this.lista = objEstadoCuentaDAO.listaEstadoCuenta();
        

        return lista;
    }

    public void setLista(List<EstadoCuenta> lista) {
        this.lista = lista;
    }
    
//    public String ir (){
//        
//        return "ir";
//    }

    public String IngresarEstadoCuenta(){
        
        EstadoCuentaDAO objEstadoCuentaDAO = new EstadoCuentaDAO();
        
        objEstadoCuentaDAO.IngresarEstadoCuenta(currentEstadoCuenta);
        return "IngresoOK";
    } 
    
    public void modificarEstadoCuenta(){
        
        EstadoCuentaDAO objEstadoCuentaDAO = new EstadoCuentaDAO();
        objEstadoCuentaDAO.modificarEstadoCuenta(currentEstadoCuenta);
    
    }
    
     public String formModificarEstadoCuenta (){
        
        return "formEstadoCuenta";

	}
     
     
     	public String editAction(EstadoCuenta objEstadoCuenta) {
	    
		objEstadoCuenta.setEditable(true);
		return null;
        }
    
}
