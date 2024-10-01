package co.edu.uptc.linkedlistworkshop.view;

import co.edu.uptc.linkedlistworkshop.controller.ListManagement;
import co.edu.uptc.linkedlistworkshop.model.Moto;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.File;

/**
 * The Search class provides a window for searching a motorcycle by its ID.
 * It allows the user to enter an ID and search for the corresponding motorcycle in the system.
 * If the ID exists, the details of the motorcycle are displayed.
 */
public class Search {

    // ListManagement instance to handle operations on the motorcycle list
    private ListManagement listManagement;

    // UI components including the search window stage, scene, and layout elements
    private Stage stage;
    private Scene scene;
    private VBox root;
    private TextField textField;
    private Separator separator;
    private Label label;
    private Button returnBtn;
    private Button searchBtn;
    private HBox hBoxBtns;

    /**
     * Constructor for the Search class.
     * Initializes the UI components like text field, buttons, labels, and sets up the layout.
     */
    public Search() {
        listManagement = new ListManagement();  // Create a new ListManagement instance
        root = new VBox();
        stage = new Stage();
        textField = new TextField("Enter the Motorcycle Id");
        separator = new Separator();
        label = new Label();
        hBoxBtns = new HBox();
        returnBtn = new Button("Return");
        searchBtn = new Button("Search");
        scene = new Scene(root, 500, 555);
    }

    /**
     * Initializes and displays the search window.
     * This method sets up the scene, event listeners, and styles for the search window.
     *
     * @param primaryStage The parent stage that will be blocked while this window is open.
     * @param listManagement The ListManagement instance to interact with the motorcycle list.
     */
    public void scene(Stage primaryStage, ListManagement listManagement) {
        this.listManagement = listManagement;  // Assign the passed ListManagement instance

        // Add the external stylesheet to the scene
        scene.getStylesheets()
                .add(new File("src/main/java/co/edu/uptc/linkedlistworkshop/view/Style.css").toURI().toString());

        root.setId("rootSearch");
        textField.setId("txtSearch");

        // Set up the initial display for the motorcycle information section
        moto();
        events();  // Initialize event listeners

        // Set up the return button to close the window
        returnBtn.setOnAction(event -> stage.close());

        // Add the search and return buttons to the HBox
        hBoxBtns.getChildren().addAll(searchBtn, returnBtn);

        // Set margins for the UI elements
        VBox.setMargin(textField, new Insets(10, 0, 20, 0));
        VBox.setMargin(label, new Insets(30, 0, 50, 25));
        HBox.setMargin(returnBtn, new Insets(0, 25, 0, 25));
        HBox.setMargin(searchBtn, new Insets(0, 25, 0, 25));

        // Add components to the root layout
        root.getChildren().addAll(textField, separator, label, hBoxBtns);

        // Set scene and stage properties for the search window
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);  // Transparent stage without window decorations
        stage.initModality(Modality.WINDOW_MODAL);  // Block the parent window while this one is active
        stage.initOwner(primaryStage);  // Set the owner of this window
        stage.setScene(scene);  // Set the scene to the stage
        stage.showAndWait();  // Show the window and wait for it to close
    }

    /**
     * Sets up the event listeners for user interactions in the search window.
     * Listens for focus changes on the text field and checks the validity of the entered ID.
     * If a valid ID is entered, the corresponding motorcycle details are displayed.
     */
    public void events(){
        textField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            // When the text field loses focus, check the input
            if (!newValue) {
                String input = textField.getText();
                int id = listManagement.isNumericInt(input);  // Validate if the input is numeric

                if (id == -1) {
                    // Show error if input is not a numeric value
                    textField.setText("Enter a numeric value");
                    textField.setStyle("-fx-text-fill: #B52626;");
                } else if (!listManagement.idValidation(id)){
                    // Show error if input is not a natural number
                    textField.setText("Enter natural numbers");
                    textField.setStyle("-fx-text-fill: #B52626;");
                } else if (listManagement.findNode(id) == null) {
                    // Show error if the ID does not exist
                    textField.setText("This ID doesn't exist");
                    textField.setStyle("-fx-text-fill: #B52626;");
                } else {
                    // Reset the text style if the input is valid
                    textField.setStyle("-fx-text-fill: white;");

                    // Set up the search button to display motorcycle details when clicked
                    searchBtn.setOnAction(event -> {
                        Moto moto = listManagement.findNode(id).getInfo();
                        label.setText("- ID: " + moto.getId() + "\n\n- Brand: " + moto.getBrand() +
                                "\n\n- Model: " + moto.getModel() + "\n\n- Color: " + moto.getColor() +
                                "\n\n- Year: " + moto.getYear() + "\n\n- EngineSize: " + moto.getEngineSize() +
                                " c.c" + "\n\n- Price: $" + moto.getPrice());
                    });
                }
            }
        });
    }

    /**
     * Initializes the motorcycle information display area with placeholder text.
     * This is used to provide structure to the display before any search results are shown.
     */
    public void moto(){
        label.setText("- ID: " + "\n\n- Brand: " + "\n\n- Model: " + "\n\n- Color: " + "\n\n- Year: " +
                "\n\n- EngineSize: " + " c.c" + "\n\n- Price: $");
    }
}
