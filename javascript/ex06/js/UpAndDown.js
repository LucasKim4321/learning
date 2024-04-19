// 1. HTML요소 JS와 연결

var _try = document.querySelector('#try')
var _check = document.querySelector('#check')
var _reset = document.querySelector('#reset')
var _display = document.querySelector('#display')
var _counter = document.querySelector('#counter')

// 체크
// console.log(_try)
// console.log(_check)
// console.log(_reset)
// console.log(_display)
// console.log(_counter)

// 컴퓨터 숫자 발생1~100사이 무작위
var rnd = Math.ceil(Math.random()*100)
console.log('컴퓨터가 생성한 숫자:', rnd)  // 체크


// 2. 이벤트 등록하기

// 확인 버튼 이벤트 등록하기
_check.addEventListener('click', ()=> {
    // var userNum = _try.value
    // console.log('사용자가 입력한 수:', userNum)
    // alert(`사용자가 입력한 수: ${userNum}`)  // 체크
    finding()
})
// 위에거랑 같음
// _check.addEventListener('click',finding)  // 함수의 인자값이 함수일 때 해당함수에 인자 값을 쓰면 에러


// 숫자 입력란에서 enter키 이벤트 등록하기
_try.addEventListener('keypress', (e)=> {  // 대상.keyCode == 키 코드 값 누를 때 이벤트가 발생하는 함수  13=enter
    // e: 이벤트가 발생한 객체의 정보가 전달됨.
    // 여기서는 key의 기본정보중 keycode값이 키를 구분해줌
    if (e.keyCode == 13) {
        // var userNum = _try.value
        // alert(`사용자가 입력한 수: ${userNum}`)
        finding()
    }
})

var counter = 0  // 카운트 체크
// 입력받은 숫자에 대한 조건 처리하는 함수
function finding() {
    var userNum = _try.value
    // alert(`사용자가 입력한 수: ${userNum}`)
    counter++
    if (userNum >=1 && userNum<=100) {
        if (rnd == userNum) {  
            _display.innerHTML = "<h1>정답!!</h1>"
        }
        else if (rnd > userNum) {
            _display.innerHTML = '<h1>UP!</h1>'
        }
        else {
        _display.innerHTML = '<h1>DOWN!</h1>'
        }
        _counter.innerHTML = '시도 횟수:' + counter + "회"  // , 쓰면 안됨
    }
    else {
        alert('1과 100사이의 숫자를 입력하세요.')
    }
}



// 다시 버튼 클릭시 수행할 함수 정의
function fun_reset() {
    // alert('reset 버튼 클릭')  // 체크
    window.location.reload()
}