const items = [10,20,30,40,40,40]
console.log(items)
items.push('길순이')  // 대상.push('추가할 값')   대상에 추가함
console.log(items)  // 길순이가 추가된 후 출력
items.pop()    // 대상.push('뺄 값')  대상에서 뺌
console.log(items)

const userIdList = new Set();  // set()은 중복 적용 안됨
userIdList.add('20')  // 대상.add('값') 대상에 값 추가
userIdList.add('20')
userIdList.add('20')
userIdList.add('20')
userIdList.add('10')
console.log('userIdList',userIdList)  // 20은 하나만 추가됨

const userIdList2 = new Set([20,50,30,30])  // 중복 허용 안됨
console.log('userIdList2',userIdList2)

const userIdList3 = new Set(items)  // 중복 제거 됨
console.log('userIdList3',userIdList3)

const valueSet = userIdList3.values()
console.log(valueSet)

for( let value of valueSet){
    console.log(value)
}

userIdList3.forEach((value)=>console.log(value))
console.log(valueSet)

console.log('-- set : delete(값)')
userIdList3.delete(40)  // delete(값) 배열에서 값 삭제
userIdList3.forEach((value)=>console.log(value))
console.log(userIdList3.has(40))

console.log('-- set : clear()')
userIdList3.clear()  // clear() 전체 삭제
userIdList3.forEach((value)=>console.log(value))

// 맵 초기화
const memberList = new Map();  // key값 중복 안됨
memberList.set(1,'홍길동1')
memberList.set(2,'홍길동2')
memberList.set(3,'홍길동3')
memberList.set(3,'홍길동3')
memberList.set(3,'홍길동4')  // 해당 키의 value값만 수정
console.log(memberList)

console.log('memberList.get(2)',memberList.get(2))  // 대상.get(key) 대상의 key의 value값 리턴
console.log('memberList.has(2)',memberList.has(2))  // 대상.has(key) 대상의 key의 value값 판별
console.log('memberList.delete(2)',memberList.delete(2))  // 대상.delete(key) 대상의 key의 value값 삭제  // .clear(): 전체 삭제
console.log('memberList',memberList)
console.log('memberList.keys()',memberList.keys())  // 대상.get(key) 대상의 key값 리턴
console.log('memberList.values()',memberList.values())  // 대상.get(key) 대상의 value값 리턴
console.log('memberList.entries()',memberList.entries())  // 대상.get(key) 대상의 key와 value값 리턴

console.log('--- map 객체.forEach()')
memberList.forEach((v,k)=>{
    console.log(`key:${k}=>value:${v}`)
})
console.log(memberList.size)  // Map객체.size  Map객체의 갯수
const memberList2 = new Map([[1,'홍길동'],[2,'홍길순']])  // Map객체의 구조
console.log(memberList2)



// Set구조 : 중복제거, 순서가 없음
/*
new Set(반복가능한 객체)
세트객체.add(값): 추가
세트객체.has(값): 존재 여부 확인
세트객체.delete(값): 삭제
세트객체.clear(): 전체 삭제
세트객체.values(): 전체 값을 반환:(Iterator)
세트객체.forEach(콜백함수)
*/
