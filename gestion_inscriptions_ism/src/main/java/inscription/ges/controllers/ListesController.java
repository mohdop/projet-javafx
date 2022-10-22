package inscription.ges.controllers;

import java.util.List;

import inscription.ges.core.Fabrique;
import inscription.ges.entities.Etudiant;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListesController {
    @FXML
    TextField libelleClasse,annee;

    @FXML
    TableView tableEtudiant;

    @FXML
    TableColumn matriculeColumn,libelleColumn,anneeColumn;

    ObservableList obsEtudiant;

    private void loadTableCompte(String annee,String libelle){
        //Conversion List-> ObservableList
        if (libelle=="") {
            obsEtudiant=FXCollections.observableList(Fabrique.getService().ListerParAnnee(annee));
        }else{
            obsEtudiant=FXCollections.observableList(Fabrique.getService().ListerParAnneeClasse(annee,libelle));
        }
        
        //Abonnement
        tableEtudiant.setItems(obsEtudiant);
        //Construction des colonnes
        matriculeColumn.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        libelleColumn.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        anneeColumn.setCellValueFactory(new PropertyValueFactory<>("date_ins"));
     }

    
   public List<Etudiant> handleRechercher(){
    Etudiant etudiant;
    List<Etudiant> etudiants;
       if(libelleClasse==null){
        String an =annee.getText().trim();
        String libelle =libelleClasse.getText().trim();
        etudiant = new Etudiant(an);
        etudiants =Fabrique.getService().ListerParAnnee(an);
        obsEtudiant= FXCollections.observableList(Fabrique.getService().ListerParAnnee(an));
        obsEtudiant.add(etudiant);
       
          loadTableCompte(an,libelle);
       }else{
        String an =annee.getText().trim();
        String libelle =libelleClasse.getText().trim();
        etudiant = new Etudiant(an,libelle);
        etudiants =Fabrique.getService().ListerParAnneeClasse(an,libelle);
        obsEtudiant= FXCollections.observableList(Fabrique.getService().ListerParAnneeClasse(an,libelle));
        obsEtudiant.add(etudiant);
        
          loadTableCompte(an,libelle);
       }
       return etudiants;
   }

    //public void handleRechercher()
    //ListerParAnnee(String annee)
    
}
