package br.com.sinn.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import br.com.sinn.model.pessoa;

@Stateless
public class PessoaDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "sinnProducao", type = PersistenceContextType.TRANSACTION)
	private EntityManager manager;

	public void salvar(pessoa pessoa) {
		if (pessoa.getCodigo() == 0) {
			this.manager.persist(pessoa);
		} else {
			this.manager.merge(pessoa);
		}
	}

	public void deletar(pessoa pessoa) {
		this.manager.remove(pessoa);
	}

	@SuppressWarnings("unchecked")
	public List<pessoa> listaPessoas() {
		return this.manager.createQuery("from pessoa ").getResultList();
	}
}
