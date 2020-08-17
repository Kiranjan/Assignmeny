package info.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.tech.model.Item;
import info.tech.model.Order;

@Repository
public interface OrderItemServiceRepo extends JpaRepository<Item, Integer> {

}