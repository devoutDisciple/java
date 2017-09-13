1.为类型添加别名
	<typeAliases>
		<typeAlias type="com.xmg.mybatis.domain.User" alias="User" />
	</typeAliases>
2.把数据库配置文件移动到db.properties中
	1：在创建SqlSessionFactory的时候传入Properties
		Properties properties = new Properties();
		properties.load(Resources.getResourceAsStream("db.properties"));
		//启动框架
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"),properties);
	2：可以在properties元素中引入外部的properties文件
		<!-- 加载配置文件 -->
		<properties resource="db.properties"/>
3:mapper的使用
	1：创建一个Mapper接口，保证接口的全限定名等于mapper.xml中的namespace；
	2：位mapper.xml中每一个sql元素创建相应的方法，保证：
		1：方法名等于元素id属性
		2：方法的参数等于元素的parameterType；
		3：方法的返回值等于元素的resultType；
	3：通过session.getMapper(Class<?>mapperType)得到动态代理出来的Mapper的实例对象
	4：调用对象上对应的接口方法完成CRUD
	5：原理:使用JDK的动态代理
	6:	使用第一种方式（引入id的方式），应用必须要有字的DAO实现，mybatis仅仅只是作为实现DAO的工具
		使用第二中方式可以直接把Mapper作为DAO，系统中不需要额外的DAO
		
4：mapper的参数
	1:在sqlsession中的insert/delete/update...等方法，都只能传入一个参数
	2：在默认情况下SQL标签中的#{}的查询方式
		1：首先在传入的参数的属性中查询
		2：如果查询不到，尝试直接使用传入的参数
		3：配合mapper使用，一般不用谢parameterType属性
		4:如果要传入多个参数，可以把多个参数封装到一个对象或者封装到一个Map中，这个对象或者这个Map作为我参数的root的对象
		5：也可以直接在mapper中写多个参数，但是每个参数需要使用@param注解来起名字
			原理：把@param的值作为key，把参数的值作为value，把多个参数重新包装成Map
5:many2one/one2many;many2many
	1:many2one
		1:在many方保存对象的时候，sql自己去处理关联对象的主键的保存
		2：一定记住，保存的时候先保存one方，在保存many方
		3:映射方法
			<!-- 
			association:代表一个关系（mybatis中使用association去映射一个对象）
			1：property：在对象中这个关系的属性
			2：column：在数据库中那个列反应这个关系
			3：javaType：关联的对象是什么类型
			4：select：使用哪个SQL去查询关联的对象
		 -->
		<association property="dept" column="dept_id" javaType="Department" select="com.xmg.mybatis.day2.mapper.DepartmentMapper.get"></association>
		4：延迟加载
			1：默认情况下，是没有延迟加载的
			2：在mybatis中配置
				<settings>
					<!-- 全局启用或禁用延迟加载。当禁用时, 所有关联对象都会即时加载。 -->
					<setting name="lazyLoadingEnabled" value="true"/>
					
					<!-- 当启用时, 有延迟加载属性的对象在被调用时将会完全加载任意属性。否则, 每种属性将会按需要加载。 -->
					<setting name="aggressiveLazyLoading" value="false"/>
					
					<!-- Object对象上面的哪些方法触发延迟加载。 -->
					<setting name="lazyLoadTriggerMethods" value="clone"/>
				</settings>
6:在sqlsession中一定有一个一级缓存
	一级缓存的生命周期是在sqlsession上
	在mybatis中，如果需要处理大量的数据，分页，及时清楚一级缓存中的数据来毕淼内存溢出
	在sqlsession中，仅仅只是提供了一个clearCache（）方法来清除一级缓存中的所有数据

7:mybatis的二级缓存
	1：默认情况下，mybatis的二级缓存是开启的，但是没有使用
	2：在对象的mapper文件中直接开启<cache />,就可以为这个对象开启二级缓存（注意一下，在mybatis中，一般直接说缓存就是二级缓存）
	3：在对象中开启了cache这个对象的所有的select都享受到了缓存的待遇，在mybatis中根本不会区分二级缓存和查询缓存
	4：需要使用缓存的对象必须实现序列化接口
	5：现象
		get一个对象，然后插入一个对象，然后在get一个对象，两个select
		对数据表的改变导致这个表关联对象的查询缓存全部失效
	6：缓存的控制
		1：可以通过select元素的useCache=false来关闭某一个查询不需要使用缓存；一般会把执行查询的缓存关闭，只保留get方法的查询缓存
		2：可以修改insert元素的flushCache=false来关闭insert语句对查询缓存的刷新
	7:使用第三方的二级缓存
		1:拷贝ehcache相关包（ehcache以及mybatis-ehcache）
		2：在对象上配置
			<cache type="ehcache" />
			注意，这里的ehcache是<typeAlias type="prg.mybatis.caches.ehcache.EHcacheCache" alias="ehcache"/>
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		