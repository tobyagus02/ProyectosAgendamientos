/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectosagendamientos.Infraestructura.Data.Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lab217-06
 */
public class ConexionDB {
    private String UserDB;
    private String PasswordDB;
    private String DataBase;
    private String HostDB;
    private String portDB;
    private String url;
    
    public Connection conexion;
    
    public ConexionDB(String userDB,
                      String passwordDB,
                      String database,
                      String hostDB,
                      String portDB){
        this.UserDB = userDB;
        this.PasswordDB = PasswordDB;
        this.DataBase = database;
        this.HostDB = HostDB;
        this.portDB = portDB;
        this.url = "jdbc:postgresql://" + this.HostDB + ":" + this.portDB + "/" + this.DataBase;
    }
    
    public void ConectarDB(){
        try {
            Class.forName("org.postgres.Driver");
            conexion = DriverManager.getConnection(this.url, this.UserDB, this.PasswordDB);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}