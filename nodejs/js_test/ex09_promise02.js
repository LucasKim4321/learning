// Promise직렬 처리하기
// 외부 데이터를 가져와 후속 처리 작업에 사용할 경우
// Promise => await, async (둘이 한 셋트)

// resolve()=>then(), reject()=>catch()
// Promise.resolve().then().then()  // then 두개 순서대로 처리
Promise.resolve()  // 지연시 시간순으로 처리
.then(()=> {
    new Promise((resolve)=> {
        setTimeout(()=>{
            console.log('첫번째 Promise',new Date().toLocaleDateString())
            resolve()
        },2000)
    })
})
.then(()=> {
    new Promise((resolve)=> {
        setTimeout(()=>{
            console.log('두번째 Promise',new Date().toLocaleDateString())
            resolve()
        },1000)
    })
})

// Await와 async적용시
// 함수앞에 async 선언시 비동기 처리
async function start() {
    // await : Promise가 끝날 때까지 기다리는 뜻
    await new Promise((resolve)=>{
        setTimeout(()=>{
            console.log('세번째 Promise',new Date().toLocaleDateString())
            resolve()
        },3000)
    })
    await new Promise((resolve)=>{  // 무조건 세번째 Prommise를 기다린 후 실행
        setTimeout(()=>{
            console.log('네번째 Promise',new Date().toLocaleDateString())
            resolve()
        },1000)
    })
}
start()