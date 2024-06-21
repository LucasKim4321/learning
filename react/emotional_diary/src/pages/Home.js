import { useSearchParams } from "react-router-dom";
import './Home.css';
import Button from "../component/Button"

// 쿼리스트링을 이용할 경우 : useSearchParams()
// http://localhost:3000/?name=hong&age=30&addr=부산

const Home = ()=> {

    const [searchParams, setSearchParams] = useSearchParams();

    console.log("searchParams.get():", searchParams.get("name"))
    console.log("searchParams.get():", searchParams.get("age"))
    console.log("searchParams.get():", searchParams.get("addr"))
    console.log("searchParams.get():", searchParams.get("sort"))

    return (
        <div>
            <Button
                text={"기본버튼"}
                onClick={()=>{alert("하이!!!")}}/>
                
            <Button
                text={"danger"}
                type={"danger"}
                onClick={()=>{alert("danger!!!")}}/>
                
            <Button
                text={"warning"}
                type={"warning"}
                onClick={()=>{alert("warning!!!")}}/>
                
            <Button
                text={"primary"}
                type={"primary"}
                onClick={()=>{alert("primary!!!")}}/>
            <div>Home 페이지</div>
        </div>
    )
}
export default Home;