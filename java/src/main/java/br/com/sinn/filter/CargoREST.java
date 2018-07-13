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

import br.com.sinn.model.cargo;
import br.com.sinn.service.AtividadeService;

@RequestScoped
@Path("/cargo")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class CargoREST {

	@Inject
	AtividadeService service;
	
	@GET
	@Path("/lista")
	@Produces(MediaType.APPLICATION_JSON)
	public List<cargo> lista(){
		return this.service.listarCargos();
	}
	
	@POST
	@Path("/salvar")
	@Produces(MediaType.APPLICATION_JSON)
	public void salvar(cargo cargo){
		this.service.salvar(cargo);
	}
	
	@POST
	@Path("/deletar")
	@Produces(MediaType.APPLICATION_JSON)
	public void deletar(cargo cargo){
		this.service.deletar(cargo);
	}
}
