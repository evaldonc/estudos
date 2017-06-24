package br.com.caelum.livraria.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Usuario;

@Stateless
public class UsuarioDao {
	
	//private Banco banco = new Banco();
	@PersistenceContext
	private EntityManager manager;

	public Usuario buscaPeloLogin(String login) {
		//return this.banco.buscaPeloNome(login);
		Usuario usuario = (Usuario) this.manager
				.createQuery("SELECT u from Usuario u where u.login = :pLogin")
				.setParameter("pLogin", login).getSingleResult();
		return usuario;
	}
	
}
