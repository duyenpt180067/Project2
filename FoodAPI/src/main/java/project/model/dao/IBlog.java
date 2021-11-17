package project.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.model.entity.Blog;

@Repository
public interface IBlog extends JpaRepository<Blog, Integer> {

}
