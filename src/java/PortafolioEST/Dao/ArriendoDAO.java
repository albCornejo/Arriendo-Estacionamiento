/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PortafolioEST.Dao;

import PortafolioEST.Clases.Arriendo;
import PortafolioEST.Clases.Estacionamiento;
import PortafolioEST.Conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Alberto
 */
public class ArriendoDAO {
    
        public static Conexion conn = null;

    public ArriendoDAO() {
        conn = new Conexion();
    }
    
    
        public List<Estacionamiento> listaEstacionamiento() {

        Estacionamiento objEst = null;
        Connection acceso = conn.getCnn();
        List<Estacionamiento> objList = new ArrayList<>();

        try {
            ResultSet rs = null;
            OracleCallableStatement cs = (OracleCallableStatement) acceso.prepareCall("{call PKG_GESTION_EST.SPR_EST_SELECT_TODOS(?)");
            //cs.setInt(1, idTipoProd);// parametro de entrada
            cs.registerOutParameter(1, OracleTypes.CURSOR);//parametro de salida . varchar .number, etc.
            cs.executeUpdate();//ejecuta la query
            rs = (ResultSet) cs.getObject(1);//trae el cursor
            while (rs.next()) {
                objEst = new Estacionamiento();
                objEst.setEST_CUENTA_ID(rs.getInt("EST_CUENTA_ID"));
                objEst.setDIR_CALLE(rs.getString("DIR_CALLE"));
                objEst.setNUMERO(rs.getString("NUMERO"));
                objEst.setP_NOMBRE(rs.getString("P_NOMBRE"));
                objEst.setP_APELLIDO(rs.getString("P_APELLIDO"));
                objEst.setTELEFONO(rs.getString("TELEFONO"));
                objEst.setEMAIL(rs.getString("EMAIL"));
                objEst.setVALOR_HORA(rs.getInt("VALOR_HORA"));


                objList.add(objEst);
            }
            cs = null;// opcional para cerrar el objeto
            rs = null;
        } catch (Exception e) {

            System.out.println(e.getMessage());
            throw new UnsupportedOperationException("Not supported yet.");
        }
        objEst = null;
        return objList;
    }
        
         public String ingresarArriendo(Arriendo objArriendo) {

        Connection acceso = conn.getCnn();
        String resultado = null;


        try {

            OracleCallableStatement cs = (OracleCallableStatement) acceso.prepareCall("{call PKG_GESTION_ARRIENDO.SPR_ARR_INSERTAR(?,?,?,?)");
            System.out.println("idEstacionamiento   " + objArriendo.getEstCuenta_id());
            cs.setInt(1, objArriendo.getEstCuenta_id());
            System.out.println("user   " + objArriendo.getUser().toUpperCase());
            cs.setString(2, objArriendo.getUser().toUpperCase());
            System.out.println("hora termino   " + objArriendo.getHora_f());
            cs.setString(3, objArriendo.getHora_f());
            cs.registerOutParameter(4, OracleTypes.VARCHAR);
            cs.executeUpdate();
            resultado = (String) cs.getObject(4);
            System.out.println("resultado   " + resultado);

        } catch (Exception ee) {
            System.out.println(ee.getMessage());
            return "ErrorGuardar";
        }

        return resultado;

    }
         
         


    
}
