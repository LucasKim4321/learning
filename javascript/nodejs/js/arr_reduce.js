// 배열의 요소를 계산하여 하나의 값을 생성
// 배열.reduce(콜백함수,[초기화])

const priceList = [100,200,300]

console.log('--for문 합계')
priceSum = 0
for (let i=0; i<priceList.length; i++) {
    priceSum += priceList[i]  //+100,+200,+300
    console.log (priceList[i], priceSum)
}

console.log('--확장 for문 합계')
priceSum = 0
for (let data of priceList) {
    priceSum += data
    console.log(data, priceSum)
}

console.log('-- 배열.reduce(): 합계')  // 초기값 주기 가능
priceSum = 0
priceSum = priceList.reduce( (pre, curr)=> pre+curr , 1000 )  // 배열.reduce( (과거값, 현재값)=> 과거값+현재값, 초기값)
console.log ('sum:', priceSum)

priceSum = 0
priceSum = priceList.reduce( (pre, curr, idx)=> {
    console.log ('idx'+ idx + 'pre:'+ pre + 'curr:'+ curr + 'pre+curr' + (pre+curr))
    return pre+curr
},0 )
console.log ('sum:', priceSum)

let fac = [1,2,3,4,5].reduce( (a,b)=> a*b , 1)
console.log ('fac:', fac)

// 2차원 배열 -> 1차 배열 전환 => 플래트닝(Flattening)
const array = [['바나나','사과','딸기'],['귤','포도'],['배','망고'],['키위','석류']]
console.log(array)
console.log(array[0])
console.log(array[1])
console.log(array[0][1])

const flattenedArray = array.reduce( (a,b)=> a.concat(b),[1,2,3])  // 배열 2개 이상 합칠 때 더 유용, 초기값 가능(배열 계산시 배열 대입)
console.log ('flattenedArray', flattenedArray)

const flattenedArray2 = array[0].concat(array[1],array[2],array[3],[1,2,3])
console.log ('flattenedArray2', flattenedArray2)

var flattenedArray3 = []
for (i=0; i<array.length; i++) {
    flattenedArray3 = flattenedArray3.concat(array[i])
}
console.log ('flattenedArray3', flattenedArray3)