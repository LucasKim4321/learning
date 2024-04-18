// 수학 객체

console.log(Math.abs(1), Math.abs(-1))  // 절대값 반환   음수도 양수로 나옴
console.log(Math.max(10,50,90,100))  // 최대값
console.log(Math.min(10,50,90,100))  // 최저값
console.log(Math.round(10.51),Math.round(10.44))  // 소수점 아래 반올림
console.log(Math.floor(10.54))  // 자리 내림 소수점 아래 자름
console.log(Math.ceil(10.2))  // 자리 올림 소수점 아래 자름
console.log(Math.trunc(10))  // 소수점 아래 자름
console.log(Math.PI)  // 파이
console.log(Math.random())  // 랜덤한 숫자
console.log(Math.random()*10)  // 0~9 10가지 랜덤한 숫자

console.log(Math.pow(10,3))  // 제곱   10의 3승의 값
console.log(Math.sqrt(4))  // 루트   루트4의 값


console.log('----')


// for (i=1; i<=10; i++) {
//     console.log(Math.ceil(Math.random()*3))
// }

// var arr_str = ['홍길순', '길순이','동길이','강감찬','이순신']
// console.log(arr_str)

// var rn = Math.floor(Math.random()*5)  // 0~4 사이 난수 발생
// console.log(arr_str[rn])




// 랜덤 숫자 검증
var n1=0,n2=0,n3=0,n=0
for (i=1; i<=10; i++) {
    num = Math.ceil(Math.random()*3)
    if (num==3){
        n3++
        console.log(num)
    }
    else if (num==2) {
        n2++
        console.log(num)
    }
    else if (num==1) {
        n1++
        console.log(num)
    }
    else
    n++
}
console.log(n1,n2,n3,n)