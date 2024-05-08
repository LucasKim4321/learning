// 동기는 하나가 끝날때까지 다른건 못함(순서대로처리)  비동기는 하나를 처리중에 다른거도 처리함
// 비동기처리: 특정 코드의 실행이 완료될 때까지 기다리지 않고 다음 코드를 먼저 수행하는 특성

// 비동기화 Promise 객체 사용
// promise생성자 인자: 비동기 처리 작업을 하는 함수를 지정(사용)
// 함수 내부에서 비동기 처리완료 메소드인 resolve()호출
// Promise인스턴스의 then()을 사용해 resolve()실행후의 작업을 처리

// const promise = new Promise( (resolve)=> {
//     setTimeout( ()=> {
//         resolve('orange')
//     },2000)
//     for(i=1; i<=5; i++) {console.log(i)}  // 먼저 실행
// })
// promise.then( (value)=> {
//     console.log(value)
// })

// resolve()=>then(), reject()=>catch()
const promise = new Promise( (resolve,reject)=> {  // 선언할때 new Promise 선언  인자,변수는 뭘 쓰든 관계없음
    let flag= true
    if (flag ===true)
        resolve('orange')
    else
        reject('apple')
}) //.then((result)=>console.log(result)).catch((result)=>{console.log(result)})

promise.then((value)=> {  // 작업 완료 후 실행
    console.log(value)
})
// 실패할 가능성이 있는 비동기 작업을 처리할 경우
promise.catch((value)=> {  // 실패시 실행
    console.log(value)
})


// Promise.all(배열) : 다수의 Promise병렬 실행
const arrFunc = []
for (let i=0; i<5; i++) {
    const func = (resolve)=> {
        console.log(`1. 처리 ${i} 시작`, new Date().toLocaleDateString())
        // const delayMsec = 2000 // 2초
        const delayMsec = 1000 * Math.ceil(Math.random()*5) // 1~5초
        console.log(delayMsec)

        setTimeout( ()=> {  // 비동기 지연 처리 함수  setTimeout(수행할 함수, 시간설정)
            console.log(`2. 처리 ${i} 시작`, new Date().toLocaleDateString())
            resolve()  // 코드가 정상처리
        }, delayMsec)
    }
    // 비동기식 처리하는 함수객체를 배열에 저장
    arrFunc.push(func)  //[0],[1]....[4]
}
// console.log(arrFunc)
// 비동기 함수 저장 배열 => 배열에 promise 객체 저장
const arrPromise = arrFunc.map((func)=> new Promise(func))
console.log('---> Promise 배열로 전환')
console.log(arrPromise)

// 병렬 처리 실행
Promise.all(arrPromise).then(()=>{  // 모든 작업 완료 후 실행
    console.log('모든 작업이 완료되었습니다.')
})



// const promise = new Promise()
// promise.then()
// promise.cantch()

