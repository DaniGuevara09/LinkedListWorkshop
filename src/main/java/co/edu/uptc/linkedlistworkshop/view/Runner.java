package co.edu.uptc.linkedlistworkshop.view;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;

public class Runner extends Application {

    private Label title;
    private Label subtitle;

    private Label createLabel;
    private Label readLabel;
    private Label updateLabel;
    private Label deleteLabel;

    private Button createBut;
    private Button readBut;
    private Button updateBut;
    private Button deleteBut;
    private Button exit;

    private VBox root;
    private GridPane grid;
    private Scene scene;

    public Runner() {
        title = new Label("Motorcycle information management");
        subtitle = new Label("Select an option");
        createLabel = new Label("1. Create a new moto");
        readLabel = new Label("2. View all motos");
        updateLabel = new Label("3. Update moto information");
        deleteLabel = new Label("4. Delete moto");
        createBut = new Button("Create");
        readBut = new Button("Read");
        updateBut = new Button("Update");
        deleteBut = new Button("Delete");
        exit = new Button("Exit");
        root = new VBox();
        grid = new GridPane();
        scene = new Scene(root, 800, 800);
    }

    @Override
    public void start(Stage stage) throws IOException {
        events();
        scene.getStylesheets().add(new File("src/main/java/co/edu/uptc/linkedlistworkshop/view/Style.css").toURI().toString());

        // Column, row
        grid.add(createLabel, 0, 0);
        grid.add(readLabel, 0, 1);
        grid.add(updateLabel, 0, 2);
        grid.add(deleteLabel, 0, 3);
        grid.add(createBut, 1, 0);
        grid.add(readBut, 1, 1);
        grid.add(updateBut, 1, 2);
        grid.add(deleteBut, 1, 3);

        title.setId("title");
        subtitle.setId("subtitle");
        root.setId("root");

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(50);
        grid.setVgap(50);

        root.getChildren().addAll(title, subtitle, grid, exit);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(55);

        stage.setTitle("Motos");
        stage.setScene(scene);
        stage.show();
    }

    public void events(){
        exit.setOnAction(event -> {
            Platform.exit();
        });
    }

    public static void main(String[] args) {
        launch();
    }
}
