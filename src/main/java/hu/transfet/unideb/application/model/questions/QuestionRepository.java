package hu.transfet.unideb.application.model.questions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Question repository.
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    /**
     * Visszaad egy kerdest egy ID alapjan.
     * @param ID Egy int ertek, mely a keresett kerdes ID-je.
     * @return Egy kerdes, melynek az ID-je a parameterkent megadott ID.
     */
    Question findById(int ID);

}
