package goweather;

import java.io.IOException;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GoWeatherMobile extends Application {

    private static Stage primaryStage;
    private Scene scene;
    private static Pane mainLayout;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        primaryStage.setTitle("GoWeather!");

        showMainView();
        //hyde park
        //victoria park
        //wembley 
    }

    public void showMainView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(GoWeatherMobile.class.getResource("/goweather/HomePage.fxml"));
        mainLayout = loader.load();
        scene = new Scene(mainLayout);
        primaryStage.setScene(scene);
        primaryStage.show();

        //Delay logo screen for 3 seconds and move onto next page
        PauseTransition delay = new PauseTransition(Duration.seconds(1));
        Parent root = FXMLLoader.load(getClass().getResource("/goweather/Location.fxml"));
        Scene scene2 = new Scene(root);
        delay.setOnFinished(event -> primaryStage.setScene(scene2));
        delay.play();

    }

    public static void getMainScreen() throws IOException {
        primaryStage.hide();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
