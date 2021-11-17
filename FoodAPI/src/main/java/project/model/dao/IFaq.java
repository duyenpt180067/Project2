package project.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.model.entity.Faq;

@Repository
public interface IFaq extends JpaRepository<Faq, Integer> {

}
