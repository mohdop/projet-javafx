package inscription.ges.repositories.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import inscription.ges.core.MysqlDB;
import inscription.ges.entities.Etudiant;
import inscription.ges.repositories.IAttacheRepository;

public class AttacheRepository extends MysqlDB  implements IAttacheRepository {

    private static String SQL_INSCRIRE = "INSERT INTO `etudiant`(`matricule`,`nomComplet`,`tuteur`,`libelle`,`date_ins`) Values(?,?,?,?,?) ";
    private static String SQL_REINSCRIRE="INSERT INTO `etudiant`(`libelle`,`date_ins`,`matricule`) Values(?,?,?) ";
    private static String SQL_LISTER_ETUDIANT="SELECT * FROM `etudiant` WHERE `date_ins` LIKE ?";
    private static String SQL_LISTER_ETUDIANT_CLASSE=SQL_LISTER_ETUDIANT + "AND `libelle` LIKE ,";

    @Override
    public Etudiant insertEtudiant(Etudiant etudiant){
        this.ouvrirConnexion();
       
        try {
            ps=conn.prepareStatement(SQL_INSCRIRE,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,etudiant.getMatricule());
            ps.setString(2,etudiant.getNomComplet());
            ps.setString(3,etudiant.getTuteur());
            ps.setString(4,etudiant.getLibelle());
            ps.setString(5,etudiant.getAnnee());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                etudiant.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        this.fermerConnexion();
        return etudiant;
    }
     @Override
    public Etudiant ReInsertEtudiant(Etudiant etudiant){
        this.ouvrirConnexion();
       
        try {
            ps=conn.prepareStatement(SQL_REINSCRIRE,PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setString(1,etudiant.getLibelle());
            ps.setString(2,etudiant.getAnnee());
            ps.setString(3,etudiant.getMatricule());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
             if (rs.next()) {
                etudiant.setId(rs.getInt(1));
            }
            
        } catch (SQLException e) {
            System.out.println("not ok");
            e.printStackTrace();
        }
        this.fermerConnexion();
        return etudiant;
    } 

    @Override
    public List<Etudiant> findByAnnee(String annee) {
        List<Etudiant>  etudiants=new ArrayList<>();
        this.ouvrirConnexion();
        try {
              ps= conn.prepareStatement(SQL_LISTER_ETUDIANT) ;
              ps.setString(1, annee); 
              ResultSet rs=ps.executeQuery();
              Etudiant etudiant;
             
              while(rs.next()){
              
                etudiant=new Etudiant(rs.getString("date_ins"));
              }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.fermerConnexion();
        return etudiants;
        
    }
    @Override
    public List<Etudiant> findByAnneeClasse(String annee,String libelle) {
        List<Etudiant>  etudiants=new ArrayList<>();
        this.ouvrirConnexion();
        try {
              ps= conn.prepareStatement(SQL_LISTER_ETUDIANT) ;
              ps.setString(1, annee); 
              ps.setString(2, libelle); 
              ResultSet rs=ps.executeQuery();
              Etudiant etudiant;
             
              while(rs.next()){
              
                etudiant=new Etudiant(rs.getString("date_ins"),rs.getString("libelle"));
              }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.fermerConnexion();
        return etudiants;
        
    }
}
