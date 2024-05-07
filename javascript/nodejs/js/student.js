// 김태진

let object = {
    name:'홍길동',
    kor:100,
    eng:100,
    mat:100,
    tot:function(){return this.kor+this.eng+this.mat},
    avg:function(){return this.tot()/3},
    result:function(){console.log(`이름:${this.name}, 총점:${this.tot()}, 평균:${this.avg()}`)}
}
// console.log(object.tot())
// console.log(object.avg())
object.result()