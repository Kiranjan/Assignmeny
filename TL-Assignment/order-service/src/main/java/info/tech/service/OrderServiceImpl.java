package info.tech.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.tech.model.Order;
import info.tech.repository.OrderServiceRepo;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderServiceRepo orderServiceRepo;
	@Override
	public Order createOrder(Order order) {
		return orderServiceRepo.save(order);
	}
	@Override
	public Optional<Order> findOrderById(String id) {
		
		return orderServiceRepo.findById(Integer.parseInt(id));
		
	}

}
