/*
연산식 : 
산술식 => 
이항 연산 : +, -, *(곱하기), /(나누기), %(나눈 나머지), **(제곱)
단항 연산 : ++, --
관계 연산 : >,>=,<,<=,!=(같지않다), 같음(==,===)
         : 관계연산의 결과는 true, false
논리연산 : !(NOT) &&(AND) ||(OR)
&&(AND) : 모든 조건이 ture면 true
||(OR) : 모든 조건이 false => false
^(XOR) : 모든 조건이 true 이거나 false면 false
NOT -> AND -> OR 순으로 계산

삼항 연산자 : 조건식 ? true경우 처리 : false인 경우 처리

복합형 대입연산자
+=,-=,*=,/=,%=
*/

let num5 = 1000
num5 += 100 //num5=num5+100
console.log(num5)
num5 -= 50
console.log(num5)

console.log(10>2 ? "10은 2보다 크다" : 1000) 

console.log("!(NOT)", (5>2), !(5>2)) // true, false 출력

console.log("&&(AND)", 5>2 && 5>3) //true 둘 다 참이므로 true 
console.log("&&(AND)", 5>2 && 5>3 && 5<3) //false 하나가 false 이므로 false

console.log("||(OR)", 5>2 || 5>3 || 5<3) //true 
console.log("||(OR)", 5<2 || 5<3 || 5<3) //

console.log("^(XOR)", 5>2 ^ 5>3) // 0
console.log("^(XOR)", 5<2 ^ 5<3) // 0
console.log("^(XOR)", 5>2 ^ 5<3) // 1
console.log("^(XOR)", true ^ false) // 1

console.log("5>2", 5>2) //true
console.log("5<2", 5<2) //false
console.log("5!=2", 5!=2) //true
console.log("5==2", 5==2) //false
console.log("5==5", 5==5) //true
console.log("5=='5'", 5=="5") //true ==숫자 문자 관계없이 결과 출력
console.log("5==='5'", 5==="5") //false ===만 숫자 문자 다르면 무조건 false
console.log("문자==='문자'", "문자"==="문자") //true ===,== 글자도 비교됨 true
console.log("5>'2'", 5>"2") //true 숫자 문자 관계없이 결과 출력

// 1. 기억장소 선언
let num1=10, num2=3
let add, sub, mul, div, mod, pow

// 2. 계산 처리
add = num1 + num2
sub = num1 - num2
mul = num1 * num2
div = num1 / num2
mod = num1 % num2
pow = num1 ** num2

console.log(add, sub, mul, div, mod, pow)
let num3 = 10
console.log('num3'+ --num3)
console.log(num3)