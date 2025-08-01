import React from 'react';

const IndianPlayers = () => {
  const allPlayers = ['Kohli', 'Rohit', 'Rahul', 'Iyer', 'Pant', 'Jadeja'];
  const oddPlayers = allPlayers.filter((_, i) => i % 2 === 0);
  const evenPlayers = allPlayers.filter((_, i) => i % 2 !== 0);

  const T20players = ['Suryakumar', 'Arshdeep'];
  const RanjiTrophyPlayers = ['Pujara', 'Rahane'];

  const mergedPlayers = [...T20players, ...RanjiTrophyPlayers];

  return (
    <div>
      <h2>Odd Team Players:</h2>
      <ul>
        {oddPlayers.map((p, i) => <li key={i}>{p}</li>)}
      </ul>

      <h2>Even Team Players:</h2>
      <ul>
        {evenPlayers.map((p, i) => <li key={i}>{p}</li>)}
      </ul>

      <h2>Merged T20 + Ranji Players:</h2>
      <ul>
        {mergedPlayers.map((p, i) => <li key={i}>{p}</li>)}
      </ul>
    </div>
  );
};

export default IndianPlayers;