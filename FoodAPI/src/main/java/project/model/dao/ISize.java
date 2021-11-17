package project.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.model.entity.Size;

@Repository
public interface ISize extends JpaRepository<Size, Integer> {

}
