package inscription.ges.repositories.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import inscription.ges.core.MysqlDB;
import inscription.ges.entities.Classe;
import inscription.ges.entities.ClasseProfesseur;
import inscription.ges.entities.Professeur;
import inscription.ges.repositories.IResponsablePedagogiqueRepository;

public class ResponsablePedagogiqueRepository extends MysqlDB  implements IResponsablePedagogiqueRepository{
    private static String SQL_INSERT_CLASSE="INSERT INTO `classe`(`libelle`) VALUES (?)";
    private static String SQL_INSERT_PROFESSEUR="INSERT INTO `professeurs`(`nci`,`nom_complet`,`grade`) VALUES (?,?,?)";
    private final String SQL_LIST_CLASSES_PROF="SELECT * FROM `classe_professeur` WHERE `nci` LIKE ? ";
    private static String SQL_LIST_ALL_CLASSES="SELECT * FROM `classe`";
    private static String SQL_LIST_ALL_PROFESSEURS="SELECT * FROM `professeurs`";
    private static String SQL_INSERT_CLASSE_PROF="INSERT INTO `classe_professeur`(`nci`,`libelle`) ";

    @Override
    public List<Classe> findall() {
        List<Classe> classes = new ArrayList<>();
       
        try {
            this.ouvrirConnexion();
            Statement stm = conn.createStatement();
            //4-recuperer les results
            ResultSet rs= stm.executeQuery(SQL_LIST_ALL_CLASSES);
            while(rs.next()){
                //un enregistrement ou une ligne de la table
                Classe classe = new Classe(
                    rs.getInt(1),
                    rs.getString("libelle")
                    );
                classes.add(classe);
            }
            this.fermerConnexion();;
        } catch (SQLException e){
            e.printStackTrace();
        }        
        return classes;
    }

    @Override
    public Professeur insertProfesseur(Professeur professeur){
        this.ouvrirConnexion();
       
        try {
            ps=conn.prepareStatement(SQL_INSERT_PROFESSEUR,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,professeur.getNci());
            ps.setString(2,professeur.getNomComplet());
            ps.setString(3,professeur.getGrade());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                professeur.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        this.fermerConnexion();
        return professeur;
    }
    
    @Override
    public ClasseProfesseur profClasse(ClasseProfesseur classeProfesseur){
        this.ouvrirConnexion();
        try {
            ps=conn.prepareStatement(SQL_INSERT_CLASSE_PROF,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,classeProfesseur.getLibelle());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                classeProfesseur.setId(rs.getInt(1));
            }
        } catch (Exception e) {
           
        }this.fermerConnexion();
        return classeProfesseur;
    }

    @Override
    public Classe insertClasse(Classe classe){
        this.ouvrirConnexion();
       
        try {
            ps=conn.prepareStatement(SQL_INSERT_CLASSE,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,classe.getLibelle());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                classe.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        this.fermerConnexion();
        return classe;
    }
    @Override
    public List<Professeur> findallProf() {
        List<Professeur> professeurs = new ArrayList<>();
      

        try {
            this.ouvrirConnexion();
            Statement stm = conn.createStatement();
            ResultSet rs= stm.executeQuery(SQL_LIST_ALL_PROFESSEURS);
            while(rs.next()){
                Professeur professeur = new Professeur(
                    rs.getInt(1),
                    rs.getString("nom_complet"),
                    rs.getString("grade")
                    );
               professeurs.add(professeur);
            }
            this.fermerConnexion();;
        } catch (SQLException e){
            e.printStackTrace();
        }        
        return professeurs;
    }

    @Override

     public List<ClasseProfesseur> findClasseProfesseurs(String nci) {
        List<ClasseProfesseur> classes = new ArrayList<>();
        this.ouvrirConnexion();
        try 
        {
            ps = conn.prepareStatement(SQL_LIST_CLASSES_PROF);
            ps.setString(1,nci);
            ResultSet rs = ps.executeQuery();
            ClasseProfesseur classeProfesseur;
            while(rs.next())
            {
                classeProfesseur = new ClasseProfesseur(
                    rs.getInt("id"),
                    rs.getString("libelle")
                );  
                classes.add(classeProfesseur);
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        this.fermerConnexion();
        return classes;
    }

  
    
}
