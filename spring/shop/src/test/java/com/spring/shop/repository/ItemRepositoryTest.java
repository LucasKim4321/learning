package com.spring.shop.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.shop.constant.ItemSellStatus;
import com.spring.shop.entity.Item;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
//@TestPropertySource(locations="classpath:application-test.properties")  // 환경설정파일 따로 지정
@Log4j2
public class ItemRepositoryTest {
	
	@Autowired
	ItemRepository itemRepository;
	
	@Test
	@DisplayName("상품 저장 repository 테스트")
	public void createItemTest() {
		Item item = Item.builder()
				.itemNm("테스트 상품")
				.price(10000)
				.itemDetail("테스트 상품 상세 설명")
				.itemSellStatus(ItemSellStatus.SELL)
				.regTime(LocalDate.now())
				.updateTime(LocalDateTime.now())
				.build();
		
		// 엔티티를 영속성 컨텍스트를 통해 DB작업 처리
		// 비영속성 -> 영속성 상태 관리
		Item saveItem = itemRepository.save(item);
		
		log.info("저장된 후 반환된 값: "+saveItem);
		
		
	}
	
	// 상품 등록
	public void createItemList() {
		IntStream.rangeClosed(1, 10).forEach(num -> {
			Item item = Item.builder()
					.itemNm("테스트 상품"+num)
					.price(10000+num)
					.itemDetail("테스트 상품 상세 설명"+num)
					.itemSellStatus(ItemSellStatus.SELL)
					.stockNumber(100)
					.regTime(LocalDate.now())
					.updateTime(LocalDateTime.now())
					.build();
			
			log.info("=> 저장하기전: 비영속성");
			
			Item saveItem = itemRepository.save(item);
			log.info("상품등록"+saveItem);
		});
	}
	
	// 상품 조회
	@Test
	@DisplayName("상품명 조회 테스트")
	public void findByItemnmTest() {
		this.createItemList();

		log.info("조회");
		List<Item> itemList = itemRepository.findByItemNm("테스트 상품10");
		log.info("=> 조회 후: "+itemList);
	}
	
}
