package inscription.ges.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import inscription.ges.core.Fabrique;
import inscription.ges.entities.Etudiant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class InscriptionController implements Initializable {
    @FXML
    TextField matricule,nomComplet,tuteur,classe,annee;
    @FXML
    Button enregistrerReinscription,enregistrerInscription,inscription,reinscription;
   // private final ObservableList obsetudiant = FXCollections.observableList(Fabrique.getService().listerProfesseurs());

    public void handleInscription(){
            String matr = matricule.getText().trim();    
            String nom_Complet = nomComplet.getText().trim();     
            String tut = tuteur.getText().trim();     
            String libelle=classe.getText().trim();
            String an=annee.getText().trim();
            Etudiant etudiant=Fabrique.getService().ajouterEtudiant(new Etudiant(matr, nom_Complet,tut,libelle,an));
            Alert alert= new Alert(AlertType.INFORMATION);
            alert.setTitle("Ajout de l'étudiant");
            alert.setContentText("L'ajout de l'étudiant a été effectcuée!");
            alert.show();
            matricule.clear();
            nomComplet.clear();
            tuteur.clear();
            
           // obsetudiant.add(etudiant);
    };
     public void handleReinscription(){
        String libelle=classe.getText().trim();
        String an=annee.getText().trim();
        String matr = matricule.getText().trim();
        Etudiant etudiant=Fabrique.getService().ReAjouterEtudiant(new Etudiant(libelle,an,matr));
    } 
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        inscription.setDisable(true);
        enregistrerReinscription.setDisable(true);
    };
    public void faireInscription(){
        inscription.setDisable(true);
        reinscription.setDisable(false);
        enregistrerInscription.setDisable(false);
        enregistrerReinscription.setDisable(true);
        matricule.setDisable(false);
        nomComplet.setDisable(false);
        tuteur.setDisable(false);

    }
    public void faireReinscription(){
        inscription.setDisable(false);
        reinscription.setDisable(true);
        enregistrerReinscription.setDisable(false);
        enregistrerInscription.setDisable(true);

        matricule.setDisable(false);
        nomComplet.setDisable(true);
        tuteur.setDisable(true);
    }
}