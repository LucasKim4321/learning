const Controller = ({handleSetCount2}) => {
    return(
        <div className="controller">
            <button className="btn btn-outline-danger" onClick={()=>handleSetCount2(-1)}>-1</button>
            <button className="btn btn-outline-danger" onClick={()=>handleSetCount2(-10)}>-10</button>
            <button className="btn btn-outline-danger" onClick={()=>handleSetCount2(-100)}>-100</button>
            <button className="btn btn-outline-danger" onClick={()=>handleSetCount2(+100)}>+100</button>
            <button className="btn btn-outline-danger" onClick={()=>handleSetCount2(+10)}>+10</button>
            <button className="btn btn-outline-danger" onClick={()=>handleSetCount2(+1)}>+1</button>
        </div>
    );
}

export default Controller;