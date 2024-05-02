// 김태진

let array = { name:'홍길동', kor:100, eng:100, mat:100}
calculater()
function calculater() {
    let tot = array.kor+array.eng+array.mat
    let avg = tot/3
    console.log(`결과값 : 이름 : ${array.name}, 총점 : ${tot}, 평균 : ${avg}`)
}