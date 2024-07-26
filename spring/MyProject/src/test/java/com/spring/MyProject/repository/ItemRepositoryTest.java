package com.spring.MyProject.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.spring.MyProject.constant.ItemSellStatus;
import com.spring.MyProject.entity.Item;
import com.spring.MyProject.entity.QItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.TestPropertySource;
import org.thymeleaf.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
//@TestPropertySource(locations="classpath:application-test.properties")  // 환경설정파일 따로 지정
class ItemRepositoryTest {
    /* H2 기본 속성 이랑 mariadb 사용 할 때 create 설정했을 때랑 비슷한듯
    spring.jpa.hibernate.ddl-auto=create */


    @Autowired
    private ItemRepository itemRepository;

    @PersistenceContext
    EntityManager em;

    @Test
    @DisplayName("상품명 등록 테스트")
    public void insertItemTest() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            Item item = Item.builder()
                    .itemNm("테스트 상품" + i)
                    .price(10000 + i)
                    .itemDetail("테스트 상품 상세 설명" + i)
                    .itemSellStatus(ItemSellStatus.SELL)
                    .stockNumber(100)
                    .regTime(LocalDate.now())
                    .updateTime(LocalDateTime.now())
                    .build();
            Item savedItem = itemRepository.save(item);  // 저장 후 저장된 값 리턴
        });

    }

    @Test
    @DisplayName("상품명 조회 테스트")
    public void findByItemNmTest() {

        // 상품 등록 현재 메서드만 실행시(테스트 전체를 수행하면 필요없음)
        this.insertItemTest();

        // 상품 조회
        List<Item> itemList = itemRepository.findByItemNm("테스트 상품1");  // 검색할 때 엔티티에 선언된 테이블 상의 이름을 기준으로 검색

        // stream().forEach()이용해서 결과 로그 출력
        itemList.stream().forEach(item -> {
            log.info("==> item: " + item);
        });
    }

    @Test
    @DisplayName("상품명과 상품상세설명 동시(OR) 조회 테스트")
    public void findByItemNmOrItemDetailTest() {

        // 상품 등록 현재 메서드만 실행시(테스트 전체를 수행하면 필요없음)
        this.insertItemTest();

        // 상품 조회
        List<Item> itemList = itemRepository.findByItemNmOrItemDetail("테스트 상품1", "테스트 상품 상세 설명5");

        // 확장for를 이용해서 결과 로그 출력
        for (Item item : itemList) {
            log.info("==> item: " + item);
        }
    }


    @Test
    @DisplayName("해당 가격보다 적은(LessThen) 테스트")
    public void findByPriceLessThenTest() {

        // 상품 등록 현재 메서드만 실행시(테스트 전체를 수행하면 필요없음)
        this.insertItemTest();

        // 상품 조회
        List<Item> itemList = itemRepository.findByPriceLessThan(10005);  // 10005보다 적은 가격을 찾음

        // 결과 로그 출력
        itemList.stream().forEach(item -> {
            log.info("==> Less Than: " + item);
        });
    }

    @Test
    @DisplayName("가격 내림차순 and LessThan 테스트 ")
    public void findPriceLessThanOrderByPriceDescTest() {

        // 상품 등록 현재 메서드만 실행시(테스트 전체를 수행하면 필요없음)
        this.insertItemTest();

        // 상품 조회
        List<Item> itemList = itemRepository.findByPriceLessThanOrderByPriceDesc(10005);  // 10005보다 적은 가격을 찾음

        itemList.stream().forEach(item -> log.info("==> Price Less Than Order Desc: " + item));

    }

    // ------------------------------------- //
    // Spring DATA JPA @Query 어노테이션 테스트
    // ------------------------------------- //

    @Test
    @DisplayName("상품명, 상품상세설명 or 테스트")
    public void findByItemDetailTest() {
        // 상품 등록 현재 메서드만 실행시(테스트 전체를 수행하면 필요없음 or MariaDB에서 테이블 데이터 생성 후 update로 설정하면 필요없음)
        this.insertItemTest();

        List<Item> itemList = itemRepository.findByItemDetail("테스트 상품 상세 설명5");
        itemList.stream().forEach(item-> {
            log.info("==> item list: "+item);
        });
    }

    @Test
    @DisplayName("상품명, 상품상세설명 or 테스트")
    public void findByItemDetailByNativeTest() {
        // 상품 등록 현재 메서드만 실행시(테스트 전체를 수행하면 필요없음 or MariaDB에서 테이블 데이터 생성 후 update로 설정하면 필요없음)
        this.insertItemTest();

        List<Item> itemList = itemRepository.findByItemDetailByNative("테스트 상품 상세 설명");
        itemList.stream().forEach(item-> {
            log.info("==> item list: "+item);
        });
    }

    // ------------------------------------- //
    // Spring Q도메인 클래스 적용
    // ------------------------------------- //

    @Test
    @DisplayName("QueryDSL을 적용해서 조회 기능 테스트")
    public void queryDSLTest() {
        // 5. JPA queryDSL error => "Attempt to recreate a file" 도메인 중복 발생
        // IntelliJ -> Gradle 변환 or
        // Gradle -> IntelliJ 변환

        // 상품 등록 현재 메서드만 실행시(테스트 전체를 수행하면 필요없음 or MariaDB에서 테이블 데이터 생성 후 update로 설정하면 필요없음)
        this.insertItemTest();

        // 위에 선언함
        // @PersistenceContext
        // EntityManager em;
        
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QItem qItem = QItem.item;

        // 동적 query문 작성
        JPAQuery<Item> query = queryFactory
                .selectFrom(qItem)
                .where(qItem.itemSellStatus.eq(ItemSellStatus.SELL))
                .where(qItem.itemDetail.like("%"+"상품 상세 설명"+"%"))
                .orderBy(qItem.price.desc());

        // 1. List<T> fetch() => query문 실행 (조회한 결과를 반환를 List로 반환)
        List<Item> itemList = query.fetch();
        log.info("==> item list: .fetch() 메서드 결과");
        itemList.stream().forEach( item-> log.info("=> Qitem: " +item.getId()+", "+item.getItemDetail()));

        // fetchFirst() 하나만 반환
        Item itemOne = query.fetchFirst();
        log.info("==> itemOne: .fetchFirst() 메서드 결과");
        log.info("==> Qitem: " +itemOne.getId()+", "+itemOne.getItemDetail());

        // fetchCount() 검색된 값 카운트
        Long total = query.fetchCount();
        log.info("==> total: .fetchCount() 메서드 결과");
        log.info("==> total: " +total);

        // fetchSize() 검색 할 때 카운트
        int total2 = queryFactory
                .selectFrom(qItem)
                .where(qItem.itemSellStatus.eq(ItemSellStatus.SELL))
                .where(qItem.itemDetail.like("%"+"상품 상세 설명"+"%"))
                .orderBy(qItem.price.desc())
                .fetch().size();
        log.info("==> 2: .fetchSize() 메서드 결과");
        log.info("==> total2: " +total2);

        // 단일 결과 처리  select * from qItem where id=5
        JPAQuery<Item> query2 = queryFactory.selectFrom(qItem).where(qItem.id.eq(5L));  // eq(equal) : 같은
        Item itemOne2 = query2.fetchOne();
        log.info("==> .fetchOne() 조회결과: ");
        log.info("==> id: "+itemOne2.getId()+", 아이템이름: "+itemOne2.getItemNm());

    }

    // ------------------------------------- //
    // Spring Q도메인 클래스 적용 : QuerydslPredicateExecutor 테스트
    // ------------------------------------- //

    @Test
    @DisplayName("QueryDSL: 조회기능 테스트2")
    public void queryDSLTest2() {
        // 상품 등록 현재 메서드만 실행시(테스트 전체를 수행하면 필요없음 or MariaDB에서 테이블 데이터 생성 후 update로 설정하면 필요없음)
        this.insertItemTest();

        BooleanBuilder booleanBuilder = new BooleanBuilder(); // dsl 조건식 담당
        QItem item = QItem.item;

        // 조건을 검색 할 대상의 초기값을 설정
        String itemDetail = "테스트 상품 상세 설명";
        int price = 10003;
        String searchItemState = "SELL";

        // query에 필요한 조건 설정
        booleanBuilder.and(item.itemDetail.like("%"+itemDetail+"%"));
        booleanBuilder.and(item.price.gt(price));  // gt(greater) : 보다 큰

        // 판매 상태에 대한 검색 키워드가 있으면 판매 상태 조건문 추가
        if(StringUtils.equals(searchItemState, ItemSellStatus.SELL)) {  // StringUtils thymeleaf에 있는 기능 사용
            booleanBuilder.and(item.itemSellStatus.eq(ItemSellStatus.SELL));  // where ItemSellStatus = 'SELL';
        }

        // 페이징 처리 : Pageable과 Page<E>타입
        // Pageable타입의 객체를 구성해서 파라미터로 전달
        // Pageable은 인터페이스 타입, PageRequest.of()기능을 활용

        // Pageable pageable = PageRequest.of(0,5);  // (페이지번호, 페이지당 데이터 개수(page size))
        // Pageable pageable = PageRequest.of(0,5);  // (페이지번호, 페이지 사이즈, 정렬(sort))
        // Pageable pageable = PageRequest.of(0,5);  // (페이지번호, 페이지 사이즈, sort.direction, 속성...) 정렬 타입과 여러 속성 지정

        // 페이징 객체 생성 및 설정
        // 페이징 기능이 있는 결과 값 타입은 Page<T>
        Pageable pageable = PageRequest.of(0,5);
        // booleanBuilder조건 itemDetail에 "테스트 상품 상세 설명" 포함하고 가격이 10003보다 큰값 중에 순서대로 5개 표시
        Page<Item> itemPagingResult = itemRepository.findAll(booleanBuilder, pageable);
        // int number => number
        // Optional<int> number =>  number.get()와 유사 방식
        // Page => .content()메서드를 사용하여 데이터 읽어오기
        List<Item> itemList = itemPagingResult.getContent();
        log.info("==> Paging Result");
        itemList.forEach(item_data-> log.info("==> Paging item data: "+item_data));

        // 페이징 관련 메서드
        log.info("------------");
        log.info("==> 전체 데이터 수 .getTotalElements(): "+itemPagingResult.getTotalElements());
        log.info("==> 전체 페이지 수 .getTotalPages(): "+itemPagingResult.getTotalPages());
        log.info("==> 현재 페이지 .getNumber(): "+itemPagingResult.getNumber());
        log.info("==> 페이지 크기 .getSize(): "+itemPagingResult.getSize());
        log.info("==> 다음 페이지 여부 .hasNext(): "+itemPagingResult.hasNext());
        log.info("==> 이전 페이지 여부 .hasPrevious(): "+itemPagingResult.hasPrevious());


    }
}

