package info.tech.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Table
@Entity
public class Order implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	@NotBlank(message = "Please fill this field")
	@NotNull(message = "Customer name is mandatory")
	private String customerName;
	
	@Column
	private Date orderDate;
	
	@Column
	private int total;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shippingaddressid", referencedColumnName = "id")
	private Address shippingAddress;
	
	
	@OneToMany(mappedBy ="order" )
	private Set<Item> orderItems;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getPrice() {
		return total;
	}

	public void setPrice(int price) {
		this.total = price;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Set<Item> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<Item> orderItems) {
		this.orderItems = orderItems;
	}

	
	
	
	
	
	
	
	

}
