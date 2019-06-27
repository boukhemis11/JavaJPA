package fr.afpa.poec.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Warranty {
	@Column
	private String summary;
	@Column
	private String fullText;
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
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getFullText() {
		return fullText;
	}
	public void setFullText(String fullText) {
		this.fullText = fullText;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Warranty() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Warranty(String summary, String fullText) {
		super();
		this.summary = summary;
		this.fullText = fullText;
	}
	@Override
	public String toString() {
		return "Warranty [summary=" + summary + ", fullText=" + fullText + ", id=" + id + "]";
	}

}
