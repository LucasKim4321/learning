import {Routes, Route} from "react-router-dom";
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';

// import { getEmotionImgById } from './util';

// 라우팅 할 페이지
import Home from "./pages/Home";
import New from "./pages/New";
import Diary from "./pages/Diary";
import Edit from './pages/Edit';

function App() {
  return (
    <div className="App myStyle">
      <div className="container border border-warning rounded-4 mt-5">
      <h3 className='title border border-warning-subtle rounded-4 text-center my-5 p-3'>감정일기장 프로젝트</h3>
      <Routes>
        <Route path="/" element= {<Home/>} />
        <Route path="/new" element= {<New/>} />
        {/* :id 하면 해당 자리에 다른 값이 입력되면 그걸 불러옴 */}
        <Route path="/diary/:id" element= {<Diary/>} />
        <Route path="/edit" element= {<Edit/>} />
      </Routes>

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