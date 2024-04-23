// 요소의 개별 변수에 분할 대입 (할당)
let a,b,c
[a,b,c] = [1,2,3]  // 각각 대입  a=1 b=2 c=3
console.log(a,b,c)

console.log('---')
const array = ['홍길동','홍길순']; // 배열도 가능. 문장 끝을 알리는 세미콜론이 반드시 있어야함. 다른 경우엔 보통 생략.
[array[0],array[1]] = [array[1],array[0]]
console.log(array)

// 배열 섞기 (셔플)
const arr = [1,2,3,4,5]
const arr_len = arr.length
console.log(arr, arr_len)

// 피셔 예이츠 알고리즘
for (let i=arr_len-1; i>=0; i--) {  //4~0까지 배열 번호로 맞춤
    // console.log(i)  // 4 3 2 1 0
    // random()*10 => 0~9
    const rnd = Math.floor(Math.random()*(i+1));  // 0~4 인덱스 번호가 나오게 맞춤
    // console.log(i,rnd)  // 렌덤값 확인
    [arr[i],arr[rnd]] = [arr[rnd],arr[i]];  // 배열 섞음
    console.log(i,rnd)  // 섞이는 배열 확인
}
console.log(arr)

