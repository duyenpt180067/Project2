package project.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.model.entity.FoodDetail;

@Repository
public interface IFoodDetail extends JpaRepository<FoodDetail, Integer>{

}
