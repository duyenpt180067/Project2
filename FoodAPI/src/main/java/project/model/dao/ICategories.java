package project.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.model.entity.Categories;

@Repository 
public interface ICategories extends JpaRepository<Categories, Integer> {
	List<Categories> findByCaName(String CaName);
}
