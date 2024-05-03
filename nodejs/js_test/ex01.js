// const date = new Date()  // new Date()  프로그램 자체 내장 객체
// console.log(date)

// 사용자 정의 함수
// function a() {}
// a()


// 사용자 객체 만들기

// 1.
var Picture = new Object()  // 객체 선언 // 객체는 보통 앞글자 대문자로 하는 듯  소문자도 상관없음 
// var Picture3 = {}  // 위에거랑 같은 기능
Picture.name = '길순이'
Picture.age = 10
Picture.info = function () {
    console.log('당신의 이름은'+Picture.name+'입니다.')
}
// console.log(Picture)  // 객체 정보 출력
// console.log(Picture.name)
// console.log(Picture.age)
// console.log(Picture.info)
// Picture.info()  // 객체안에 함수를 불러옴

// 2.리터럴 방식으로 객체 만들기
var Picture2 = { name:'강감찬', age:15,
info:function(){console.log('당신의 이름은'+this.name+'입니다.')},  //this는 
info2:function(name,age){console.log('당신의 이름은 '+name+' 나이는 '+age+'살입니다.')},
}
console.log(Picture2)  // 객체 정보 출력
// console.log(Picture2.name)
// console.log(Picture2.age)
// console.log(Picture2.info)
Picture2.info()  // 객체안에 함수를 불러옴
Picture2.info2('홍길동',20)  // 당신의 이름은 홍길동 나이는20입니다. 출력
console.log(typeof(Picture2))

var Student = {
    name: '홍길동',
    kor: 100,
    mat: 50,
    eng: 100,
    tot: function(){
        return this.kor+this.mat+this.eng
    },
    avg: function(){
        return (this.kor+this.mat+this.eng)/3
    },
}
console.log('학생이름:', Student.name)
console.log('총첨:', Student.tot())
console.log('평균:', Student.avg().toFixed(2))  // toFixed(2)소수점 둘째자리에서 자름


// 객체 생성자 함수 : 객체 초기치 설정할 때 사용
// 객체 생성 시점에 1번 수행하는 함수
function Person(name,age,weight) {
    this.userName = name,  // this를 받는 순간 함수가 객체가 됨
    this.userAge = age,
    this.userWeight= weight
}
Person.prototype.info = function() {  // prototype 객체를 여러개 생성해도 공동으로 쓰는 함수를 선언
    console.log(`이름: ${this.userName}, 나이:${this.userAge}, 몸무게:${this.userWeight}`)  //  \는 한줄로 인식하게 만듬
}
var jang = new Person('강감찬',180,80)
console.log(jang)
jang.info()

var lee = new Person('이순신',177,77)
console.log(lee)
jang.info()

// var a
// a = 10

// var b = 0  // 변수 초기화
// var arr1 = new Arrray()
// arr1[0] = 10

// var arr2 = [1,2,3]  // 배열 초기화
// var obj1 = {a:1,b:2,c:3}  // 객체 초기화
// new Date(), new Date(20,11,3)




// var Picture3 = [1,2,'3','동길이',1>2,function(name){console.log('당신의 이름은'+name+'입니다.')}]
// console.log(Picture3)
// Picture3[5]('홍길동')
// console.log(typeof(Picture3))