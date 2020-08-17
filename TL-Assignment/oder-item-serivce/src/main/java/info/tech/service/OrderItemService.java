package info.tech.service;

import java.util.Optional;

import info.tech.model.Item;

public interface OrderItemService {

	public Item createOrderItem(Item item);

	public Optional<Item> findItemById(String id);

}