// 김태진

// [문항2]  배열 arr에 담긴 모든 값을 더하는 프로그램을 완성하시오.


let num = [10, 20, 30,40,50]
let sum = 0

// // 1.for
for (let i=0; i<num.length; i++) {
    // console.log(num[i])
    sum+=num[i]
}
console.log('for(제어문): sum=',sum)



// 2. 확장 for
sum = 0
for( let num2 of num) {
    sum+=num2
}
console.log('for(변수 of 배열)',sum)

// 3. forEach()
sum = 0
num.forEach( (num2)=> {
    sum+=num2
})
console.log('배열.forEach :sum=',sum)

// 4. reduce()
sum = 0
sum = num.reduce( (a,b)=> a+b )
console.log('배열.reduce() :sum =',sum)



// /*
// 1. for(제어문): sum= 150
// 2. for(변수 of 배열) :sum= 150
// 3. 배열.forEach :sum= 150
// 4. 배열.reduce() :sum => 150
// */