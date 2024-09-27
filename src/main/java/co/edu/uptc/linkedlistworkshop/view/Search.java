package co.edu.uptc.linkedlistworkshop.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.File;

public class Search {

    private Stage stage;
    private Scene scene;

    private VBox root;
    private TextField textField;
    private Separator separator;
    private Label label;
    private Button returnBtn;

    public Search() {
        root = new VBox();
        stage = new Stage();
        textField = new TextField("Enter the Motorcycle Id");
        separator = new Separator();
        label = new Label();
        returnBtn = new Button("Return");
        scene = new Scene(root, 500, 555);
    }

    public void scene(Stage primaryStage) {
        scene.getStylesheets()
                .add(new File("src/main/java/co/edu/uptc/linkedlistworkshop/view/Style.css").toURI().toString());
        root.setId("rootSearch");
        textField.setId("txtSearch");

        moto();
        returnBtn.setOnAction(event -> stage.close());

        // Up, right, down, left
        VBox.setMargin(textField, new Insets(10, 0, 20, 0));
        VBox.setMargin(label, new Insets(30, 0, 50, 25));
        VBox.setMargin(returnBtn, new Insets(0, 0, 0, 150));

        root.getChildren().addAll(textField, separator, label, returnBtn);
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT); // Without name and exit button
        stage.initModality(Modality.WINDOW_MODAL); // Block the first window
        stage.initOwner(primaryStage);
        stage.setScene(scene);
        stage.showAndWait();
    }

    public void moto(){
        label = new Label("- ID: " + "\n\n- Brand: " + "\n\n- Model: " + "\n\n- Color: " + "\n\n- Year: " + "\n\n- EngineSize: " + " c.c" + "\n\n- Price: $");
    }
}
