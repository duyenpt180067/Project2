package project.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.model.entity.WebUser;

@Repository
public interface IWebUser extends JpaRepository<WebUser, Integer>{

}
