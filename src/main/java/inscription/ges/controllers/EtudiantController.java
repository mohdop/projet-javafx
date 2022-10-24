package inscription.ges.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import inscription.ges.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class EtudiantController implements Initializable {



    @FXML
    AnchorPane anchorContent;

    public void loadView(String fxml) throws IOException{
        AnchorPane root = (AnchorPane) App.loadFXML(fxml);
        anchorContent.getChildren().clear();
        anchorContent.getChildren().add(root);
    }
    public void handleDeconnexion() throws IOException{
        App.setRoot("connexion");
    }

    public void handleLoadViewInscription() throws IOException{
        this.loadView("inscription");
    }
    public void handleLoadViewLister() throws IOException{
        //inscription->liste
        this.loadView("liste");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
      
        try {
            this.loadView("inscription");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
