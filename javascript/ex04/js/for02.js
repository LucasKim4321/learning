// 다중 for


// html에서 테이블 구조 만들기 <table><tr><td>

// let num1=100
// num1 +=100
// let table_str = "<table border=1 width=200>"
// table_str += "홍길동"
// table_str += "홍길순"
// table_str += "</table>"
// console.log(table_str,num1)


// table -> tr*5 -> td*5
// var row=prompt('행 입력','1')
// var colum=prompt('열 입력','1')
var row=3 , colum=4
let count = 0
let table_str = "<table border=1 width=400 height=70>"
for (let i=1; i<=row; i++) {
    table_str += "<tr>"
    for (let j=1; j<=colum; j++) {
        // table_str += "<td>"
        // table_str += ++count
        // table_str += "</td>"
        table_str += `<td>${++count}</td>`
    }
    table_str += "</tr>"
}
table_str += "</table>"
console.log(table_str)
document.write(table_str)


// var row=prompt('행 입력','1')
// var colum=prompt('열 입력','1')
var row=3 , colum=4
document.write(`<table border=1 width=300 height=70>`)
for(i=1; i<=row; i++) {
    document.write(`<tr>`)
    for(j=1; j<=colum; j++) {
        document.write(`<td>1</td>`)
    }
    document.write(`</tr>`)
}
document.write(`</table>`)


// 구구단 => 다중for
// 2x1=1, ... 2x9=18
// 3x1=1, ... 3x9=27
// 9x1=9, ... 9x9=81


// var dan=prompt("입력",0)
// console.log(dan)
// document.write(dan+"단<br>")
// for (let i=1; i<=9; i++){
//     document.write(`${dan}x${i}=${dan*i}<br>`)
// }


// var c=prompt("입력",0)
// for (let i=c; i<=c; i++) {

// for (let i=1; i<=9; i++) {
//     document.write(`<h1>${i}단<hr></h1>`)
//     for (let j=1; j<=9; j++) {
//         document.write(`${i}x${j}=${i*j}<br>`)
//     }
//     document.write("<br>")
// }


// i++, i+=1, i=i+1 같은 의미 
//반복문 내부 변수는 외부랑은 상관없지만 내부끼리는 겹치면 안됨

// for (let i=1; i<=3; i++) {  //outer for
//     // 반복구간
//     for(let j=1; j<=3; j++){  //inner for
//         // 반복구간
//         // console.log(i,j)
//         for(let c=1; c<=3; c++){  //inner for
//             // 반복구간
//             console.log(i,j,c)
//         } 
//     } 
// }