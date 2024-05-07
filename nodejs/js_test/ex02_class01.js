// 클래스 = 멤버변수 + 함수(메서드) 구성
// - 사용자가 정의한 자료형 타입

// 카멜 케이스 표기 - 클래스명
class MyClass {
    // // 1. 생성자
    // constructor() {
    //     console.log('클래스 생성될 때 1번 수행됩니다.')
    // }

    // // 2. 인자가 있는 생성자
    // constructor(name,age) {
    //     console.log(name,age)
    // }

    // // 3. 생성자로 멤버 변수 정의
    // constructor() {
    //     // 멤버 변수 선언
    //     this.MyName = '사자'
    //     this.age = 10
    // }

    // 4. 인자가 있는 생성자로 멤버 변수 정의
    constructor(name='강감찬',age=1) {  // 초기값 선언 가능  넘어온 인자값이 없으면 초기값 대입
        // 멤버 변수 선언 및 외부에서 전달받은 값으로 초기화
        this.MyName = name
        this.age = age
    }
}
// const obj1 = new MyClass() // 인자 없는 생성자
// console.log(obj1)
// const obj2 = new MyClass('여우',20)  // 인자 있는 생성자
// console.log(obj2)  //  MyClass{} 출력
// const obj3 = new MyClass()
// console.log(obj3)
const obj4 = new MyClass()
console.log(obj4)

// 클래스 선언 => 자료의 구조 설계
// 클래스 타입으로 구성된 실제 기억 장소(객체) 사용하려면 => new 연산자 사용
// 클래스 -> 결과 -> 인스턴스화(객체)