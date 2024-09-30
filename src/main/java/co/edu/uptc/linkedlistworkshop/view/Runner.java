package co.edu.uptc.linkedlistworkshop.view;

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

public class Runner extends Application {

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

    public Runner() {
        screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
        screenHeight = Screen.getPrimary().getVisualBounds().getHeight();

        primaryStage = new Stage();
        root = new VBox();
        grid = new GridPane();
        scene = new Scene(root, screenWidth, screenHeight);

        title = new Label("Motorcycle information management");
        subtitle = new Label("Select an option");

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

    @Override
    public void start(Stage stage) throws IOException {
        events();

        scene.getStylesheets().add(new File("src/main/java/co/edu/uptc/linkedlistworkshop/view/Style.css").toURI().toString());
        // Column, row
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

        title.setId("title");
        subtitle.setId("subtitle");
        root.setId("root");

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(100);
        grid.setVgap(20);

        root.getChildren().addAll(title, subtitle, grid, exit);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(55);

        primaryStage.setTitle("Motorcycle Information Management");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

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
        });

        findInfoBtn.setOnAction(event -> {
            Search search = new Search();
            search.scene(primaryStage);
            //search.setPrevScene(scene);
            //search.setPrevStage(primaryStage);
            //primaryStage.setScene(search.getScene());
        });

        deleteBtn.setOnAction(event -> {
            Delete delete = new Delete();
            delete.scene(primaryStage);
        });

        getFirstBtn.setOnAction(event -> {
            GetFirst getFirst = new GetFirst();
            getFirst.scene(primaryStage);
        });

        getLastBtn.setOnAction(event -> {
            GetLast getLast = new GetLast();
            getLast.scene(primaryStage);
        });

        sizeBtn.setOnAction(event -> {
            Total total = new Total();
            total.scene(primaryStage);
        });

        exit.setOnAction(event -> primaryStage.close());
    }

    public void addMotoWindow(NewMoto newMoto, int op){
        newMoto.setPrevScene(scene);
        newMoto.setPrevStage(primaryStage);
        primaryStage.setScene(newMoto.getScene());
        newMoto.setMenuOptionAndId(op, -1);
    }

    public void addMotoWindow(NewMoto newMoto, int op, Stage stage, Scene scene, int id){
        primaryStage.close();
        this.scene = scene;
        primaryStage = stage;

        newMoto.setPrevScene(scene);
        newMoto.setPrevStage(primaryStage);
        primaryStage.setScene(newMoto.getScene());
        newMoto.setMenuOptionAndId(op, id);
    }

    public void addAfterBefore(int op){
        AddAfterBefore add = new AddAfterBefore();
        add.scene(primaryStage, scene, op);
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
