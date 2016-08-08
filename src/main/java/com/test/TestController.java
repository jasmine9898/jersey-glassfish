package com.test;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.client.JerseyClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.mink.resource.User;

@Controller
public class TestController {

	@RequestMapping("hello.do")
	public void hello(){
	}
	@RequestMapping("client.do")
	@ResponseBody
	public String client(){
		JerseyClient  client = (JerseyClient) ClientBuilder.newClient().register(JacksonJsonProvider.class);// 注册json 支持  
        WebTarget target = client.target("http://localhost:8080/jersey-glassfish/services/user/getJson");
        Response response = target.request().get();  
        User user = response.readEntity(User.class);  
        System.out.println(user.getId() + user.getUserName()  +  user.getDesc());  
        response.close();
        return "id:"+user.getId() + " name:"+user.getUserName()  +" desc:"+  user.getDesc();
	}
}
