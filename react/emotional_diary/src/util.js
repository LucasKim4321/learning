// import './util.css';

import emotion1 from "./img/emotion1.png";
import emotion2 from "./img/emotion2.png";
import emotion3 from "./img/emotion3.png";
import emotion4 from "./img/emotion4.png";
import emotion5 from "./img/emotion5.png";




// 이미지 리소스 추출하는 함수
export const getEmotionImgById = (e) => {

    /*
    페이지 라우팅: 요청에 따라 적절한 페이지를 반환하는 일련의 과정
    서버 사이드(Server Side)렌더링
    클라이언트 사이드(Client Side)렌더링  - 페이지 라우팅 전용라이브러리를 이용
    */

    const targetEmotionId = String(e);

    switch (targetEmotionId) {
        case "1": return emotion1;
        case "2": return emotion2;
        case "3": return emotion3;
        case "4": return emotion4;
        case "5": return emotion5;

        default:
            return null;
    }

}

// 처음 렌더링할 때 오늘 날짜를 yyyy-mm-dd형식으로 출력
export const getFormattedDate = (targetDate)=> {
    let year = targetDate.getFullYear();
    let month = targetDate.getMonth()+1;
    let date = targetDate.getDate();

    if (month < 10) {
        month = `0${month}`
    }
    
    if (date < 10) {
        date = `0${date}`
    }
    return `${year}-${month}-${date}`;

}