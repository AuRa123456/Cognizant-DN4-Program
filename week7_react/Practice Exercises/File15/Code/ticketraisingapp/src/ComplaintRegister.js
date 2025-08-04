import React, { useState } from 'react';
import './ComplaintRegister.css';

function ComplaintRegister() {
  const [employeeName, setEmployeeName] = useState('');
  const [complaint, setComplaint] = useState('');
  const [complaints, setComplaints] = useState([]); // NEW: store submitted complaints

  const handleSubmit = (event) => {
    event.preventDefault();

    if (!employeeName.trim() || !complaint.trim()) {
      alert('Please enter both name and complaint');
      return;
    }

    const refNumber = 'REF' + Math.floor(100000 + Math.random() * 900000);
    
    const newComplaint = {
      id: refNumber,
      name: employeeName,
      text: complaint
    };

    setComplaints(prev => [...prev, newComplaint]);

    alert(`Complaint Registered!\nReference Number: ${refNumber}`);

    // Clear form fields
    setEmployeeName('');
    setComplaint('');
  };

  return (
    <div className="complaint-container">
      <h2>Raise a Complaint</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Employee Name:</label>
          <input
            type="text"
            value={employeeName}
            onChange={(e) => setEmployeeName(e.target.value)}
            placeholder="Enter your name"
          />
        </div>
        <div>
          <label>Complaint:</label>
          <textarea
            value={complaint}
            onChange={(e) => setComplaint(e.target.value)}
            placeholder="Describe your complaint"
          />
        </div>
        <button type="submit">Submit Complaint</button>
      </form>

      {/* Display complaints below */}
      <div className="complaint-list">
        <h3>Submitted Complaints</h3>
        {complaints.length === 0 && <p>No complaints yet.</p>}
        <ul>
          {complaints.map((comp) => (
            <li key={comp.id}>
              <strong>{comp.name}</strong>: {comp.text} <br />
              <em>Ref: {comp.id}</em>
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}

export default ComplaintRegister;