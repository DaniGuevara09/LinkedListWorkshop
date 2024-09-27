package co.edu.uptc.linkedlistworkshop.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;

public class AddAfterBefore {

    private Stage prevStage;
    private Scene prevScene;

    private Stage stage;
    private Scene scene;

    private VBox root;
    private TextField textField;
    private Button returnBtn;
    private Button nextBtn;
    private HBox buttons;

    private int menuOption;
    private int currentNodeId;

    public AddAfterBefore() {
        root = new VBox();
        stage = new Stage();
        prevStage = new Stage();
        textField = new TextField("Enter the Current Motorcycle Id");
        returnBtn = new Button("Return");
        nextBtn = new Button("Next");
        buttons = new HBox();
        scene = new Scene(root, 800, 150);
    }

    public void scene(Stage primaryStage, Scene lastScene, int op) {
        prevScene = lastScene;
        prevStage = primaryStage;
        menuOption = op;

        scene.getStylesheets()
                .add(new File("src/main/java/co/edu/uptc/linkedlistworkshop/view/Style.css").toURI().toString());
        root.setId("rootSearch");
        textField.setId("txtSearch2");

        returnBtn.setOnAction(event -> stage.close());

        buttons.getChildren().addAll(nextBtn, returnBtn);
        buttons.setSpacing(100);
        buttons.setAlignment(Pos.CENTER);
        nextBtn.setOnAction(e -> addMotoWindow(new NewMoto()));

        root.setAlignment(Pos.CENTER);
        root.setSpacing(40);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(textField, buttons);

        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT); // Without name and exit button
        stage.initModality(Modality.WINDOW_MODAL); // Block the first window
        //stage.initOwner(primaryStage);
        stage.setScene(scene);
        stage.showAndWait();
    }

    public void addMotoWindow(NewMoto newMoto){
        stage.close();
        Runner run = new Runner();
        run.addMotoWindow(newMoto, menuOption, prevStage, prevScene);
    }

    public void setCurrentNodeId(int currentNodeId) {
        this.currentNodeId = currentNodeId;
    }

    public int getMenuOption() {
        return menuOption;
    }

    public void setMenuOption(int menuOption) {
        this.menuOption = menuOption;
    }
}

