module co.edu.uptc.linkedlistworkshop {
    requires javafx.controls;
    requires javafx.fxml;

    exports co.edu.uptc.linkedlistworkshop.view;
    opens co.edu.uptc.linkedlistworkshop.model to javafx.base;
}