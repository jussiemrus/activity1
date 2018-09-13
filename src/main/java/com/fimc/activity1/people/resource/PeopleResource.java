package com.fimc.activity1.people.resource;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Path("/people")
public class PeopleResource implements Serializable {
	ArrayList<PeopleResponse> list = new ArrayList();
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response hello(PeopleRequest request) {
		
		if(StringUtils.isEmpty(request.getFirstName())||StringUtils.isEmpty(request.getLastName())||StringUtils.isEmpty(request.getBirthDate())) {
			return Response.status(HttpServletResponse.SC_BAD_REQUEST)
			 .entity("All fields are required.").type( MediaType.TEXT_PLAIN).build();

		}else {
			
			PeopleResponse peopleResponse = new PeopleResponse();
			SimpleDateFormat Date = new SimpleDateFormat("MM-dd-yyyy");
			peopleResponse.setFirstName(String.format(" %s",request.getFirstName()));
			peopleResponse.setLastName(String.format(" %s",request.getLastName()));
			peopleResponse.setBirthDate(Date.format(request.getBirthDate()));
			list.add(peopleResponse);
			return Response.status(HttpServletResponse.SC_CREATED).entity(HttpServletResponse.SC_CREATED).build();

		}
	}	
	
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Response peopleAll(PeopleRequest request) {
			return Response.ok().entity(list).build();
		}
}
