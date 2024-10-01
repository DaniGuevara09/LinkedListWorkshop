package co.edu.uptc.linkedlistworkshop.view;

import co.edu.uptc.linkedlistworkshop.controller.ListManagement;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.File;

/**
 * The AddAfterBefore class handles the graphical interface for adding a node before or after an existing node
 * in the linked list of motorcycles. It provides the ability to input the current motorcycle ID, validate the input,
 * and proceed to the next screen for adding a motorcycle.
 */
public class AddAfterBefore {
    private ListManagement listManagement;

    private Stage prevStage;
    private Scene prevScene;

    private Stage stage;
    private Scene scene;

    private VBox root;
    private TextField textField;
    private Button returnBtn;
    private Button nextBtn;
    private HBox buttons;

    private int menuOption;
    private int currentNodeId;

    /**
     * Constructor that initializes the user interface components such as text fields, buttons, and layout containers.
     * It also sets up a new Stage for displaying the window.
     */
    public AddAfterBefore() {
        listManagement = new ListManagement();
        root = new VBox();
        stage = new Stage();
        prevStage = new Stage();
        textField = new TextField("Enter the Current Motorcycle Id");
        returnBtn = new Button("Return");
        nextBtn = new Button("Next");
        buttons = new HBox();
        scene = new Scene(root, 800, 150);
    }

    /**
     * Sets up the main scene for the "Add After/Before" window. This method links the previous stage and scene,
     * configures the UI elements, applies styles, and sets the event handlers for user interaction.
     * @param primaryStage the previous stage to which the window is linked.
     * @param lastScene the previous scene that will be restored when this window closes.
     * @param op the operation type (either adding before or after the selected node).
     * @param management the ListManagement instance for managing the linked list of motorcycles.
     */
    public void scene(Stage primaryStage, Scene lastScene, int op, ListManagement management) {
        prevScene = lastScene;
        prevStage = primaryStage;
        listManagement = management;
        menuOption = op;

        // Applying CSS styles to the UI elements
        scene.getStylesheets()
                .add(new File("src/main/java/co/edu/uptc/linkedlistworkshop/view/Style.css").toURI().toString());
        root.setId("rootSearch");
        textField.setId("txtSearch2");

        // Event handler for the return button
        returnBtn.setOnAction(event -> stage.close());
        events();

        // Setting up the layout for buttons and aligning UI elements
        buttons.getChildren().addAll(nextBtn, returnBtn);
        buttons.setSpacing(100);
        buttons.setAlignment(Pos.CENTER);

        root.setAlignment(Pos.CENTER);
        root.setSpacing(40);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(textField, buttons);

        // Configure the stage settings
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT); // Hides window name and exit button
        stage.initModality(Modality.WINDOW_MODAL); // Blocks interaction with the previous window
        stage.setScene(scene);
        stage.showAndWait(); // Displays the window and waits for it to be closed
    }

    /**
     * Closes the current window and opens the window for adding a new motorcycle.
     * It passes relevant data such as the menu option and current node ID to the next window.
     */
    public void addMotoWindow(){
        stage.close();
        NewMoto newMoto = new NewMoto();
        newMoto.setListManagement(listManagement);
        Runner run = new Runner();
        run.addMotoWindow(newMoto, menuOption, prevStage, prevScene, currentNodeId, listManagement);
    }

    /**
     * Sets up event listeners for validating the user input in the text field.
     * It checks whether the input is numeric, ensures that the ID is valid,
     * and verifies that the node with the specified ID exists in the list.
     */
    public void events(){
        textField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // Executes when focus is lost
                String input = textField.getText();
                int id = listManagement.isNumericInt(input);

                // Check if the input is a valid numeric ID
                if (id == -1) {
                    textField.setText("Enter a numeric value");
                    textField.setStyle("-fx-text-fill: #B52626;"); // Display error in red text
                } else if (!listManagement.idValidation(id)){
                    textField.setText("Enter natural numbers");
                    textField.setStyle("-fx-text-fill: #B52626;");
                } else if (listManagement.findNode(id) == null) {
                    textField.setText("This ID doesn't exist");
                    textField.setStyle("-fx-text-fill: #B52626;");
                } else {
                    currentNodeId = id;
                    textField.setStyle("-fx-text-fill: white;");
                    nextBtn.setOnAction(e -> addMotoWindow()); // Proceed to the next window on valid input
                }
            }
        });
    }
}