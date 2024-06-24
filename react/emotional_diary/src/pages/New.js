import Header from '../component/Header.js';
import Button from "../component/Button.js";

const New = ()=> {
    return (
    <div>
        <Header
            title={"Home"}
            leftChild={
                <Button
                    text={"뒤로가기"}
                    onClick={()=>{alert("뒤로가기!!!")}}/>
                }
                    
            rightChild={
                <Button
                    text={"삭제하기"}
                    type={"danger"}
                    onClick={()=>{alert("삭제하기!!!")}}/>
                    }
        >
        </Header>
    </div>
    )
}

export default New;
