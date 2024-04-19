// 문자열 길이
console.log("홍길동은 부산에 있습니다.".length)
console.log(" 홍길동은 부산에 있습니다. ".length)  // 문자열 길이 측정 공백 포함

// textarea 영역
let textarea = document.querySelector('#textarea')
let str_len = document.querySelector('.str_len')

// 이벤트 핸들러 구성
// 텍스트를 입력할 때 마다 함수를 수행 : onkeyup()  
// textarea.addEventListener('keyup', onKeyUp)  // keyup '이벤트종료시' 눌렀다 때는게 기준, '수행할 함수'   1부터 체크 
textarea.addEventListener('keydown', onKeyUp)  // keydown '이벤트시' 입력이 들어올때마다    왜 인지 모르지만 0부터 체크

// 수행할 함수 정의
function onKeyUp() {
    console.log('aaaaa')  // 되는지 확인 눌렀다 땔때마다 작동
    //입력된 글자 읽어오기
    str_len.innerText = textarea.value.length  // 입력한 문자 개수 표시
    str_len.style.color = 'blue'
}



// 공백 자르기
 // .trim() 양쪽 끝 공백만 자름

console.log('trim()','hello'.length,' hello  '.length, ' hel lo  '.trim().length)  // 5, 8, 6 출력
const str1= 'Javascript good!!'

// 첫번째 위치 : index 0번!!

// 대상.indexOf('해당 글자열')의 첫번째 자리를 대상과 비교해  index 번호 표시  없으면 -1  
console.log( str1.indexOf('Javascript'))  // 0
console.log( str1.indexOf('script'))  // 4
console.log( str1.indexOf('python'))  // 없으면 -1 반환

if (str1.indexOf('python')<0) {
    console.log('python문자열을 포함하고 있지 않습니다.')
}
else {
    console.log('찾고자하는 문자열을 포함하고 있습니다.')
}

console.log(str1.indexOf('as',2))  // 특정 인덱스번호 2부터 검색  3     index는 0부터
console.log(str1.indexOf('ipt',3))  // 특정 인덱스번호 3부터 검색  7

console.log('----')

// 정규식 표현
// 대상.search(/해당 글자열/)의 첫번째 자리를 대상과 비교해  index 번호 표시  없으면 -1  
console.log(str1.search(/Javascript/))  // 일치하는 글자 인덱스번호 찾음   없으면 -1  
console.log(str1.search(/html/))  // 검색 실패  -1 출력     index는 0부터

console.log(str1.includes('Javascript'))  // 검색성공여부 : true/false
console.log(str1.includes('html'))  // false 출력

console.log(str1.startsWith('Java'))  // 문자열 시작 확인  해당 문자열로 시작시 true 아니면 false
console.log(str1.startsWith('html'))  // false
console.log(str1.endsWith('!!'))  // 문자열 끝 확인  해당 문자열로 끝날시 true
console.log(str1.endsWith('Java'))  //false

console.log('----')



// 특정 위치에 있는 문자열 추출
console.log('javascript'.charAt(4))  // 해당 index번호 위치에 있는 글자 표시  index는 0부터


//-------------------------------//
// * HTML 요소와 javascript 연결 *
//-------------------------------//


// 검색어
const searchWordText = document.querySelector('#search-word-input')  // 변수 값에 함수 대입
// 지역리스트 : button 요소만 그룹핑(배열구조)
// const prefectureList = document.querySelector('#prefecture-list button')
const prefectureList = document.querySelectorAll('#prefecture-list button')  //#prefecture-list > button  html이랑 똑같이 씀


// 문자가 입력될 때마다 데이터 체크 작업 실행
// 객체.addEventListenter (이벤트 종류, 이벤트가 발생할 경우 처리함수 호출 및 정의)
searchWordText.addEventListener('keyup', ()=> {
    // console.log('2222') 체크용
    // alert('keyup 이벤트 발생')
    // console.log(prefectureList)  체크용

    // 입력한 검색어
    const searchWord = searchWordText.value
    console.log('입력한 문자:', searchWord)
    //   console.log(searchWordText.value)
    
    // 리스트 루프 처리 => button요소를 하나씩 불러옴
    prefectureList.forEach( (btn)=> {
        // console.log(btn)

        // 검색어가 없으면 모든 요소를 표시
        if (searchWord=='' || !searchWord) {  // searchWord=='' 둘 다 같음 !searchWord
            console.log('검색어가 없음')
            // 요소.classList => add()추가, remove()삭제, toggle() 등등 가능
            // btn.classList.add('hide')  // button요소에 'hide' 클래스 추가  응용해서 실제로 숨기기 가능
            // btn.classList.remove('btn')  // 'btn' 클래스 삭제
        }

        // 태그요소 속정 중 dataset 값 불러오기
        const prefectureName = btn.dataset.name  // 변수 값에 함수 대입
        const phonetic = btn.dataset.phonetic
        // console.log(btn,prefectureName,phonetic)  // 변수 값 체크

        // 검색어와 첫 번째 글자 일치 여부에 따라 hide클래스 사용
        if ( searchWord.charAt(0) == prefectureName.charAt(0) ||  // dataset.name 값 식별 (data-name) 
            searchWord.charAt(0) == phonetic.charAt(0)) {  // dataset.phonetic 값 식별 (data-phonetic) 
            btn.classList.remove('hide')  // 버튼 표시
        }
        else {
            btn.classList.add('hide')  //버튼 숨기기
        }
    })
})


// 변수, 배열구조, 객체구조
// forEach()


const data = [10,20,30]
const data2 = 'asdf1234아야얼엵'
const data3 = {a:1,b:2,c:3,abc:4}
console.log(data,data.length,'***')  // 배열은 개수를 측정
console.log(data2,data2.length,'***')  // .length 문자열,배열구조 길이 측정  숫자열x 객체변수x
console.log(data3,data3.length,'***')  // 객체구조 길이 측정 안됨
console.log(data[0].length,'***') // 배열 내부 데이터 길이 측정 불가


console.log('-- 배열 읽기1')
console.log(data[0])
console.log(data[1])
console.log(data[2])

console.log('-- 배열 읽기2:for')
for (i=0; i<data.length; i++) {
    console.log(data[i])  // data[i]=>data[0],data[1],data[2]
}

console.log('-- 배열 읽기2:확장forEach')
// 배열객체.forEach(배열객체 안에 있는 데이터를 순차적으로 읽어서 처리)
data.forEach ( (item)=> {  // 변수data에 있는 값을 순서대로 출력  //위에거랑 같음
    console.log(item)
})
