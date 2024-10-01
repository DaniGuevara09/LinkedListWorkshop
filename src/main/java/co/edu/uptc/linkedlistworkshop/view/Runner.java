package co.edu.uptc.linkedlistworkshop.view;

import co.edu.uptc.linkedlistworkshop.controller.ListManagement;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;

/**
 * Runner class is the main entry point for the Motorcycle Information Management application.
 * It sets up the primary stage, UI components, and event handlers for the various options
 * like adding, deleting, searching, and managing motorcycles in the list.
 */
public class Runner extends Application {

    // ListManagement instance to handle operations on the motorcycle list
    private ListManagement listManagement;

    // UI elements including the primary stage, root layout, and buttons for actions
    private Stage primaryStage;
    private Scene scene;
    private VBox root;
    private GridPane grid;

    private Label title;
    private Label subtitle;
    private Label addFirstLab;
    private Label addLastLab;
    private Label afterToLab;
    private Label beforeToLab;
    private Label sortLab;
    private Label findInfoLab;
    private Label getListLab;
    private Label deleteLab;
    private Label sizeLab;
    private Label getFirstLab;
    private Label getLastLab;

    private Button addFirstBtn;
    private Button addLastBtn;
    private Button afterToBtn;
    private Button beforeToBtn;
    private Button sortBtn;
    private Button findInfoBtn;
    private Button getListBtn;
    private Button deleteBtn;
    private Button sizeBtn;
    private Button getFirstBtn;
    private Button getLastBtn;
    private Button exit;

    private static double screenWidth;
    private static double screenHeight;

    /**
     * Constructor for Runner class.
     * Initializes the ListManagement instance, calculates screen dimensions,
     * and sets up the main UI components such as labels, buttons, and layouts.
     */
    public Runner() {
        listManagement = new ListManagement();  // Create a new ListManagement instance
        screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
        screenHeight = Screen.getPrimary().getVisualBounds().getHeight();

        // Initialize UI components
        primaryStage = new Stage();
        root = new VBox();
        grid = new GridPane();
        scene = new Scene(root, screenWidth, screenHeight);

        title = new Label("Motorcycle information management");
        subtitle = new Label("Select an option");

        // Initialize labels and buttons for each action
        addFirstLab = new Label("1. Add Motorcycle First");
        addLastLab = new Label("2. Add Motorcycle Last");
        afterToLab = new Label("3. Add Motorcycle After");
        beforeToLab = new Label("4. Add Motorcycle Before");
        sortLab = new Label("5. Add Motorcycle Sort");
        findInfoLab = new Label("6. Search Motorcycle");
        getListLab = new Label("7. Get Motorcycle List");
        deleteLab = new Label("8. Delete Motorcycle");
        sizeLab = new Label("9. Total Number of Motorcycles");
        getFirstLab = new Label("10. Get First Motorcycle");
        getLastLab = new Label("11. Get Last Motorcycle");

        // Buttons for each action
        addFirstBtn = new Button("Add First");
        addLastBtn = new Button("Add Last");
        afterToBtn = new Button("Add After");
        beforeToBtn = new Button("Add Before");
        sortBtn = new Button("Add Sort");
        findInfoBtn = new Button("Search Moto");
        getListBtn = new Button("Get List");
        deleteBtn = new Button("Delete");
        sizeBtn = new Button("Size");
        getFirstBtn = new Button("Get First");
        getLastBtn = new Button("Get Last");
        exit = new Button("Exit");
    }

    /**
     * The main entry point for the JavaFX application.
     * Sets up the event handlers for each button and the main layout of the application.
     *
     * @param stage The primary stage for this application.
     * @throws IOException if an error occurs while loading resources like CSS.
     */
    @Override
    public void start(Stage stage) throws IOException {
        events();  // Initialize event handlers for buttons

        // Add external CSS stylesheet
        scene.getStylesheets().add(new File("src/main/java/co/edu/uptc/linkedlistworkshop/view/Style.css").toURI().toString());

        // Add buttons and labels to the grid layout in specific positions
        grid.add(addFirstBtn, 1, 0);
        grid.add(addLastBtn, 1, 1);
        grid.add(afterToBtn, 1, 2);
        grid.add(beforeToBtn, 1, 3);
        grid.add(sortBtn, 1, 4);
        grid.add(findInfoBtn, 1, 5);
        grid.add(getListBtn, 1, 6);
        grid.add(deleteBtn, 1, 7);
        grid.add(sizeBtn, 1, 8);
        grid.add(getFirstBtn, 1, 9);
        grid.add(getLastBtn, 1, 10);

        // Add labels for each button's description
        grid.add(addFirstLab, 0, 0);
        grid.add(addLastLab, 0, 1);
        grid.add(afterToLab, 0, 2);
        grid.add(beforeToLab, 0, 3);
        grid.add(sortLab, 0, 4);
        grid.add(findInfoLab, 0, 5);
        grid.add(getListLab, 0, 6);
        grid.add(deleteLab, 0, 7);
        grid.add(sizeLab, 0, 8);
        grid.add(getFirstLab, 0, 9);
        grid.add(getLastLab, 0, 10);

        // Style UI elements
        title.setId("title");
        subtitle.setId("subtitle");
        root.setId("root");

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(100);  // Set horizontal gap between elements
        grid.setVgap(20);  // Set vertical gap between elements

        // Set layout for root and add all elements
        root.getChildren().addAll(title, subtitle, grid, exit);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(55);

        // Set up the primary stage
        primaryStage.setTitle("Motorcycle Information Management");
        primaryStage.setScene(scene);
        primaryStage.show();  // Display the stage
    }

