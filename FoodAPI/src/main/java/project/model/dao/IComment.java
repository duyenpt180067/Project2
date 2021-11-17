package project.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.model.entity.Comment;

@Repository
public interface IComment extends JpaRepository<Comment, Integer>{

}
