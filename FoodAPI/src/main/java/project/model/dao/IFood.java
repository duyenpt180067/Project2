package project.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.model.entity.Food;

@Repository 
public interface IFood extends JpaRepository<Food, String> {

}
