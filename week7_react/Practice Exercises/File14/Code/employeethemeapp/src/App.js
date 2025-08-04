import React, { useState } from 'react';
import EmployeesList from './EmployeesList';
import ThemeContext from './ThemeContext';
import './App.css';

function App() {
  const [theme, setTheme] = useState('light');

  return (
    <ThemeContext.Provider value={theme}>
      <div className="App">
        <h1>Employee Management</h1>
        <button onClick={() => setTheme(prev => prev === 'light' ? 'dark' : 'light')}>
          Toggle Theme
        </button>
        <EmployeesList />
      </div>
    </ThemeContext.Provider>
  );
}

export default App;