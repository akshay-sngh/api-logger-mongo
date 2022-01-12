package edu.cmu.akshaysi.project4task0service;

import edu.cmu.akshaysi.project4task0service.model.CovidInfoStore;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import org.json.JSONObject;

import java.io.IOException;

@Path("/covid-resources")
public class CovidInfoResource {
    CovidInfoExtractor service = new CovidInfoExtractor();
    CovidInfoStore model = new CovidInfoStore();

    @Path("/dashboard")
    @GET
    public void displayDashboard(@Context HttpServletRequest request,
                                   @Context HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    @Path("{ageRange}")
    @GET
    @Produces("application/json")
    public Response getCovidInfo(@PathParam("ageRange") String ageRange) {
        JSONObject response = service.getCovidInfoJSON(ageRange);
        return Response.status(200).entity(response.toString()).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response getAndStoreCovidInfo(String requestString) {
        JSONObject request = new JSONObject(requestString);
        JSONObject response = service.getCovidInfoJSON(request.getString("ageRange"));
        request.put("response", response);
        model.insertCovidInfo(request);
        return Response.status(200).entity(response.toString()).build();
    }
}