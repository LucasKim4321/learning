// 함수 정의

// 익명 함수는 호출보다 먼저 선언해야 함.
// myPrn2("/") // 앞에서 호출하면 에러남

var myPrn2 = (str) => {
    for (i=1; i<=10; i++) {
        document.write(str)
    }
    document.write("<hr>")
}

myPrn2("/")


// 일반 함수

myPrn("*")
myPrn("@")
myPrn("~")

function myPrn(str) {
    for (i=1; i<=10; i++) {
        document.write(str)
    }
    document.write("<hr>")
}


function mySum(start,end) {
    var sum = 0
    for (i=start; i<=end; i++) {
        sum += i
    }
    document.write(sum,"<br>")
}
mySum(5,10)
mySum(1,100)
mySum(1,1000)
document.write("<hr>")


function mySum2(start,end) {
    // 값의 유효성 검사
    if (start>end) {
        alert("인자값이 문제가 있습니다.")
    }
}
// mySum2(20,10)
// mySum2(1,100)


function mySum3(start,end) {
    // 값의 유효성 검사
    if (start>end) {
        alert("인자값이 문제가 있습니다.")
    }
    var sum = 0
    for (i=start; i<=end; i++) {
        sum += i
    }
    document.write(sum,"<br>")
    return (sum)
}
var tot = mySum3(1,5)
document.write(`<h3>${tot+10000}</h3>`)
document.write("<hr>")


var return_str = ()=> "홍길동 만세"
var return_num = (num1)=> num1*num1 // {} 안쓰면 return 생략
var return_num2 = (num1)=> {num1*num1} // {} return을 안넣어서 에러 undefined출력
var return_num3 = (num1)=> { return num1*num1}

document.write(return_str(),"<br>")
document.write(return_num(5),"<br>")
document.write(return_num2(5),"<br>")
document.write(return_num3(5),"<br>")

// 전역 변수 : 함수 밖에서 선언한 변수 공통 사용 가능
// 지역 변수 : 함수 내에서 선언한 변수 함수 내에서만 사용 가능

var name1 = "홍길순"
function fun_local() {
    var name2 = "홍길동" // 지역변수 (한수가 실행하는 동안에만 값을 유지)
    name3 = '강감찬' // 함수안에서 전역변수 선언시 var키워드 생략하
    console.log("name1:"+name1)
    console.log("name2:"+name2)
    console.log("name3:"+name3)
}
var name1 = "홍길순"
function fun_local2() {
    var name2 = "동길이" // 지역변수
    console.log("name1:"+name1)
    console.log("name2:"+name2)
    console.log("name3:"+name3) //전역변수 name3이 있는 함수를 호출 하지 않으면 에러
}
fun_local()
fun_local2()
// console.log("name1:"+name1)
// console.log("name2:"+name2) //함수 내에서만 사용 가능