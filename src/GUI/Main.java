package GUI;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Main extends Application {

    private VBox root = new VBox();
    static AnchorPane urlPane;
    static AnchorPane resultsPane;

    static ScrollPane scrollPane;



    Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        Scene scene = createScene();

        //urlPane = new UrlPane();
        //resultsPane = new ResultPane();
        StackPane stackPane = new StackPane();
        stackPane.setMinHeight(380);
        stackPane.setMaxWidth(800);
        urlPane = FXMLLoader.load(getClass().getResource("urlSelection.fxml"));
        stackPane.getChildren().add(urlPane);

        resultsPane = FXMLLoader.load(getClass().getResource("results.fxml"));
        resultsPane.setTranslateX(0);
        resultsPane.setTranslateY(381);
        stackPane.getChildren().add(resultsPane);

        root.getChildren().add(stackPane);
        primaryStage.setScene(scene);
        //primaryStage.setResizable(false);
        primaryStage.setHeight(444);
        primaryStage.show();
        stackPane.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public static void transition(){

        urlPane.setTranslateX(801);
        resultsPane.setTranslateY(0);
    }

    /*public NotificationPane(int w, int h) {
        this.w = w;
        this.h = h;

        bg = new Rectangle(w, h, Color.color(0.2, 0.2, 0.2, 0.75));

        getChildren().add(bg);

        tt.setOnFinished(e -> isAnimating = false);

        tt.setInterpolator(new Interpolator() {
            @Override
            protected double curve(double t) {
                //return (t == 0.0) ? 0.0 : Math.pow(2.0, 10 * (t - 1));
                return (t == 1.0) ? 1.0 : 1 - Math.pow(2.0, -10 * t);
            }
        });
    }*/


    private Scene createScene(){

        root.getChildren().add(getMenuBar());

        Scene scene = new Scene(root, 800, 380);

        return scene;
    }


    private MenuBar getMenuBar(){

        MenuBar menuBar = new MenuBar();

        Menu menu = new Menu("About Us");
        MenuItem first = new MenuItem("Google");

        menu.getItems().add(first);

        menuBar.getMenus().add(menu);
        return menuBar;

    }

    public static void main(String[] args) {
        launch(args);
    }
}
