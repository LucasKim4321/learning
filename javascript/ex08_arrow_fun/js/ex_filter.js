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


// 유사 배열 => 배열 전환
const allDiv= document.querySelectorAll('.spread_box > div')
console.log('div개수:', allDiv.length)
for (let el of allDiv) {
    console.log (el)
}
console.log (allDiv)
console.log (allDiv[0])
// Error: allDiv.filter is not a function (유사 배열 관계로 .filter()함수 지원안됨)
// const filter_ex = allDiv.filter( (element)=> element.classList.contains('on'))  // 안됨

// 스프레드연산(...): 유사배열 -> 배열 전환
const filter_arr = [...allDiv]
console.log(filter_arr)
const filter_ex = filter_arr.filter( (element)=> element.classList.contains('on'))
console.log(filter_ex)

const myString = '안녕하세요'
console.log([...myString])  // 일시적으로 배열로바꿈
console.log (myString)  

const newString = [...myString].map( (ch)=> `${ch}!!`)
console.log(newString)

const newString2 = newString.reduce( (a,b)=> a+b)
console.log(newString2)

console.log('---')  // 유사배열 -> 배열 -> map() -> reduce() -> 최종 배열
const str1= [...myString].map( (ch)=> `${ch}!`).reduce ( (a,b)=> a+b)
console.log('배열.map().reduce()=>', str1)