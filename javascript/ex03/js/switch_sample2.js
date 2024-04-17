// 내장 함수
// Math.random() 랜덤한 숫자 생성
// Math.floor() 소수점 아래 생략
// 0~n-1 사이 숫자 발생
// console.log(Math.floor(Math.random()*3))
console.log(Math.floor(Math.random()*10)) //자리내림 0~9
console.log(Math.ceil(Math.random()*10)) //자리올림 1~10


document.write("<h1>컴퓨터 가위,바위,보 맞추기</h1>")

var game = prompt ("가위, 바위, 보 중 선택?","가위")

switch(game) {
    case ("가위"||"바위"||"보"):
        break
    default:
        alert("잘못 작성했습니다.")
        location.reload()
}

var com = Math.ceil(Math.random()*3) // 1~3 사이 난수 발생
console.log("Math.random:",com)
var gameName2
switch(com){
    case 1:
        gameName2="가위"
        break
    case 2:
        gameName2="바위"
        break
    case 3:
        gameName2="보"
        break        
}

document.write("플레이어:",game,  "컴퓨터:",gameName2,"<br><br>")

if (game==gameName2)
document.write ("<h1>잘 맞췄습니다. 축하 드립니다!</h1>")
else
document.write ("<h3>틀렸습니다. 다시 시도해보세요.</h3>")