/*
 * 페이징 관련 메서드(JPA의 Page Interface Method)
 *
 * 메서드		                                    설명		                                    반환 타입
 * getContent()	                                    현재 페이지에 있는 데이터 리스트를 반환	        List<T>
 * getNumber()	                                    현재 페이지 번호를 반환	                        int
 * getSize()	                                    페이지 크기를 반환	                            int
 * getTotalPages()	                                전체 페이지 수를 반환	                        int
 * getTotalElements()	                            전체 데이터 수를 반환	                        long
 * hasNext()	                                    다음 페이지가 있는지 여부를 반환	                boolean
 * hasPrevious()	                                이전 페이지가 있는지 여부를 반환	                boolean
 * isFirst()	                                    첫 번째 페이지인지 여부를 반환	                boolean
 * isLast()	                                        마지막 페이지인지 여부를 반환	                boolean
 * getNumberOfElements()	                        현재 페이지에 포함된 요소의 개수를 반환	        int
 * getPageable()	                                페이지에 대한 메타데이터를 반환	                Pageable
 * getSort()	                                    페이지의 정렬 정보를 반환	                    Sort
 * isEmpty()	                                    페이지가 비어 있는지 여부를 반환	                boolean
 * iterator()	                                    페이지의 요소를 반복할 수 있는 iterator를 반환	Iterator<T>
 * subList(int fromIndex, int toIndex)	            페이지의 특정 범위의 요소를 리스트로 반환	        List<T>
 * stream()	                                        페이지의 요소를 스트림으로 반환	                Stream<T>
 * map(Function<? super T,? extends R> converter)	페이지의 요소를 변환하여 새로운 페이지로 반환	    Page<R>
 * nextPageable()	                                다음 페이지의 Pageable을 반환	                Pageable
 * previousPageable()	                            이전 페이지의 Pageable을 반환	                Pageable
 *
 */


/*
 * JPAQuery 데이터 변환 메서드
 * List<T> fetch() : 조회한 결과를 List로 반환
 * T fetchOne() : 조회 대상이 1건인 경우 제네릭으로 지정한 타입 반환
 * T fetchFirst() : 조회 대상 중 1건만 반환
 * Long fetchCount() : 조회 대상 개수 반환
 *  =>  fetchCount() 메서드 대신 : .fetch().size() 형식으로  변경
 * QueryResult<T> fetchResults() : 조회한 리스트와 전체 개수를 포함한 QueryResult반환
 * 
 * QuerydslPredicateExecutor 적용하여 상품 조회 기능 구현
 * Predicate : 조건이 맞는지 판별
 * Repository에서는 Predicate를 파라미터로 전달하가 위해 QuerydslPredicateExecutor 인터페이스를 상속
 *
 */

