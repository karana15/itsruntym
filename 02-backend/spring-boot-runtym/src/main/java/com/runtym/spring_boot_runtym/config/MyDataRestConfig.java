package com.runtym.spring_boot_runtym.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.runtym.spring_boot_runtym.entity.Favorite;
import com.runtym.spring_boot_runtym.entity.Sheet;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer{
	
	private String theAllowedOrigins = "http://localhost:3000";
	
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, 
														CorsRegistry cors) {
		HttpMethod[]  theUnsupportedActions = {
				HttpMethod.POST,
				HttpMethod.PATCH,
				HttpMethod.DELETE,
				HttpMethod.PUT};
		
		config.exposeIdsFor(Sheet.class);
		config.exposeIdsFor(Favorite.class);
		
		disableHttpMethods(Sheet.class, config, theUnsupportedActions);
		disableHttpMethods(Favorite.class, config, theUnsupportedActions);
		
		/* Configure CORS Mapping */
		cors.addMapping(config.getBasePath() + "/**").allowedOrigins(theAllowedOrigins);
  	}
	
	private void disableHttpMethods(Class theClass, 
									RepositoryRestConfiguration config, 
									HttpMethod[] theUnsupporHttpActions) {
		config.getExposureConfiguration()
				.forDomainType(theClass)
				.withItemExposure((metdata, httpMethods) -> 
						httpMethods.disable(theUnsupporHttpActions))
				.withCollectionExposure((metdata, httpMethods) ->
						httpMethods.disable(theUnsupporHttpActions));
	}

}
