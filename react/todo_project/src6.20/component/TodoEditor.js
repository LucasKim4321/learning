import './TodoEditor.css';
import {useState, useRef} from 'react';

const TodoEditor = ({onCreate})=> {
/* 
    ref prop
    React의 ref prop은 HTML 엘리먼트의 레퍼런스를 변수에 저장하기 위해서 사용합니다.

    예를 들어, 다음과 같이 <input> 엘리먼트에 ref prop으로 inputRef라는 변수를 넘기게 되면, 
    우리는 이 inputRef 객체의 current 속성을 통해서 <input> 엘리먼트에 접근할 수 있고, DOM API를 이용하여 제어할 수 있습니다.
*/
    const [content, setContent] = useState("");
    const inputRef = useRef();
    // inputRef = document.querySelector('#input1')와 유사 방식

    // input에 입력시 동작
    const onChangeContent = (e)=> {
        setContent(e.target.value)  // input의 현재 value값을 content에 저장

        // console.log(content)  // 바뀌기전 값이 보이지만 setContent는 정상 작동했음
        console.log(e.target.value)
    }

    // 추가버튼 동작
    const onSubmit = ()=> {
        if (!content) {  // content값이 없으면
            inputRef.current.focus();  // inputRef가 들어있는 입력창(inputRef.current) 활성화(focus)
            inputRef.current.placeholder = "새로운 Todo를 입력해주세요 ~";
            return;
        }
        onCreate(content);  // 아이템 추가 : 입력창의 value 값을 아이템리스트에 추가
        setContent("");  // 입력란 초기화
    }
    const onKeyDown = (e)=> {
        if (e.keyCode == 13) {
            onSubmit();
        }
    }

    return(
        <div className="TodoEditor border border-danger-subtle p-2 rounded-2">
            <h4 className="m-0">새로운 Todo 작성하기!! 💕</h4>
            <div className="edit_wrapper">
                <input 
                type="search"
                placeholder="새로운 Todo..."
                value={content}
                onChange={onChangeContent}
                onKeyDown={onKeyDown}
                ref={inputRef}
                />
                <button onClick={onSubmit}>추가</button>
            </div>
        </div>
    );
};

export default TodoEditor;


// import './TodoEditor.css';
// import {useState, useRef, useReducer} from 'react';


// function reducer (content,action) {
//     switch (action.type) {
//         case "onChangeContent":
//             return content = action.data.target.value;
//         case "onKeyDown":
//             if (action.data.keyCode == 13) {
//                 // onSubmit();
//             }
//             return;
//         case "onSubmit":
//             if (!content) {  // content값이 없으면
//                 action.data.current.focus();  // inputRef가 들어있는 입력창(inputRef.current) 활성화(focus)
//                 action.data.current.placeholder = "새로운 Todo를 입력해주세요 ~";
//                 return;
//             }
//             // onCreate(content);  // 아이템 추가 : 입력창의 value 값을 아이템리스트에 추가
//             // setContent("");  // 입력란 초기화

//     }
// }

// // function reducer2 (inputRef,action) {
    
// //     switch (action.type) {
// //         case "onSubmit":
// //             if (!content) {  // content값이 없으면
// //                 action.data.current.focus();  // inputRef가 들어있는 입력창(inputRef.current) 활성화(focus)
// //                 action.data.current.placeholder = "새로운 Todo를 입력해주세요 ~";
// //                 return;
// //             }
// //             // onCreate(content);  // 아이템 추가 : 입력창의 value 값을 아이템리스트에 추가
// //             // setContent("");  // 입력란 초기화
// //     }
// // }
// const TodoEditor = ({onCreate})=> {
//     const [content, dispatch] = useReducer (reducer, "");
//     // const [inputRef, dispath2] = useReducer (reducer2, "");
// /* 
//     ref prop
//     React의 ref prop은 HTML 엘리먼트의 레퍼런스를 변수에 저장하기 위해서 사용합니다.

//     예를 들어, 다음과 같이 <input> 엘리먼트에 ref prop으로 inputRef라는 변수를 넘기게 되면, 
//     우리는 이 inputRef 객체의 current 속성을 통해서 <input> 엘리먼트에 접근할 수 있고, DOM API를 이용하여 제어할 수 있습니다.
// */
//     // const [content, setContent] = useState("");
//     const inputRef = useRef();
//     // inputRef = document.querySelector('#input1')와 유사 방식

//     // input에 입력시 동작
//     // const onChangeContent = (e)=> {
//     //     setContent(e.target.value)  // input의 현재 value값을 content에 저장

//     //     // console.log(content)  // 바뀌기전 값이 보이지만 setContent는 정상 작동했음
//     //     console.log(e.target.value)
//     // }

//     // 추가버튼 동작
//     // const onSubmit = ()=> {
//     //     if (!content) {  // content값이 없으면
//     //         inputRef.current.focus();  // inputRef가 들어있는 입력창(inputRef.current) 활성화(focus)
//     //         inputRef.current.placeholder = "새로운 Todo를 입력해주세요 ~";
//     //         return;
//     //     }
//     //     onCreate(content);  // 아이템 추가 : 입력창의 value 값을 아이템리스트에 추가
//     //     setContent("");  // 입력란 초기화
//     }
//     // const onKeyDown = (e)=> {
//     //     if (e.keyCode == 13) {
//     //         onSubmit();
//     //     }
//     // }

//     return(
//         <div className="TodoEditor border border-danger-subtle p-2 rounded-2">
//             <h4 className="m-0">새로운 Todo 작성하기!! 💕</h4>
//             <div className="edit_wrapper">
//                 <input 
//                 type="search"
//                 placeholder="새로운 Todo..."
//                 value={content}
//                 // onChange={onChangeContent}
//                 onChange={(e)=> dispatch({type:"onChangeContent", data:e})}
//                 // onKeyDown={onKeyDown}
//                 onKeyDown={(e)=> dispatch({type:"onKeyDown", data:e})}
//                 ref={inputRef}
//                 />
//                 {/* <button onClick={onSubmit}>추가</button> */}
//                 <button onClick={()=> dispatch({type:"onSubmit", data:inputRef})}>추가</button>
//             </div>
//         </div>
//     );
// };

// export default TodoEditor;