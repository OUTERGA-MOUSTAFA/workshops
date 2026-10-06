package ma.youcode.workshop.resources;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ma.youcode.workshop.dao.ApprenantDao;
import ma.youcode.workshop.models.Apprenant;



@Path("/apprenants")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ApprenantsResource {
    

    private ApprenantDao dao = new ApprenantDao();

    // Exercice 1 : Lire tous les apprenants (GET /api/apprenants)
    @GET
    public List<Apprenant> getAll() {
        return dao.findAll(); // Utilise la méthode existante du projet de départ
    }

    // Exercice 2 : Lire un apprenant par son ID (GET /api/apprenants/{id})
    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") int id) {
        Apprenant apprenant = dao.findById(id);
        if (apprenant == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(apprenant).build();
    }

    // Exercice 3 : Créer un apprenant (POST /api/apprenants)
    @POST
    public Response create(Apprenant apprenant) {
        dao.save(apprenant); // Utilise la méthode d'insertion du DAO
        return Response.status(Response.Status.CREATED).entity(apprenant).build();
    }
}
