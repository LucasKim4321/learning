// App 최상위 컴포넌트
// Header,Body,Footer 하위 컴포넌트
import './App.css';
import Header from './component/Header.js';
import Body from './component/Body.js';
import Footer from './component/Footer.js';
// import BodyEvent from './component/BodyEvent.js';
// import BodyState from './component/BodyState.js';
// import BodyState2 from './component/BodyState2.js';
import BodyStateProp from './component/BodyStateProp.js';
import BodyRef from './component/BodyRef.js';

function ChildComp() {
  return <div>children component</div>  
}

function App() {  // component

  const name = "홍길동";
  const BodyProps = {
    name: "홍길순",
    location: "부산",
    // favorList: ["파스타","빵","떡볶이"]
  }

  return (  // html랑 거의 흡사하지만 다름  리엑트에서만 쓰는 jsx문법 html+javascript
    <div className="App">
      <Header />
      {/* <Body name={name} location={"부산"} />
      <Body {...BodyProps} /> */}
      {/* <Body {...BodyProps}>
        <ChildComp />
      </Body> */}
      <hr/><div>BodyEvent</div>
      {/* <BodyEvent/> */}
      <hr/><div>BodyState</div>
      {/* <BodyState/> */}
      <hr/><div>BodyState2</div>
      {/* <BodyState2/> */}
      <hr/><div>BodyStateProp</div>
      <BodyStateProp/>
      <hr/><div>BodyRef</div>
      <BodyRef/>
      <Footer />

    </div>
  );
}

export default App;
