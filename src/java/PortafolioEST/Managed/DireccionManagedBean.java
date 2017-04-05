/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PortafolioEST.Managed;

import PortafolioEST.Clases.Direccion;
import PortafolioEST.Dao.DireccionDAO;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.map.GeocodeEvent;
import org.primefaces.event.map.ReverseGeocodeEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.GeocodeResult;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;


@ManagedBean
@SessionScoped
public class DireccionManagedBean implements Serializable {

    // crear objeto de cliente managed bean y usar obtenerUsuario()
    private String direccion;
    private Integer numeracion;
    private Integer region;
    private Integer provincia;
    private Integer comuna;
    private Direccion currentDireccion;
    private String usuarioRescatado;
    private String tiene;

//    --------------------------------------------------------------------------
    private MapModel geoModel;
    private MapModel revGeoModel;
    private String centerGeoMap = "41.850033, -87.6500523";
    private String centerRevGeoMap = "41.850033, -87.6500523";
    private String latitud = " ";
    private String longitud = " ";
    private String dirConcat = "";
    
//    --------------------------------------------------------------------------
    
//    @PostConstruct
//    public void init() {
//        geoModel = new DefaultMapModel();
//        revGeoModel = new DefaultMapModel();
//    }

    public String getDirConcat() {
        return dirConcat;
    }

    public void setDirConcat(String dirConcat) {
        this.dirConcat = dirConcat;
    }
     
    
    
    public void onGeocode(GeocodeEvent event) {
        List<GeocodeResult> results = event.getResults();
         
        if (results != null && !results.isEmpty()) {
            LatLng center = results.get(0).getLatLng();
            
            centerGeoMap = center.getLat() + "," + center.getLng();
            
            latitud = String.valueOf(center.getLat());
            longitud = String.valueOf(center.getLng());
            
            System.out.println("latitud: " + latitud);
            System.out.println("longitud: " + longitud);
            
            for (int i = 0; i < results.size(); i++) {
                GeocodeResult result = results.get(i);
                geoModel.addOverlay(new Marker(result.getLatLng(), result.getAddress()));
            }
        }
    }
     
    public void onReverseGeocode(ReverseGeocodeEvent event) {
        List<String> addresses = event.getAddresses();
        LatLng coord = event.getLatlng();
         
        if (addresses != null && !addresses.isEmpty()) {
            centerRevGeoMap = coord.getLat() + "," + coord.getLng();
            revGeoModel.addOverlay(new Marker(coord, addresses.get(0)));
        }
    }
 
    public MapModel getGeoModel() {
        return geoModel;
    }
 
    public MapModel getRevGeoModel() {
        return revGeoModel;
    }
 
    public String getCenterGeoMap() {
        return centerGeoMap;
    }
 
    public String getCenterRevGeoMap() {
        return centerRevGeoMap;
    }

    /**
     * @return the Latitud
     */
    public String getLatitud() {
        return latitud;
    }

    /**
     * @param Latitud the Latitud to set
     */
    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    /**
     * @return the Longitud
     */
    public String getLongitud() {
        return longitud;
    }

    /**
     * @param Longitud the Longitud to set
     */
    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
    
//    --------------------------------------------------------------------------    
    
    
    
    


    public String getTiene() {
        return tiene;
    }

    public void setTiene(String tiene) {
        this.tiene = tiene;
    }

    private Map<String, Integer> regiones;
    private Map<String, Integer> provincias;
    private Map<String, Integer> comunas;

    @PostConstruct
    public void init() {

        DireccionDAO direccionDAO = new DireccionDAO();
        regiones = direccionDAO.getAllRegiones();
        
        
        geoModel = new DefaultMapModel();
        revGeoModel = new DefaultMapModel();

    }

    public Direccion getCurrentDireccion() {
        return currentDireccion;
    }

    public void setCurrentDireccion(Direccion currentDireccion) {
        this.currentDireccion = currentDireccion;
    }

