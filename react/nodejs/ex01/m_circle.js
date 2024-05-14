// export : 내보내기
export const PI = 3.14159;  // 따로 따로 export

function getArea(radius) {
    return PI*radius*radius
}
function getCircumference(radius) {
    return 2*PI*radius
}
console.log(PI)
console.log(getArea(3))

// export {getArea,getCircumference}  //  한꺼번에 export
export default {getArea,getCircumference}  // 기본값으로 내보내기