package project.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.model.entity.OrderDetail;

@Repository
public interface IOrderDetail extends JpaRepository<OrderDetail, Integer> {

}
