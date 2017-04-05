/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PortafolioEST.Dao;

import PortafolioEST.Conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import PortafolioEST.Clases.Cliente;

/**
 *
 * @author Alberto
 */
public class ClienteDAO {

    public static Conexion conn = null;

    public ClienteDAO() {
        conn = new Conexion();
    }

    public List<Cliente> listaCliente() {

        Cliente objCli = null;
        Connection acceso = conn.getCnn();
        List<Cliente> objList = new ArrayList<>();

        try {
            ResultSet rs = null;
            OracleCallableStatement cs = (OracleCallableStatement) acceso.prepareCall("{call PKG_GESTION_CLIENTE.SPR_CUENTA_MOSTRAR(?)");

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeUpdate();
            rs = (ResultSet) cs.getObject(1);
            while (rs.next()) {
                objCli = new Cliente();
                objCli.setCliente_id(rs.getString("CLIENTE_ID"));
                objCli.setP_nombre(rs.getString("P_NOMBRE"));
                objCli.setS_nombre(rs.getString("S_NOMBRE"));
                objCli.setP_apellido(rs.getString("P_APELLIDO"));
                objCli.setS_apellido(rs.getString("S_APELLIDO"));
                objCli.setSexo(rs.getString("SEXO"));
                objCli.setTelefono(rs.getString("TELEFONO"));
                objCli.setEmail(rs.getString("EMAIL"));
                objCli.setUser(rs.getString("USER"));
                objCli.setPass(rs.getString("PASS"));

                objList.add(objCli);
            }
            cs = null;
            rs = null;
        } catch (Exception e) {

            System.out.println(e.getMessage());
            throw new UnsupportedOperationException("Not supported yet.");
        }
        objCli = null;
        return objList;
    }

