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
 * The Delete class manages the user interface for deleting a motorcycle from the linked list.
 * It includes a search functionality and shows the details of the motorcycle before confirming the deletion.
 */
public class Delete {

    private ListManagement listManagement;
    private Stage stage;
    private Scene scene;

    private VBox root;
    private TextField textField;
    private Separator separator;
    private Label label;
    private HBox hBoxBtns;
    private Button returnBtn;
    private Button delete;
    private Button searchBtn;

    /**
     * Constructor initializes the UI components, such as buttons, text fields, and labels for
     * the delete window. It also initializes the ListManagement object to interact with the data.
     */
    public Delete() {
        listManagement = new ListManagement();
        root = new VBox();
        hBoxBtns = new HBox();
        stage = new Stage();
        textField = new TextField("Enter the Motorcycle Id");
        separator = new Separator();
        label = new Label();
        searchBtn = new Button("Search");
        returnBtn = new Button("Return");
        delete = new Button("Delete");
        scene = new Scene(root, 500, 555);
    }

    /**
     * Displays the delete window, allowing the user to search for a motorcycle by ID
     * and delete it after confirmation. The window is configured as a modal dialog.
     * @param primaryStage the parent stage that will be blocked while this window is open.
     * @param listManagement the ListManagement object to manage the list of motorcycles.
     */
    public void scene(Stage primaryStage, ListManagement listManagement) {
        this.listManagement = listManagement;
        scene.getStylesheets()
                .add(new File("src/main/java/co/edu/uptc/linkedlistworkshop/view/Style.css").toURI().toString());
        root.setId("rootSearch");
        textField.setId("txtSearch");

        events();
        moto();

        // Adjust margins for components
        VBox.setMargin(textField, new Insets(10, 0, 20, 0));
        VBox.setMargin(label, new Insets(30, 0, 50, 25));
        HBox.setMargin(returnBtn, new Insets(0, 25, 0, 25));
        HBox.setMargin(delete, new Insets(0, 25, 0, 25));

        hBoxBtns.getChildren().addAll(searchBtn, delete, returnBtn);

        root.getChildren().addAll(textField, separator, label, hBoxBtns);
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT); // Hide window title and buttons
        stage.initModality(Modality.WINDOW_MODAL); // Block interaction with the parent window
        stage.initOwner(primaryStage);
        stage.setScene(scene);
        stage.showAndWait();
    }

    /**
     * Sets a default label template with placeholders for displaying motorcycle information.
     */
    public void moto(){
        label = new Label("- ID: " + "\n\n- Brand: " + "\n\n- Model: " + "\n\n- Color: " + "\n\n- Year: " + "\n\n- EngineSize: " + " c.c" + "\n\n- Price: $");
    }

    /**
     * Defines the event listeners for the text field and buttons. When a valid ID is entered,
     * the motorcycle's information is displayed, and the user can choose to delete it.
     */
    public void events(){
        returnBtn.setOnAction(event -> stage.close());

        textField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                String input = textField.getText();
                int id = listManagement.isNumericInt(input);

                if (id == -1) {
                    textField.setText("Enter a numeric value");
                    textField.setStyle("-fx-text-fill: #B52626;");
                } else if (!listManagement.idValidation(id)){
                    textField.setText("Enter natural numbers");
                    textField.setStyle("-fx-text-fill: #B52626;");
                } else if (listManagement.findNode(id) == null) {
                    textField.setText("This ID doesn't exists");
                    textField.setStyle("-fx-text-fill: #B52626;");
                } else {
                    textField.setStyle("-fx-text-fill: white;");

                    searchBtn.setOnAction(event -> {
                        Moto moto = listManagement.findNode(id).getInfo();
                        label.setText("- ID: " + moto.getId() + "\n\n- Brand: " + moto.getBrand() + "\n\n- Model: " + moto.getModel() + "\n\n- Color: " + moto.getColor() + "\n\n- Year: " + moto.getYear() + "\n\n- EngineSize: " + moto.getEngineSize() + " c.c" + "\n\n- Price: $" + moto.getPrice());
                    });

                    delete.setOnAction(event -> {
                        listManagement.deleteNode(id);
                        Confirmation config = new Confirmation();
                        config.scene(null, "Deleted Successfully");
                        stage.close();
                    });
                }
            }
        });
    }
}