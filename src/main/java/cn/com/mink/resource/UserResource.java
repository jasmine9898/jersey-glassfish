package cn.com.mink.resource;

import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

@Path("user")

public class UserResource {
	//http://localhost:8280/jersey-glassfish/services/user/abc?desc=d
	//http://localhost:8280/jersey-glassfish/services/user/xyz
	@GET
	@Path("{username}")
	//@Produces(MediaType.APPLICATION_XML)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public User getUser(@PathParam("username") String userName, @DefaultValue("description") @QueryParam("desc") String desc) {
	User user = new User();
	user.setId(new Random().nextInt());
	user.setUserName(userName);
	user.setDesc(desc);
	return user;
	}
	@POST
	@Path("updateUser")
	@Consumes("application/x-www-form-urlencoded")
	public void updateUser(@FormParam("name") String userName, @FormParam("desc") String desc) {
	User user = new User();
	user.setId(1);
	user.setUserName(userName);
	user.setDesc(desc);
	System.out.println(user);
	}
	@POST
	@Path("updateUser1")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes("application/x-www-form-urlencoded")
	public User updateUser1(@BeanParam User user) {//注意这个方法需要在User这个bean中使用@FromParam注解
	System.out.println(user);
	return user;
	}
	
	@Context
	HttpServletRequest request;
	@Context
	HttpServletResponse response;
	@Context
	ServletConfig servletConfig;
	@Context
	ServletContext servletContext;
	@Context
	HttpHeaders header;
	@Context
	UriInfo info;
	@GET
	@Path("/test/{param}")
	@Produces(MediaType.APPLICATION_XML)
	public User getContext() {
	MultivaluedMap<String, String> queryParameters = info.getQueryParameters();
	MultivaluedMap<String, String> pathParameters = info.getPathParameters();
	System.out.println("queryParameters"+queryParameters);
	System.out.println("pathParameters"+pathParameters);
	System.out.println("request"+this.request);
	System.out.println("response"+this.response);
	System.out.println("servletConfig"+this.servletConfig);
	System.out.println("servletContext"+this.servletContext);
	System.out.println("header"+this.header);
	System.out.println("info"+this.info);
	return new User(1, "gusi");
	}
	//http://localhost:8280/jersey-glassfish/services/user/getJson
	@Path("getJson")
	@GET
	@Produces(value=MediaType.APPLICATION_JSON)
	    public User getJson(){
	    return new User(1, "sssss");
	    }
	
}