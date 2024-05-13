// 에러 발생 확인
// 에러가 발생 해도 다음 문장 출력 후 정상 처리 
const a = 10
try {
    a = 100  // const 읽기만 가능해서 에러 발생
}
catch(e) {
    console.log(`에러가 발생했습니다. ${e.message}`)  // 에러 발생시 발동
}
console.log("애러 발생한 후 처리한 내용:",a)


// console.log('---')
// const b = 100
// b=200
// console.log('b',b)  // 에러로 인해 작동안함

// 50% 확률로 에러를 발생시켜 try와 catch처리
function generateError() {
    try{
        var rnd = Math.random()  // 0 < rnd > 1
        console.log('발생한 숫자=>',rnd)
        if (rnd >= 0.5) {  // 조건 만족시 에러
            throw new Error(`number:${rnd}`)  // 에러값(`number:${rnd}`) 리턴
        }
        else {
            console.log('에러 없음')
        }
    }
    catch(error) {
        console.log('errorMessage:',error.message)  // 에러값 출력
    }
    finally {  // 에러가 발생하든 말든 실행됨
        console.log('에러 처리 완료')
        console.log('에러 여부 관계없이 무조건 수행')

    }
}
generateError()
// setInterval(generateError,1500);  // 1.5초 단위로 generateError함수 반복 호출


// 에러종류
// RangeError : 값이 허용 범위 내에 없음
// ReferenceError : 선언되지 않은 변수를 호출
// SyntaxError : 언어 구문 부정확
// TypeError : 데이터 타입 부정확
// URIError : URI 부정확

// try {
//     // 1. SyntaxError
//     // let num null

//     // 2. ReferenceError
//     // console.log(b)
// }
// catch(error) {
//     console.log(error)
// }