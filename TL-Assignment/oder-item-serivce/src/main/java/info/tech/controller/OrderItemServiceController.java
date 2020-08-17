package info.tech.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import info.tech.config.NotFoundException;
import info.tech.model.Item;
import info.tech.service.OrderItemService;

@RestController
public class OrderItemServiceController {
	
	@Autowired
	private OrderItemService orderItemService;
	
	@PostMapping(value = "/item")
	public Item newItem (@Valid @RequestBody Item item) {
		return orderItemService.createOrderItem(item);
	}
	
	@GetMapping(value = "/item/{id}")
	public Item getItemById(@PathVariable String id) {
		 return orderItemService.findItemById(id).orElseThrow(() -> new NotFoundException("Item is not found with id " + id));
	}



}