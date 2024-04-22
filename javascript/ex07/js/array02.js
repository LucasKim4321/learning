// 배열 요소 추가, 삭제하기
const arr1 = ['사과','귤']
console.log ('arr1:', arr1)

arr1.unshift ('바나나')  // 대상.unshift 배열안 앞에 추가
console.log ('unshift()', arr1)

arr1.push ('딸기')  // 대상.push 배열안 뒤에 추가 *
console.log ('push()', arr1)

// 배열 요소 삭제하기
const shifteValue = arr1.shift()  // 대상.shift() 배열 첫번째 요소 삭제
console.log ('삭제된 요소', shifteValue)
console.log ('삭제후 배열', arr1)

const popValue = arr1.pop()
console.log ('삭제된 요소', popValue)  // 대상.pop() 배열 마지막 요소 삭제
console.log ('삭제후 배열', arr1)

// 대상.splice (위치, 삭제할 개수, 요소추가(무한대?가능))
const arr2_splice = ['홍길동', '홍길순', '동길이']
console.log ('arr1_splice', arr2_splice)
arr2_splice.splice (1, 0, '동길이홍')  // 인덱스 1위치에 추가 후 뒤에 0개 삭제
console.log (arr2_splice)
arr2_splice.splice (1, 2, '동길이홍','dd','aa')  // 인덱스 1위치에 추가 후 뒤에 2개 삭제
console.log (arr2_splice)

// 배열 결합
const arr3 = ['홍', '길']
const arr4 = ['동순이']
const arr5 = arr3.concat(arr4)
console.log ('arr3.concat(arr4):', arr5)

// 스프레드 연산자 : (...)
const arr6 = ['곰','사자']
console.log (arr6)
console.log(...arr6)
console.log ('스프레드 연산,', ([...arr3,...arr4]))
const arr7 = [...arr3,...arr4]
console.log (arr7)

// 배열 요소를 결합해서 문자열 출력
const arr8 = [2,4,8]
console.log ('arr8:', arr8, typeof(arr8))
console.log ('join():', arr8.join(), typeof(arr8.join()))

const arr9 = ['a', 'b', 'c']
console.log('join():', arr9.join())  // 기본값 ','
console.log('join():', arr9.join(''))  //공백으로 대체
console.log('join():', arr9.join('-'))

// 배열 요소 검색
const arr10 = ['홍길동', '홍길순', '동길이']
console.log ('indexOf():', arr10.indexOf('동길이'))  //있으면 인덱스 번호 2출력
console.log ('indexOf():', arr10.indexOf('홍길순1'))  //없으면 -1
console.log ('indexOf():', arr10.includes('동길이'))  // true
console.log ('indexOf():', arr10.includes('홍길순1'))  //false
console.log ('indexOf():', arr10.lastIndexOf('홍길순'))  //1