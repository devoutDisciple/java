#环境
struts2.3.x
spring4.0.0
hibernate4.2

思路：从下往上集成，层与层之间没有关系，在集成的时候，只关注当前集成的那个层的内容

1：创建一个空的web项目
2：设置项目编码
3：完成domain
4：完成映射文件
5：写DAO
6:写DAO实现
	1：拷包（hibernate/required,数据库驱动，springcore/test/bean/context）
	2:spring配置文件
		1：配置dataSource；
		2：添加db.properties文件
		3：引入db.properties文件
	3：配置sessionFactory
		1：导入spring jdbc/tx/orm
		2:使用LocalSessionFactoryBean来创建SessionFactory
			1:配置dataSource
			2:配置hibernate的其他相关配置，直接在classpath下面创建一个hibernate.properties文件，里面加上show_sql,dailect,hbm2ddl.auto等相关配置（spring会自动的加载和读入）
		3:配置映射文件：使用的是扫描hbm.xml文件所在的文件夹路径来引入的（mappingDirectoryLocations,这个配置后面的内容可以使用classpath：前缀，注意是文件路径）
	4：完成DAO
		1:直接在dao中注入一个SessionFactory
		2：在dao中直接使用SessionFactory.getCurrentSession（）来得到我们需要的session；因为session是在service层开启的，所以要得到当前线程的session
		3：千万不要开启事务，因为事务是配置在service层的
		4：不要关闭session
	5：在spring中配置DAO
7:写Service
	1：完成service接口和实现；
	2：在spring中配置servicebean
	3：配置事务
		1:配置transationManager,使用HibernateTransactionManager，并传入一个sessionFactory
		2：配置事务属性
		3：配置事务切面
8:集成Struts2
	1：拷贝相关内容（struts2.xml，struts2的jar包，web.xml）
	2:完成Action
	3：在spring中配置Action，注意，action的scope需要是prototype的
	4：完成struts的配置文件
		注意，在action的class属性，不能再写Action的类限定名，只能写这个Action在spring中配置的bean的id值
	5：导入spring-web.jar，struts2-spring-plugin.jar;
	6：在web.xml添加<listener class="ContextLoaderListener" />
	
	
	
	
	
	
	
	
	
	
	
	
