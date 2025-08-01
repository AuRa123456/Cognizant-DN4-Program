import React from 'react';

const ListofPlayers = () => {
  const players = [
    { name: 'Virat Kohli', score: 90 },
    { name: 'Rohit Sharma', score: 85 },
    { name: 'KL Rahul', score: 60 },
    { name: 'Shreyas Iyer', score: 72 },
    { name: 'Rishabh Pant', score: 55 },
    { name: 'Hardik Pandya', score: 40 },
    { name: 'Ravindra Jadeja', score: 75 },
    { name: 'Jasprit Bumrah', score: 65 },
    { name: 'Mohammed Shami', score: 50 },
    { name: 'Yuzvendra Chahal', score: 35 },
    { name: 'Shubman Gill', score: 95 }
  ];

  const filteredPlayers = players.filter(player => player.score < 70);

  return (
    <div>
      <h2>All Players:</h2>
      <ul>
        {players.map((player, index) => (
          <li key={index}>{player.name} - {player.score}</li>
        ))}
      </ul>

      <h2>Players with Score below 70:</h2>
      <ul>
        {filteredPlayers.map((player, index) => (
          <li key={index}>{player.name} - {player.score}</li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;