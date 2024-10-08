// 결과 값 표시 대상 -> 콘솔창, HTML태그로 표시
// 진위 여부판별 : Boolean타입 -> true/false


console.log("==값이 있을 경우 판별")
const userName="홍길동"
if (userName) {  //값이 존재하면 true
    console.log("값 여부 판별", userName, Boolean(userName))
}
console.log("0=>", Boolean(0))  // false
console.log("1=>", Boolean(1))  // true
console.log("-1=>", Boolean(-1))  // true
console.log("!0=>", !Boolean(0))  // false -> true
console.log("!!0=>", !!Boolean(0))  // false -> true -> false
console.log("!!...0=>", !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Boolean(0)) //결과 출력 가능
console.log("홍길동",!"홍길동") // 글자가 boolean타입으로 바뀜
console.log(24, !24)
console.log([1,2,3], ![1,2,3])


const flg = "Javascript".includes('a') // 포함 여부 판별
console.log('a 포함 여부 판별',flg,!flg) //a가 포함 되어있으므로 true
if(flg)
    console.log('문자가 있습니다.')


var userName2 //기억장소만 확보, 값이 없는 상태
console.log("userName2 판별", Boolean(userName2))  // false
userName2="길순이"
console.log("userName2 판별", Boolean(userName2))  // true


console.log("==비교연산자 결과 : true/false")
const a = 10
const b = 20
console.log(a>b) // 관계(비교) 연산의 결과 true/false
console.log(a<b)

const num =100>20
console.log(num) //true