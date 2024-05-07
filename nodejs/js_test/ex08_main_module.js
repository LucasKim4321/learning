// 가져오는 모듈 : import  // node에선 따로 설정 해줘야함


// 파일에 있는 모듈 가져오기
import {MyClass1} from './ex08_module01.js'

// 파일내에 특정 모듈 가져오기
import {MyClass2, PI,myObj,myPrn,myPrn2} from './ex08_module02.js'

// 파일내에 모든 모듈 가져오기, 별칭 부여
import * as m from './ex08_module02.js'


// MyClass1 메소드로 문자열 가져오기
// const message1 = new MyClass1()
// message1.myMethod1()

// const message1 = new MyClass1().myMethod1()
// console.log('module01.js: MyClass1 myMethod1()=>', message1)


// const obj = new MyClass2()
// console.log('module02.js: MyClass2 myMethod2()=>', obj.myMethod2())

console.log('PI=', PI)
console.log('myObj=',myObj, myObj.name, myObj.age)
myPrn()
myPrn2('홍길동',12)

// 별칭일 경우
console.log('PI=', m.PI)
console.log('myObj=',m.myObj, m.myObj.name, m.myObj.age)
m.myPrn()


