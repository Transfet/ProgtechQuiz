package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Main class
 */
public class Game extends Application {

    public static Boolean isSplashLoaded = false;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/views/loginpages/SignInPage.fxml"));

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Quiz Game");
        primaryStage.show();

    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        ServiceLocator.setApplicationContext(applicationContext);

        launch(args);
    }

}