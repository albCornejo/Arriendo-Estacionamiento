package PortafolioEST.Managed;

import PortafolioEST.Clases.Cliente;
import PortafolioEST.Dao.ClienteDAO;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Alberto
 */
@ManagedBean
@SessionScoped
public class ClienteManagedBean implements Serializable {

    List<Cliente> lista;
    List<Cliente> listaUno;
    private Cliente currentCliente;
    private Cliente currentClienteLogin;
    private String usuarioRescatado;
    private String var;
    private String mes;
    private String anio;
    private String tiene;

    public String getTiene() {
        return tiene;
    }

    public void setTiene(String tiene) {
        this.tiene = tiene;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public List<Cliente> getListaUno() {
        ClienteDAO objClienteDAO = new ClienteDAO();
        this.listaUno = objClienteDAO.listaCliente();
        return listaUno;
    }

    public void setListaUno(List<Cliente> listaUno) {
        this.listaUno = listaUno;
    }

    public Cliente getCurrentClienteLogin() {
        return currentClienteLogin;
    }

    public void setCurrentClienteLogin(Cliente currentClienteLogin) {
        this.currentClienteLogin = currentClienteLogin;
    }

    public String getUsuarioRescatado() {
        return usuarioRescatado;
    }

    public void setUsuarioRescatado(String usuarioRescatado) {
        this.usuarioRescatado = usuarioRescatado;
    }

    public Cliente getCurrentCliente() {
        return currentCliente;
    }

    public void setCurrentCliente(Cliente currentCliente) {
        this.currentCliente = currentCliente;
    }

    public List<Cliente> getLista() {
        ClienteDAO objClienteDAO = new ClienteDAO();
        this.lista = objClienteDAO.listaCliente();
        return lista;
    }

    public void setLista(List<Cliente> lista) {
        this.lista = lista;
    }

    public ClienteManagedBean() {

        try {
            this.currentCliente = new Cliente();
            this.currentClienteLogin = new Cliente();
        } catch (Exception ee) {
            System.out.print(ee.getMessage());
        }
    }

    public void ingresarCliente() {
        ClienteDAO objClienteDAO = new ClienteDAO();
        currentCliente.setTarj_fecha(mes + "-" + anio);
        var = objClienteDAO.ingresarCliente(currentCliente);
        if (var.equals("Registro grabado")) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(null, "" + var));
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(null, "Error " + var));

        }
    }

    public void saveMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Error", "Verifique los datos ingresados " + var));
    }

    public String listarCliente() {
        ClienteDAO objClienteDAO = new ClienteDAO();
        objClienteDAO.listaCliente();
        return "listarCliente";

    }

    public String formModificarUsuario() {

        return "formModificarUsuario";

    }

    public String guardarModificar() {

        ClienteDAO objClienteDAO = new ClienteDAO();
        var = objClienteDAO.ActualizarClienteDAO(currentCliente);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(null, "Exito ! " + var));

        currentCliente = null;

        return "ModificadoListar";
    }

    public void eliminarCliente() {

        ClienteDAO objClienteDAO = new ClienteDAO();
        objClienteDAO.eliminarClienteDAO(currentCliente);

    }

    public String autenticar() {

        ClienteDAO objClienteDAO = new ClienteDAO();
        String resu = objClienteDAO.ValidarCuenta(currentClienteLogin);

        if (resu.equals("NOEXISTE")) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Usuario Y Password son INCORRECTOS",
                            "Porfavor Ingrese Usuario y Password Correctos"));

            return "UsuarioIncorrecto";

        } else {

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", currentClienteLogin.getUser());

            return "UsuarioCorrecto";

        }
    }

    public String ObtenerUsuario() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuarioRescatado = (String) context.getExternalContext().getSessionMap().get("usuario");
        return this.usuarioRescatado;

    }

    public void cerrarSession() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().invalidateSession();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Su sesión se ha cerrado con éxito", ""));
            context.getExternalContext().redirect("/AMEEST1/faces/index.xhtml");
        } catch (Exception e) {
        }
    }

    public String traeCliMod() {
        ClienteDAO objClienteDAO = new ClienteDAO();
        currentCliente.setUser(ObtenerUsuario());
        currentCliente = objClienteDAO.listaUnCliente(currentCliente);
        return "modificarClienteFinal";

    }

    public String cambiaTarjeta() {
//           currentCliente = null; 
        return "cambiaTarjetaForm";
    }

    public void redireccionRegistro() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();

            context.getExternalContext().redirect("/AMEEST1/faces/Vistas/agregaCliente.xhtml");
            //    return "registro";
        } catch (IOException ex) {
            Logger.getLogger(ClienteManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String cambiaTarjeta1() {
        ClienteDAO objClienteDAO = new ClienteDAO();
        currentCliente.setUser(ObtenerUsuario());
        currentCliente.setTarj_fecha(mes + "-" + anio);
        objClienteDAO.cambiaTarjetaDAO(currentCliente);
        listarDatosTarjeta();
        return "listaTarjeta";
    }

    public String listarDatosTarjeta() {
        ClienteDAO objClienteDAO = new ClienteDAO();
        currentCliente.setUser(ObtenerUsuario());
        currentCliente = objClienteDAO.listaUnaTarjetaDAO(currentCliente);
//        currentCliente = null;
        return "listaTarjeta";
    }

    public void index() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();

            context.getExternalContext().redirect("/AMEEST1/faces/index.xhtml");
        } catch (Exception e) {
        }
    }

}
