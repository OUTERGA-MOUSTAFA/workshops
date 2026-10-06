package ma.youcode.workshop.resources;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath ("/api")
public class RestApplication extends Application{
    // Laissez le corps vide, Jersey scanne tout seul !
    // public RestApplication(){
    //     Register(ApprenantsResource.class);
    // }
}
