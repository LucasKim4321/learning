// 배열 요소 추출 하여 새 배열
const idList = [4,10,20]
// const userIdList = idList.map( (v)=> v )  // 요소 3개를 받아서 3개 만듬  // 함수형 프로그래밍 기법
const userIdList = idList.map( (v)=> `userid_${v}` )
console.log (userIdList)