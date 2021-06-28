package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.mapper.MemberMapper;
import com.example.demo.member.domain.MemberAuthorization;
import com.example.demo.member.domain.MemberSignUpDTO;
import com.example.demo.member.domain.SavedMemberDTO;

@SpringBootTest
public class MapperFirstTest {
	
	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	MemberMapper mapper;
	
	@Autowired
	DataSource datasource;
	
	
	@Autowired
	SqlSessionFactory sql;
	
	
	
	static{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
	//spring.datasource.url=jdbc:oracle:thin:@localhost:1521/xe
		//	spring.datasource.username=book_ex
			//spring.datasource.password=book_ex
	
	
	@Test
	public void test() throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521/xe", "book_ex","book_ex");
		
		Assertions.assertNotNull(con);
		
		System.out.println(con);
	}
	
	@Test
	public void DataSOurcetest() throws SQLException {
		Connection con = datasource.getConnection();
		
		System.out.println(con);
		Assertions.assertNotNull(con);

	}
	
	@Test
	public void mybatisConnectionTest() throws SQLException {
		SqlSession session = sql.openSession();
		Connection con = session.getConnection();
		
		System.out.println(con);
		Assertions.assertNotNull(con);

	}
	

	
	@Test
	public void mybatisSaveTest() {
		SavedMemberDTO test = new SavedMemberDTO("tester123123123","lookhkh","lookhkh@naver.com",MemberAuthorization.MEMBER);
		mapper.save(test);
	}
	
	@Test
	public void mybatisCheckTheIdTest() {
		SavedMemberDTO tester = mapper.checkTheId("lookhkh");
		SavedMemberDTO falsetest = mapper.checkTheId("aaaaaaaa");
		
		Assertions.assertNull(falsetest);
		Assertions.assertNotNull(tester);

	}
	
	@Test
	public void mybatisGetuserDTO() {
		SavedMemberDTO tester = mapper.checkTheId("lookhkh");
		SavedMemberDTO falsetest = mapper.checkTheId("aaaaaaaaaa");
		
		log.info(tester.getUserName());
		
		Assertions.assertNull(falsetest);
		Assertions.assertNotNull(tester);


	}
	
	@Test
	public void mybatisChangeuserDTO() {
		SavedMemberDTO origin = mapper.checkTheId("lookhkh");
		MemberSignUpDTO temp = new MemberSignUpDTO("lookhkh","testfortest","testfortest","checktheinfo@check.com");
		
		log.info(origin.toString()+" ----------변경 전 정보");
		log.info(temp.toString()+"변경 후 정보 ------");
		
		
		mapper.editUserInfo(temp);
		
		SavedMemberDTO after = mapper.checkTheId("lookhkh");
		
		Assertions.assertEquals(temp.getPassWord(), after.getPassWord());


	}
	
}
