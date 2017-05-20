import application.database.QuestionService;
import application.model.questions.Question;
import application.model.questions.QuestionRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Null;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class QuestionServiceTest {

    Question question;

    @Mock
    QuestionRepository questionRepository;

    @InjectMocks
    private QuestionService questionService;


    private Question getQuestion(){
        return question;
    }

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        question = new Question();
        question.setQuestion("TestQuestion");
    }

    @Test
    public void findQuestionsTest(){

        Question testQuestion = getQuestion();

        List<Question> questions = new ArrayList<>();
        questions.add(testQuestion);

        when(questionRepository.findAll()).thenReturn(questions);

        List<Question> checkQuestions = questionService.findAllQuestion();

        verify(questionRepository,timeout(1)).findAll();

        Assert.assertTrue(checkQuestions.size() > 0);
        Assert.assertEquals(testQuestion,checkQuestions.get(0));

    }

    @Test
    public void findByIdTest(){

        Question testQuestion = getQuestion();
        testQuestion.setId(3);
        questionService.addQuestion(testQuestion);

        when(questionRepository.findById(any(Integer.class))).thenReturn(testQuestion);

        Question checkQuestion = questionService.findById(3);

        verify(questionRepository,times(1)).findById(any(Integer.class));

        Assert.assertNotNull(checkQuestion);
        Assert.assertEquals(checkQuestion,testQuestion);

    }

    @Test(expected = Exception.class)
    public void addQuestionTest(){
        Question testQuestion = getQuestion();

        doThrow(Exception.class).when(questionRepository.save(any(Question.class)));

        questionService.deleteQuestion(testQuestion);
        verify(questionRepository,times(2)).save(any(Question.class));
    }

    @Test(expected = NullPointerException.class)
    public void deleteQuestionTest(){
        Question testQuestion = getQuestion();

        doThrow(NullPointerException.class).when(questionRepository).delete(any(Question.class));

        questionService.deleteQuestion(testQuestion);
        verify(questionRepository,times(2)).delete(any(Question.class));
    }
}
