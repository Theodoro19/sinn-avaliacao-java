package br.com.sinn.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.sinn.dao.CargoDAO;
import br.com.sinn.dao.EmpresaDAO;
import br.com.sinn.dao.PessoaDAO;
import br.com.sinn.model.cargo;
import br.com.sinn.model.empresa;
import br.com.sinn.model.pessoa;

@Stateless
public class AtividadeService {

	@Inject
	EmpresaDAO empresaDAO;
	@Inject
	CargoDAO cargoDAO;
	@Inject
	PessoaDAO pessoaDAO;
	
	/***** EMPRESA *****/
	
	// MÉTODO PARA SALVAR E ALTERAR EMPRESA
	public void salvar(empresa empresa){
		this.empresaDAO.salvar(empresa);
	}
	
	// MÉTODO PARA DELETAR EMPRESA
	public void deletar(empresa empresa){
		this.empresaDAO.deletar(empresa);
	}
	
	// MÉTODO PARA LISTAR TODAS AS EMPRESAS
	public List<empresa> listarEmpresas(){
		return this.empresaDAO.listaEmpresas();
	}

	
	/***** CARGO *****/
	
	// MÉTODO PARA SALVAR CARGO
	public void salvar(cargo cargo){
		this.cargoDAO.salvar(cargo);
	}
	
	// MÉTODO PARA DELETAR CARGO
	public void deletar(cargo cargo){
		this.cargoDAO.deletar(cargo);
	}
	
	// MÉTODO PARA LISTAR TODOS OS CARGOS
	public List<cargo> listarCargos(){
		return this.cargoDAO.listaCargos();
	}
	
	/***** PESSOA *****/
	
	// MÉTODO PARA SALVAR PESSOA
	public void salvar(pessoa pessoa){
		this.pessoaDAO.salvar(pessoa);
	}
	
	// MÉTODO PARA DELETAR PESSOA
	public void deletar(pessoa pessoa){
		this.pessoaDAO.deletar(pessoa);
	}
	
	// MÉTODO PARA LISTAR TODAS AS PESSOAS
	public List<pessoa> listaPessoas(){
		return this.pessoaDAO.listaPessoas();
	}
}
