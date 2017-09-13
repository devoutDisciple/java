1.Ϊ������ӱ���
	<typeAliases>
		<typeAlias type="com.xmg.mybatis.domain.User" alias="User" />
	</typeAliases>
2.�����ݿ������ļ��ƶ���db.properties��
	1���ڴ���SqlSessionFactory��ʱ����Properties
		Properties properties = new Properties();
		properties.load(Resources.getResourceAsStream("db.properties"));
		//�������
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"),properties);
	2��������propertiesԪ���������ⲿ��properties�ļ�
		<!-- ���������ļ� -->
		<properties resource="db.properties"/>
3:mapper��ʹ��
	1������һ��Mapper�ӿڣ���֤�ӿڵ�ȫ�޶�������mapper.xml�е�namespace��
	2��λmapper.xml��ÿһ��sqlԪ�ش�����Ӧ�ķ�������֤��
		1������������Ԫ��id����
		2�������Ĳ�������Ԫ�ص�parameterType��
		3�������ķ���ֵ����Ԫ�ص�resultType��
	3��ͨ��session.getMapper(Class<?>mapperType)�õ���̬���������Mapper��ʵ������
	4�����ö����϶�Ӧ�Ľӿڷ������CRUD
	5��ԭ��:ʹ��JDK�Ķ�̬����
	6:	ʹ�õ�һ�ַ�ʽ������id�ķ�ʽ����Ӧ�ñ���Ҫ���ֵ�DAOʵ�֣�mybatis����ֻ����Ϊʵ��DAO�Ĺ���
		ʹ�õڶ��з�ʽ����ֱ�Ӱ�Mapper��ΪDAO��ϵͳ�в���Ҫ�����DAO
		
4��mapper�Ĳ���
	1:��sqlsession�е�insert/delete/update...�ȷ�������ֻ�ܴ���һ������
	2����Ĭ�������SQL��ǩ�е�#{}�Ĳ�ѯ��ʽ
		1�������ڴ���Ĳ����������в�ѯ
		2�������ѯ����������ֱ��ʹ�ô���Ĳ���
		3�����mapperʹ�ã�һ�㲻��лparameterType����
		4:���Ҫ���������������԰Ѷ��������װ��һ��������߷�װ��һ��Map�У��������������Map��Ϊ�Ҳ�����root�Ķ���
		5��Ҳ����ֱ����mapper��д�������������ÿ��������Ҫʹ��@paramע����������
			ԭ����@param��ֵ��Ϊkey���Ѳ�����ֵ��Ϊvalue���Ѷ���������°�װ��Map
5:many2one/one2many;many2many
	1:many2one
		1:��many����������ʱ��sql�Լ�ȥ�����������������ı���
		2��һ����ס�������ʱ���ȱ���one�����ڱ���many��
		3:ӳ�䷽��
			<!-- 
			association:����һ����ϵ��mybatis��ʹ��associationȥӳ��һ������
			1��property���ڶ����������ϵ������
			2��column�������ݿ����Ǹ��з�Ӧ�����ϵ
			3��javaType�������Ķ�����ʲô����
			4��select��ʹ���ĸ�SQLȥ��ѯ�����Ķ���
		 -->
		<association property="dept" column="dept_id" javaType="Department" select="com.xmg.mybatis.day2.mapper.DepartmentMapper.get"></association>
		4���ӳټ���
			1��Ĭ������£���û���ӳټ��ص�
			2����mybatis������
				<settings>
					<!-- ȫ�����û�����ӳټ��ء�������ʱ, ���й������󶼻ἴʱ���ء� -->
					<setting name="lazyLoadingEnabled" value="true"/>
					
					<!-- ������ʱ, ���ӳټ������ԵĶ����ڱ�����ʱ������ȫ�����������ԡ�����, ÿ�����Խ��ᰴ��Ҫ���ء� -->
					<setting name="aggressiveLazyLoading" value="false"/>
					
					<!-- Object�����������Щ���������ӳټ��ء� -->
					<setting name="lazyLoadTriggerMethods" value="clone"/>
				</settings>
6:��sqlsession��һ����һ��һ������
	һ�������������������sqlsession��
	��mybatis�У������Ҫ������������ݣ���ҳ����ʱ���һ�������е�����������ڴ����
	��sqlsession�У�����ֻ���ṩ��һ��clearCache�������������һ�������е���������

7:mybatis�Ķ�������
	1��Ĭ������£�mybatis�Ķ��������ǿ����ģ�����û��ʹ��
	2���ڶ����mapper�ļ���ֱ�ӿ���<cache />,�Ϳ���Ϊ����������������棨ע��һ�£���mybatis�У�һ��ֱ��˵������Ƕ������棩
	3���ڶ����п�����cache�����������е�select�����ܵ��˻���Ĵ�������mybatis�и����������ֶ�������Ͳ�ѯ����
	4����Ҫʹ�û���Ķ������ʵ�����л��ӿ�
	5������
		getһ������Ȼ�����һ������Ȼ����getһ����������select
		�����ݱ�ĸı䵼��������������Ĳ�ѯ����ȫ��ʧЧ
	6������Ŀ���
		1������ͨ��selectԪ�ص�useCache=false���ر�ĳһ����ѯ����Ҫʹ�û��棻һ����ִ�в�ѯ�Ļ���رգ�ֻ����get�����Ĳ�ѯ����
		2�������޸�insertԪ�ص�flushCache=false���ر�insert���Բ�ѯ�����ˢ��
	7:ʹ�õ������Ķ�������
		1:����ehcache��ذ���ehcache�Լ�mybatis-ehcache��
		2���ڶ���������
			<cache type="ehcache" />
			ע�⣬�����ehcache��<typeAlias type="prg.mybatis.caches.ehcache.EHcacheCache" alias="ehcache"/>
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		