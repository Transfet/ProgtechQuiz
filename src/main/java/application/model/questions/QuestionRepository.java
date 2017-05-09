package application.model.questions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Transfet on 2017. 05. 03..
 */

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    Question findAnswerByQuestion(String question);
    Question findById(int ID);


}
