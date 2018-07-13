package br.com.sinn.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import br.com.sinn.model.empresa;

@Stateless
public class EmpresaDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "sinnProducao", type = PersistenceContextType.TRANSACTION)
	private EntityManager manager;

	public void salvar(empresa empresa) {
		if (empresa.getCodigo() == 0) {
			this.manager.persist(empresa);
		} else {
			this.manager.merge(empresa);
		}
	}

	public void deletar(empresa empresa) {
		this.manager.remove(empresa);
	}

	@SuppressWarnings("unchecked")
	public List<empresa> listaEmpresas() {
		return this.manager.createQuery("from empresa ").getResultList();
	}
}
