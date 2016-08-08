package cn.com.mink.resource;

//import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationAPI extends ResourceConfig {

	public ApplicationAPI() {

		// 加载resources

		register(HelloResource.class);

		register(UserResource.class);

		// 注册数据转换器

	//	register(JacksonJsonProvider.class);
		register(JacksonFeature.class);
		// 注册日志

		register(LoggingFilter.class);

	}

}