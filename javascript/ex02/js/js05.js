/*
단일 기억장소 : 일반 변수
복수 기억장소 : 배열구조, 객체구조
n개의 기억장소 -> n-1의 인덱스번호 표시

- 배열구조 -> "[데이터1,...]" 표시
- 객체구조 -> "{'key':'value',...}" 표시
*/

// 배열 데이터 저장. 앞에서부터 index번호 순서대로 0부터 부여
// 0팽귄 1고래 2참치
const myArray=['팽귄','고래','참치']
console.log(myArray)

// 배열구조 데이터 보기
myArray[0] = '100' //const읽기전용이지만 배열,객체 구조시 내부에는 적용안됨
console.log(myArray[0]) //0번 데이터 출력
console.log(myArray[1])
console.log(myArray[2])

// 객체 데이터 저장. 객체 안에 각각 변수에 데이터 저장.
const myObj = { id:20, name:'홍길동', name2:'홍길순'}
myObj.id = 10
console.log(myObj)
console.log(myObj.id)
console.log(myObj.name)
console.log(myObj['id'])
console.log(myObj['name'])
console.log(myObj.id, myObj.name2)


console.log('홍길동',typeof('홍길동')) // '홍길동'은 string 속성 출력
console.log('100',typeof('100')) // '100'은 string 속성 출력
console.log(100,typeof(100)) // 그냥 100은 number 속성
console.log (5>2, typeof(5>2)) // 5>2는 boolean 속성 출력