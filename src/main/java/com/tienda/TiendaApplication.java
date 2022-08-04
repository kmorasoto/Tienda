package com.tienda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TiendaApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(TiendaApplication.class, args);
                
         /* String informeOrigen = "C:\\Users\\dell\\Documents\\NetBeansProjects\\Tienda\\src\\main\\java\\com\\tienda\\report1.jrxml";
          String informeDestino = "C:\\Users\\dell\\Documents\\NetBeansProjects\\Tienda\\src\\main\\java\\com\\tienda\\report1.pdf";
          
          //Crear la conexión
          Connection conexion =null; 
          
          try{
              System.out.println ("Probando conexión a la base de datos");
              conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda", "root", "310820");
              conexion.setAutoCommit (false);
              
              if (conexion != null){
                  System.out.println ("Conexion correcta a la base de datos");
              }
          }catch(SQLException ex){
              System.out.println ("Error al conectar con la base de datos");
          }
          
          try{
              //Compilar el archivo generado tipo jrmxl
             JasperReport jasperReport = JasperCompileManager.compileReport(informeOrigen);
             
          }catch 	*/
}
                  
            
        
}
