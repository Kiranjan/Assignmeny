package info.tech.service;

import java.util.Optional;

import info.tech.model.Order;

public interface OrderService {

	public Order createOrder(Order order);

	public Optional<Order> findOrderById(String id);

}
