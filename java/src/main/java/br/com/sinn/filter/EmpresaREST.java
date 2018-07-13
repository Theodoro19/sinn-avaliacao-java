package br.com.sinn.filter;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.sinn.model.empresa;
import br.com.sinn.service.AtividadeService;

@RequestScoped
@Path("/empresa")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class EmpresaREST {

	@Inject
	AtividadeService service;
	
	@GET
	@Path("/lista")
	@Produces(MediaType.APPLICATION_JSON)
	public List<empresa> lista(){
		return this.service.listarEmpresas();
	}
	
	@POST
	@Path("/salvar")
	@Produces(MediaType.APPLICATION_JSON)
	public void salvar(empresa empresa){
		this.service.salvar(empresa);
	}
	
	@POST
	@Path("/deletar")
	@Produces(MediaType.APPLICATION_JSON)
	public void deletar(empresa empresa){
		this.service.deletar(empresa);
	}
}
