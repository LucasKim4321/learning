const items = [10,20,30,40,40,40]
console.log(items)
items.push('길순이')
console.log(items)  // 길순이가 추가된 후 출력

const userIdList = new Set();  // set()은 중복 적용 안됨
userIdList.add('20')
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
const memberList = new Map()  // key값 중복 안됨
memberList.set(1,'홍길동1')
memberList.set(2,'홍길동2')
memberList.set(3,'홍길동3')
memberList.set(3,'홍길동3')
memberList.set(3,'홍길동4')  // 해당 키의 value값만 수정
console.log(memberList)

console.log('memberList.get(2)',memberList.get(2))
console.log('memberList.has(2)',memberList.has(2))
console.log('memberList.delete(2)',memberList.delete(2))  // .clear(): 전체 삭제
console.log('memberList',memberList)
console.log('memberList.keys()',memberList.keys())
console.log('memberList.values()',memberList.values())
console.log('memberList.entries()',memberList.entries())
