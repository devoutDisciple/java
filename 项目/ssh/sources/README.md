#����
struts2.3.x
spring4.0.0
hibernate4.2

˼·���������ϼ��ɣ������֮��û�й�ϵ���ڼ��ɵ�ʱ��ֻ��ע��ǰ���ɵ��Ǹ��������

1������һ���յ�web��Ŀ
2��������Ŀ����
3�����domain
4�����ӳ���ļ�
5��дDAO
6:дDAOʵ��
	1��������hibernate/required,���ݿ�������springcore/test/bean/context��
	2:spring�����ļ�
		1������dataSource��
		2�����db.properties�ļ�
		3������db.properties�ļ�
	3������sessionFactory
		1������spring jdbc/tx/orm
		2:ʹ��LocalSessionFactoryBean������SessionFactory
			1:����dataSource
			2:����hibernate������������ã�ֱ����classpath���洴��һ��hibernate.properties�ļ����������show_sql,dailect,hbm2ddl.auto��������ã�spring���Զ��ļ��غͶ��룩
		3:����ӳ���ļ���ʹ�õ���ɨ��hbm.xml�ļ����ڵ��ļ���·��������ģ�mappingDirectoryLocations,������ú�������ݿ���ʹ��classpath��ǰ׺��ע�����ļ�·����
	4�����DAO
		1:ֱ����dao��ע��һ��SessionFactory
		2����dao��ֱ��ʹ��SessionFactory.getCurrentSession�������õ�������Ҫ��session����Ϊsession����service�㿪���ģ�����Ҫ�õ���ǰ�̵߳�session
		3��ǧ��Ҫ����������Ϊ������������service���
		4����Ҫ�ر�session
	5����spring������DAO
7:дService
	1�����service�ӿں�ʵ�֣�
	2����spring������servicebean
	3����������
		1:����transationManager,ʹ��HibernateTransactionManager��������һ��sessionFactory
		2��������������
		3��������������
8:����Struts2
	1������������ݣ�struts2.xml��struts2��jar����web.xml��
	2:���Action
	3����spring������Action��ע�⣬action��scope��Ҫ��prototype��
	4�����struts�������ļ�
		ע�⣬��action��class���ԣ�������дAction�����޶�����ֻ��д���Action��spring�����õ�bean��idֵ
	5������spring-web.jar��struts2-spring-plugin.jar;
	6����web.xml���<listener class="ContextLoaderListener" />
	
	
	
	
	
	
	
	
	
	
	
	
