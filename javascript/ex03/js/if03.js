// 입력한 숫자가 양수, 0 음수 판별
var num=prompt("숫자 입력","0")
console.log(num)

if (num==0)
document.write("0")
else if (num>0)
document.write("양수")
else
document.write("음수")


// 메시지 창 : alert("메시지") 메시지창 생성
// 입력 창 : prompt("메시지", "기본값") 입력가능한 창 생성
// 판별 여부 창 : confirm("메시지") 확인하면 true 취소하면 false

// alert("???")
// var isOK=confirm("정말로 회원을 탈퇴하시겠습니까?")
// console.log(isOK)

// if(isOK) {
//     document.write("탈퇴 처리하였습니다.")
// }
// else {
//     document.write("탈퇴 취소하였습니다.")
// }



// 입력한 숫자가 3의 배수이고 6의 배수인 숫자 판별하기
// var num=prompt("숫자 입력:",0)
// console.log(num)
// console.log(num, num/3, num%3)

// if (num==0){
//     alert("다시입력")
//     location.reload()
// }
// else if (num%3==0&&num%6==0){
//     console.log(`입력한 숫자${num}가 3의 배수이고 6의 배수`)
//     document.write(`입력한 숫자${num}가 3의 배수이고 6의 배수`)
// }
// else if (num%3==0){
//     console.log(`입력한 숫자${num}는 3의 배수`)
//     document.write(`입력한 숫자${num}는 3의 배수`)
// }
// else
//     console.log(`그냥 숫자${num}`)


