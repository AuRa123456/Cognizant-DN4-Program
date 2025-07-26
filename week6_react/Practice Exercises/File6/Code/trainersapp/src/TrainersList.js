import React from 'react';
import { Link } from 'react-router-dom';
import './TrainersList.css';

function TrainersList({ data }) {
  return (
    <div className="trainers-list">
      <h2>Trainers List</h2>
      <ul>
        {data.map(trainer => (
          <li key={trainer.trainerId}>
            <Link to={`/trainer/${trainer.trainerId}`}>{trainer.name}</Link>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default TrainersList;