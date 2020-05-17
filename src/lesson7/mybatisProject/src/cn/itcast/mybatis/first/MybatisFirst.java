package cn.itcast.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.mybatis.po.User;

/**
 *
 * <p>
 * Title: MybatisFirst
 * </p>
 * <p>
 * </p>
 *
 * @version 1.0
 */
public class MybatisFirst {

	// 根据id查询用户信息，得到一条记录结果
	@Test
	public void findUserByIdTest() throws IOException {

		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);

		// 通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 通过SqlSession操作数据库
		// 第一个参数：映射文件中statement的id，等于=namespace+"."+statement的id
		// 第二个参数：指定和映射文件中所匹配的parameterType类型的参数
		// sqlSession.selectOne结果 是与映射文件中所匹配的resultType类型的对象
		// selectOne查询出一条记录
		User user = sqlSession.selectOne("test.findUserById", 1);

		System.out.println(user);

		// 释放资源
		sqlSession.close();

	}

	// 根据用户名称模糊查询用户列表
	@Test
	public void findUserByNameTest() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);

		// 通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// list中的user和映射文件中resultType所指定的类型一致
		List<User> list = sqlSession.selectOne("test.findUserByName", "wang feng");
		System.out.println(list);
		sqlSession.close();

	}

	// 添加用户信息
	@Test
	public void insertUserTest() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);

		// 通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 插入用户对象
		User user = new User();
		user.setUsername("test111");
		user.setPassword("123456789");
		user.setSex("0");
		user.setAddress("bei jing");
		user.setAge(30);

		sqlSession.insert("test.insertUser", user);

		// 提交事务
		sqlSession.commit();

		// 获取用户信息主键
		System.out.println(user.getUser_id());
		// 关闭会话
		sqlSession.close();

	}

	// 根据id删除 用户信息
	@Test
	public void deleteUserTest() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);

		// 通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 传入id删除 用户
		sqlSession.delete("test.deleteUser", 11);

		// 提交事务
		sqlSession.commit();

		// 关闭会话
		sqlSession.close();

	}

	// 更新用户信息
	@Test
	public void updateUserTest() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);

		// 通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 更新用户信息

		User user = new User();
		//必须设置id
		user.setUser_id(12);
		user.setUsername("test222");
		user.setPassword("123456789");
		user.setSex("1");
		user.setAddress("dalian");

		sqlSession.update("test.updateUser", user);

		// 提交事务
		sqlSession.commit();

		// 关闭会话
		sqlSession.close();

	}

}
