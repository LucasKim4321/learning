// import : 외부 모듈 가져오기
// import {PI, getArea, getCircumference} from './ex01/m_circle.js'
// console.log(PI, getArea(1),getCircumference(1))

// export default 기본값으로 내보내기 -> 다른 이름으로 붙여도 됨.
import circle from './ex01/m_circle.js'  // default
console.log(circle.getArea(1),circle.getCircumference(1))

// 다운받은 외부 라이브러리 호출  npmjs.comn  maven
import lodash from "lodash"
const arr = [1,1,1,2,2,2,1,1,4,4,3,2]
const uniqueArr = lodash.uniqBy(arr)
console.log(uniqueArr)
// export default {getArea,getCircumference}  // 기본값으로 내보내기