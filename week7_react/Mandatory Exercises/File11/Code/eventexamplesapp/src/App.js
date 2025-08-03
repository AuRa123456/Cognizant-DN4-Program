import React from 'react';
import Counter from './Counter';
import EventButtons from './EventButtons';
import CurrencyConvertor from './CurrencyConvertor';

function App() {
  return (
    <div style={{ padding: '20px' }}>
      <h1>React Event Handling Examples</h1>
      <Counter />
      <EventButtons />
      <CurrencyConvertor />
    </div>
  );
}

export default App;