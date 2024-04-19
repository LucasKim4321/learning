// 문자열 다루기 : 위치 지정하여 선택하기

console.log('javascript'.slice(3,8))  // '문자열'.slice(n,n2) 문자열 n번째에서 시작해서 n2번째까지 자름
console.log('javascript'.slice(0))  // 0번째부터 나옴
console.log('javascript'.slice(4))  // 4번째부터 나옴
console.log('javascript'.substring(3,8))  // .slice랑 똑같음  다른 기능도 있을 듯?
console.log('javascript'.substring(0))  // 0번째부터 나옴

// 시작>마지막 : 음수 인식
console.log('javascript'.slice(3,-1))  // 음수 허용 3 ~ 끝에서-1
console.log('javascript'.substring(3,-1))  // 0 ~ 3
console.log('javascript'.slice(-6,9))  // 음수는 끝에서 부터 몇 번째인지 4 ~ 9
console.log('javascript'.substr(3,4))  // (시작번호, 개수) 편함

// 문자열 변환
console.log ('image1.png'.replace('1.png','2.png'))  // image2.png 출력
const inputText = '홍길\t동\n홍\'길\\순'  // \기능 : 문자열 내에서 기능 : \n 엔터 \t 탭 \' '출력 ...
console.log(inputText)
console.log(inputText.replace('\n',''))  // replace 할 대상 \n의 교체 값 (빈자리)로 대체
var name = '\n홍길동 홍길순 동길이 동길홍'
// var name1 = name.replace(' ','')
// var name2 = name.replace(' ',',')
var name1 = name.replaceAll(' ','')
var name2 = name.replaceAll(' ',',')
console.log(name, name1, name2)
var tel = '010-1111-2222'
var tel_number = tel.replace(/-/g,'')  // 정규식 표현  (/대상/g(전체), '교체값')
console.log(tel_number)  // 변수 tel 값 010-1234-5678에서 값-를 전부 다 뺀 결과 출력


// ex1) 텍스트 영역에 입력한 전화번호의 하이픈(-)을 제거한 내용을 표시하기

document.querySelector('#sendBtn').addEventListener('click', ()=> {
    // alert('click')  // 체크

    // html에서 tel input요소의 값 읽기
    const tel = document.querySelector('#tel').value
    console.log(tel) // 체크

    // // 전화번호에서 '-'제거
    const tel_number = tel.replace(/-/g, '')  // '-'기호 제거
    alert(`전화번호는 ${tel_number} 입니다.`)
})