/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PortafolioEST.Managed;

import PortafolioEST.Clases.Marcadores;
import PortafolioEST.Dao.DireccionDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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
@ViewScoped
public class MakersManagedBean implements Serializable {

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
            simpleModel.addOverlay(new Marker(coord2,String.valueOf(objMarcadorDAO.listaMarcadoresDAO().get(i).getIdMarcador()) ));
        }
    }
    
    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
        String idMarca = marker.getTitle();
        int idMarca2 = Integer.parseInt(idMarca);
        DireccionDAO objDireccionDAO = new DireccionDAO();
        currentMarca = objDireccionDAO.listaMarcadoresDetalleDAO(idMarca2);
    }

//    public MakersManagedBean() {
//        try {
//            this.currentMarca = new Marcadores();
//
//        } catch (Exception ee) {
//            System.out.print(ee.getMessage());
//        }
//    }

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
            System.out.println("Ta mala la wea");
        }

    }
}
