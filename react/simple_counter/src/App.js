import 'bootstrap/dist/css/bootstrap.css'

import './App.css';
import Viewer from './component/Viewer.js'
import Controller from './component/Controller.js'


import { useState } from 'react';

function App() {

  // 멤버 변수
  const [count,setCount] = useState(1000)
  // 함수 선언
  const handleSetCount = (value) => {
    setCount(count+value)
  }

  return (
    <div className="App">
      <div className="container">
        <div className='alert alert-danger title'>
          <h1>Simple Counter</h1>
        </div>
        <section>
          <Viewer count2={count}/>
        </section>
        <section>
          <Controller handleSetCount2={handleSetCount}/>
        </section>
      </div>
    </div>
  );
}

export default App;
