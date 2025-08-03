import React from 'react';

const EventButtons = () => {
  const sayWelcome = (message) => {
    alert(message);
  };

  const handleClick = (event) => {
    alert("I was clicked");
    console.log("Synthetic event:", event);
  };

  return (
    <div>
      <h2>Event Buttons</h2>
      <button onClick={() => sayWelcome("Welcome!")}>Say Welcome</button>{' '}
      <button onClick={handleClick}>OnPress</button>
    </div>
  );
};

export default EventButtons;