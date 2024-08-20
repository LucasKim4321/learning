console.log("/js/upload.js....")

// ----------------------------------------------- //
// server에 파일 upload 처리 : axios(비동기) 요청 테스트
// ----------------------------------------------- //

async function uploadToServer(formObj) {
    console.log(formObj);

    // 서버쪽에 "/upload" 요청 받으면
    // UpDownController에서  RestAPI형식으로 요청한 url 분석하여 실제 업로드
    const response = await axios({
        method: 'post',
        url: '/upload',
        data: formObj,
        headers: {
            'Content-Type': 'multipart/form-data'  // 타입은 첨부파일 여러개
        }

        /*
        'Content-Type': 'multipart/form-data' 설정:
        multipart/form-data는 파일 업로드 시 기본적으로 설정되는 타입입니다.
        axios가 FormData 객체를 감지하면, 자동으로 Content-Type을 설정해 줍니다.
        따라서 이 설정은 생략해도 됩니다. by ChatGPT4
        */

    }) // end axios

    return response.data

} // end function


// ----------------------------------------------- //
// server에 파일 upload 파일 삭제 처리 : axios(비동기) 요청 테스트
// ----------------------------------------------- //

async function removeFileToServer(uuid, fileName) {
    const response = await axios.delete(`/remove/${uuid}_${fileName}`)

    return response.data

} // end function