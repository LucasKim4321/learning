import './App.css';
import Header from './component/head.js';

function App() {
  return (
    <div className='container'>
      <div className='contents alert alert-warning'>
        <Header/>
        <div className='border'>Todo Editor</div>
        <div className='border'>Todo List</div>
      </div>
    </div>
  );
}

export default App;
