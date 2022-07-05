module ir.ac.kntu {
    requires javafx.controls;
    requires javafx.fxml;

    opens ir.ac.kntu to javafx.fxml;
    exports ir.ac.kntu;
}