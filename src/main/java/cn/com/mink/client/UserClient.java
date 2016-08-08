package cn.com.mink.client;
import javax.ws.rs.client.Client;  
import javax.ws.rs.client.ClientBuilder;  
import javax.ws.rs.client.Entity;  
import javax.ws.rs.client.WebTarget; 
import javax.ws.rs.core.Response;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.client.JerseyClient;

import cn.com.mink.resource.User;
public class UserClient {
    
	public static void main(String[] args) {  
       getUser();  
       
    }

	private static void getUser() {
		JerseyClient  client = (JerseyClient) ClientBuilder.newClient().register(JacksonJsonProvider.class);// 注册json 支持  
         WebTarget target = client.target("http://localhost:8280/jersey-glassfish/services//services/user/getJson");  
         Response response = target.request().get();  
         User user = response.readEntity(User.class);  
         System.out.println(user.getId() + user.getUserName()  +  user.getDesc());  
         response.close();  
	} 
}