    public String ingresarCliente(Cliente objCliente) {

        Connection acceso = conn.getCnn();
        String resultado = null;
        try {

            OracleCallableStatement cs = (OracleCallableStatement) acceso.prepareCall("{call PKG_GESTION_CLIENTE.SPR_CUENTA_INSERTAR(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            System.out.println(objCliente.getCliente_id());
            cs.setString(1, objCliente.getCliente_id());

            System.out.println(objCliente.getEmail());
            cs.setString(2, objCliente.getEmail());

            System.out.println(objCliente.getP_nombre());
            cs.setString(3, objCliente.getP_nombre());

            System.out.println(objCliente.getS_nombre());
            cs.setString(4, objCliente.getS_nombre());

            System.out.println(objCliente.getP_apellido());
            cs.setString(5, objCliente.getP_apellido());

            System.out.println(objCliente.getS_apellido());
            cs.setString(6, objCliente.getS_apellido());

            System.out.println(objCliente.getSexo());
            cs.setString(7, objCliente.getSexo());

            System.out.println(objCliente.getTelefono());
            cs.setString(8, objCliente.getTelefono());

            System.out.println(objCliente.getUser());
            cs.setString(9, objCliente.getUser());

            System.out.println(objCliente.getPass());
            cs.setString(10, objCliente.getPass());

            System.out.println(objCliente.getPatente());
            cs.setString(11, objCliente.getPatente());

            System.out.println(objCliente.getTarj_num());
            cs.setString(12, objCliente.getTarj_num());

            System.out.println(objCliente.getTarj_fecha());
            cs.setString(13, objCliente.getTarj_fecha());

            System.out.println(objCliente.getTarj_num_seg());
            cs.setString(14, objCliente.getTarj_num_seg());

            System.out.println(objCliente.getMetodoPago());
            cs.setString(15, objCliente.getMetodoPago());

            System.out.println("aqui es el fin1");
            cs.registerOutParameter(16, OracleTypes.VARCHAR);
            System.out.println("aqui es el fin2");
            cs.executeUpdate();
            resultado = (String) cs.getObject(16);

        } catch (Exception ee) {
            System.out.println(ee.getMessage());
            return "ErrorGuardar";
        }
        System.out.println(resultado);
        return resultado;

    }

    public String ActualizarClienteDAO(Cliente objCliente) {
        Connection acceso = conn.getCnn();
        String resultado = null;
        try {

            OracleCallableStatement cs = (OracleCallableStatement) acceso.prepareCall("{call PKG_GESTION_CLIENTE.SPR_CUENTA_ACTUALIZAR(?,?,?,?,?,?,?,?,?,?)");

            cs.setString(1, objCliente.getEmail());
            cs.setString(2, objCliente.getP_nombre());
            cs.setString(3, objCliente.getS_nombre());
            cs.setString(4, objCliente.getP_apellido());
            cs.setString(5, objCliente.getS_apellido());
            cs.setString(6, objCliente.getSexo());
            cs.setString(7, objCliente.getTelefono());
            cs.setString(8, objCliente.getUser());
            cs.setString(9, objCliente.getPass());
            cs.registerOutParameter(10, OracleTypes.VARCHAR);
            cs.executeUpdate();
            resultado = (String) cs.getObject(10);

        } catch (Exception ee) {
            System.out.println(ee.getMessage());
            return "ErrorGuardar";
        }
        return "Usuario actualizado";
    }

    public String eliminarClienteDAO(Cliente objCliente) {
        Connection acceso = conn.getCnn();
        String resultado = null;
        System.out.println(objCliente.getCliente_id());
        try {
            OracleCallableStatement cs = (OracleCallableStatement) acceso.prepareCall("{call PKG_GESTION_CLIENTE.SPR_CUENTA_ELIMINAR(?,?)");
            cs.setString(1, objCliente.getCliente_id());
            cs.registerOutParameter(2, OracleTypes.VARCHAR);
            cs.executeUpdate();
            resultado = (String) cs.getObject(2);
            System.out.println("dentro del try");
            cs = null;
        } catch (Exception ee) {
            System.out.println(ee.getMessage());
            System.out.println("dentro del exception");
        }
        objCliente = null;
        System.out.println("al final");
        return "EliminaOK";
    }

    public String ValidarCuenta(Cliente objCliente) {
        Connection acceso = conn.getCnn();
        String resultado = null;

        try {

            OracleCallableStatement cs = (OracleCallableStatement) acceso.prepareCall("{call PKG_GESTION_CLIENTE.SPR_INICIO_SESION(?,?,?)");
            cs.setString(1, objCliente.getUser());
            cs.setString(2, objCliente.getPass());
            cs.registerOutParameter(3, OracleTypes.VARCHAR);//parametro de salida . varchar .number, etc.
            cs.executeUpdate();
            resultado = (String) cs.getObject(3);
            System.out.println(resultado);
        } catch (Exception ee) {
            System.out.println(ee.getMessage());
            return "UsuarioInccorrecto";
        }
        objCliente = null;
        return resultado;
    }

    public Cliente listaUnCliente(Cliente objCliente) {

        Cliente objCli = null;
        Connection acceso = conn.getCnn();

        try {
            ResultSet rs = null;
            OracleCallableStatement cs = (OracleCallableStatement) acceso.prepareCall("{call PKG_GESTION_CLIENTE.SPR_CUENTA_MOSTRAR(?,?)");

            System.out.println("Punto trer");
            System.out.println(objCliente.getUser().toUpperCase());
            cs.setString(1, objCliente.getUser().toUpperCase());
            System.out.println("Punto 2");
            cs.registerOutParameter(2, OracleTypes.CURSOR);//parametro de salida . varchar .number, etc.
            cs.executeUpdate();//ejecuta la query
            rs = (ResultSet) cs.getObject(2);//trae el cursor
            System.out.println("Punto 3");
            while (rs.next()) {
                System.out.println("Dentro de while");
                objCli = new Cliente();
                objCli.setCliente_id(rs.getString("CLIENTE_ID"));
                objCli.setP_nombre(rs.getString("P_NOMBRE"));
                objCli.setS_nombre(rs.getString("S_NOMBRE"));
                objCli.setP_apellido(rs.getString("P_APELLIDO"));
                objCli.setS_apellido(rs.getString("S_APELLIDO"));
                objCli.setSexo(rs.getString("SEXO"));
                objCli.setTelefono(rs.getString("TELEFONO"));
                objCli.setEmail(rs.getString("EMAIL"));
                objCli.setUser(rs.getString("USER"));
                objCli.setPass(rs.getString("PASS"));

                System.out.println("el cliente es: " + objCli.getP_nombre());
            }
            cs = null;// opcional para cerrar el objeto
            rs = null;
        } catch (Exception e) {

            System.out.println(e.getMessage());
            throw new UnsupportedOperationException("Not supported yet.");
        }

        return objCli;
    }
    
    
     public Cliente listaUnaTarjetaDAO(Cliente objCliente) {

        Cliente objCli = null;
        Connection acceso = conn.getCnn();

        try {
            ResultSet rs = null;
            OracleCallableStatement cs = (OracleCallableStatement) acceso.prepareCall("{call PKG_GESTION_CLIENTE.SPR_CC_MOSTRAR(?,?)");

            System.out.println("Punto 1");
            System.out.println(objCliente.getUser().toUpperCase());
            cs.setString(1, objCliente.getUser().toUpperCase());
            System.out.println("Punto 2");
            cs.registerOutParameter(2, OracleTypes.CURSOR);//parametro de salida . varchar .number, etc.
            cs.executeUpdate();//ejecuta la query
            rs = (ResultSet) cs.getObject(2);//trae el cursor
            System.out.println("Punto 3");
            while (rs.next()) {
                System.out.println("Dentro de while");
                objCli = new Cliente();
                
                System.out.println(rs.getString("DESC"));
                objCli.setMetodoPago(rs.getString("DESC"));
                System.out.println(rs.getString("TARJETA_NUM"));
                objCli.setTarj_num(rs.getString("TARJETA_NUM"));
            }
            cs = null;// opcional para cerrar el objeto
            rs = null;
        } catch (Exception e) {

            System.out.println(e.getMessage());
            throw new UnsupportedOperationException("Not supported yet.");
        }
        System.out.println("no hay una mierda");
        return objCli;
    }
     

    
    public String cambiaTarjetaDAO(Cliente objCliente) {
        Connection acceso = conn.getCnn();
        String resultado = null;

        try {
            OracleCallableStatement cs = (OracleCallableStatement) acceso.prepareCall("{call PKG_GESTION_CLIENTE.SPR_MODIFICAR_CC(?,?,?,?,?,?)");
            System.out.println(objCliente.getUser());
            cs.setString(1, objCliente.getUser().toUpperCase());
            System.out.println(objCliente.getTarj_num());
            cs.setString(2, objCliente.getTarj_num());
            System.out.println(objCliente.getTarj_fecha());
            cs.setString(3, objCliente.getTarj_fecha());
            System.out.println(objCliente.getTarj_num_seg());
            cs.setString(4, objCliente.getTarj_num_seg());
            System.out.println(objCliente.getMetodoPago());
            cs.setString(5, objCliente.getMetodoPago());
            System.out.println("el finish");
            cs.registerOutParameter(6, OracleTypes.VARCHAR);//parametro de salida . varchar .number, etc.

            cs.executeUpdate();
            resultado = (String) cs.getObject(6);
            System.out.println(resultado);
        } catch (Exception ee) {
            System.out.println(ee.getMessage());
        }
        objCliente = null;
        return resultado;
    }
    

}
