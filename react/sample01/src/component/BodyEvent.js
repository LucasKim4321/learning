function BodyEvent() {

    function handleOnClick(){
        alert("버튼을 클릭하셨군요!!")
    }
    
    function handleOnClick2(e) {
        console.log(e.target.name)
    }

    return(
        <div>
            <button onClick={handleOnClick}>Event</button>
            <button name="A버튼" onClick={handleOnClick2}>A버튼</button>
            <button name="B버튼" onClick={handleOnClick2}>B버튼</button>
        </div>
    )
}

export default BodyEvent;