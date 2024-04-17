// 특정 구간을 반복처리 : for -> 일정한 횟수만 반복,  while -> 조건이 참일때까지 무한 반복

// while(조건식) {
//     참인 동안
//     반복 처리 할 내용
// }


// var loop_cnt=10
var loop_cnt=-5 //조건이 참이 아니면 한번도 처리 안함

while(loop_cnt > 0) {    //...5,4,3,2,1,0
    console.log("반복하기",loop_cnt)
    loop_cnt--
}
console.log("while() outer")


// 최소 1번을 반복 수행
let loop_cnt2 = -10
do {
    console.log("반복 처리")
}
while(loop_cnt2>0)


// while(true) { 
//     // console.log("무한 반복하기")
//     // document.write("무한 반복하기")
// }