import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("")
public class MyApplication extends ResourceConfig {
    public MyApplication() {
        packages("br.ufrj.tic.integrator.service");
    }
}