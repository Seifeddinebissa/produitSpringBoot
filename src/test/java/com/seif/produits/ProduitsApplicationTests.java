package com.seif.produits;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.seif.produits.entities.Categorie;
import com.seif.produits.entities.Produit;
import com.seif.produits.repositorys.ProduitRepository;



@SpringBootTest
class ProduitsApplicationTests {

	@Autowired
	private ProduitRepository produitRepository;
	

	/*@Test
	public void testCreateProduit() {
		Categorie categorie = new Categorie("PC","Les PCs");
		Produit prod = new Produit("PC Dell", 2200.5, new Date(),categorie);
		produitRepository.save(prod);
	}*/
	
	@Test
	public void testFindProduit() {
		Produit p = produitRepository.findById(1L).get();
		System.out.println(p);
	}

	@Test
	public void testUpdateProduit() {
		Produit p = produitRepository.findById(1L).get();
		p.setPrixProduit(1000.0);
		produitRepository.save(p);	
	}

	@Test
	public void testDeleteProduit() {
		produitRepository.deleteById(1L);
		;
	}

	@Test
	public void testListerTousProduits() {
		List<Produit> prods = produitRepository.findAll();
		for (Produit p : prods) {
			System.out.println(p);
		}
	}
	
	/*@Test
	public void testFindByNomProduitContains() {
		Page<Produit> prods = produitService.getAllProduitsParPage(0, 2);
		System.out.println(prods.getSize());
		System.out.println(prods.getTotalElements());
		System.out.println(prods.getTotalPages());
		prods.getContent().forEach(p -> {
			System.out.println(p.toString());
		});
		/*
		 * ou bien for (Produit p : prods) { System.out.println(p); }
		 
	}*/
	
	@Test
	public void testFindByNomProduit() {
		List<Produit> prods = produitRepository.findByNomProduit("PC Dell");
		for (Produit p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindByNomProduitContains() {
		List<Produit> prods = produitRepository.findByNomProduitContains("pc");
		for (Produit p : prods) {
			System.out.println(p);
		}
	}
	
	@Test
	public void testfindByNomPrix() {
		List<Produit> prods = produitRepository.findByNomPrix("pc dell", 1000.0);
		prods.forEach(p ->{
			System.out.println(p.toString());
		});
	}

	@Test
	public void testfindByCategorie() {
		Categorie cat = new Categorie();
		cat.setIdCat(1L);
		List<Produit> prods = produitRepository.findByCategorie(cat);
		for (Produit p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void findByCategorieIdCat() {
		List<Produit> prods = produitRepository.findByCategorieIdCat(1L);
		for (Produit p : prods) {
			System.out.println(p);
		}
	}
	
	@Test
	public void testfindByOrderByNomProduitAsc() {
		List<Produit> prods = produitRepository.findByOrderByNomProduitAsc();
		for (Produit p : prods) {
			System.out.println(p);
		}
	}
	
	@Test
	public void testTrierProduitsNomsPrix() {
		List<Produit> prods = produitRepository.trierProduitsNomsPrix();
		for (Produit p : prods) {
			System.out.println(p);
		}
	}

}
