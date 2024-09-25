package co.edu.uptc.linkedlistworkshop.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Runner extends Application {

    private Stage primaryStage;
    private Label title;
    private Label sortBy;
    private ComboBox<String> sortComboBox;
    private TableView tableView;
    private Button addButton;

    private BorderPane root;
    private HBox sortHBox;
    private VBox top;
    private Scene scene;

    private static double screenWidth;
    private static double screenHeight;

    public Runner() {
        primaryStage = new Stage();
        title = new Label("Motorcycle Information Management");
        sortBy = new Label("Sort by ");
        sortComboBox = new ComboBox<>();
        tableView = new TableView();
        addButton = new Button("Add New Moto");
        root = new BorderPane();
        sortHBox = new HBox();
        top = new VBox();
        screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
        screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
        scene = new Scene(root, screenWidth, screenHeight);
    }

    @Override
    public void start(Stage stage) throws IOException {
        scene.getStylesheets()
                .add(new File("src/main/java/co/edu/uptc/linkedlistworkshop/view/Style.css").toURI().toString());

        events();

        // Srot
        sortComboBox.getItems().addAll("minor to major", "major to minor");
        sortComboBox.setValue("minor to major");

        sortHBox.getChildren().addAll(sortBy, sortComboBox);
        title.setId("title");
        sortBy.setId("sortBy");
        root.setId("root");

        top.getChildren().addAll(title, sortHBox);

        root.setTop(top);
        root.setCenter(tableView);
        root.setBottom(addButton);

        // Up, right, down, left
        VBox.setMargin(sortHBox, new Insets(30, 0, 0, 0));
        BorderPane.setMargin(top, new Insets(30, 30, 30, 30));
        BorderPane.setMargin(tableView, new Insets(0, 30, 30, 30));
        BorderPane.setMargin(addButton, new Insets(0, 0, 30, 30));

        primaryStage.setTitle("Motos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void events() {
        addButton.setOnAction(event -> {
            NewMoto newMoto = new NewMoto();
            newMoto.setPrevScene(scene);
            newMoto.setPrevStage(primaryStage);
            primaryStage.setScene(newMoto.getScene());
        });
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public static void main(String[] args) {
        launch();
    }
}
