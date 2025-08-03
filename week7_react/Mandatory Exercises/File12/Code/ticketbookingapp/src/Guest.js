import React from 'react';

const Guest = () => {
  return (
    <div>
      <h2>Welcome, Guest!</h2>
      <p>Here are available flight details:</p>
      <ul>
        <li>Flight A: Delhi → Mumbai - ₹4500</li>
        <li>Flight B: Bangalore → Chennai - ₹3200</li>
        <li>Flight C: Kolkata → Hyderabad - ₹3800</li>
      </ul>
    </div>
  );
};

export default Guest;