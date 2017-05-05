package application;

import application.view.DefaultPage.RegisterPage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * Created by Transfet on 2017. 05. 01..
 */


public class Game extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/LogInPage.fxml"));
        primaryStage.setScene(new Scene(root));

        primaryStage.show();

    }


    public static void main(String[] args){

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        ServiceLocator.setApplicationContext(applicationContext);

        launch(args);

    }


}

