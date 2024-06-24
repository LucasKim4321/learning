import { useSearchParams } from "react-router-dom";

import './Home.css';

import Header from '../component/Header.js';
import Button from "../component/Button";
import Editor from "../component/Editor";

// 쿼리스트링을 이용할 경우 : useSearchParams()
// http://localhost:3000/?name=hong&age=30&addr=부산

// const onSubmitSend = ()=> {
//     alert("작성완료 버튼 클릭")
// }


const Home = ()=> {

    const [searchParams, setSearchParams] = useSearchParams();

    console.log("searchParams.get():", searchParams.get("name"))
    console.log("searchParams.get():", searchParams.get("age"))
    console.log("searchParams.get():", searchParams.get("addr"))
    console.log("searchParams.get():", searchParams.get("sort"))

    return (
        <div>
            <Header
                title={"Home"}
                leftChild={
                    <Button
                            text={"긍정버튼"}
                            onClick={()=>{alert("하이!!!")}}/>
                        }
                        
                rightChild={
                    <Button
                        text={"danger"}
                        type={"danger"}
                        onClick={()=>{alert("danger!!!")}}/>
                        }
            />
                {/* <Button
                    text={"warning"}
                    type={"warning"}
                    onClick={()=>{alert("warning!!!")}}/>
                    
                <Button
                    text={"primary"}
                    type={"primary"}
                    onClick={()=>{alert("primary!!!")}}/>
                    <div>Home 페이지</div> */}
            <Editor onSubmit={
                ()=>{alert("작성완료 버튼 클릭")}
                // onSubmitSend()
                }/>
        </div>
    )
}
export default Home;