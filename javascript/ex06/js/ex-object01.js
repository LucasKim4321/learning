// 1. HTML 연결
var _try = document.querySelector('#try')  //text박스
var _check = document.querySelector('#check')  //check버튼
var _reset = document.querySelector('#reset')  //reset버튼
var _result = document.querySelector('#result')  //결과창
var _counter = document.querySelector('#counter')  //횟수카운트창


// 랜덤 숫자
var cNum = Math.ceil(Math.random()*100)
console.log ('컴퓨터 숫자:', cNum)


// 이벤트
_check.addEventListener('click', ()=> {
    finding()
})
_try.addEventListener('keypress', (key)=> {
    if (key.keyCode == 13) {  // 대상의 키 코드 값이 13(enter)일때 true
        finding()
    }
})

// 결과
var count = 0
function finding() {
    var uNum = _try.value
    // alert('테스트')
    console.log('유저 숫자:', uNum)
    if (uNum<1 || uNum>100) {
        alert('1~100까지의 숫자를 입력하세요')
    }
    else if (uNum==cNum) {
        _result.innerHTML = '<h1>정답!!!</h1>'
    }
    else if(uNum>cNum) {
        _result.innerHTML = '<h2>DOWN!</h2>'
    }
    else {
        _result.innerHTML = '<h2>UP!</h2>'
    }
    count++
    _counter.innerHTML = '시도 횟수:' + count + "회"
}

// 리셋
function reset() {
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


// var 중복 선언, 수정 가능  let 중복 선언x, 수정가능  const 중복x 수정x