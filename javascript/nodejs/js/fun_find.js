// 화살표 함수 : 콜백함수 활용 => (인자:함수)  함수형 프로그램
const arr = ['홍길동', '홍길순', '동길이', '홍길동']
console.log(arr)

// 함수(매개변수,...) {}
// 함수(인자값,...)
// 배열.find( 콜백함수 조건에 맞는 첫번째 요소를 반환)
const find_result = arr.find( (v)=> v == '사자')
console.log('자료가 없을 경우 null:', find_result)

const find_result2 = arr.find( (v)=> v == '홍길동')  // 앞에거만 찾고 종료
console.log('자료가 없을 경우 null:', find_result2)