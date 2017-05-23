package hu.transfet.unideb.application;

import hu.transfet.unideb.application.model.answer.Answer;
import hu.transfet.unideb.application.model.questions.Question;
import hu.transfet.unideb.application.service.QuestionServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Kerdeseket es a hozzajuk tartozo valaszadasi lehetosegeket eloallito osztaly
 *
 * @see Question
 * @see Answer
 */

public class QuestionBuilder {
    private Logger logger = LoggerFactory.getLogger(QuestionBuilder.class);
    List<QuestionParser> questions;
    private QuestionServiceImpl questionService;

    /**
     * Alapertelmezett konstruktor
     */
    public QuestionBuilder(){
        questionService = ServiceLocator.getService(QuestionServiceImpl.class);
    }


    /**
     * Feldolgoz egy Json fajlt, melyet paramterkent kap
     *
     * @param json Json fajl
     */
    @SuppressWarnings("ConstantConditions")
    public void processJson(String json) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ClassLoader classLoader = getClass().getClassLoader();

            questions = objectMapper.readValue(new File(classLoader.getResource(json).getFile()), new TypeReference<List<QuestionParser>>() {
            });

        }catch (FileNotFoundException fnfe){
            logger.error("question.json not found: ", fnfe);
            fnfe.printStackTrace();

        }catch (IOException ioe){
            logger.error("Cannot read question.json: ",ioe);
            ioe.printStackTrace();
        }

    }

    public void loadQuestions(){

        for(int i = 0; i < questions.size(); i++){
            String questionName = questions.get(i).getQuestion();
            List<String> answers = questions.get(i).getAnswers();

            Question question = new Question();
            question.setQuestion(questionName);
            question.setCorrectAnswerIndex(questions.get(i).getCorrect());

            List<Answer> questionAnswers = new ArrayList<>();
            for(int j = 0; j < answers.size(); j++){
                questionAnswers.add(new Answer(answers.get(j),question));
            }

            question.setAnswers(questionAnswers);
            questionService.addQuestion(question);

            for(Question question1: questionService.findAllQuestion()){
                logger.info(question1.toString());
            }
        }

    }
}
