package cn.itcast.mybatis.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.po.User;

public class UserDaoImplTest {

	private SqlSessionFactory sqlSessionFactory;

	// 此方法是在执行testFindUserById之前执行
	@Before
	public void setUp() throws Exception {
		// 创建sqlSessionFactory

		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂，传入mybatis的配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
	}

	@Test
	public void testFindUserById() throws Exception {
		// 创建UserDao的对象
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);

		// 调用UserDao的方法
		User user = userDao.findUserById(5);

		System.out.println(user);
	}

	@Test
	public void testInsertUser() throws Exception {
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		User user = new User();
		user.setUsername("tttttt111");
		user.setPassword("0000000");
		user.setSex("1");
		user.setAddress("ri ben");
		user.setAge(10);
		userDao.insertUser(user);
	}

	@Test
	public void testDeleteUser() throws Exception {
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		userDao.deleteUser(16);
	}

	@Test
	public void testUpdateUser() throws Exception {
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = new User();
        user.setUser_id(15);
        user.setUsername("updateName");
        user.setAge(15);
        user.setSex("0");
        user.setAddress("da lian");
        user.setPassword("123456789");
		userDao.updateUser(user);
	}
}
