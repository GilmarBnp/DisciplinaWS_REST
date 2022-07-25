/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gil.disciplinasws_rest.service;

import com.gil.disciplinasws_rest.Modulo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author emerson
 */
@Stateless
@Path("com.gil.disciplinasws_rest.modulo")
public class ModuloFacadeREST extends AbstractFacade<Modulo> {

    @PersistenceContext(unitName = "com.gil_DisciplinasWS_REST_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public ModuloFacadeREST() {
        super(Modulo.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Modulo entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Modulo entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Modulo find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Modulo> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Modulo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /*
* Metodo para recuperar as informações do módulo conforme o tema_id informado
     */
    @GET
    @Path("/tema/{tema_id}") //Define a URI do recurso
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Modulo> findByTemaId(@PathParam("tema_id") Integer tema_id) {
        //Cria uma query selecionando os dados do modulo de acordo com o tema_id informado
        return em.createQuery(
                "SELECT m.moduloId, m.moduloNome, m.temaId FROM Modulo m WHERE m.temaId = :temaId")
                .setParameter("temaId", tema_id)
                .getResultList();
    }

}
