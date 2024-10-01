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

public class GetFirst {
    private ListManagement listManagement;
    private Stage stage;
    private Scene scene;

    private VBox root;
    private Label title;
    private Separator separator;
    private Label label;
    private Button returnBtn;

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

    public void scene(Stage primaryStage, ListManagement listManagement) {
        this.listManagement = listManagement;
        scene.getStylesheets()
                .add(new File("src/main/java/co/edu/uptc/linkedlistworkshop/view/Style.css").toURI().toString());
        root.setId("rootSearch");

        moto();
        returnBtn.setOnAction(event -> stage.close());

        title.setPrefWidth(200);

        Moto moto = listManagement.getFist();
        label.setText("- ID: " + moto.getId() + "\n\n- Brand: " + moto.getBrand() + "\n\n- Model: " + moto.getModel() +
                "\n\n- Color: " + moto.getColor() + "\n\n- Year: " + moto.getYear() + "\n\n- EngineSize: " +
                moto.getEngineSize() + " c.c" + "\n\n- Price: $" + moto.getPrice());

        // Up, right, down, left
        VBox.setMargin(title, new Insets(10, 0, 20, 150));
        VBox.setMargin(label, new Insets(30, 0, 50, 25));
        VBox.setMargin(returnBtn, new Insets(0, 0, 0, 150));

        root.getChildren().addAll(title, separator, label, returnBtn);
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT); // Without name and exit button
        stage.initModality(Modality.WINDOW_MODAL); // Block the first window
        stage.initOwner(primaryStage);
        stage.setScene(scene);
        stage.showAndWait();
    }

    public void moto() {
        label = new Label(
                "- ID: " + "\n\n- Brand: " + "\n\n- Model: " + "\n\n- Color: " + "\n\n- Year: " + "\n\n- EngineSize: " +
                        " c.c" + "\n\n- Price: $");
    }
}
