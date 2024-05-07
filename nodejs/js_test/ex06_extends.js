// 상위클래스(부모클래스, 슈퍼클래스)
class MyParent {
    parentMethod() {
        console.log('MyParent : 부모클래스')
    }
}

// 자식클래스 : 부모클래스로부터 상속받은 클래스
class MyChild extends MyParent {
    childMethod() {
        console.log('MyChild : 부모클래스로부터 상속 받은 자식클래스')
    }
}

// const parent = new MyParent()
// console.log(parent.parentMethod())  // 함수 출력 후 console.log 중첩으로 인한 undefined 출력
// parent.parentMethod()
// const child = new MyChild()
// child.parentMethod()  // 부모 클래스에서 상속 받은 함수 출력 가능
// child.childMethod()

class Person {
    constructor (name, age) {  // 객체가 생성될 때 멤버 변수 초기화
        this.name = name;
        this.age = age;
        console.log('부모 생성자 호출')
    }
    sayHello() {
        console.log(`이름: ${this.name}, 나: ${this.age}`)
    }
}

class Student extends Person {
    constructor (name,age,grade) {
        super(name,age)  // 부모 클래스에 있는 멤버 변수는 부모생성자에서 초기화 작업    상속 받고 초기화 안해주면 에러남
        this.grade = grade
        console.log('자식 생성자 호출')
    }
    sayStudent() {
        // console.log(this.name, this.age, this.grade)
    }
}

console.log('부모Person------')
const person = new Person('길순이',15)
console.log(person.name, person.age)
person.sayHello()

console.log('자식Student------')
const student = new Student('동길이',18,95)
console.log(student)
student.sayHello()
student.sayStudent()

person.sayHello()
