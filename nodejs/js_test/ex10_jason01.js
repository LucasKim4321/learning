// JSON은 범용적인 데이터 형식
// {
//     "age":40,
//     "grade":4,
//     "classes":[
//         {"name":'홍길동','address':'bussan'},
//         {"name":'홍길동','address':'bussan'},...
//     ]
// }


// 서버쪽에서 클라이언트에게 넘길때 사용
// const data = {name:"길순이",age:20}  //자바 스크립트에서만 통용
const data = `{"name":"길순이","age":20}`  // '는 안됨
console.log('JSON형식의 문자열',data)

// 문자열을 JSON(객체)으로 전환
const info = JSON.parse(data)
console.log('문자열을 JSON으로 전환 => JSON객체:',info)
console.log(info.name, info.age)

// JSON객체 => 문자열 전환
const info_string = JSON.stringify(info)
console.log('JSON객체 => 문자열 전환',info_string)

console.log("---JSON 커스터마이징")
const obj = {
    pref : 'seoul',
    flag:true,
    apple:100,
    orange:100
}
const replacer = (key, value)=> {
    if (typeof value === 'number') {
        return undefined;
    }
    return value
}
str1 = JSON.stringify(obj)  // JSON객체 => 문자열 전환
console.log('obj:',obj)
console.log('str1:',str1)
str2 = JSON.stringify(obj,replacer,' ')
console.log('str2:',str2)