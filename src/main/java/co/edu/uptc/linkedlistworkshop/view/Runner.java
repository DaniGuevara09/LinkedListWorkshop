package co.edu.uptc.linkedlistworkshop.view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Runner extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VBox root = new VBox();
        Scene scene = new Scene(root, 800, 800);
        scene.getStylesheets().add(new File("src/main/java/co/edu/uptc/linkedlistworkshop/View/Style.css").toURI().toString());

        Button createLabel = new Button("Create a new moto");
        Button readLabel = new Button("View all motos");
        Button updateLabel = new Button("Update moto information");
        Button deleteLabel = new Button("Delete moto");

        root.getChildren().addAll(createLabel, readLabel, updateLabel, deleteLabel);
        root.setAlignment(Pos.CENTER);
        stage.setTitle("Motos");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
