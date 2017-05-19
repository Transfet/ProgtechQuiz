import application.AppConfig;
import application.database.QuestionService;
import application.model.questions.Question;
import application.model.questions.QuestionRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Transfet on 2017. 05. 19..
 */


@ContextConfiguration(classes = AppConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class QuestionServiceTest {

    //@Autowired
    //private QuestionRepository questionRepository;

    @Autowired
    private QuestionService questionService;


    @Test
  //  @Rollback
    public void testAddQuestion(){

        Question question = new Question();
        question.setQuestion("TestQuestion");

        questionService.addQuestion(question);

        List<Question> addQuestion = questionService.findAllQuestion();
        Assert.assertEquals(question.getQuestion(),addQuestion.get(0).getQuestion());

    }

    @Test
    public void testDeleteQuestion(){

    }
}
