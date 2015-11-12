/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import exam.preparation_threadpoolcallables.ScrapeInfo;
import exam.preparation_threadpoolcallables.Utility;
import java.util.concurrent.ExecutionException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author bbalt
 */
@Path("group")
public class ApiResource {

    @Context
    private UriInfo context;
    Utility groupUrls = new Utility();
    private static Gson gson = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();

    
    public ApiResource() {
    }

    @GET
    @Produces("application/json")
    public String getJson() throws InterruptedException, ExecutionException {
        ScrapeInfo si = new ScrapeInfo();
        si.scapeInfo(groupUrls.urls, 4);
        return gson.toJson(si.getGroups());
    }

    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
