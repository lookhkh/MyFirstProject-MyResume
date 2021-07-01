package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.member.domain.RefBoardReply;
import com.example.demo.member.repository.RefBoardRepository;

@SpringBootTest
public class replyTest {

	@Autowired
	RefBoardRepository service;

	
	@Test
	public void test() {
		
		RefBoardReply vo = new RefBoardReply();
		vo.setBno(144L);
		vo.setWriter("funcyouououo");
		vo.setContent("ㅋㅋㅋ");
		vo.setRoot(1L);
		
		
		System.out.println(vo.toString());
		
		service.insertReplyWithRoot(vo);
		System.out.println("루트 존재");

		List<RefBoardReply> dto = service.getReply(144L);
		
		dto.forEach((a)->System.out.println(a.toString()));
		

		/*	<insert id="insertReply">	
		insert into reply(bno, rno, writer, content, registerdate<if test="root!=null">rootreply</if>) values(#{bno},#{rno},#{writer},#{content},sysdate<if test="root!=null">#{root}</if>)
		</insert>
		
		<select id="getReply" resultType="com.example.demo.member.domain.RefBoardReply">
			select * from reply where bno=#{bno}
		</select>
		 * */
	
	
	}
}
