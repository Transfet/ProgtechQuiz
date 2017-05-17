package application.model.questions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    Question findAnswerByQuestion(String question);
    Question findById(int ID);


}