    /**
     * Sets up event handlers for each button.
     * Each button triggers a different window or action depending on the task.
     */
    public void events() {
        addFirstBtn.setOnAction(e -> addMotoWindow(new NewMoto(), 1));
        addLastBtn.setOnAction(e -> addMotoWindow(new NewMoto(), 2));
        afterToBtn.setOnAction(e -> addAfterBefore(3));
        beforeToBtn.setOnAction(e -> addAfterBefore(4));
        sortBtn.setOnAction(e -> addMotoWindow(new NewMoto(), 5));

        getListBtn.setOnAction(event -> {
            List list = new List();
            list.setPrevScene(scene);
            list.setPrevStage(primaryStage);
            primaryStage.setScene(list.getScene());
            list.scene(listManagement);
        });

        findInfoBtn.setOnAction(event -> {
            Search search = new Search();
            search.scene(primaryStage, listManagement);
        });

        deleteBtn.setOnAction(event -> {
            Delete delete = new Delete();
            delete.scene(primaryStage, listManagement);
        });

        getFirstBtn.setOnAction(event -> {
            GetFirst getFirst = new GetFirst();
            getFirst.scene(primaryStage, listManagement);
        });

        getLastBtn.setOnAction(event -> {
            GetLast getLast = new GetLast();
            getLast.scene(primaryStage, listManagement);
        });

        sizeBtn.setOnAction(event -> {
            Total total = new Total();
            total.scene(primaryStage, listManagement);
        });

        // Exit button closes the application
        exit.setOnAction(event -> primaryStage.close());
    }

    /**
     * Opens a new window to add a motorcycle.
     * @param newMoto The NewMoto instance representing the window for adding a new motorcycle.
     * @param op The operation type (1 for add first, 2 for add last, etc.).
     */
    public void addMotoWindow(NewMoto newMoto, int op) {
        newMoto.setPrevScene(scene);  // Set the previous scene to return later
        newMoto.setPrevStage(primaryStage);  // Set the previous stage
        primaryStage.setScene(newMoto.getScene());  // Set the new scene for adding a motorcycle
        newMoto.setMenuOptionAndId(op, -1);  // Configure the menu option
        newMoto.setListManagement(listManagement);  // Set list management for data handling
    }

    /**
     * Overloaded method for adding a motorcycle with custom stage and scene parameters.
     * @param newMoto The NewMoto instance for adding a new motorcycle.
     * @param op The operation type.
     * @param stage The stage to display.
     * @param scene The scene to switch to.
     * @param id The ID of the motorcycle.
     * @param management The ListManagement instance for handling list operations.
     */
    public void addMotoWindow(NewMoto newMoto, int op, Stage stage, Scene scene, int id, ListManagement management){
        primaryStage.close();  // Close the current primary stage
        this.scene = scene;  // Update the scene reference
        this.listManagement = management;  // Update the list management reference
        primaryStage = stage;  // Set the new stage

        newMoto.setPrevScene(scene);
        newMoto.setPrevStage(primaryStage);
        primaryStage.setScene(newMoto.getScene());
        newMoto.setMenuOptionAndId(op, id);
        newMoto.setListManagement(listManagement);
        System.out.println("Runner: " + listManagement);
    }

    /**
     * Opens the window for adding a motorcycle after or before an existing one.
     * @param op Operation type (3 for after, 4 for before).
     */
    public void addAfterBefore(int op){
        AddAfterBefore add = new AddAfterBefore();
        add.scene(primaryStage, scene, op, listManagement);
    }

    // Setters for primary stage and scene

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    /**
     * The main method to launch the JavaFX application.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        launch();
    }
}