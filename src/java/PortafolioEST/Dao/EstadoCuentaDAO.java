/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PortafolioEST.Dao;

import PortafolioEST.Clases.EstadoCuenta;
import PortafolioEST.Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Alberto
 */
public class EstadoCuentaDAO {
    
    Conexion conn;
    
    public EstadoCuentaDAO()
    {
        conn = new Conexion();
    }
    
//    public List<EstadoCuenta> listaEstadoCuenta(){
//      
//        
//        EstadoCuenta objEstadoCuenta = null;
//        Connection acceso = conn.getCnn();
//        List<EstadoCuenta> objList = new ArrayList<>();
//        
//        try {
//            ResultSet rs = null;
//            OracleCallableStatement cs = (OracleCallableStatement)
//            acceso.prepareCall("{call PKG_PRODUCTO.MOSTRAR_PRODUCTO(?,?)");
//            //cs.setInt(1, idTipoProd);// parametro de entrada
//            cs.registerOutParameter(2, OracleTypes.CURSOR);//parametro de salida . varchar .number, etc.
//            cs.executeUpdate();//ejecuta la query
//            rs = (ResultSet) cs.getObject(2);//trae el cursor 
//            while (rs.next()) {
//                objEstadoCuenta = new EstadoCuenta();
//                objEstadoCuenta.setEstado_cuenta_id(rs.getInt("ESTADO_CUENTA_ID"));
//                objEstadoCuenta.setDesc(rs.getString("DESC"));
//               
//                objList.add(objEstadoCuenta);
//            }
//            cs = null;// opcional para cerrar el objeto
//            rs = null;
//
//        } catch (Exception ee) {
//            System.out.println(ee.getMessage());
//            throw new UnsupportedOperationException("Not supported yet.");
//        }
//        objEstadoCuenta = null;
//        return objList;
//        
//    }
    
    public List<EstadoCuenta> listaEstadoCuenta(){
    EstadoCuenta objEstadoCuenta = null;
        Connection acceso = conn.getCnn();
        List<EstadoCuenta> EstadoCuentaList = new ArrayList<>();
        try {
            PreparedStatement ps = acceso.prepareStatement("SELECT   * FROM ESTADO_CUENTA");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                objEstadoCuenta = new EstadoCuenta();
                objEstadoCuenta.setEstado_cuenta_id(rs.getInt("ESTADO_CUENTA_ID"));
                objEstadoCuenta.setDesc(rs.getString("DESC"));
                EstadoCuentaList.add(objEstadoCuenta);
            }
            ps = null;
            rs = null;

        } catch (Exception ee) {
            System.out.println(ee.getMessage());
        }
        objEstadoCuenta = null;
        return EstadoCuentaList;
    
    
}
    
    public String IngresarEstadoCuenta(EstadoCuenta objEstadoCuenta){
        
        Connection acceso = conn.getCnn();
        
        try {
            
            PreparedStatement ps = acceso.prepareStatement("INSERT INTO ESTADO_CUENTA (ESTADO_CUENTA_ID, \"DESC\") VALUES (?, ?)");
            ps.setInt(1,objEstadoCuenta.getEstado_cuenta_id());
            ps.setString(2,objEstadoCuenta.getDesc());
            ps.executeUpdate();
            
            
            ps = null;
         

        } catch (Exception ee) {
            System.out.println(ee.getMessage());
        }
        objEstadoCuenta = null;
        return "IngresoOK";
        
    }
    
    public String modificarEstadoCuenta(EstadoCuenta objEstadoCuenta){
        
        Connection acceso = conn.getCnn();
        
        try {
            
            PreparedStatement ps = acceso.prepareStatement("UPDATE \"ESTUSER\".\"ESTADO_CUENTA\" SET \"DESC\" = '?' WHERE ESTADO_CUENTA_ID =?");
            ps.setInt(1,objEstadoCuenta.getEstado_cuenta_id());
            ps.setString(2,objEstadoCuenta.getDesc());
            ps.executeUpdate();
            
            
            ps = null;
         

        } catch (Exception ee) {
            System.out.println(ee.getMessage());
        }
        objEstadoCuenta = null;
        return "ModificaOK";
        
    }
    
}
