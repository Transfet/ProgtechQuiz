package hu.transfet.unideb.test.testservice;

import hu.transfet.unideb.application.service.QuestionServiceImpl;
import hu.transfet.unideb.application.model.questions.Question;
import hu.transfet.unideb.application.model.questions.QuestionRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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
    private QuestionServiceImpl questionServiceImpl;


    private Question getQuestion(){
        return question;
    }


    @Test
    public void testFindQuestionShouldSucceedWhenQuestionsListIsNotEmpty(){

        Question testQuestion = getQuestion();

        List<Question> questions = new ArrayList<>();
        questions.add(testQuestion);

        when(questionRepository.findAll()).thenReturn(questions);

        List<Question> checkQuestions = questionServiceImpl.findAllQuestion();

        verify(questionRepository,timeout(1)).findAll();

        Assert.assertTrue(checkQuestions.size() > 0);
        Assert.assertEquals(testQuestion,checkQuestions.get(0));

    }

    @Test
    public void testFindByIdShouldSucceedWhenQuestionsIdIsNotNull(){

        Question testQuestion = getQuestion();
        testQuestion.setId(3);
        questionServiceImpl.addQuestion(testQuestion);

        when(questionRepository.findById(any(Integer.class))).thenReturn(testQuestion);

        Question checkQuestion = questionServiceImpl.findById(3);

        verify(questionRepository,times(1)).findById(any(Integer.class));

        Assert.assertNotNull(checkQuestion);
        Assert.assertEquals(checkQuestion,testQuestion);

    }

    @Test(expected = Exception.class)
    public void addQuestionTest(){
        Question testQuestion = getQuestion();

        doThrow(Exception.class).when(questionRepository.save(any(Question.class)));

        questionServiceImpl.deleteQuestion(testQuestion);
        verify(questionRepository,times(2)).save(any(Question.class));
    }

    @Test(expected = NullPointerException.class)
    public void deleteQuestionTest(){
        Question testQuestion = getQuestion();

        doThrow(NullPointerException.class).when(questionRepository).delete(any(Question.class));

        questionServiceImpl.deleteQuestion(testQuestion);
        verify(questionRepository,times(2)).delete(any(Question.class));
    }
}