// 문자열 길이
console.log("홍길동은 부산에 있습니다.".length)
console.log(" 홍길동은 부산에 있습니다. ".length)

// textarea 영역
let textarea = document.querySelector('#textarea')
let str_len = document.querySelector('.str_len')

// 이벤트 핸들러 구성
// 텍스트를 입력할 때 마다 함수를 수행 : onkeyup()  
// textarea.addEventListener('keyup', onKeyUp)  // keyup '이벤트종료시' 눌렀다 때는게 기준, '수행할 함수'    
textarea.addEventListener('keydown', onKeyUp)  // keydown '이벤트시' 입력이 들어올때마다 

// 수행할 함수 정의
function onKeyUp() {
    console.log('aaaaa')  // 되는지 확인 눌렀다 땔때마다 작동
    //입력된 글자 읽어오기
    str_len.innerText = textarea.value.length  // 입력한 문자 개수 표시
    str_len.style.color = 'blue'
}



// 공백 자르기
 // .trim() 양쪽 끝 공백만 자름

console.log('trim()','hello'.length,' hello  '.length, ' hello     '.trim().length)
const str1= 'Javascript good!!'

// 첫번째 위치 : index 0번!!

console.log( str1.indexOf('Javascript'))  // 0
console.log( str1.indexOf('script'))  // 4
console.log( str1.indexOf('python'))  // 없으면 -1 반환

if (str1.indexOf('python')<0) {
    console.log('python문자열을 포함하고 있지 않습니다.')
}
else
    console.log('찾고자하는 문자열을 포함하고 있습니다.')
console.log(str1.indexOf('as',3))  // 특정 인덱스번호 부터 검색  3     index는 0부터
console.log(str1.indexOf('ipt',3))  // 특정 인덱스번호 부터 검색  7

console.log('----')

// 정규식 표현

console.log(str1.search(/Javascript/))  // 일치하는 글자 인덱스번호 찾음   없으면 -1  
console.log(str1.search(/html/))  // 검색 실패  -1 출력     index는 0부터

console.log(str1.includes('Javascript'))  // 검색성공여부 : true/false
console.log(str1.includes('html'))  // 검색성공여부 : true/false

console.log(str1.startsWith('Java'))  // 문자열 시작 확인  해당 문자열로 시작시 true 아니면 false
console.log(str1.startsWith('html'))  // false
console.log(str1.endsWith('!!'))  // 문자열 끝 확인  해당 문자열로 끝날시 true
console.log(str1.endsWith('Java'))  //false

console.log('----')


/* 
// 특정 위치에 있는 문자열 추출
console.log('javascript'.charAt(4))  // 해당 index번호 위치에 있는 글자 표시  index는 0부터

// 검색어
const searchWordText = document.querySelector('#search-word-input')
// 지역리스트
const prefectureList = document.querySelector('#prefecture-list')

// 문자가 입력될 때마다 데이터 체크 작업 실행
searchWordText.addEventListener('keyup',()=> {
    // console.log('2222')
    // 입력한 검색어
      const searchWordText = searchWordText.value
      console.log(searchWord)

    //   if (!searchWord || searchWord='') {
    //   }

    //   prefectureList.forEach( ()=> {
    //   })
})
*/


// forEach()

const data = [10,20,30]

for (i=0; i<data.length; i++) {
    console.log(data[i])
}
// 위에거랑 같음
// 변수data에 있는 값을 순서대로 출력
data.forEach ( (item)=> {
    console.log(item)
})