// 합계, 카운터

// 숫자 1,2,3,4... 생성
// 변수 = 변수 + 숫자 => 숫자만큼 증가 => a=a+1 => a+=1 => a++

// 1. 기억장소 확보, 초기화 작업


// var count = 0
// count = count + 1  // count+=1  count++  ++count
// console.log(count) // 값 1
// count = count + 1 // 값 2
// console.log(count)

//반복 수행
// for(i=1; i<=10; i++) {
//     // count = count + 1
//     // count += 1
//     count--
//     console.log(count)
// }


// 합계 => sum = sum + a => a는 숫자 발생
var sum=0 // 합계 기억장소
var a = 0

a = a + 1
sum = sum + a  // sum + 1
console.log(sum)

a = a + 1
sum = sum + a  // sum + 2
console.log(sum)

a = a + 1
sum = sum + a  // sum + 3
console.log(sum)

// a=a+1; b=b+a;

var a = 0
for(i=1; i<=5; i++) {  
    document.write("a=",a, " => ", a, "+", i, " => ", a=a+i,"<br>")  
    // console.log(a = a + i)
}


// 1-10까지의 합
// 숫자발생, 누적

var total = 0

for (i=1; i<=10; i++) {
    total = total + i // +1, +2, +3 ...
    console.log(i, total)
}

for (i=1; i<=10; i+=2) {
    total = total + i // +1, +2, +3 ...
    console.log(i, total)
}