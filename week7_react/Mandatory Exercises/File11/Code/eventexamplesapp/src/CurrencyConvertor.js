import React, { useState } from 'react';

const CurrencyConvertor = () => {
  const [rupees, setRupees] = useState('');
  const [dollar, setDollar] = useState('');

  const handleChange = (e) => {
    setRupees(e.target.value);
  };

  const handleSubmit = () => {
    const dollarRate = 0.011;
    const converted = (parseFloat(rupees) * dollarRate).toFixed(2);
    setDollar(converted);
  };

  return (
    <div>
      <h2>Currency Convertor (INR to USD)</h2>
      <input
        type="number"
        value={rupees}
        onChange={handleChange}
        placeholder="Enter amount in INR"
      />{' '}
      <button onClick={handleSubmit}>Convert</button>
      {dollar && <p>Converted Amount: ${dollar}</p>}
    </div>
  );
};

export default CurrencyConvertor;