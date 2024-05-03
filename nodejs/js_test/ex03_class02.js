// API 통신 결과  (API 통신받은 데이터에 대한 구조 및 사용법?)
class ApiResultData {  // 데이터를 구성할 수 있는 구조
    constructor() {
        this.result;  // 구버전과 ; 호환성 때문에 (안해도 됨)
        this.errorMessage;
        this.userName;
        this.age
    }
}

// response 데이터 변환
function parseData(response) {
    const apiResultData = new ApiResultData()
    console.log('response=>',response)

    apiResultData.result = response.result
    apiResultData.errorMessage = response.error_message
    apiResultData.userName = response.user_name
    apiResultData.age = response.age

    // console.log(apiResultData)
    console.log(apiResultData.userName,apiResultData.age)
}

const apiResponse = {
    result: true,
    user_name: '강감찬',
    age: 10,
    error_message:'정상처리됨.'
}

// 데이터 구조 확인
// console.log(apiResultData)
// 함수 호출(실행)
parseData(apiResponse)