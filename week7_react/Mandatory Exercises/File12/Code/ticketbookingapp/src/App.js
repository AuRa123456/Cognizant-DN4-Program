import React, { useState } from 'react';
import Guest from './Guest';
import User from './User';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLogin = () => setIsLoggedIn(true);
  const handleLogout = () => setIsLoggedIn(false);

  let content;
  if (isLoggedIn) {
    content = <User />;
  } else {
    content = <Guest />;
  }

  return (
    <div style={{ padding: '20px' }}>
      <h1>Ticket Booking App</h1>
      <div style={{ marginBottom: '15px' }}>
        {isLoggedIn ? (
          <button onClick={handleLogout}>Logout</button>
        ) : (
          <button onClick={handleLogin}>Login</button>
        )}
      </div>
      {content}
    </div>
  );
}

export default App;