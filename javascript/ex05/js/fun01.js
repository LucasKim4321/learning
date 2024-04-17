// 독립된 단위 프로그램
// 함수 호출


// numberPrint()
// numberPrint()
// numberPrint2(10,15)
// numberPrint2(100,105)
let result=sum(100,200)
console.log(result)

// 함수 정의  //독립된 기억 장소 사용 //함수 종료시 데이터 사라짐


// 1. 인자가 없는 함수
function numberPrint() {
    for (i=1; i<=3; i++) {
        console.log(i)
    }
}


// 2. 인자가 있는 함수
// let start=prompt("start","")
// let end=prompt("end","")
// numberPrint2(start,end)
function numberPrint2(start, end) {
    for (i=start; i<=end; i++) {
        console.log(i)
        document.write(`${i}<br>`)
    }
}


// 3. 인자가 있고, 반환 값이 있는 함수
// let num1=prompt("num1","")
// let num2=prompt("num2","")
// let result=sum(num1,num2)
// document.write(result)
function sum(num1,num2) {
    return (num1+num2)
}


// 4. 가변 인자   ...values 인자 갯수 무제한
function calcSum(...values) {  // 배열구조=>values[0],values[1],values[2],...
    // for(i=0; i<values.length; i++){ //아래거랑 같음
    //     console.log(values[i])
    // }
    for (const value of values) { //values값을 순차적으로 하나씩 꺼집어내어 value저장
        console.log(value)
    }
}

// calcSum(10)
// calcSum(10,20)
// calcSum(10,20,30)
// calcSum(10,20,30,40)