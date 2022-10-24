package inscription.ges.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class MysqlDB implements IMysqlDB {

    public Connection conn;
    public PreparedStatement ps;

    @Override
    public void ouvrirConnexion() {
        try {
            //1-charger le driver
           Class.forName("com.mysql.cj.jdbc.Driver");
           //2-ouvrir la connexion
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_inscriptions_ism","root","");
                System.out.println("connecté à la bd");
            } catch (SQLException e) {
                System.out.println("echec conn");

                e.printStackTrace();
            }
           System.out.println("connected");}
        
        
       catch (ClassNotFoundException e) {
           
           e.printStackTrace();
       }
   
    }

    @Override
    public void fermerConnexion() {
        //l'objet conn est initialisé par défaut à null car ils est un "attribut de classe"
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                
                e.printStackTrace();
            }
        }
    }
    @Override
    public void initPreparedStatement() {
      
        
    }
    
}
