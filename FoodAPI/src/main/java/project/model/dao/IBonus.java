package project.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.model.entity.Bonus;

@Repository
public interface IBonus extends JpaRepository<Bonus, Integer> {

}
