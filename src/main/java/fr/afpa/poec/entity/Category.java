package fr.afpa.poec.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Category {
	@Column
	private String name;
	@Column
	private String code;
	@Column
	private String description;
	@Id
	@GeneratedValue(
	strategy= GenerationType.AUTO,
	generator="native"
	)
	@GenericGenerator(
	name = "native",
	strategy = "native"
	)
	Long id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Category(String name, String code, String description) {
		super();
		this.name = name;
		this.code = code;
		this.description = description;
	}
	@Override
	public String toString() {
		return "Category [name=" + name + ", code=" + code + ", description=" + description + ", id=" + id + "]";
	}
	
	
}
