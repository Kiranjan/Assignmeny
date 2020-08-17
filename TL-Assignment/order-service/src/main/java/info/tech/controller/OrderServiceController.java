package info.tech.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import info.tech.config.NotFoundException;
import info.tech.model.Order;
import info.tech.service.OrderService;

@RestController
public class OrderServiceController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping(value = "/order")
	public Order newOrder (@Valid @RequestBody Order order) {
		return orderService.createOrder(order);
	}
	
	@GetMapping(value = "/order/{id}")
	public Order getOrderById(@PathVariable String id) {
		 return orderService.findOrderById(id).orElseThrow(() -> new NotFoundException("Order not found with id " + id));
	}



}
