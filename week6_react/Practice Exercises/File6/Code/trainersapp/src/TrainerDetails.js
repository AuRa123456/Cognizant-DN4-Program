import React from 'react';
import { useParams } from 'react-router-dom';
import Trainers from './TrainersMock';
import './TrainerDetails.css';

function TrainerDetails() {
  const { id } = useParams();
  const trainer = Trainers.find(t => t.trainerId === parseInt(id));

  if (!trainer) return <h2>Trainer not found!</h2>;

  return (
    <div className="trainer-detail">
      <h2>{trainer.name}</h2>
      <p><strong>Email:</strong> {trainer.email}</p>
      <p><strong>Phone:</strong> {trainer.phone}</p>
      <p><strong>Technology:</strong> {trainer.technology}</p>
      <p><strong>Skills:</strong> {trainer.skills.join(", ")}</p>
    </div>
  );
}

export default TrainerDetails;