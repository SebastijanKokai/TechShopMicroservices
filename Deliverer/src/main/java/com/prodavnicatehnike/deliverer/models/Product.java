package com.prodavnicatehnike.deliverer.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Product {

	// Primary key
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

    // Attributes
	private String name;
	private Integer available;

	// Relationships
	@ManyToOne
	@JoinColumn(name="product_type")
	private ProductType productType;
	@JsonIgnore
	@OneToMany(mappedBy="assemblyId")
	private List<Assembly> assemblies;
	@JsonIgnore
	@OneToMany(mappedBy="partId")
	private List<Assembly> parts;
	@OneToMany(mappedBy="productId")
	@JsonIgnore
	private List<OrderItem> orderItems;

	// Getters and setters
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	public List<Assembly> getAssemblies() {
		return assemblies;
	}
	public void setAssemblies(List<Assembly> assemblies) {
		this.assemblies = assemblies;
	}
	public List<Assembly> getParts() {
		return parts;
	}
	public void setParts(List<Assembly> parts) {
		this.parts = parts;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAvailable() {
		return available;
	}
	public void setAvailable(Integer available) {
		this.available = available;
	}

	// Methods
	public Assembly AddAssembly(Assembly assembly)
	{
		getAssemblies().add(assembly);
		assembly.setAssembly(this);
		return assembly;
	}
	public Assembly removeAssembly(Assembly assembly) {
		this.getAssemblies().remove(assembly);
		assembly.setAssembly(null);
		return assembly;
	}
	public Assembly AddPart(Assembly part)
	{
		getAssemblies().add(part);
		part.setPart(this);
		return part;
	}
	public Assembly removePart(Assembly part) {
		this.getAssemblies().remove(part);
		part.setPart(null);
		return part;
	}
	
}
