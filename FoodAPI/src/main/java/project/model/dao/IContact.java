package project.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.model.entity.Contact;

@Repository
public interface IContact extends JpaRepository<Contact, Integer> {

}
