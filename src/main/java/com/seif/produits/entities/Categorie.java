package com.seif.produits.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Categorie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCat;
	private String nomCat;
	private String descriptionCat;
	
	public Categorie(String nom, String description) {
		super();
		this.nomCat = nom;
		this.descriptionCat = description;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "categorie")
	private List<Produit> produits;
	
	

}
