package hu.transfet.unideb.application.model.answer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Answer repository.
 */
@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
