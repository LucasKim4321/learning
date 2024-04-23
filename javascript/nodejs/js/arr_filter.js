// 배열.filter(콜백함수)
// 조건을 만족하는 데이터의 배열 생성
const newArr = [10,20,30,40].filter( (data)=> data >= 20 )
console.log ('20이상:',newArr)

const num = [10,20,30,40]   
const newArr2 = num.filter (function(data) {return data<=30})
console.log ('30이하:',newArr2)


let a = Number(prompt('입력',''))
const newArr11 = [10,20,30,40].filter( (data)=> data >= 20+a )
console.log (newArr11)

const newArr12 = newArr11.map( (data)=> data>30)
console.log (newArr12)
if (newArr12[0]==true)
console.log('true')
else
console.log('false')