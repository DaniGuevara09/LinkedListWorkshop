package co.edu.uptc.linkedlistworkshop.view;

import co.edu.uptc.linkedlistworkshop.controller.ListManagement;
import co.edu.uptc.linkedlistworkshop.model.Moto;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.File;

/**
 * The GetFirst class displays the details of the first motorcycle in the linked list.
 * It provides a simple user interface to view the information of the first node in the list.
 */
public class GetFirst {
    private ListManagement listManagement;
    private Stage stage;
    private Scene scene;

    private VBox root;
    private Label title;
    private Separator separator;
    private Label label;
    private Button returnBtn;

    /**
     * Constructor initializes the UI components for displaying the first motorcycle
     * and prepares the scene with styling and layout.
     */
    public GetFirst() {
        listManagement = new ListManagement();
        root = new VBox();
        stage = new Stage();
        title = new Label("First Motorcycle");
        separator = new Separator();
        label = new Label();
        returnBtn = new Button("Return");
        scene = new Scene(root, 500, 555);
    }

    /**
     * Displays the window that shows the details of the first motorcycle in the linked list.
     * The window is configured as a modal dialog.
     * @param primaryStage the parent stage that will be blocked while this window is open.
     * @param listManagement the ListManagement object to interact with the motorcycle list.
     */
    public void scene(Stage primaryStage, ListManagement listManagement) {
        this.listManagement = listManagement;
        scene.getStylesheets()
                .add(new File("src/main/java/co/edu/uptc/linkedlistworkshop/view/Style.css").toURI().toString());
        root.setId("rootSearch");

        moto();
        returnBtn.setOnAction(event -> stage.close());

        title.setPrefWidth(200);

        // Fetch the first motorcycle and display its details
        Moto moto = listManagement.getFist();
        label.setText("- ID: " + moto.getId() + "\n\n- Brand: " + moto.getBrand() + "\n\n- Model: " + moto.getModel() +
                "\n\n- Color: " + moto.getColor() + "\n\n- Year: " + moto.getYear() + "\n\n- EngineSize: " +
                moto.getEngineSize() + " c.c" + "\n\n- Price: $" + moto.getPrice());

        // Adjust margins for components
        VBox.setMargin(title, new Insets(10, 0, 20, 150));
        VBox.setMargin(label, new Insets(30, 0, 50, 25));
        VBox.setMargin(returnBtn, new Insets(0, 0, 0, 150));

        root.getChildren().addAll(title, separator, label, returnBtn);
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT); // Hide window title and buttons
        stage.initModality(Modality.WINDOW_MODAL); // Block interaction with the parent window
        stage.initOwner(primaryStage);
        stage.setScene(scene);
        stage.showAndWait();
    }

    /**
     * Initializes a default label template with placeholders for the motorcycle details.
     */
    public void moto() {
        label = new Label(
                "- ID: " + "\n\n- Brand: " + "\n\n- Model: " + "\n\n- Color: " + "\n\n- Year: " + "\n\n- EngineSize: " +
                        " c.c" + "\n\n- Price: $");
    }
}