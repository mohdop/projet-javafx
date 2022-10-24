package inscription.ges.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import inscription.ges.App;
import inscription.ges.core.Fabrique;
import inscription.ges.entities.Role;
import inscription.ges.entities.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ConnexionController implements Initializable{
    @FXML
    Text lblError;
    @FXML
    TextField loginField;
    @FXML
    PasswordField pwdField;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        lblError.setVisible(false);
    }
    public void handleConnexion() throws IOException{
        String login=loginField.getText().trim();
        String password=pwdField.getText().trim();
        User user = Fabrique.getService().seConnecter(login, password);
        if(user==null){
            lblError.setVisible(true);
        }else{
          // App.setRoot("home");
               if(user.getRole()==Role.ResponsablePedagogique){
                 App.setRoot("home");
             }  else{
                App.setRoot("etudiant");
             }
        }
    }
    public void handleAnnuler(){
        loginField.setText("");
        pwdField.setText("");
    }
    
}