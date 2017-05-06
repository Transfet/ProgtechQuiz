package application.controller;

import application.ServiceLocator;
import application.database.QuestionService;
import application.model.questions.Question;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Transfet on 2017. 05. 06..
 */
public class QuestionController implements Initializable{

    private QuestionService questionService;

    @FXML
    private Button okButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField questionField;

    @FXML
    private TextField answerField;

    private void changeToLogIn(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/views/loginpages/SignInPage.fxml"));
        Scene scene = new Scene(root);

        Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        appStage.setScene(scene);

        appStage.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        questionService = ServiceLocator.getService(QuestionService.class);

    }

    @FXML
    void okBut(ActionEvent event){

        Question question = new Question();
        question.setQuestion(questionField.getText());
        question.setAnswer(answerField.getText());


        questionService.addQuestion(question);

        questionField.clear();
        answerField.clear();

        for(Question questio: questionService.findAllQuestion())
        {
            System.out.println(questio);
        }

        System.out.println("ID ALAPJÁN: " + questionService.findById(1));

        System.out.println("Kérdés alapján: " + questionService.findAnswerByQuestion("Mi a nevem?"));

    }

    @FXML
    void back(ActionEvent event) throws IOException{

        changeToLogIn(event);

    }
}
