import {Routes, Route} from "react-router-dom"

import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';

import NoteMain from "./pages/NoteMain.js"
// import Setting from './pages/Setting.js'
// import Sign_up from './pages/Sign_up.js'
// import Theme from './pages/Theme.js'
// import Tutorial from './pages/Tutorial.js'


function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<NoteMain/>}/>
        {/* <Route path="/setting" element={<Setting/>}/> */}
        {/* <Route path="/sign_up" element={<Sign_up/>}/> */}
        {/* <Route path="/theme" element={<Theme/>}/> */}
        {/* <Route path="/tutorial" element={<Tutorial/>}/> */}
      </Routes>
    </div>
  );
}

export default App;
