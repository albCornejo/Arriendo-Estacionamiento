package PortafolioEST.Managed;

import PortafolioEST.Clases.Arriendo;
import PortafolioEST.Clases.Estacionamiento;
import PortafolioEST.Clases.Marcadores;
import PortafolioEST.Dao.ArriendoDAO;
import PortafolioEST.Dao.DireccionDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author Alberto
 */
@ManagedBean
@SessionScoped
@ViewScoped
public class ArriendoManagedBean implements Serializable {

    List<Estacionamiento> listaEst;
    private Estacionamiento currentEst;
    private Arriendo currentArriendo;
    private String usuarioRescatado;
    private String cantHoras;
    private String var;
    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public String getCantHoras() {
        return cantHoras;
    }

    public void setCantHoras(String cantHoras) {
        this.cantHoras = cantHoras;
    }

    public ArriendoManagedBean() {
        try {
            this.currentEst = new Estacionamiento();
            this.currentArriendo = new Arriendo();
            this.currentMarca = new Marcadores();
        } catch (Exception ee) {
            System.out.print(ee.getMessage());
        }
    }

    public List<Estacionamiento> getListaEst() {
        ArriendoDAO objArriendoDAO = new ArriendoDAO();
        this.listaEst = objArriendoDAO.listaEstacionamiento();
        return listaEst;
    }

    public Arriendo getCurrentArriendo() {
        return currentArriendo;
    }

    public void setCurrentArriendo(Arriendo currentArriendo) {
        this.currentArriendo = currentArriendo;
    }

    public void setListaEst(List<Estacionamiento> listaEst) {
        this.listaEst = listaEst;
    }

    public Estacionamiento getCurrentEst() {
        return currentEst;
    }

    public void setCurrentEst(Estacionamiento currentEst) {
        this.currentEst = currentEst;
    }

    public String getUsuarioRescatado() {
        return usuarioRescatado;
    }

    public void setUsuarioRescatado(String usuarioRescatado) {
        this.usuarioRescatado = usuarioRescatado;
    }

    public String listarEst() {
        ArriendoDAO objArriendoDAO = new ArriendoDAO();
        objArriendoDAO.listaEstacionamiento();
        return "listarEstacionamiento";

    }

    public String ObtenerUsuario() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuarioRescatado = (String) context.getExternalContext().getSessionMap().get("usuario");
        return this.usuarioRescatado;

    }

    public String ingresarEstacionamiento() {

        ArriendoDAO objArriendoDAO = new ArriendoDAO();

        currentArriendo.setHora_f(cantHoras);
        currentArriendo.setEstCuenta_id(currentMarca.getEST_CUENTA_ID());
        currentArriendo.setUser(ObtenerUsuario());
        var = objArriendoDAO.ingresarArriendo(currentArriendo);
        getSimpleModel();
        FacesContext context = FacesContext.getCurrentInstance();

        if (var.equals("ARRIENDO EXITOSO")) {

            context.addMessage(null, new FacesMessage(null, "Exito ! " + var));

        } else {

            context.addMessage(null, new FacesMessage(null, "Error " + var));

        }

        return "tutoteamo1";

    }

//    --------------------------------------------------------------------------------------------------
    List<Marcadores> listaMarca;
    private Marcadores currentMarca;
    private Marcadores listaUno;

    private MapModel simpleModel = new DefaultMapModel();

    private Marker marker;

    public Marcadores getListaUno() {
        return listaUno;
    }

    public void setListaUno(Marcadores listaUno) {
        this.listaUno = listaUno;
    }

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    public List<Marcadores> getListaMarca() {
        DireccionDAO objMarcaDAO = new DireccionDAO();
        this.listaMarca = objMarcaDAO.listaMarcadoresDAO();
        return listaMarca;
    }

    public void setListaMarca(List<Marcadores> listaMarca) {
        this.listaMarca = listaMarca;
    }

    public Marcadores getCurrentMarca() {
        return currentMarca;
    }

    public void setCurrentMarca(Marcadores currentMarca) {
        this.currentMarca = currentMarca;
    }

    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public void setSimpleModel(MapModel simpleModel) {
        this.simpleModel = simpleModel;
    }

    @PostConstruct
    public void init() {
        DireccionDAO objMarcadorDAO = new DireccionDAO();
        for (int i = 0; i < objMarcadorDAO.listaMarcadoresDAO().size(); i++) {
            LatLng coord2 = new LatLng(objMarcadorDAO.listaMarcadoresDAO().get(i).getLatitud(), objMarcadorDAO.listaMarcadoresDAO().get(i).getLongitud());
            simpleModel.addOverlay(new Marker(coord2, String.valueOf(objMarcadorDAO.listaMarcadoresDAO().get(i).getIdMarcador())));
        }
    }

    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
        String idMarca = marker.getTitle();
        int idMarca2 = Integer.parseInt(idMarca);
        DireccionDAO objDireccionDAO = new DireccionDAO();
        currentMarca = objDireccionDAO.listaMarcadoresDetalleDAO(idMarca2);
    }

    public void calculoTotal() {

        total = currentMarca.getVALOR_HORA() * Integer.parseInt(cantHoras);

    }

    public String listarMarcadores() {
        DireccionDAO objMarcadorDAO = new DireccionDAO();
        listaMarca = objMarcadorDAO.listaMarcadoresDAO();
        return "listarMarcadore";
    }

    public void imprimeMarcas() {
        try {
            DireccionDAO objMarcadorDAO = new DireccionDAO();
            for (int i = 0; i < objMarcadorDAO.listaMarcadoresDAO().size(); i++) {
                System.out.println(objMarcadorDAO.listaMarcadoresDAO().get(i).getLatitud());
                System.out.println(objMarcadorDAO.listaMarcadoresDAO().get(i).getLongitud());
            }
        } catch (Exception e) {
            System.out.println("Error");
        }

    }

}
