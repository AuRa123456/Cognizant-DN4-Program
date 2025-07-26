import React from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Home from './Home';
import TrainersList from './TrainersList';
import TrainerDetails from './TrainerDetails';
import Trainers from './TrainersMock';
import './App.css'; // Make sure you have this for global styles

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <header>
          <h1>TrainersApp</h1>
          <nav>
            <Link to="/">Home</Link>
            <Link to="/trainers">Trainers</Link>
          </nav>
        </header>

        <main>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/trainers" element={<TrainersList data={Trainers} />} />
            <Route path="/trainer/:id" element={<TrainerDetails />} />
          </Routes>
        </main>
      </div>
    </BrowserRouter>
  );
}

export default App;