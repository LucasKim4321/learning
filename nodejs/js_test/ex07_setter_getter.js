// 캡슐화 : 정보를 묶어주는 기능, 정보 은닉 기능

class SetGetClass {
    // #멤버 변수 => private 멤버 변수로 클래스내에서만 접근가능
    #myName
    constructor(value) {
        this.#myName = value
    }
    set setMyName(value) {
        this.#myName = value
    }
    get getMyName() {
        return this.#myName
    }
    
    funSetmyName(value){ // funSetMyName()메서드는 public
        this.#myName = value
        // this.myName = value  // pubic
    }
    funGetmyName(){// funGetMyName()메서드는 public
        return this.#myName
        // return this.myName   // public
    }
}

// const myInstance = new SetGetClass('길순이')
// console.log(myInstance.myName)  // 길순이 출력
// myInstance.setMyName = '동순이'
// console.log(myInstance.getMyName)  // 동순이 출력
// console.log(myInstance.myName)  // 동순이 출력


console.log('-------')
const myInstance = new SetGetClass('길순이')
myInstance.setMyName = '동순이'
console.log(myInstance.myName)  // 정의 되지 않은 변수
console.log(myInstance.getMyName)

console.log('-------')
myInstance.myName = '동길이'
console.log(myInstance.myName)  // myName정의 후 출력 가능  #myName이랑은 별개
console.log(myInstance.getMyName)

console.log('-------')
//   //멤버변수 값설정: 메서드로 통해
myInstance.funSetmyName('강감찬')
console.log(myInstance.myName)
// 멤버변수 값읽기: 메서드로 통해
console.log(myInstance.funGetmyName()) 



// // 캡슐화 : 정보묶어주는 기능, 정보은닉 기능

// class SetGetClass {
//     // #멤버변수 => private 멤버변수로 클래스내에서만 접근가능
//     #myName
//     constructor(value){
//       this.#myName = value
//       // this.myName = value  // public
//     }
  
//     setmyName(value){ // setmyName()메서드는 public
//       this.#myName = value
//       // this.myName = value  // pubic
//     }
//     getmyName(){// getmyName()메서드는 public
//       return this.#myName
//       // return this.myName   // public
//     }
  
//   }
  
//   const myInstance = new SetGetClass()
//   // console.log("1. public ")
//   // console.log(myInstance)
//   // myInstance.myName=100
//   // console.log(myInstance)
  
//   console.log("2. private => 메서드를 통해 접근 가능 ")
//   // myInstance.myName = '동순이'     // 접근 불가
//   //console.log(myInstance.myName)    // 접근 불가
  
//   //멤버변수 값설정: 메서드로 통해
//   myInstance.setmyName( "강감찬") 
//   // 멤버변수 값읽기: 메서드로 통해
//   console.log( myInstance.getmyName()  ) 