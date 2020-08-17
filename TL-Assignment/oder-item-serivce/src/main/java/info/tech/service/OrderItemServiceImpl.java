package info.tech.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.tech.model.Item;
import info.tech.model.Order;
import info.tech.repository.OrderItemServiceRepo;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemServiceRepo orderItemServiceRepo;

	@Override
	public Item createOrderItem(Item item) {
		return orderItemServiceRepo.save(item);
	}

	@Override
	public Optional<Item> findItemById(String id) {
		return orderItemServiceRepo	.findById(Integer.parseInt(id));

	}

}