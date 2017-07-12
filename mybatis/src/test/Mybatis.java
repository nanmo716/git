package test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import entity.User;

public class Mybatis {
	// 获取工厂对象
	static SqlSessionFactory factory;

	static {
		try {
			// 读取配置文件
			InputStream in = Resources.getResourceAsStream("mybatis.xml");
			// 获取工厂对象
			factory = new SqlSessionFactoryBuilder().build(in);

		} catch (Exception e) {
			// TODO: handle exception
		}

	};

	// 添加
	public static  void insert() {
		try {
			// 会话
			SqlSession session = factory.openSession();
			User u = new User();
			u.setAccount("张三");
			u.setPwd("123456");
			session.insert("dao.UserDao.addUser", u);

			session.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
     //查询
	public static void query(){
		try
		{
			SqlSession session = factory.openSession();
			User user=session.selectOne("dao.UserDao.findUserById",7);			
			session.close();
			System.out.println("--用户是:"+user.getAccount());
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	public static void main(String[] args) {
         query();
	}

}









