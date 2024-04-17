// for(초기치; 조건식; 증감치) {
//     반복 처리 할 내용
// }
//반복문 변수는 반복문 내에서만 적용


for(let i=1; i<=5; i++) { //i가 1부터 5가 될 때까지 반복  5번 반복
    console.log("반복 처리 구간",i)
}

for(let i=10; i<=50; i+=10) { //i가 10부터 50가 될 때까지 반복  5번 반복
    console.log("반복 처리 구간",i)
}

for(let i=0; i<5; i++) { //i가 0부터 4가 될 때까지 반복  5번 반복  배열구조 이용시 0부터 처리하기 때문에 편리 5는 갯수
    console.log("반복 처리 구간",i)
}

for(let i=1; i<=10; i++) { 
    if (i%3==0) continue; // if조건 만족시 continue이후 문장 수행 안하고 건너감
    console.log("반복 처리 구간",i)
}

for (let i=1; i<=10; i++) {
    if (i==5) break; // if조건 만족시 break 반복문 빠져 나옴
    console.log("반복 구간",i)
}

for (let i=1; i<=10; i++) {
    if (i==5) break; // if조건 만족시 break 반복문 빠져 나옴
    console.log("반복 구간",i)
}

let num1 = 5
console.log(num1==5)  // 비교 연산
console.log(Boolean(num1=10)) // 대입문
console.log("----")

for (let i=1; i<=10; i++) {
    if (i=5) break; // if조건 만족시 break 반복문 빠져 나옴
    console.log("반복 구간",i)
}