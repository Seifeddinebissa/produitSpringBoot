package com.seif.produits.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.seif.produits.entities.Categorie;
import com.seif.produits.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long>{

	List<Produit> findByNomProduit(String nom);
	List<Produit> findByNomProduitContains(String nom); 
	
	@Query("SELECT p FROM Produit p WHERE p.nomProduit like %?1 AND p.prixProduit > ?2")
	List<Produit> findByNomPrix(String nom, Double prix);
	
	@Query("select p from Produit p where p.categorie = ?1")
	List<Produit> findByCategorie (Categorie categorie);
	
	List<Produit> findByCategorieIdCat(Long id);
	
	List<Produit> findByOrderByNomProduitAsc();
	
	@Query("select p from Produit p order by p.nomProduit ASC, p.prixProduit DESC")
	List<Produit> trierProduitsNomsPrix ();
	
	
	
}
