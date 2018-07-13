package br.com.sinn.filter;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.sinn.model.pessoa;
import br.com.sinn.service.AtividadeService;

@RequestScoped
@Path("/pessoa")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class PessoaREST {

	@Inject
	AtividadeService service;

	@GET
	@Path("/lista")
	@Produces(MediaType.APPLICATION_JSON)
	public List<pessoa> lista() {
		return this.service.listaPessoas();
	}

	@POST
	@Path("/salvar")
	@Produces(MediaType.APPLICATION_JSON)
	public void salvar(pessoa pessoa) {
		this.service.salvar(pessoa);
	}

	@POST
	@Path("/deletar")
	@Produces(MediaType.APPLICATION_JSON)
	public void deletar(pessoa pessoa) {
		this.service.deletar(pessoa);
	}

	@GET
	@Path("/lista/{salarioAtualizado}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<pessoa> lista(@PathParam("salarioAtualizado") int validar) {
		if (validar == 1) {
			List<pessoa> lista = this.service.listaPessoas();
			for (pessoa p : lista) {
				if (p.getCargo().getId() == 1) {
					p.setSalario_reajuste(p.getSalario_atual() * 1.1);
				} else if (p.getCargo().getId() == 2) {
					p.setSalario_reajuste(p.getSalario_atual() * 1.2);
				} else {
					p.setSalario_reajuste(p.getSalario_atual() * 1.35);
				}
				this.service.salvar(p);
			}
			return this.service.listaPessoas();
		} else {
			return null;
		}

	}

}
