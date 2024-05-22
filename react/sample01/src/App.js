
import './App.css';
import Header from './component/Header.js';
import Body from './component/Body.js';
import Footer from './component/Footer.js';

function App() {  // component
  return (  // html랑 거의 흡사하지만 다름  리엑트에서만 쓰는 jsx문법 html+javascript
    <div className="App">
      <Header />
      <Body />
      <Footer />
    </div>
  );
}

export default App;
