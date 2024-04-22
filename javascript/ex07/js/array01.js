const arr1 = [] // 배열구조 변수 선언
const arr2 = [0,2,8] // 배열객체 초기화
const arr3 = ['곰','여우']
const arr4 = [1,'홍길동', true]

console.log('-- 배열객체 내용 보기 (1차원)')
console.log (arr1)
console.log (arr2)
console.log (arr3)
console.log (arr4)
// console.log (arr4_1)

console.log ('-- 배열 내 다른 배열/객체 (2차원)')
const arr5 = [ [1,2,3], [4,5,6] ]
console.log (arr5)
console.log (arr5[0],arr5[1])
console.log (arr5[0][0],arr5[0][1],arr5[0][2])


console.log ('-- 1차원 배열구조 반복자를 통해 데이터 연속 읽기 --')
console.log ('-- for문')
// for (조건) {내용}
for (var i=0; i<arr4.length; i++) {  //i= 0,1,2 ...  //배열.length 배열의 길이
    console.log(arr4[i])  // arr[0], arr[1], arr[2]
}

// 대상.forEach(함수)
console.log ('--화살표 함수식 표현')
arr4.forEach( (value, index)=> {  //(값, 인덱스)=>
    console.log(value, '=>', index)  // 값, 인덱스 출력
})

// for (값 인자 of 대상)
console.log ('-- 확장 for')
for (var value of arr4) {
    console.log (value)
}

console.log ('-- 2차원 배열, 객체 데이터 읽기')
for (i=0; i<arr5.length; i++) {
    console.log (arr5[i])  // arr5[0],arr5[1],arr5[2]  출력 [1,2,3] [4,5,6]
    for (j=0; j<arr5[i].length; j++) {
        console.log(arr5[i][j])  // arr5[0][0],arr5[0][1],arr5[0][2],arr5[1][0]...  출력 1,2,3  4,5,6
    }
}  // 최종 출력 [1,2,3]1,2,3  [4,5,6]4,5,6

const arr6 = [ {id:1, name:'홍길동'}, {id:2, name:'동길이', d:[1,2,3]} ]
console.log (arr6)
console.log (arr6[0], arr6[1])
console.log (arr6[0].id, arr6[0].name)
console.log (arr6[1].id, arr6[1].name, arr6[1].d)
console.log (arr6[1].d[2])



// const arr20 = arr3.concat(arr4)
// console.log (arr20)
// console.log (arr20[3])


// const arr21 = [()=>{},1]
// console.log (arr21)

// const arr22 = [1,[2,[3,[4]]]]
// console.log (arr22)
// console.log (arr22[1][1][1])
// console.log (arr22[1][1][1][0])