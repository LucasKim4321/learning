// 문자열 나누기


const myUrl = "http://example.com/?id=12345&name=Lion&age=28"
// 대상.split('&')  // ('기준값') 대상의 특정 문자를 기준으로 분리하여 배열 구조
console.log(myUrl.split('&'))

const url_arr = myUrl.split('&')

console.log(url_arr[0])
console.log(url_arr[1])
console.log(url_arr[2])

console.log("-- 확장 for...of")
for (var value of url_arr) {
    console.log(value)
}

console.log("-- forEach()")
url_arr.forEach( (value)=> {console.log(value) })

console.log("--for")
for (i=0; i<url_arr.length; i++) {
    console.log(url_arr[i])
}

console.log("-------")
var url_arr2 = myUrl.split(/&|\?|\./)  //  /정규식 표현/  |or  \?,\.특수문자
url_arr2.forEach(v=>console.log(v))

// 인수에 공백('')을 지정하면 한 글자식 분리하여 배열로 반환
console.log('javascript'.split(''))

// 정규식 표현 => /패턴/.test(문자열) => true/false
// 전화번호 패턴 형식
console.log('--정규식 표현')
console.log(/\d{3}-\d{4}-\d{4}/.test('010-1234-1234'))
console.log(/\d{3}-\d{4}-\d{4}/.test('010-1234-1234'))
console.log(/j/, /j/.test('javascript'))
console.log(/^ja/, /^ja/.test('javascript'))  //true  첫자가 맞는지
console.log(/^ip/, /^ip/.test('javascript'))  //false
console.log(/\d/, /\d/.test('javascript'))  // false 숫자가 있는지
console.log(/java*/, /java*/.test('javascript'))  // 해당 글자가 있는지 없는지

// 소수점 자리수 지정
console.log( 0.333333333.toFixed(4))  //  대상.toFixed(자리수)  대상의 소수점이하 자리수까지 자름
var num1 = (0.21321312).toFixed(2)
console.log( num1, typeof(num1))  // string 속성
console.log( (2.4).toFixed(4))  // 자리에 값이 없으면 0 대입   2.4000
console.log( (9.2323232).toPrecision(4))  // 소수점 이하 포함 4자리 숫자

// 문자열 URI 이스케이프(escape)처리
var url3 = 'http://example.com/?name=길순&age=3&홍길동페이지.html'
var url3_ecode1 = encodeURI(url3)  // '/?&=+:@$;,#'  처리하지않음
var url3_ecode2 = encodeURIComponent(url3)  //
console.log(url3)
console.log(url3_ecode1)  // 인코딩된 문자
console.log(url3_ecode2)
console.log('-------------------')
var decode1 = decodeURI(url3_ecode1)  // 디코딩
var decode2 = decodeURIComponent(url3_ecode2)
console.log(decode1)  // 원상 복구된걸 출력
console.log(decode2)