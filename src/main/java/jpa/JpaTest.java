package jpa;

import java.util.HashSet;
import java.util.Set;

import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import jpa.controller.ArtisteController;
import jpa.controller.ClientController;
import jpa.controller.ConcertController;
import jpa.controller.GestionnaireController;
import jpa.controller.TicketController;

@ApplicationPath("/")
public class JpaTest extends Application {

	@Override
	public Set<Class<?>> getClasses() {

		final Set<Class<?>> clazzes = new HashSet<Class<?>>();

		clazzes.add(OpenApiResource.class);
		clazzes.add(SwaggerResource.class);
		clazzes.add(ConcertController.class);
		clazzes.add(ArtisteController.class);
		clazzes.add(GestionnaireController.class);
		clazzes.add(TicketController.class);
		clazzes.add(ClientController.class);
		// clazzes.add(ConcertController.class);

		return clazzes;
	}

}
