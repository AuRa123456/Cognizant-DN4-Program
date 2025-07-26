import React from 'react';
import './App.css';
import { CohortsData } from './Cohort';
import CohortDetails from './CohortDetails';

function App() {
  return (
    <div className="App">
      <h1>Cohort Dashboard</h1>
      {CohortsData.map((cohort, index) => (
        <CohortDetails key={index} cohort={cohort} />
      ))}
    </div>
  );
}

export default App;