package cn.com.mink.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.xml.bind.annotation.XmlRootElement;

	@XmlRootElement

	public class User {

	private int id;

	public User(int id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
		this.desc="descptions";
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	@FormParam("name")
	private String userName;
	@FormParam("desc")
	private String desc;
	}	