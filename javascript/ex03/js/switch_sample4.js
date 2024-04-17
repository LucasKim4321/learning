let jumsu=prompt("점수 입력",0)
console.log(jumsu)
console.log(jumsu, jumsu/10, Math.floor(jumsu/10))
document.write(`<h3>당신의 점수는<b>${jumsu}점</b>입니다.</h3>`)

// switch(jumsu/10) {
switch(Math.floor(jumsu/10)) {
    case 10:
        document.write('<h1>100점 만점!!</h1>')
        break
    case 9:
        document.write('A학점')
        break
    case 8:
        document.write('B학점')
        break
    case 7:
        document.write('C학점')
        break
    case 6:
        document.write('D학점')
        break
    case 0:
        document.write('<h1>0점!!!</h1>')
        break
    default:
        document.write('<h2>F!!</h2>')
}
document.write("<br><br>")



// 변수 선언 키워드 : var, ES6(2015)이후 let, const

const myFruit="사과"
// const myFruit=prompt("사과","")
console.log(myFruit)
switch(myFruit){
    case "귤":
    case "사과":
        document.write("사과 혹은 귤입니다.")
        break
    case "배":
        document.write("배입니다.")
        break
    default:
        document.write("기타 과일")
}