package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorDao {
	
	@PersistenceContext
	private EntityManager manager; 
	
	@PostConstruct
	void posConstrucao(){
		System.out.println("inicializou o AutorDAO ");
	}
	
	public void salva(Autor autor) {
		System.out.println("Salvando Autor " + autor.getNome());
//		try {
//			Thread.sleep(20000); // 20s
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} 
		manager.persist(autor);
		System.out.println("Salvou autor " + autor.getNome());
	}
	
	public List<Autor> todosAutores() {
		return manager.createQuery("select a from Autor a", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.manager.find(Autor.class, autorId);
		return autor;
	}
	
}
