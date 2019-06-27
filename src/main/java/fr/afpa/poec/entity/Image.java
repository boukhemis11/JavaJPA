package fr.afpa.poec.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Image {
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
	private String altText;
	@Column
	private String path;
	@ManyToOne
	@JoinColumn
	Item item;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAltText() {
		return altText;
	}
	public void setAltText(String altText) {
		this.altText = altText;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Image(String altText, String path) {
		super();
		this.altText = altText;
		this.path = path;
	}
	@Override
	public String toString() {
		return "Image [id=" + id + ", altText=" + altText + ", path=" + path +  "]";
	}
	
}
