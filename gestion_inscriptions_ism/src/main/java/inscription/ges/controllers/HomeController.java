package inscription.ges.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import inscription.ges.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class HomeController implements Initializable{

    @FXML
    AnchorPane anchorContent;
    @FXML
    Button classButton,professeurButton;
    public void handleDeconnexion() throws IOException{
        App.setRoot("connexion");
    }




    public void loadView(String fxml) throws IOException{
        AnchorPane root = (AnchorPane) App.loadFXML(fxml);
        anchorContent.getChildren().clear();
        anchorContent.getChildren().add(root);
    }
    public void handleLoadViewClasse() throws IOException{
        this.loadView("classe");
    }
    public void handleLoadViewProfesseur() throws IOException{
        this.loadView("professeur");
    }
    
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        try {
            this.loadView("professeur");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
