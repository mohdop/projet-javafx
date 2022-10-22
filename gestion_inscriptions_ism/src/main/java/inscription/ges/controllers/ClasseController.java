package inscription.ges.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import inscription.ges.core.Fabrique;
import inscription.ges.entities.Classe;
import inscription.ges.entities.ClasseProfesseur;
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

public class ClasseController implements Initializable{
    @FXML
    TextField libelleInscription,libelleAffecter,nciAffecter;
    @FXML
    TableView<Classe> tblClasses=new TableView<>();
    @FXML
    TableColumn<Classe,String> idColumn= new TableColumn<>();
    @FXML
    TableColumn<Classe,String> libelleColumn= new TableColumn<>();
    private final ObservableList obsclasse = FXCollections.observableList(Fabrique.getService().listerClasses());
     @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        libelleColumn.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        tblClasses.setItems(obsclasse);
    }
     
     public void handleCreerClasse(){
        String libelle = libelleInscription.getText().trim();        
        Classe classe= Fabrique.getService().ajouterClasse(new Classe(libelle));
        Alert alert= new Alert(AlertType.INFORMATION);
        alert.setTitle("Gestion Classe");
        alert.setContentText("Création de la classe effectcuée!");
        alert.show();
        obsclasse.add(classe);
        libelleInscription.clear();
    } 
    public void handleAffecter(){
        String libelle = libelleAffecter.getText().trim();
        String nci = nciAffecter.getText().trim();        
        ClasseProfesseur classepProfesseur= Fabrique.getService().profClasse(new ClasseProfesseur(nci,libelle));
        Alert alert= new Alert(AlertType.INFORMATION);
        alert.setTitle("Gestion Classe");
        alert.setContentText("Le professeur a été affecté à la clcasse!");
        alert.show();
        
    } 

    
}
