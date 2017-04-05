/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PortafolioEST.Managed;


import java.util.List;
import javax.annotation.PostConstruct;
//import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
//import org.primefaces.event.map.*;
import org.primefaces.event.map.GeocodeEvent;
import org.primefaces.event.map.ReverseGeocodeEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.GeocodeResult;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;


/**
 *
 * @author SPalominoM
 */
@ManagedBean

public class GeocodeView {
    
    private MapModel geoModel;
    private MapModel revGeoModel;
    private String centerGeoMap = "41.850033, -87.6500523";
    private String centerRevGeoMap = "41.850033, -87.6500523";
    private String latitud =" ";
    private String longitud =" ";
     
    @PostConstruct
    public void init() {
        geoModel = new DefaultMapModel();
        revGeoModel = new DefaultMapModel();
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
    
}
