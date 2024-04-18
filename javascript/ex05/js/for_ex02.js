// 세 점수를 입력받아 총점과 평균 구하기


// var jumsu = 0
// var tot =0, avg =0, n=0

// // prompt문자열로 입력 받음  외부 장치 입력은 문자열로 입력받음
// // 문자열 => 숫자열로 전환 필요

// jumsu=prompt("점수를 입력하세요", 0)
// jumsu=Number(jumsu)  // Number(입력받은 값)을 숫자열로 전환
// tot = tot + jumsu
// console.log(tot)
// n++

// jumsu=prompt("점수를 입력하세요", 0)
// jumsu=Number(jumsu)
// tot = tot + jumsu
// console.log(tot)
// n++

// jumsu=prompt("점수를 입력하세요", 0)
// jumsu=Number(jumsu)
// tot = tot + jumsu
// console.log(tot)
// n++

// for (i=1; i<=3; i++) {
//     jumsu=prompt("점수를 입력하세요", 0)
//     jumsu=Number(jumsu)
//     tot = tot + jumsu
//     console.log(tot)
//     n++
// }

// avg = tot/n
// console.log (`전체 총점 : ${tot}, 전체 평균 : ${avg}`)





var jumsu = 0, n = 0
var tot =0, avg =0, 

n=prompt("인원 수 입력", 0)
for (i=1; i<=n; i++) {
    jumsu=prompt("점수를 입력하세요", 0)
    jumsu=Number(jumsu)  // Number(입력받은 값)을 숫자열로 전환
    tot = tot + jumsu
    console.log(tot)
}

avg = tot/n
console.log (`${n}명의 전체 총점 : ${tot}, 전체 평균 : ${avg}`)