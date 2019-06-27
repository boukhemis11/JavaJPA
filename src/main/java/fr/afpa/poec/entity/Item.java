package fr.afpa.poec.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Item {
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
	@Column
	private String name;
	@Column
	private String code;
	@Column
	private String description;
	@Column
	private double price;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="item")
	private Set<Image> images = new HashSet<>();
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable
	private Set<Category> categories = new HashSet<>();
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn
	private Warranty warranty;
	
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Warranty getWarranty() {
		return warranty;
	}
	public void setWarranty(Warranty warranty) {
		this.warranty = warranty;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Image> getImages() {
		return images;
	}
	public void setImages(Set<Image> images) {
		this.images = images;
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Item(String name, String code, String description, double price) {
		super();
		this.name = name;
		this.code = code;
		this.description = description;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", code=" + code + ", description=" + description + ", price="
				+ price + ", images=" + images + ", categories=" + categories + ", warranty=" + warranty + "]";
	}
	public void addImage(Image img) {
		images.add(img);
		img.setItem(this);
	}
	public void removeImage(Image img) {
		images.remove(img);
		img.setItem(null);
	}
	public void addCategory(Category cat) {
		categories.add(cat);
	}
	public void removeCategory(Category cat) {
		categories.remove(cat);
	}
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
}
