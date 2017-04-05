/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PortafolioEST.Dao;

import PortafolioEST.Clases.Direccion;
import PortafolioEST.Clases.Marcadores;
import PortafolioEST.Conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class DireccionDAO {

    public static Conexion conn;

    public DireccionDAO() {

        conn = new Conexion();
    }

    public Map<String, Integer> getAllRegiones() {

        Map<String, Integer> regiones = new HashMap<String, Integer>();
        Connection acceso = conn.getCnn();

        try {
            ResultSet rs = null;
            OracleCallableStatement cs = (OracleCallableStatement) acceso.prepareCall("{call PKG_LOCALIDADES.SPR_GET_REGIONES(?)");
            //cs.setInt(1, idTipoProd);// parametro de entrada
            cs.registerOutParameter(1, OracleTypes.CURSOR);//parametro de salida . varchar .number, etc.
            cs.executeUpdate();//ejecuta la query
            rs = (ResultSet) cs.getObject(1);//trae el cursor
            while (rs.next()) {
                regiones.put(rs.getString("REGION_NOMBRE"), rs.getInt("REGION_ID"));
            }
            cs = null;// opcional para cerrar el objeto
            rs = null;
        } catch (Exception e) {

            System.out.println(e.getMessage());
            throw new UnsupportedOperationException("Not supported yet.");
        }
        return regiones;
    }

    public Map<String, Integer> getProvinciasByRegion(Integer region_id) {

        Map<String, Integer> provincias = new HashMap<String, Integer>();
        Connection acceso = conn.getCnn();

        try {
            ResultSet rs = null;
            OracleCallableStatement cs = (OracleCallableStatement) acceso.prepareCall("{call PKG_LOCALIDADES.SPR_GET_PROVINCIAS(?,?)");
            //cs.setInt(1, idTipoProd);// parametro de entrada
            cs.setInt(1, region_id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);//parametro de salida . varchar .number, etc.
            cs.executeUpdate();//ejecuta la query
            rs = (ResultSet) cs.getObject(2);//trae el cursor
            while (rs.next()) {
                provincias.put(rs.getString("PROVINCIA_NOMBRE"), rs.getInt("PROVINCIA_ID"));
            }
            cs = null;// opcional para cerrar el objeto
            rs = null;
        } catch (Exception e) {

            System.out.println(e.getMessage());
            throw new UnsupportedOperationException("Not supported yet.");
        }
        return provincias;
    }

    public Map<String, Integer> getComunasByProvincia(Integer provincia_id) {

        Map<String, Integer> comunas = new HashMap<String, Integer>();
        Connection acceso = conn.getCnn();

        try {
            ResultSet rs = null;
            OracleCallableStatement cs = (OracleCallableStatement) acceso.prepareCall("{call PKG_LOCALIDADES.SPR_GET_COMUNAS(?,?)");
            //cs.setInt(1, idTipoProd);// parametro de entrada
            cs.setInt(1, provincia_id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);//parametro de salida . varchar .number, etc.
            cs.executeUpdate();//ejecuta la query
            rs = (ResultSet) cs.getObject(2);//trae el cursor
            while (rs.next()) {
                comunas.put(rs.getString("COMUNA_NOMBRE"), rs.getInt("COMUNA_ID"));
            }
            cs = null;// opcional para cerrar el objeto
            rs = null;
        } catch (Exception e) {

            System.out.println(e.getMessage());
            throw new UnsupportedOperationException("Not supported yet.");
        }
        return comunas;
    }

    /**
     *
     * @param objDireccion
     * @return
     */
    public String ingresarDireccion(Direccion objDireccion) {

        Connection acceso = conn.getCnn();
        String resultado = null;

//        System.out.println("Punto 1");
        try {
//System.out.println("Punto 2");
            OracleCallableStatement cs = (OracleCallableStatement) acceso.prepareCall("{call PKG_GESTION_EST.SPR_EST_INSERTAR(?,?,?,?,?,?,?,?)");
            System.out.println("userrrrrrrrr" + objDireccion.getUser().toUpperCase());
            cs.setString(1, objDireccion.getUser().toUpperCase());
            System.out.println("comuna" + objDireccion.getComuna_id());
            cs.setInt(2, objDireccion.getComuna_id());
            System.out.println("calle" + objDireccion.getDir_calle());
            cs.setString(3, objDireccion.getDir_calle());
            System.out.println("numero" + objDireccion.getNumeracion());
            cs.setString(4, objDireccion.getNumeracion());
            System.out.println("valorHora" + objDireccion.getValorHora());
            cs.setInt(5, objDireccion.getValorHora());
            System.out.println("Latitud   " + objDireccion.getLatitud());
            cs.setDouble(6, objDireccion.getLatitud());
            System.out.println("Longitud      " + objDireccion.getLongitud());
            cs.setDouble(7, objDireccion.getLongitud());

            cs.registerOutParameter(8, OracleTypes.VARCHAR);
            cs.executeUpdate();
            resultado = (String) cs.getObject(8);
            System.out.println(resultado);

        } catch (Exception ee) {

            System.out.println(ee.getMessage());
            return "ErrorGuardar";
        }

        return resultado;

    }

    public String cambiaEstadoEstDAO(Direccion objDireccion) {

        Connection acceso = conn.getCnn();
        String resultado = null;
        try {
            OracleCallableStatement cs = (OracleCallableStatement) acceso.prepareCall("{call PKG_GESTION_EST.SPR_EST_CAMBIA_ESTADO(?,?)");
            cs.setString(1, objDireccion.getUser().toUpperCase());
            cs.registerOutParameter(2, OracleTypes.VARCHAR);
            cs.executeUpdate();
            resultado = (String) cs.getObject(2);

        } catch (Exception ee) {
            return "ErrorGuardar";
        }
        return resultado;

    }

    public Direccion listaUnaDireccionDAO(Direccion objDireccion) {


        Direccion objDir = null;
        Connection acceso = conn.getCnn();
        try {
            ResultSet rs = null;
            OracleCallableStatement cs = (OracleCallableStatement) acceso.prepareCall("{call PKG_GESTION_EST.SPR_EST_SELECT_UNO(?,?)");
            System.out.println("Punto 1");
            System.out.println(objDireccion.getUser().toUpperCase());
            cs.setString(1, objDireccion.getUser().toUpperCase());
            System.out.println("Punto 2");
            cs.registerOutParameter(2, OracleTypes.CURSOR);//parametro de salida . varchar .number, etc.
            cs.executeUpdate();//ejecuta la query
            rs = (ResultSet) cs.getObject(2);//trae el cursor
            System.out.println(cs.getObject(2));
            System.out.println("Punto 3");
            while (rs.next()) {
                System.out.println("Dentro de while");
                objDir = new Direccion();
                System.out.println(rs.getString("dir_calle"));
                objDir.setDir_calle(rs.getString("dir_calle"));
                System.out.println(rs.getString("NUMERO"));
                objDir.setNumeracion(rs.getString("NUMERO"));
                System.out.println(rs.getString("COMUNA_NOMBRE"));
                objDir.setComuna(rs.getString("COMUNA_NOMBRE"));
                System.out.println(rs.getInt("VALOR_HORA"));
                objDir.setValorHora(rs.getInt("VALOR_HORA"));
                System.out.println(rs.getString("DESC"));
                objDir.setEStadoDesc(rs.getString("DESC"));

            }
            cs = null;// opcional para cerrar el objeto
            rs = null;
        } catch (Exception e) {

            System.out.println(e.getMessage());
            throw new UnsupportedOperationException("Not supported yet.");
        }
//        objCli = null;
        System.out.println("no hay una mierda listarEst");
        return objDir;
    }

    public String tieneEstDAO(Direccion objDireccion) {

        Connection acceso = conn.getCnn();
        String resultadoEst = null;
        try {

            OracleCallableStatement cs = (OracleCallableStatement) acceso.prepareCall("{call PKG_GESTION_EST.SPR_EST_POSEE_EST(?,?)");

//            System.out.println("aqui es la cosa " + objDireccion.getUser().toUpperCase());
            cs.setString(1, objDireccion.getUser().toUpperCase());
            cs.registerOutParameter(2, OracleTypes.VARCHAR);
//            System.out.println("antes de ejecutar ");
            cs.executeUpdate();
            resultadoEst = (String) cs.getObject(2);

        } catch (Exception ee) {
            System.out.println(ee.getMessage());
            return "ErrorGuardar";
        }
//         System.out.println("aqui   "+resultadoEst);
        return resultadoEst;

    }

    public List<Marcadores> listaMarcadoresDAO() {

        Marcadores objMarcador = null;
        Connection acceso = conn.getCnn();
        List<Marcadores> objList = new ArrayList<>();

        try {
            ResultSet rs = null;
            OracleCallableStatement cs = (OracleCallableStatement) acceso.prepareCall("{call PKG_GESTION_MAPA.SPR_MAPA_MARKERS(?)");
            //cs.setInt(1, idTipoProd);// parametro de entrada
            cs.registerOutParameter(1, OracleTypes.CURSOR);//parametro de salida . varchar .number, etc.
            cs.executeUpdate();//ejecuta la query
            rs = (ResultSet) cs.getObject(1);//trae el cursor
            while (rs.next()) {
                objMarcador = new Marcadores();
                objMarcador.setIdMarcador(rs.getInt("id"));
                objMarcador.setLatitud(rs.getDouble("lat"));
                objMarcador.setLongitud(rs.getDouble("lng"));
                objMarcador.setVALOR_HORA(rs.getInt("VALOR_HORA"));
                objMarcador.setDIR_CALLE(rs.getString("DIR_CALLE"));
                objMarcador.setNUMERO(rs.getString("NUMERO"));
                objMarcador.setCOMUNA_NOMBRE(rs.getString("COMUNA_NOMBRE"));

                objList.add(objMarcador);
            }
            cs = null;// opcional para cerrar el objeto
            rs = null;
        } catch (Exception e) {

            System.out.println(e.getMessage());
            throw new UnsupportedOperationException("Not supported yet.");
        }
        objMarcador = null;
        return objList;
    }

    public Marcadores listaMarcadoresDetalleDAO(int Marca) {

        Marcadores objMarcador = null;
        Connection acceso = conn.getCnn();
//        List<Marcadores> objList = new ArrayList<>();

        try {
            ResultSet rs = null;
            OracleCallableStatement cs = (OracleCallableStatement) acceso.prepareCall("{call PKG_GESTION_MAPA.SPR_MAPA_DETALLE(?,?)");
            //cs.setInt(1, idTipoProd);// parametro de entrada
            cs.setInt(1, Marca);
            cs.registerOutParameter(2, OracleTypes.CURSOR);//parametro de salida . varchar .number, etc.
            cs.executeUpdate();//ejecuta la query
            rs = (ResultSet) cs.getObject(2);//trae el cursor
            while (rs.next()) {
                objMarcador = new Marcadores();
                objMarcador.setIdMarcador(rs.getInt("id"));
                objMarcador.setLatitud(rs.getDouble("lat"));
                objMarcador.setLongitud(rs.getDouble("lng"));
                objMarcador.setVALOR_HORA(rs.getInt("VALOR_HORA"));
                objMarcador.setDIR_CALLE(rs.getString("DIR_CALLE"));
                objMarcador.setNUMERO(rs.getString("NUMERO"));
                objMarcador.setCOMUNA_NOMBRE(rs.getString("COMUNA_NOMBRE"));
                objMarcador.setPROVINCIA_NOMBRE(rs.getString("PROVINCIA_NOMBRE"));
                objMarcador.setEST_CUENTA_ID(rs.getInt("EST_CUENTA_ID"));

//                objList.add(objMarcador);
            }
            cs = null;// opcional para cerrar el objeto
            rs = null;
        } catch (Exception e) {

            System.out.println(e.getMessage());
            throw new UnsupportedOperationException("Not supported yet.");
        }
//        objMarcador = null;
        return objMarcador;
    }

}
