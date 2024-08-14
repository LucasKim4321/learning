package com.spring.MyProject.repository;

import com.spring.MyProject.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

// Item에 대한 JpaRepository
public interface ItemRepository extends JpaRepository<Item, Long>, QuerydslPredicateExecutor<Item> {  // JpaRepository<엔티티명, 엔티티의 기본키명>



    // 1. spring data jpa query 메서드
    // 형식: findBy엔티티필드명()
    // 상품명으로 조회
    List<Item> findByItemNm(String itemNm);

    // 상품명과 상품 상세 설명을 OR조건으로 조회
    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);
    
    // 상품 가격이 전달된 매개변수보다 값이 작은 상품 조회
    List<Item> findByPriceLessThan(Integer price);  // price < 매개변수값

    // 조건 조회 후 정렬
    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);


    // 2. spring data jpa @query어노테이션 => 파라미터이름 => %:매개변수%
    @Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);

    // 기존의 데이터베이스에 사용하던 쿼리문 그대로 사용시=> (쿼리문, nativeQuery속성)(ByNative) 필수
    @Query(value="select * from item i where i.item_detail like %:itemDetail% order by i.item_detail desc ", nativeQuery = true)
    List<Item> findByItemDetailByNative(@Param("itemDetail") String itemDetail);

}


/*
 * QuerydslPredicateExecutor 적용하여 상품 조회 기능 구현
 * Predicate : 조건이 맞는지 판별
 * Repository에서는 Predicate를 파라미터로 전달하가 위해 QuerydslPredicateExecutor 인터페이스를 상속
 */

/*
 * Querydsl 장점
 * - 고정된 SQL문이 아닌 조건에 맞게 동적 쿼리를 생성
 * - 비슷한 쿼리를 재사용, 제약 조건 조립 및 가독성 향상
 * - 문자열이 아닌 자바 소스코드로 작성하기 때문에 컴파일 시점에 오류생성
 * - IDE도움을 받아 자동 완성 기능 활용
 *
 */


/*
 * JpaRepository 지원하는 메서드 (기본적으로 들어있는 기능)
 * <S extends T> save(S entity) : 저장 및 수정
 * void delete(t entity) : 삭제
 * count() : 총 개수 반환
 * Iterable<T> findAll() : 모든 엔티티 조회
 *
 * find+(엔티티이름) +By + 변수(필드)명
 *
 *
 */

/* 
 * JpaRepository 기본 기능 (by ChatGPT)
 *
 * 메서드 이름	설명
 * save(S entity)	주어진 엔티티를 저장하거나 업데이트합니다.
 * saveAll(Iterable<S> entities)	주어진 엔티티 목록을 모두 저장하거나 업데이트합니다.
 * findById(ID id)	주어진 ID에 해당하는 엔티티를 반환합니다. (Optional 타입으로 반환)
 * existsById(ID id)	주어진 ID에 해당하는 엔티티가 존재하는지 확인합니다.
 * findAll()	모든 엔티티를 반환합니다.
 * findAllById(Iterable<ID> ids)	주어진 ID 목록에 해당하는 모든 엔티티를 반환합니다.
 * count()	전체 엔티티의 수를 반환합니다.
 * deleteById(ID id)	주어진 ID에 해당하는 엔티티를 삭제합니다.
 * delete(T entity)	주어진 엔티티를 삭제합니다.
 * deleteAllById(Iterable<? extends ID> ids)	주어진 ID 목록에 해당하는 모든 엔티티를 삭제합니다.
 * deleteAll(Iterable<? extends T> entities)	주어진 엔티티 목록을 모두 삭제합니다.
 * deleteAll()	모든 엔티티를 삭제합니다.
 * 
 * 
 */

// JPA Query Method
//
// Distinct             findDistinctByLastnameAndFirstname	                    select distinct …​ where x.lastname = ?1 and x.firstname = ?2
// And	                findByLastnameAndFirstname          	                … where x.lastname = ?1 and x.firstname = ?2
// Or	                findByLastnameOrFirstname	                            … where x.lastname = ?1 or x.firstname = ?2
// Is, Equals	        findByFirstname,findByFirstnameIs,findByFirstnameEquals	… where x.firstname = ?1
// Between	            findByStartDateBetween		                            … where x.startDate between ?1 and ?2
// LessThan	            findByAgeLessThan		                            … where x.age < ?1
// LessThanEqual	    findByAgeLessThanEqual		                            … where x.age <= ?1
// GreaterThan	        findByAgeGreaterThan		                            … where x.age > ?1
// GreaterThanEqual	    findByAgeGreaterThanEqual		                            … where x.age >= ?1
// After	            findByStartDateAfter		                            … where x.startDate > ?1
// Before	            findByStartDateBefore		                            … where x.startDate < ?1
// IsNull, Null	        findByAge(Is)Null		                            … where x.age is null
// IsNotNull, NotNull	findByAge(Is)NotNull		                            … where x.age not null
// Like	                findByFirstnameLike		                            … where x.firstname like ?1
// NotLike	            findByFirstnameNotLike		                            … where x.firstname not like ?1
// StartingWith	        findByFirstnameStartingWith		                            … where x.firstname like ?1 (parameter bound with appended %)
// EndingWith	        findByFirstnameEndingWith		                            … where x.firstname like ?1 (parameter bound with prepended %)
// Containing	        findByFirstnameContaining		                            … where x.firstname like ?1 (parameter bound wrapped in %)
// OrderBy	            findByAgeOrderByLastnameDesc		                            … where x.age = ?1 order by x.lastname desc
// Not	                findByLastnameNot		                            … where x.lastname <> ?1
// In	                findByAgeIn(Collection<Age> ages)		                            … where x.age in ?1
// NotIn	            findByAgeNotIn(Collection<Age> ages)		                            … where x.age not in ?1
// True	                findByActiveTrue()		                            … where x.active = true
// False	            findByActiveFalse()		                            … where x.active = false
// IgnoreCase	        findByFirstnameIgnoreCase		                            … where UPPER(x.firstname) = UPPER(?1)

