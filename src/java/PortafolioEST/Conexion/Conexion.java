/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PortafolioEST.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alejandrosuns
 */
public class Conexion {
    
    
    private String USERNAME = "estuser";
    private String PASSWORD = "root";
    private String PORT = "1525";
    private String HOST = "localhost";
    private String SID = "DBEST";
    private String CLASSNAME = "oracle.jdbc.driver.OracleDriver";
    private String URL = "jdbc:oracle:thin:@" + HOST + ":" + PORT + ":" + SID;
    private Connection cnn;

    public Conexion() {
        this.conectarBD();
    }

    public Connection getCnn() {
        return cnn;
    }

    public void setCnn(Connection cnn) {
        this.cnn = cnn;
    }

    public void conectarBD() {

        try {
            Class.forName(CLASSNAME);
            try {
                this.setCnn(DriverManager.getConnection(URL, USERNAME, PASSWORD));
                System.out.println("La coneccion ama a tuto");
            } catch (SQLException ee) {
                System.out.println(ee.getMessage());
            }
        } catch (ClassNotFoundException ee) {
            System.out.println(ee.getMessage());
        }
    }

    public void desonectarBD() {
        try {
            this.getCnn().close();
        } catch (Exception ee) {
            System.out.println(ee.getMessage());
        }

    }

    
}
