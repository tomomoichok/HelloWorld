package cn.itcast.mybatis.mapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.po.User;
import cn.itcast.mybatis.po.UserCustom;
import cn.itcast.mybatis.po.UserQueryVo;

public class UserMapperTest {

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

	//用户信息的综合 查询
	@Test
	public void testFindUserList() throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();

		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		//创建包装对象，设置查询条件
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("0");
		//由于这里使用动态sql，如果不设置某个值，条件不会拼接在sql中
//		userCustom.setSex("1");
		//userCustom.setUsername("dddd");
		//传入多个id
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(4);
		ids.add(5);
		ids.add(17);
		//将ids通过userQueryVo传入statement中
		userQueryVo.setIds(ids);
		userQueryVo.setUserCustom(userCustom);
		//调用userMapper的方法

		List<UserCustom> list = userMapper.findUserList(userQueryVo);

		System.out.println(list);


	}

	@Test
	public void testFindUserCount() throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();

		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		//创建包装对象，设置查询条件
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("1");
		userCustom.setUsername("admin");
		userQueryVo.setUserCustom(userCustom);
		//调用userMapper的方法

		int count = userMapper.findUserCount(userQueryVo);

		System.out.println(count);


	}

	@Test
	public void testFindUserById() throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();

		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		//调用userMapper的方法

		User user = userMapper.findUserById(1);

		System.out.println(user);


	}

	@Test
	public void testFindUserByIdResultMap() throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();

		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		//调用userMapper的方法

		User user = userMapper.findUserByIdResultMap(1);

		System.out.println(user);


	}

	@Test
	public void testFindUserByName() throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();

		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		//调用userMapper的方法

		List<User> list = userMapper.findUserByName("小明");

		sqlSession.close();

		System.out.println(list);


	}



	@Test
	public void testInsertUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setUsername("GGGGG");
		user.setPassword("0000000");
		user.setSex("1");
		user.setAddress("ri ben");
		user.setAge(10);
		userMapper.insertUser(user);
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testDeleteUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.deleteUser(22);
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testUpdateUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUser_id(18);
        user.setUsername("updateName");
        user.setAge(18);
        user.setSex("0");
        user.setAddress("da lian");
        user.setPassword("123456789");
        userMapper.updateUser(user);
		sqlSession.commit();
		sqlSession.close();
	}

}
