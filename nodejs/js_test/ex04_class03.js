// 클래스에서 메소드 사용하기
class MyClass {
    constructor() {
        this.name = '홍길순'
    }
    myNamePrn() {
        console.log('이름:'+this.name)
    }
}

const obj1 = new MyClass()
console.log(obj1)
console.log(obj1.name)
obj1.myNamePrn()

class Student {
    constructor(name='',kor,mat,eng) {
         // '#멤버변수=>private' 외부에서 임의로 데이터 입력 안되게 할 수있는데 안됨 this._name
        this.name = name
        this.kor = kor
        this.mat = mat
        this.eng = eng
        this.tot = 0
        this.avg = 0.0
    }
    // 총점 계산하는 함수 정의
    totMethod(){
        return this.tot = this.kor+this.mat+this.eng
    }
    avgMethod(){
        // this.avg = (this.kor+this.mat+this.eng)/3
        return this.avg = this.tot/3
    }
    scoreInfo() {
        console.log(`이름: ${this.name}, 평균:${this.avg}`)
    }
}
const obj2 = new Student('홍길순',100,90,80)
console.log('계산전:',obj2)
console.log(obj2.totMethod())
console.log(obj2.avgMethod())  // totMethod() 함수 실행 전까진 기본값 0 출력
obj2.scoreInfo()  //avgMethod() 함수 실행전까진 기본값
console.log('성적 계산후:',obj2)  // 함수 실행 후 바뀐 값 들어있음 
obj2.name = '동길이'  
console.log(obj2)