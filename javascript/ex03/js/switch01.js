/*
switch문 : 조건을 만족하는 다수의 데이터를 처리
switch(식){
    case 값:
        처리
        break
    case 값:
        처리
        break
    default:
        처리    
}
*/
let str1
str1=prompt("영문자1개 입력:","a")
switch(str1) {
    case "a":
    case "A":
        console.log("영문자 A입니다.")
        break
    case "b":   
    case "B":
        console.log("영문자 B입니다.")
        break
    default:
        console.log("영문자 A,B가 아닙니다.")
}
console.log(str1)


let num2 = 3
switch(num2) {
    case 1: //break 없으면 나올때까지 다음 문장 실행
    case 2:
    case 3:
    case 4: 
        console.log("숫자1-4")
        break
    case 5:
    case 6:
    case 7:
        console.log("숫자5-7")
        break
    default:
    console.log("나머지 숫자")
}

let num1 = 1
switch(num1) {
    case 1:
        console.log("숫자1")
        break 
    case 2:
        console.log("숫자2")
        break
    case 3:
        console.log("숫자3")
        break
    case 4:
        console.log("숫자4")
        break
    default:
        console.log("나머지 숫자")
}
