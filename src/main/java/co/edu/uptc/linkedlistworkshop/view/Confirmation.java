package co.edu.uptc.linkedlistworkshop.view;

import co.edu.uptc.linkedlistworkshop.controller.ListManagement;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.File;

/**
 * The Confirmation class represents a simple confirmation dialog window in the user interface.
 * It displays a message and provides a button to return to the previous window.
 */
public class Confirmation {
    private Stage stage;
    private Scene scene;

    private VBox root;
    private Label label;
    private Button returnBtn;

    /**
     * Constructor that initializes the window components including the label, return button,
     * and the layout for displaying the confirmation message.
     */
    public Confirmation() {
        root = new VBox();
        stage = new Stage();
        label = new Label();
        returnBtn = new Button("Return");
        scene = new Scene(root, 800, 150);
    }

    /**
     * Displays the confirmation window with a specified message. The window is styled with an external
     * CSS file and is configured as a modal that blocks interaction with the parent window until closed.
     * @param primaryStage the owner stage that will be blocked while this window is active.
     * @param message the confirmation message to display in the dialog.
     */
    public void scene(Stage primaryStage, String message) {
        label.setText(message); // Set the message to be displayed
        scene.getStylesheets()
                .add(new File("src/main/java/co/edu/uptc/linkedlistworkshop/view/Style.css").toURI().toString()); // Add styles
        root.setId("rootSearch");

        returnBtn.setOnAction(event -> stage.close()); // Close the window when the button is pressed

        // Configure the layout settings
        root.setSpacing(40);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(label, returnBtn);

        // Configure the stage settings
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT); // Remove window title and exit buttons
        stage.initModality(Modality.WINDOW_MODAL); // Block the parent window until this window is closed
        stage.initOwner(primaryStage); // Set the parent window
        stage.setScene(scene);
        stage.showAndWait(); // Show the window and wait until it is closed
    }
}