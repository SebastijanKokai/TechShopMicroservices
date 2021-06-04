package com.agilne.assemblyMicroservice.models;

import javax.persistence.*;

@Entity
@IdClass(AssemblyId.class)
public class Assembly {

	// Composite primary key
	@Id
	private Integer assemblyId;
	@Id
	private Integer partId;

	// Attributes
	private Integer quantity;

	// Relationships
	@Transient
	private Product assembly;
	@Transient
	private Product part;

	// Getters and setters
	public Integer getAssemblyId() {
		return assemblyId;
	}
	public void setAssemblyId(Integer assemblyId) {
		this.assemblyId = assemblyId;
	}
	public Integer getPartId() {
		return partId;
	}
	public void setPartId(Integer partId) {
		this.partId = partId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Product getAssembly() {
		return assembly;
	}
	public void setAssembly(Product assembly) {
		this.assembly = assembly;
	}
	public Product getPart() {
		return part;
	}
	public void setPart(Product part) {
		this.part = part;
	}
	
	
}
