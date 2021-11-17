package project.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.model.entity.Favorite;

@Repository
public interface IFavorite extends JpaRepository<Favorite, Integer> {

}
