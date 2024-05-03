// 클래스 = 멤버변수 + 함수(메서드) 구성
// - 사용자가 정의한 자료형 타입

// 카멜 케이스 표기 - 클래스명
class MyClass {
    // 생성자
    // constructor() {
    //     console.log('클래스 생성될 때 1번 수행됩니다.')
    // }

    // 인자가 있는 생성자
    constructor(name,age) {
        console.log(name,age)
    }
}
// const obj1 = new MyClass()
const obj2 = new MyClass('여우',20)