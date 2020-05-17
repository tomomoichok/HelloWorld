package cn.itcast.mybatis.po;

/**
 *
 * <p>Title: User</p>
 * <p>Description:用户po </p>
 * @version 1.0
 */
public class User {

	//属性名和数据库表的字段对应
	private int user_id;
	private String username;// 用户姓名
	private String sex;// 性别
	private String password;// 密码
	private String address;// 地址
	private int age;

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", sex=" + sex
				+ ", password=" + password + ", address=" + address + "]";
	}


}
