package br.com.sinn.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import br.com.sinn.model.cargo;

@Stateless
public class CargoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "sinnProducao", type = PersistenceContextType.TRANSACTION)
	private EntityManager manager;

	public void salvar(cargo cargo) {
		if (cargo.getId() == 0) {
			this.manager.persist(cargo);
		} else {
			this.manager.merge(cargo);
		}
	}

	public void deletar(cargo cargo) {
		this.manager.remove(cargo);
	}

	@SuppressWarnings("unchecked")
	public List<cargo> listaCargos() {
		return this.manager.createQuery("from cargo ").getResultList();
	}
}
