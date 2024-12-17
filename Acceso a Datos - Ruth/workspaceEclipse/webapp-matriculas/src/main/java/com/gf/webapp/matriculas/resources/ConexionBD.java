package com.gf.webapp.matriculas.resources;

import java.sql.Connection;
import java.sql.SQLException;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jakarta.annotation.Resource;

@Resource(name="jdbc/miDataSource")
public class ConexionBD {
	//private static Connection conn;
    public static Connection getConnection() throws SQLException, NamingException {
    	
//    	Context initcontext = new InitialContext(); //JNDI
//    	Context envContext = (Context) initcontext.lookup("java:/comp/env");
//    	DataSource ds = (DataSource) envContext.lookup("jdbc/miDartaSource");
//    	
//    	return ds.getConnection();
    	
    	//DataSource para Pool de Conexion
    	return ((DataSource) new InitialContext().lookup("java:/comp/env/jdbc/miDataSource")).getConnection();
    	
        // Update these details based on your specific database configuration
//        return DriverManager.getConnection(
//            "jdbc:mysql://localhost:3306/matriculas", 
//            "root", 
//            ""
//        );
    }
}