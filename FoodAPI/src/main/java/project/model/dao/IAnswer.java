package project.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.model.entity.Answer;

@Repository
public interface IAnswer extends JpaRepository<Answer, Integer> {

}
