package project.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.model.entity.Systems;

@Repository
public interface ISystems extends JpaRepository<Systems, Integer> {

}
