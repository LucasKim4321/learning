import {Routes, Route} from "react-router-dom";
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';

// 이미지 불러오기
import { getEmotionImgById } from './util';
import emotion5 from './img/emotion5.png';

// 라우팅 할 페이지 가져오기
import Home from "./pages/Home";
import New from "./pages/New";
import Diary from "./pages/Diary";
import Edit from './pages/Edit';

function App() {
  return (
    <div className="App myStyle">
      <div className="container border border-warning rounded-4 mt-5">
        <div className="contents">
          <h3 className='title border border-warning-subtle rounded-4 text-center my-5 p-3'>감정일기장 프로젝트</h3>
          <div>
            <img src={emotion5}/>
            <img src={getEmotionImgById(1)}/>
            <img src={getEmotionImgById(2)}/>
          </div>
          {/* path 설정 */}
          <Routes>
            <Route path="/" element= {<Home/>} />
            <Route path="/new" element= {<New/>} />
            {/* 동적 경로 설정 */}
            {/* :id 하면 해당 자리에 다른 값이 입력되면 해당 페이지에서 읽음 */}
            <Route path="/diary/:id" element= {<Diary/>} />
            <Route path="/edit" element= {<Edit/>} />
          </Routes>
        </div>
      </div>
    </div>
  );
}

export default App;

//  cd./emotional_diary


// <header className="App-header">
// <h3 className='title border border-warning-subtle rounded-4 text-center my-5 p-3'>감정일기장 프로젝트</h3>
// <div>
// {/* <img alt="감정1" src={emotion2}/> */}
// <hr/>
//   <img alt="감정1" src={getEmotionImgById(1)}/>
//   <img alt="감정2" src={getEmotionImgById(2)}/>
//   <img alt="감정3" src={getEmotionImgById(3)}/>
//   <img alt="감정4" src={getEmotionImgById(4)}/>
//   <img alt="감정5" src={getEmotionImgById(5)}/>
// </div>
// </header>