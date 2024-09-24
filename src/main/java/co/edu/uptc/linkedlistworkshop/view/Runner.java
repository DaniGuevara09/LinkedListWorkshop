package co.edu.uptc.linkedlistworkshop.view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Runner extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VBox root = new VBox();
        GridPane grid = new GridPane();
        Scene scene = new Scene(root, 800, 800);
        scene.getStylesheets().add(new File("src/main/java/co/edu/uptc/linkedlistworkshop/view/Style.css").toURI().toString());

        Label title = new Label("Motorcycle information management");
        Label subtitle = new Label("Select an option");

        Label createLabel = new Label("1. Create a new moto");
        Label readLabel = new Label("2. View all motos");
        Label updateLabel = new Label("3. Update moto information");
        Label deleteLabel = new Label("4. Delete moto");

        Button createBut = new Button("Create");
        Button readBut = new Button("Read");
        Button updateBut = new Button("Update");
        Button deleteBut = new Button("Delete");

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
        root.setId("root");

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(50);
        grid.setVgap(50);

        root.getChildren().addAll(title, subtitle, grid);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(50);

        stage.setTitle("Motos");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
