package hu.transfet.unideb.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * Main class
 */
public class Game extends Application {

    public static Boolean isSplashLoaded = false;
    static Logger logger = LoggerFactory.getLogger(Game.class);

    @Override
    @SuppressWarnings("ConstantConditions")
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("SignInPage.fxml"));

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Quiz Game");
        primaryStage.show();

    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        ServiceLocator.setApplicationContext(applicationContext);

        QuestionBuilder questionBuilder = new QuestionBuilder();
        questionBuilder.processJson("questions.json");


        launch(args);
    }


    }
