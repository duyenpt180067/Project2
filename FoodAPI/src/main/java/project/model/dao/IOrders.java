package project.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.model.entity.Orders;

@Repository
public interface IOrders extends JpaRepository<Orders, String> {

}