    public DireccionManagedBean() {

        try {
            this.currentDireccion = new Direccion();
        } catch (Exception ee) {
            System.out.print(ee.getMessage());
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(Integer numeracion) {
        this.numeracion = numeracion;
    }

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    public Integer getProvincia() {
        return provincia;
    }

    public void setProvincia(Integer provincia) {
        this.provincia = provincia;
    }

    public Integer getComuna() {
        return comuna;
    }

    public void setComuna(Integer comuna) {
        this.comuna = comuna;
    }

    public Map<String, Integer> getRegiones() {
        return regiones;
    }

    public void setRegiones(Map<String, Integer> regiones) {
        this.regiones = regiones;
    }

    public Map<String, Integer> getProvincias() {
        return provincias;
    }

    public void setProvincias(Map<String, Integer> provincias) {
        this.provincias = provincias;
    }

    public Map<String, Integer> getComunas() {
        return comunas;
    }

    public void setComunas(Map<String, Integer> comunas) {
        this.comunas = comunas;
    }

    public void onChangeRegion() {
        comunas = new HashMap<String, Integer>();
        DireccionDAO direccionDAO = new DireccionDAO();
        if (!region.equals(0) && region != null) {
            provincias = direccionDAO.getProvinciasByRegion(region);
        } else {
            provincias = new HashMap<String, Integer>();
        }
    }

    public void onChangeProvincia() {
        DireccionDAO direccionDAO = new DireccionDAO();
        if (!provincia.equals(0) && provincia != null) {
            comunas = direccionDAO.getComunasByProvincia(provincia);
        } else {
            comunas = new HashMap<String, Integer>();
        }
    }

    public String getUsuarioRescatado() {
        return usuarioRescatado;
    }

    public void setUsuarioRescatado(String usuarioRescatado) {
        this.usuarioRescatado = usuarioRescatado;
    }

    public String ObtenerUsuario() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuarioRescatado = (String) context.getExternalContext().getSessionMap().get("usuario");
        return this.usuarioRescatado;

    }

    public String ingresarEstacionamiento() {

        DireccionDAO direccionDAO = new DireccionDAO();
        currentDireccion.setUser(ObtenerUsuario());
        currentDireccion.setLatitud(Double.parseDouble(latitud));
        currentDireccion.setLongitud(Double.parseDouble(longitud));
        String var = direccionDAO.ingresarDireccion(currentDireccion);
        System.out.println("variable retorno"+var);
        FacesContext context = FacesContext.getCurrentInstance();

        if (var.equals("ESTACIONAMIENTO REGISTRADO CON EXITO")) {

            context.addMessage(null, new FacesMessage(null, "Exito ! " + var));
        } else {

            context.addMessage(null, new FacesMessage(null, "Error " + var));

        }
        
        
        return "tutoteamo";

    }

    public void cambiaEstadoEst() {
        DireccionDAO direccionDAO = new DireccionDAO();
        currentDireccion.setUser(ObtenerUsuario());
        direccionDAO.cambiaEstadoEstDAO(currentDireccion);
        listarDatosEst();
//        return "modificaEstadoEst";

    }

    public String listarDatosEst() {
        DireccionDAO objDireccionDAO = new DireccionDAO();
        currentDireccion.setUser(ObtenerUsuario());
      
        currentDireccion = objDireccionDAO.listaUnaDireccionDAO(currentDireccion);
//        currentDireccion = null;
        return "modificaEstadoEst";

    }

    public String tieneEst() {

        DireccionDAO objDireccionDAO = new DireccionDAO();
        currentDireccion.setUser(ObtenerUsuario());
        this.tiene = objDireccionDAO.tieneEstDAO(currentDireccion);
        System.out.println(tiene);
        return tiene;
    }

    public String redireccionEst() {
        if (tieneEst().equals("1")) {
            return listarDatosEst();
        }
        return "BuscaEst";
    }
    
    public void concatenarDireccion()
    {

        dirConcat = currentDireccion.getDir_calle()+" "+currentDireccion.getNumeracion();

    }

}
