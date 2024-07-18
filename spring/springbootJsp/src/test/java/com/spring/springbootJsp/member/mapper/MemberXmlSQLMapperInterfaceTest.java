package com.spring.springbootJsp.member.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.spring.springbootJsp.member.vo.MemberVO;

import lombok.extern.log4j.Log4j2;

//test시 Transaction은 자동으로 rollback하므로 commit어노테이션을 적용
@Commit  // 커밋 적용  // test에서는 커밋이 자동 적용이 안되있어서 원할 시 해줘야함.

@SpringBootTest  // spring에서 태스트
@Log4j2
class MemberXmlSQLMapperInterfaceTest {
	
	@Autowired
	private MemberXmlSQLMapperInterface memberMapperXml;	
	
//	@Test
//	@DisplayName("회원등록 테스트")
//	@Transactional
//	void testInsertMember() {
//		log.info("java interface mapper와 xml db처리와 연결하는 테스트");
//		
//		try {
//			for(int i=1; i<10; i++) {
//				
//				MemberVO vo = MemberVO.builder()
//						.id("t"+i).pwd("987"+i).email("test"+i+"@gmail.com")
//						.name("길동홍"+i)
//						.build();
//				
//				memberMapperXml.insertMember(vo);
//
//			}
//		} catch (Exception e) {log.info(e.getMessage());
//		}
//	}

	//@RepeatedTes어노테이션: db처리 여러번 반복 처리할 경우 적용 for대신 사용
	@RepeatedTest(value=1024, name="{DisplayName}{currentRepetition}/{totalRepetition}")
	@Test
	@DisplayName("회원등록 테스트")
	@Transactional
	void testInsertMember(RepetitionInfo repetitionInfo) {
		log.info("java interface mapper와 xml db처리와 연결하는 테스트");
		
		int i = repetitionInfo.getCurrentRepetition();
		try {
//			for(int i=1; i<10; i++) {
				
				MemberVO vo = MemberVO.builder()
						.id("t"+i).pwd("987"+i).email("test"+i+"@gmail.com")
						.name("길동홍"+i)
						.build();
				
				memberMapperXml.insertMember(vo);

//			}
		} catch (Exception e) {log.info(e.getMessage());
		}
	}

}
