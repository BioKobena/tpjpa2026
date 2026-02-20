package jpa;

import java.util.HashSet;
import java.util.Set;

import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import jpa.controller.ConcertController;

@ApplicationPath("/")
public class JpaTest extends Application {

	@Override
	public Set<Class<?>> getClasses() {

		final Set<Class<?>> clazzes = new HashSet<Class<?>>();

		clazzes.add(OpenApiResource.class);
		clazzes.add(SwaggerResource.class);
		clazzes.add(ConcertController.class);

		return clazzes;
	}

}
