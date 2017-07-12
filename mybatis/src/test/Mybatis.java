package test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import entity.User;

public class Mybatis {
	// ��ȡ��������
	static SqlSessionFactory factory;

	static {
		try {
			// ��ȡ�����ļ�
			InputStream in = Resources.getResourceAsStream("mybatis.xml");
			// ��ȡ��������
			factory = new SqlSessionFactoryBuilder().build(in);

		} catch (Exception e) {
			// TODO: handle exception
		}

	};

	// ���
	public static  void insert() {
		try {
			// �Ự
			SqlSession session = factory.openSession();
			User u = new User();
			u.setAccount("����");
			u.setPwd("123456");
			session.insert("dao.UserDao.addUser", u);

			session.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
     //��ѯ
	public static void query(){
		try
		{
			SqlSession session = factory.openSession();
			User user=session.selectOne("dao.UserDao.findUserById",7);			
			session.close();
			System.out.println("--�û���:"+user.getAccount());
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	public static void main(String[] args) {
         query();
	}

}









