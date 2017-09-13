1:导入jar包

	spring的核心包
	/springMVC/webapp/WEB-INF/lib/spring-beans-4.0.0.RELEASE.jar
	/springMVC/webapp/WEB-INF/lib/spring-context-4.0.0.RELEASE.jar
	/springMVC/webapp/WEB-INF/lib/spring-core-4.0.0.RELEASE.jar
	/springMVC/webapp/WEB-INF/lib/spring-expression-4.0.0.RELEASE.jar
	
	springmvc的核心包
	/springMVC/webapp/WEB-INF/lib/spring-web-4.0.0.RELEASE.jar
	/springMVC/webapp/WEB-INF/lib/spring-webmvc-4.0.0.RELEASE.jar
	
	/springMVC/webapp/WEB-INF/lib/com.springsource.org.apache.commons.logging-1.1.1.jar
	
	/springMVC/webapp/WEB-INF/lib/el-api.jar
	/springMVC/webapp/WEB-INF/lib/jsp-api.jar
	/springMVC/webapp/WEB-INF/lib/servlet-api.jar
2:添加配置文件application.xml
	当不使用注解的方式的时候，bean中的name代表路径
	<bean name="/hello" class="com.xmg.springmvc.controller.Hello" />
	并且类要实现 org.springframework.web.servlet.mvc.Controller接口
	使用注解的时候
		1：在类上加@Controller
		2：在方法上加@RequestMapping("/demo")，代表访问路径
3:配置web.xml
	该项目下访问路径的severlet都用org.springframework.web.servlet.DispatcherServlet来进行分发；但是DispatcherServlet的默认命名方式是
	(severlet的name)-servlet.xml，所以要修改默认的配置文件路径：如下：
	<init-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>classpath:application.xml</param-value>
	</init-param>
	
	<servlet>
		<servlet-name>springmvc</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<!-- 修改默认的资源加载路径 -->
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>classpath:application.xml</param-value>
		</init-param>
	</servlet>
	<servlet-mapping>
		<servlet-name>springmvc</servlet-name>
		<url-pattern>/</url-pattern>
	</servlet-mapping>
		
4:使用全注解的方式
	1:开启注解扫描
	
		<!-- 添加自动扫描bean -->
		<context:component-scan base-package="com.xmg.springmvc.controller" />
	
	2：添加对springmvc驱动支持
		
		<!-- 添加对springmvc的支持 -->
		<mvc:annotation-driven/>
	
	3：导入aop相关的包	
		com.springsource.org.apache.commons.logging-1.1.1.jar
		
	4:在类上面
		控制层：@Controller
		业务逻辑层：@Service
		DAO:@Respository
		工具类:@Conpoment
		
	5:支持静态资源处理
		<!-- 此时可以直接访问到根目录下的文件，在浏览器上输入地址 -->
		<mvc:default-servlet-handler/>
		
5:解决中文乱码
	org.springframework.web.filter.CharacterEncodingFilter
	
	<!-- 解决参数中文乱码的问题 -->
	<filter>
		<filter-name>CharacterEncodingFilter</filter-name>
		<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
		<init-param>
			<param-name>encoding</param-name>
			<param-value>utf-8</param-value>
		</init-param>
	</filter>
	
	<filter-mapping>
		<filter-name>CharacterEncodingFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
	
6:文件上传
	1：表单写成 
		enctype="multipart/form-data"
	2：拷贝jar包
		com.springsource.org.apache.commons.fileupload-1.2.0.jar
		com.springsource.org.apache.commons.io-1.4.0.jar
	3：编写类
		@RequestMapping("/uploaddemo")
		public ModelAndView Uploaddemo(MultipartFile file) throws IOException {
			String contentTypeString = file.getContentType();
			String name = file.getName();
			System.out.println(contentTypeString);
			System.out.println(name);
			
			InputStream in = file.getInputStream();
			String flieNameString = UUID.randomUUID().toString() + ".text";
			
			FileOutputStream out = new FileOutputStream(new File("F:/", flieNameString));
			IOUtils.copy(in, out);
			out.close();
			ModelAndView mv = new ModelAndView();
			mv.setViewName("upload.jsp");
			return mv;
		}
		
		
7:文件下载
	1；在参数中添加response参数
	2：在类上添加注解
		@ResponseBody//告诉springmvc所有的相应有response操作
	3：编写类
		
		
8:配置拦截器
	1:拦截器类 org.springframework.web.servlet.HandlerInterceptor，自己定义的要实现该类
		preHandle:执行处理器前调用，放回true or false；如果为false，拦截请求
		postHandle：处理器调用完成后，但是师徒合并前
		afterCompletion：师徒合并后调用
	2:配置拦截器：
		<mvc:interceptors>
			<mvc:interceptor>
				<mvc:mapping path="/*"/>
				<bean class="com.xmg.springmvc.controller.Interceptor"></bean>
			</mvc:interceptor>
		</mvc:interceptors>