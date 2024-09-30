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

    private Label brandLabel;
    private Label modelLabel;
    private Label colorLabel;
    private Label yearLabel;
    private Label engineSizeLabel;
    private Label priceLabel;

    private ComboBox<String> brandComboBox;
    private TextField modelText;
    private ComboBox<String> colorComboBox;
    private ComboBox<Integer> yearComboBox;
    private TextField engineSizeText;
    private TextField priceText;

    private GridPane gridPane;
    private int menuOption;
    private int currentNodeId;

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

        brandLabel = new Label("Brand: ");
        modelLabel = new Label("Model: ");
        colorLabel = new Label("Color: ");
        yearLabel = new Label("Year: ");
        engineSizeLabel = new Label("Engine Size (c.c): ");
        priceLabel = new Label("Price (cop): ");

        modelText = new TextField();
        engineSizeText = new TextField();
        priceText = new TextField();

        gridPane = new GridPane();
        scene();
    }

    public void scene(){
        combo();
        events();
        scene.getStylesheets()
                .add(new File("src/main/java/co/edu/uptc/linkedlistworkshop/view/Style.css").toURI().toString());

        // Column - Row
        gridPane.add(brandLabel, 0, 0);
        gridPane.add(modelLabel, 0, 1);
        gridPane.add(colorLabel, 0, 2);
        gridPane.add(yearLabel, 0, 3);
        gridPane.add(engineSizeLabel, 0, 4);
        gridPane.add(priceLabel, 0, 5);

        gridPane.add(brandComboBox, 1, 0);
        gridPane.add(modelText, 1, 1);
        gridPane.add(colorComboBox, 1, 2);
        gridPane.add(yearComboBox, 1, 3);
        gridPane.add(engineSizeText, 1, 4);
        gridPane.add(priceText, 1, 5);

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

    public void combo(){
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

    public void events() {
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

        engineSizeText.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                String input = engineSizeText.getText();
                int engineInt = listManagement.isNumericInt(input);

                if (engineInt == -1) {
                    engineSizeText.setText("Enter a numeric value");
                    engineSizeText.setStyle("-fx-text-fill: #B52626;");
                } else if (!listManagement.engineValidation(engineInt)){
                    engineSizeText.setText("Min: 50, Max: 1200");
                    engineSizeText.setStyle("-fx-text-fill: #B52626;");
                } else {
                    engineSizeText.setStyle("-fx-text-fill: white;");
                }
            }
        });

        priceText.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                String input = priceText.getText();
                long priceLong = listManagement.isNumericInt(input);

                if (listManagement.isNumericInt(input) == -1) {
                    priceText.setText("Enter a numeric value");
                    priceText.setStyle("-fx-text-fill: #B52626;");
                } else if (!listManagement.priceValidation(priceLong)){
                    priceText.setText("Min: 2000000, Max: 160000000");
                    priceText.setStyle("-fx-text-fill: #B52626;");
                }else {
                    priceText.setStyle("-fx-text-fill: white;");
                }
            }
        });

    }

    public void titleLabel(){
        String text = "Add a New Motorcycle";
        switch (menuOption){
            case 1:
                title.setText(text + " at the Beginning");
                break;
            case 2:
                title.setText(text + " at the End");
                break;
            case 3:
                title.setText(text + " After to No. " + currentNodeId);
                break;
            case 4:
                title.setText(text + " Before to No. " + currentNodeId);
                break;
            case 5:
                title.setText(text + " in an Ordered Manner");
                break;
            default:
        }
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

    public int getMenuOption() {
        return menuOption;
    }

    public void setMenuOptionAndId(int menuOption, int currentNodeId) {
        this.menuOption = menuOption;
        this.currentNodeId = currentNodeId;
        titleLabel();
    }
}
