package inscription.ges.controllers;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import inscription.ges.core.Fabrique;
import inscription.ges.entities.ClasseProfesseur;
import inscription.ges.entities.Professeur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;





public class ProfesseurController implements Initializable {
    @FXML
    TextField nciProfesseur,nomComplet,gradeProfesseur,nciProf;

    @FXML
    TableView<Professeur> listProf=new TableView<>();

    @FXML
    TableColumn<Professeur,String> idProfColumn= new TableColumn<>();

    @FXML
    TableColumn<Professeur,String> nomProfComplet= new TableColumn<>();

    @FXML
    TableColumn<Professeur,String> gradeProfColumn= new TableColumn<>();

    @FXML
    TableColumn<Professeur,String> idClasseProf= new TableColumn<>();
    @FXML
    TableColumn<Professeur,String> libelle= new TableColumn<>();
    TableView<Professeur> tblClasseProf = new TableView<>();
    ObservableList obsclasseprof;
            
   

    private final ObservableList obsprof = FXCollections.observableList(Fabrique.getService().listerProfesseurs());
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        idProfColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomProfComplet.setCellValueFactory(new PropertyValueFactory<>("nomComplet"));
        gradeProfColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
        idClasseProf.setCellValueFactory(new PropertyValueFactory<>("id"));
        libelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        listProf.setItems(obsprof);
        tblClasseProf.setItems(obsclasseprof);

    }

    public void handleAjouterProf(){
        {
            String nci = nciProfesseur.getText().trim();    
            String nom_Complet = nomComplet.getText().trim();     
            String grade = gradeProfesseur.getText().trim();     

            Professeur professeur= Fabrique.getService().ajouterProfesseur(new Professeur(nom_Complet, grade, nci));
            Alert alert= new Alert(AlertType.INFORMATION);
            alert.setTitle("Ajout de Professeur");
            alert.setContentText("L'ajout du professeur a été effectcuée!");
            alert.show();
            nciProfesseur.clear();
            nomComplet.clear();
            gradeProfesseur.clear();
            obsprof.add(professeur);
        } 
    }
    

    public List<ClasseProfesseur> handleRechercherClasses(){
        String ncil = nciProf.getText();
        ClasseProfesseur classeProfesseur=new ClasseProfesseur(ncil);
        List<ClasseProfesseur> classes= Fabrique.getService().rechercheClasseProfesseurs(ncil); 
        obsclasseprof = FXCollections.observableList(Fabrique.getService().rechercheClasseProfesseurs(ncil));
        obsclasseprof.add(classeProfesseur);       
        return classes;
    }    
}
