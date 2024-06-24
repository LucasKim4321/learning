import {useParams, useSearchParams} from "react-router-dom";

const Diary = ()=> {
    // const params = useParams();
    // console.log("Dairy 컴포넌트 URL 파라미터 값 가져오기:",params)

    // http://localhost:3000/diary/100?name=Kim&age=20

    const {id} = useParams();  // url path에 설정된 
    const [searchParams, setSearchParams] = useSearchParams();

    const name = searchParams.get("name");
    const age = searchParams.get("age");
    const message = searchParams.get("message");

    console.log("Dairy 컴포넌트 URL 파라미터 값 가져오기:",id)
    console.log("쿼리 스트링 값 추출하기: ", searchParams.get("name"))
    console.log("쿼리 스트링 값 추출하기: ", searchParams.get("age"))

    return (
        <div>
            <div>{id}번 일기</div>
            <div>{name}님, {age}세</div>
            <div>Diray 페이지입니다.</div>
            <div>Message: {message}</div>
        </div>
    )
}

export default Diary;