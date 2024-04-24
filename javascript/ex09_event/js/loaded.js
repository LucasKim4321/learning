
// DOM액세스 타이밍 처리 실행
// DOMContentLoaded : 페이지가 표시되는 시잠
// 'load' : 페이지 내 모든 리소스(사진, 사운드, 동영상 등등) 로딩이 다 된 후 발생
// window.addEventListener('DOMContentLoaded', ()=>{
//     const boxes = document.querySelectorAll('.box')  // All을 쓰면 불러온 값 전부 배열로 저장
//     const btn = document.querySelector('.btn')
//     const result = document.querySelector('.result')
//     console.log (boxes, boxes.length)

//     btn.addEventListener('click', ()=> {
//         result.textContent = `${boxes.length}개 입니다!`
//     })
// })

const boxes = document.querySelectorAll('.box')  // All을 쓰면 불러온 값 전부 배열로 저장
const btn = document.querySelector('.btn')
const result = document.querySelector('.result')
console.log (boxes, boxes.length)

btn.addEventListener('click', ()=> {
    result.textContent = `${boxes.length}개 입니다!`
})


