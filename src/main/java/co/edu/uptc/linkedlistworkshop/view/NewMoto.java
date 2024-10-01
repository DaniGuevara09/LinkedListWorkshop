package co.edu.uptc.linkedlistworkshop.view;

import co.edu.uptc.linkedlistworkshop.controller.ListManagement;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class NewMoto {
    private ListManagement listManagement;
    private Stage prevStage;
    private Scene prevScene;
    private Scene scene;
    private static double screenWidth;
    private static double screenHeight;
    private BorderPane root;

    private Label title;
    private Button addButton;
    private Button returnButton;
    private HBox buttons;

    private Label idLabel;
    private Label brandLabel;
    private Label modelLabel;
    private Label colorLabel;
    private Label yearLabel;
    private Label engineSizeLabel;
    private Label priceLabel;

    private TextField idText;
    private ComboBox<String> brandComboBox;
    private TextField modelText;
    private ComboBox<String> colorComboBox;
    private ComboBox<Integer> yearComboBox;
    private TextField engineSizeText;
    private TextField priceText;

    private GridPane gridPane;
    private int menuOption;
    private int currentNodeId;
    private boolean event1;
    private boolean event2;
    private boolean event3;
    private boolean event4;

    /**
     * Constructor for the NewMoto class.
     * Initializes ListManagement, sets up the main layout and UI components,
     * and creates a scene for adding a new motorcycle.
     */
    public NewMoto() {
        listManagement = new ListManagement();
        root = new BorderPane();
        screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
        screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
        scene = new Scene(root, screenWidth, screenHeight);

        title = new Label();
        addButton = new Button("Add New Moto");
        returnButton = new Button("Return");
        buttons = new HBox();

        brandComboBox = new ComboBox<>();
        colorComboBox = new ComboBox<>();
        yearComboBox = new ComboBox<>();

        idLabel = new Label("Id: ");
        brandLabel = new Label("Brand: ");
        modelLabel = new Label("Model: ");
        colorLabel = new Label("Color: ");
        yearLabel = new Label("Year: ");
        engineSizeLabel = new Label("Engine Size (c.c): ");
        priceLabel = new Label("Price (cop): ");

        idText = new TextField("Enter the Id");
        modelText = new TextField("Enter the Model");
        engineSizeText = new TextField("Enter the Engine");
        priceText = new TextField("Enter the Price");

        gridPane = new GridPane();
        event1 = false;
        event2 = false;
        event3 = false;
        event4 = false;
        scene();
    }

    /**
     * Configures the layout of the scene, populates combo boxes,
     * sets event listeners for input fields, and applies styles from a CSS file.
     */
    public void scene() {
        combo();
        events();
        scene.getStylesheets()
                .add(new File("src/main/java/co/edu/uptc/linkedlistworkshop/view/Style.css").toURI().toString());

        // Column - Row
        gridPane.add(idLabel, 0, 0);
        gridPane.add(brandLabel, 0, 1);
        gridPane.add(modelLabel, 0, 2);
        gridPane.add(colorLabel, 0, 3);
        gridPane.add(yearLabel, 0, 4);
        gridPane.add(engineSizeLabel, 0, 5);
        gridPane.add(priceLabel, 0, 6);

        gridPane.add(idText, 1, 0);
        gridPane.add(brandComboBox, 1, 1);
        gridPane.add(modelText, 1, 2);
        gridPane.add(colorComboBox, 1, 3);
        gridPane.add(yearComboBox, 1, 4);
        gridPane.add(engineSizeText, 1, 5);
        gridPane.add(priceText, 1, 6);

        BorderPane.setMargin(title, new Insets(100, 100, 100, 100));
        BorderPane.setMargin(buttons, new Insets(100, 50, 50, 0));

        BorderPane.setAlignment(title, Pos.CENTER);
        gridPane.setAlignment(Pos.CENTER);
        buttons.setAlignment(Pos.CENTER_RIGHT);
        buttons.getChildren().addAll(addButton, returnButton);

        buttons.setSpacing(50);
        gridPane.setHgap(100);
        gridPane.setVgap(50);

        title.setId("title");
        root.setId("root");
        root.setTop(title);
        root.setCenter(gridPane);
        root.setBottom(buttons);
    }

    /**
     * Populates the brand, color, and year combo boxes with default values.
     */
    public void combo() {
        // Brand
        ArrayList<String> brand = new ArrayList<>();
        brand.add("BMW");
        brand.add("Ducati");
        brand.add("Honda");
        brand.add("Kawasaki");
        brand.add("KTM");
        brand.add("Suzuki");
        brand.add("Yamaha");

        for (String b : brand) {
            brandComboBox.getItems().add(b);
        }
        brandComboBox.setValue("BMW");

        // Color
        ArrayList<String> color = new ArrayList<>();
        color.add("Black");
        color.add("White");
        color.add("Red");
        color.add("Purple");
        color.add("Blue");
        color.add("Green");

        for (String c : color) {
            colorComboBox.getItems().add(c);
        }
        colorComboBox.setValue("Black");

        // Year
        int currentYear = LocalDate.now().getYear();
        for (int year = 2014; year <= currentYear; year++) {
            yearComboBox.getItems().add(year);
        }
        yearComboBox.setValue(2024);
    }

    /**
     * Sets up event listeners for buttons and input fields,
     * validating user input when the fields lose focus.
     */
    public void events() {
        engineSizeText.setStyle("-fx-text-fill: #B52626;");
        priceText.setStyle("-fx-text-fill: #B52626;");

        returnButton.setOnAction(event -> {
            Runner main = new Runner();
            main.setPrimaryStage(prevStage);
            main.setScene(prevScene);
            try {
                main.start(prevStage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        idText.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                String input = idText.getText();
                int idInt = listManagement.isNumericInt(input);

                if (listManagement.isNumericInt(input) == -1) {
                    idText.setText("Enter a numeric value");
                    idText.setStyle("-fx-text-fill: #B52626;");
                    event1 = false;
                } else if (!listManagement.idValidation(idInt)) {
                    idText.setText("Enter natural numbers");
                    idText.setStyle("-fx-text-fill: #B52626;");
                    event1 = false;
                } else if (listManagement.findNode(idInt) != null) {
                    idText.setText("This ID already exists");
                    idText.setStyle("-fx-text-fill: #B52626;");
                    event1 = false;
                } else {
                    idText.setStyle("-fx-text-fill: white;");
                    event1 = true;
                }
            }
            addNewData();
        });

        engineSizeText.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                String input = engineSizeText.getText();
                int engineInt = listManagement.isNumericInt(input);

                if (engineInt == -1) {
                    engineSizeText.setText("Enter a numeric value");
                    engineSizeText.setStyle("-fx-text-fill: #B52626;");
                    event2 = false;
                } else if (!listManagement.engineValidation(engineInt)) {
                    engineSizeText.setText("Min: 50, Max: 1200");
                    engineSizeText.setStyle("-fx-text-fill: #B52626;");
                    event2 = false;
                } else {
                    engineSizeText.setStyle("-fx-text-fill: white;");
                    event2 = true;
                }
            }
            addNewData();
        });

        priceText.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                String input = priceText.getText();
                int priceInt = listManagement.isNumericInt(input);

                if (listManagement.isNumericInt(input) == -1) {
                    priceText.setText("Enter a numeric value");
                    priceText.setStyle("-fx-text-fill: #B52626;");
                    event3 = false;
                } else if (!listManagement.priceValidation(priceInt)) {
                    priceText.setText("Min: 2000000, Max: 160000000");
                    priceText.setStyle("-fx-text-fill: #B52626;");
                    event3 = false;
                } else {
                    priceText.setStyle("-fx-text-fill: white;");
                    event3 = true;
                }
            }
            addNewData();
        });
    }

    /**
     * Sets the title of the scene based on the selected menu option.
     */
    public void titleLabel() {
        String text = "Add a New Motorcycle";
        switch (menuOption) {
            case 1 -> title.setText(text + " at the Beginning");
            case 2 -> title.setText(text + " at the End");
            case 3 -> title.setText(text + " After to No. " + currentNodeId);
            case 4 -> title.setText(text + " Before to No. " + currentNodeId);
            case 5 -> title.setText(text + " in an Ordered Manner");
        }
    }


    /**
     * Validates the input data and, if valid, adds a new motorcycle node to the list
     * based on the specified menu option.
     * <p>
     * The method performs the following validation steps:
     * - Ensures that the 'id', 'model', 'engine size', and 'price' fields are not blank or invalid.
     * - Checks if the 'id' is unique and if the input values are within acceptable ranges.
     * <p>
     * If all validation passes, a new motorcycle node is added using the appropriate
     * method from the ListManagement class, depending on the selected menu option.
     */
    public void addNewData() {
        if (idText.getText().isBlank()) {
            idText.setText("Enter the Id");
            idText.setStyle("-fx-text-fill: #B52626;");
            event4 = false;
        } else if (modelText.getText().isBlank()) {
            modelText.setText("Enter the Model");
            modelText.setStyle("-fx-text-fill: #B52626;");
            event4 = false;
        } else if (modelText.getText().equals("Enter the Model")) {
            modelText.setStyle("-fx-text-fill: #B52626;");
            event4 = false;
        } else if (engineSizeText.getText().isBlank()) {
            engineSizeText.setText("Enter the Engine");
            engineSizeText.setStyle("-fx-text-fill: #B52626;");
            event4 = false;
        } else if (priceText.getText().isBlank()) {
            priceText.setText("Enter the Price");
            priceText.setStyle("-fx-text-fill: #B52626;");
            event4 = false;
        } else {
            event4 = true;
        }

        // If all events (validations) pass, create and add a new motorcycle node
        if (event1 && event2 && event3 && event4) {
            int id = Integer.parseInt(idText.getText());
            String brand = brandComboBox.getValue();
            String model = modelText.getText();
            String color = colorComboBox.getValue();
            int year = yearComboBox.getValue();
            int engineSize = Integer.parseInt(engineSizeText.getText());
            int price = Integer.parseInt(priceText.getText());

            switch (menuOption) {
                case 1 -> addButton.setOnAction(event -> {
                    listManagement.addNodeFirst(id, brand, model, color, year, engineSize, price);
                    message();
                });
                case 2 -> addButton.setOnAction(event -> {
                    listManagement.addNodeLast(id, brand, model, color, year, engineSize, price);
                    message();
                });
                case 3 -> addButton.setOnAction(event -> {
                    listManagement.addNodeAfterTo(currentNodeId, id, brand, model, color, year, engineSize, price);
                    message();
                });
                case 4 -> addButton.setOnAction(event -> {
                    listManagement.addNodeBeforeTo(currentNodeId, id, brand, model, color, year, engineSize, price);
                    message();
                });
                case 5 -> addButton.setOnAction(event -> {
                    listManagement.addNodeSorted(id, brand, model, color, year, engineSize, price);
                    message();
                });
            }
        }
    }

    /**
     * Displays a confirmation message once the new motorcycle has been successfully added.
     * <p>
     * This method creates a new confirmation window using the Confirmation class, sets up
     * the previous stage and scene, and restarts the application by returning to the main scene.
     */
    public void message() {
        Confirmation config = new Confirmation();
        config.scene(prevStage, "Added Successfully");
        Runner main = new Runner();
        main.setPrimaryStage(prevStage);
        main.setScene(prevScene);
        try {
            main.start(prevStage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns the current Scene object used in the 'NewMoto' window.
     *
     * @return The Scene instance.
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * Sets the previous stage from where the user navigated.
     *
     * @param prevStage The previous Stage to be used for navigating back.
     */
    public void setPrevStage(Stage prevStage) {
        this.prevStage = prevStage;
    }

    /**
     * Sets the previous scene that was displayed before the current window.
     *
     * @param prevScene The Scene object to restore when returning to the previous window.
     */
    public void setPrevScene(Scene prevScene) {
        this.prevScene = prevScene;
    }

    /**
     * Configures the menu option and current node ID, which determine
     * how a new motorcycle will be added (e.g., at the beginning, end, before, or after another node).
     *
     * @param menuOption    The menu option selected by the user.
     * @param currentNodeId The ID of the current node to which the new node will be added relative to.
     */
    public void setMenuOptionAndId(int menuOption, int currentNodeId) {
        this.menuOption = menuOption;
        this.currentNodeId = currentNodeId;
        titleLabel();
    }

    /**
     * Sets the ListManagement instance used for managing the linked list of motorcycles.
     *
     * @param listManagement The ListManagement instance to be set.
     */
    public void setListManagement(ListManagement listManagement) {
        this.listManagement = listManagement;
    }
}