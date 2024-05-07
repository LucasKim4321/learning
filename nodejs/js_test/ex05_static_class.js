// 인스턴스 생성 없이 메소드 호출
class myStatic {
    static method() {
        console.log('정적 메소드....')
    }
    static myName(firstName, familyName) {
        return (`${firstName} ${familyName}`)
    }
    // constructor () {
    //     console.log('1233123123')
    // }
}

// 생략 => const obj1 = new myStatic()
// const obj1 = new myStatic()
// console.log(obj1)  // 생성자 constructor내용만 출력.  맴버 변수 없어서 myStatic{} 출력

console.log('1. static')
myStatic.method()
console.log(myStatic.myName('그레고리','포터'))
