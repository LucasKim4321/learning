// 1. HTML 연결
var _try = document.querySelector('#try')
var _check = document.querySelector('#check')
var _reset = document.querySelector('#reset')
var _result = document.querySelector('#result')
var _count = document.querySelector('#count')

// 랜덤 숫자
var cNum = Math.ceil(Math.random()*100)
console.log (cNum)

// 이벤트
_check.addEventListener('click', ()=> {
    alert('ㄴㄴ')
})



// 리셋
function ffreset() {
    window.location.reload()
}



// var cNum = 0, uNum = 0
// var cNum = Math.ceil(Math.random()*100)  //100가지 숫자 발생
// console.log('컴퓨터가 생성한 숫자',cNum)

// // document.querySelector('#reset').addEventListener('click', ()=> {
// // var cNum = Math.ceil(Math.random()*100)  //100가지 숫자 발생
// // console.log('컴퓨터가 생성한 숫자',cNum)
// // // return cNum
// // })


// document.querySelector('#check').addEventListener('click', ()=> {
//     var uNum = document.querySelector('#try').value
//     var result = document.querySelector('#result')
//     console.log(result)
//     console.log(uNum)
//     if (uNum==cNum){
//         result.innerHTML = '<h1>정답!!!</h1>'
//     }
//     else if (uNum>cNum) {
//         result.innerHTML = '<h1>UP!!!</h1>'
//     }
//     else {
//         result.innerHTML = '<h1>DOWN!!!</h1>'
//     }
// })