package br.com.digitalhouse.bootcampbrspring.domain.entity;

public class Product {

	private Long id;
	private String description;
	private String name;
	private double price;

	public Product() {
	}

	public Product(Long id, String description, String name, double price) {
		this.id = id;
		this.description = description;
		this.name = name;
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}
