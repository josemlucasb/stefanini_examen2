package com.stefanini.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.rest.dto.SucursalDTO;
import com.stefanini.service.SucursalService;

@Path("/sucursal")
public class RESTSucursalService {

	@Inject
	private SucursalService sucursalService;

	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(SucursalDTO sucursalDTO) {
		return Response.status(Response.Status.OK).entity(sucursalService.create(sucursalDTO)).build();
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(SucursalDTO sucursalDTO) {
		return Response.status(Response.Status.OK).entity(sucursalService.update(sucursalDTO)).build();
	}

	@DELETE
	@Path("/delete/{idSucursal}")
	public Response deleteById(@PathParam("idSucursal") Long idSucursal) {
		return Response.status(Response.Status.OK).entity(sucursalService.deleteById(idSucursal)).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSucursales() {
		return Response.status(Response.Status.OK).entity(sucursalService.getSucursales()).build();
	}

	@GET
	@Path("/find/{idSucursal}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBancoById(@PathParam("idSucursal") Long idSucursal) {
		return Response.status(Response.Status.OK).entity(sucursalService.getSucursalById(idSucursal)).build();
	}

	/**
	 * Buscar todas las sucursales de acuerdo con un banco
	 * 
	 * @param idBanco
	 * @return
	 */
	@GET
	@Path("/findByBanco")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSucursalesByIdBanco(@QueryParam("idBanco") Long idBanco) {
		return Response.status(Response.Status.OK).entity(sucursalService.getSucursalByIdBanco(idBanco)).build();
	}

}
