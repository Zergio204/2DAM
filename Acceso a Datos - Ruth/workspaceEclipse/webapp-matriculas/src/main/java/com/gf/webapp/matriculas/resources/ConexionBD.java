package com.gf.webapp.matriculas.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    public static Connection getConnection() throws SQLException {
        // Update these details based on your specific database configuration
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/matriculas", 
            "root", 
            ""
        );
    }
}