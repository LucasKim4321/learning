// App 최상위 컴포넌트
// Header,Body,Footer 하위 컴포넌트
import './App.css';
import Header from './component/Header.js';
import Body from './component/Body.js';
import Footer from './component/Footer.js';
import BodyEvent from './component/BodyEvent.js';

function ChildComp() {
  return <div>children</div>  
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
      {/* <Body name={name} location={"부산"} /> */}
      {/* <Body {...BodyProps} /> */}
      <Body {...BodyProps}>
        <ChildComp />
      </Body>
      <BodyEvent/>
      <Footer />
    </div>
  );
}

export default App;
