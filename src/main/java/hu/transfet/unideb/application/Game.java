package hu.transfet.unideb.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Main class
 */
public class Game extends Application {

    public static Boolean isSplashLoaded = false;
    static Logger logger = LoggerFactory.getLogger(Game.class);

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

        QuestionBuilder questionBuilder = new QuestionBuilder();
        questionBuilder.setUpQuestions();


        launch(args);
    }


    }
