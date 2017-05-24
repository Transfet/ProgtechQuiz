package hu.transfet.unideb.application.model.questions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Question repository.
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    Question findById(int ID);

}
