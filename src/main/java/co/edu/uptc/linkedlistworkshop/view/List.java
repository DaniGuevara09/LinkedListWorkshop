package co.edu.uptc.linkedlistworkshop.view;

import co.edu.uptc.linkedlistworkshop.controller.ListManagement;
import co.edu.uptc.linkedlistworkshop.model.Moto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.Comparator;

/**
 * The List class provides a graphical interface for displaying a list of motorcycles.
 * It allows the user to view the details of each motorcycle and sort them by ID.
 */
public class List {
    private ListManagement listManagement;
    private Stage prevStage;
    private Scene prevScene;

    private Label title;
    private Label sortBy;
    private ComboBox<String> sortComboBox;
    private TableView<Moto> tableView;
    private Button returnBtn;

    private BorderPane root;
    private HBox sortHBox;
    private VBox top;
    private Scene scene;

    private static double screenWidth;
    private static double screenHeight;

    /**
     * Constructor initializes the UI components for displaying the motorcycle list.
     * It sets up the scene with default dimensions based on the primary screen size.
     */
    public List() {
        listManagement = new ListManagement();
        title = new Label("Motorcycle List");
        sortBy = new Label("Sort by ");
        sortComboBox = new ComboBox<>();
        tableView = new TableView<>();
        returnBtn = new Button("Return");
        root = new BorderPane();
        sortHBox = new HBox();
        top = new VBox();
        screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
        screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
        scene = new Scene(root, screenWidth, screenHeight);
    }

    /**
     * Sets up the scene with the motorcycle list and sorting options.
     * @param listManagement the ListManagement object to manage the motorcycle list.
     */
    public void scene(ListManagement listManagement) {
        this.listManagement = listManagement;
        scene.getStylesheets()
                .add(new File("src/main/java/co/edu/uptc/linkedlistworkshop/view/Style.css").toURI().toString());

        events();
        table();

        // Sort ComboBox
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

    /**
     * Initializes the table columns for displaying motorcycle details.
     */
    public void table() {
        TableColumn<Moto, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Moto, String> brandColumn = new TableColumn<>("Brand");
        brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));

        TableColumn<Moto, String> modelColumn = new TableColumn<>("Model");
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));

        TableColumn<Moto, String> colorColumn = new TableColumn<>("Color");
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));

        TableColumn<Moto, Integer> yearColumn = new TableColumn<>("Year");
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));

        TableColumn<Moto, Integer> engineSizeColumn = new TableColumn<>("Engine Size");
        engineSizeColumn.setCellValueFactory(new PropertyValueFactory<>("engineSize"));

        TableColumn<Moto, Integer> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        tableView.getColumns().addAll(idColumn, brandColumn, modelColumn, colorColumn, yearColumn, engineSizeColumn, priceColumn);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        loadDataIntoTable();
    }

    /**
     * Loads the motorcycle data into the table and sets up the sorting event for the ComboBox.
     */
    private void loadDataIntoTable() {
        ObservableList<Moto> motoList = FXCollections.observableArrayList(listManagement.getLinkedList(true));
        tableView.setItems(motoList);

        // Sort event
        sortComboBox.setOnAction(event -> {
            String sortOrder = sortComboBox.getValue();
            if (sortOrder.equals("minor to major")) {
                motoList.sort(Comparator.comparingInt(Moto::getId));
            } else {
                motoList.sort(Comparator.comparingInt(Moto::getId).reversed());
            }
        });
    }

    /**
     * Sets up the event handling for the return button to navigate back to the previous scene.
     */
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

    /**
     * Gets the current scene for this List view.
     * @return the scene of the List view.
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * Sets the previous stage to return to when the return button is pressed.
     * @param prevStage the previous Stage to set.
     */
    public void setPrevStage(Stage prevStage) {
        this.prevStage = prevStage;
    }

    /**
     * Sets the previous scene to return to when the return button is pressed.
     * @param prevScene the previous Scene to set.
     */
    public void setPrevScene(Scene prevScene) {
        this.prevScene = prevScene;
    }
}