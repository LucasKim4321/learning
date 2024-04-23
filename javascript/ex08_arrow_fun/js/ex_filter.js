// 데이터
const userDataList = [
    { name: '홍길동', age: 18},
    { name: '동길이', age: 15},
    { name: '홍길순', age: 27},
    { name: '강감찬', age: 32},
    { name: '이순신', age: 41},
    { name: '곰돌이', age: 51}
]
// console.log (userDataList)

// 버튼 요소에 이벤트 등록
document.querySelectorAll('.button').forEach( (btn)=> {
    // console.log(btn)
    // btn.classList.add('abcd')  // 클래스 추가
    btn.addEventListener('click', (e)=> {
        console.log(e)  // 실제 클릭한 버턴의 객체 정보 출력
        // alert('버튼 클릭:'+ e.target.dataset.age)  // +대신 ,넣으면 동작안함

        // 클릭한 버튼의 요소
        const button = e.target
        // 버튼 요소에서 data-age속성 가져오기
        const targetAge = button.dataset.age

        // 조건 처리
        const filterList = userDataList.filter( (data)=> data.age >= targetAge)
        console.log('조건처리 결과:', filterList)  // ,대신 +넣으면 동작안함

        filterList.forEach( (item)=> {
            console.log(item.name, item.age)

        })
        // 결과 값 웹문서 출력
        updataList(filterList)
    })
})

// 결과값을 출력하는 함수 정의
function updataList(filterList) {
    let result = ''
    for ( const data of filterList) {
        console.log(data)
        result += `<li>${data.name} : ${data.age}</li>`
    }  // end for
    document.querySelector('.user_list').innerHTML = result
}