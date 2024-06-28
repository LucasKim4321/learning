// import './util.css';

import emotion1 from "./img/emotion1.png";
import emotion2 from "./img/emotion2.png";
import emotion3 from "./img/emotion3.png";
import emotion4 from "./img/emotion4.png";
import emotion5 from "./img/emotion5.png";




// 이미지 리소스 추출하는 함수
export const getEmotionImgById = (emotionId) => {

    /*
    페이지 라우팅: 요청에 따라 적절한 페이지를 반환하는 일련의 과정
    서버 사이드(Server Side)렌더링
    클라이언트 사이드(Client Side)렌더링  - 페이지 라우팅 전용라이브러리를 이용
    */

    const targetEmotionId = String(emotionId);

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

export const emotionList = [
    {id:1, name:"완전 좋음",img: getEmotionImgById(1)},
    {id:2, name:"좋음",img: getEmotionImgById(2)},
    {id:3, name:"그저그럼",img: getEmotionImgById(3)},
    {id:4, name:"나쁨",img: getEmotionImgById(4)},
    {id:5, name:"끔찍함",img: getEmotionImgById(5)},
]


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
    // console.log(year, month, date)
    return `${year}-${month}-${date}`;

}

// 날짜의 범위
export const getMonthRangeByDate = (date)=> {
    // 시작 시간
    const beginTimeStamp = new Date(date.getFullYear(), date.getMonth(), 1).getTime();

    // 이달의 가장 늦은 시간 0일 23시 59분 59초
    const endTimeStamp = new Date(date.getFullYear(), date.getMonth()+1, 0,23,59,59).getTime();

    return {beginTimeStamp, endTimeStamp}
}