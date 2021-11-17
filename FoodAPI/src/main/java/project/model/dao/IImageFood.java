package project.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.model.entity.ImageFood;

@Repository
public interface IImageFood extends JpaRepository<ImageFood, Integer> {

}
