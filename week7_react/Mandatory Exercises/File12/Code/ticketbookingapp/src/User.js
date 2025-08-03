import React from 'react';

const User = () => {
  return (
    <div>
      <h2>Welcome, User!</h2>
      <p>You can now book your tickets:</p>
      <form>
        <label>
          Select Flight:
          <select>
            <option>Flight A</option>
            <option>Flight B</option>
            <option>Flight C</option>
          </select>
        </label>
        <br /><br />
        <button type="submit">Book Ticket</button>
      </form>
    </div>
  );
};

export default User;