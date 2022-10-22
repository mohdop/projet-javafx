module inscription.ges {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    opens inscription.ges.controllers to javafx.fxml;
    opens inscription.ges.entities to javafx.base;
    
    exports inscription.ges;
}
