package co.edu.uptc.linkedlistworkshop.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class List {
    private Stage prevStage;
    private Scene prevScene;

    private Label title;
    private Label sortBy;
    private ComboBox<String> sortComboBox;
    private TableView tableView;
    private Button returnBtn;

    private BorderPane root;
    private HBox sortHBox;
    private VBox top;
    private Scene scene;

    private static double screenWidth;
    private static double screenHeight;

    public List() {
        title = new Label("Motorcycle List");
        sortBy = new Label("Sort by ");
        sortComboBox = new ComboBox<>();
        tableView = new TableView();
        returnBtn = new Button("Return");
        root = new BorderPane();
        sortHBox = new HBox();
        top = new VBox();
        screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
        screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
        scene = new Scene(root, screenWidth, screenHeight);
    }

    public void scene(){

        scene.getStylesheets()
                .add(new File("src/main/java/co/edu/uptc/linkedlistworkshop/view/Style.css").toURI().toString());

        events();

        // Sort
        sortComboBox.getItems().addAll("minor to major", "major to minor");
        sortComboBox.setValue("minor to major");

        sortHBox.getChildren().addAll(sortBy, sortComboBox);
        title.setId("title");
        sortBy.setId("sortBy");
        root.setId("root");

        top.getChildren().addAll(title, sortHBox);

        root.setTop(top);
        root.setCenter(tableView);
        root.setBottom(returnBtn);

        // Up, right, down, left
        VBox.setMargin(sortHBox, new Insets(30, 0, 0, 0));
        BorderPane.setMargin(top, new Insets(30, 30, 30, 30));
        BorderPane.setMargin(tableView, new Insets(0, 30, 30, 30));
        BorderPane.setMargin(returnBtn, new Insets(0, 0, 30, 30));
    }

    public void events() {
        returnBtn.setOnAction(event -> {
            Runner main = new Runner();
            main.setPrimaryStage(prevStage);
            main.setScene(prevScene);
            try {
                main.start(prevStage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public Scene getScene() {
        return scene;
    }

    public void setPrevStage(Stage prevStage) {
        this.prevStage = prevStage;
    }

    public void setPrevScene(Scene prevScene) {
        this.prevScene = prevScene;
    }
}
