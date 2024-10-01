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

public class Total {
    private ListManagement listManagement;
    private Stage stage;
    private Scene scene;

    private VBox root;
    private Label label;
    private Button returnBtn;

    public Total() {
        listManagement = new ListManagement();
        root = new VBox();
        stage = new Stage();
        label = new Label("Last Motorcycle");
        returnBtn = new Button("Return");
        scene = new Scene(root, 800, 150);
    }

    public void scene(Stage primaryStage, ListManagement listManagement) {
        scene.getStylesheets()
                .add(new File("src/main/java/co/edu/uptc/linkedlistworkshop/view/Style.css").toURI().toString());
        root.setId("rootSearch");

        label.setText("The Number of Stored Motorcycles is: " + listManagement.getSize());
        returnBtn.setOnAction(event -> stage.close());

        root.setSpacing(40);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(label, returnBtn);
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT); // Without name and exit button
        stage.initModality(Modality.WINDOW_MODAL); // Block the first window
        stage.initOwner(primaryStage);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
