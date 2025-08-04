import React from 'react';
import EmployeeCard from './EmployeeCard';

function EmployeesList() {
  const employees = [
    { id: 1, name: 'Prabyasachi 1', role: 'Developer' },
    { id: 2, name: 'Prabyasachi 2', role: 'Designer' },
    { id: 3, name: 'Prabyasachi 3', role: 'Tester' },
  ];

  return (
    <div>
      <h2>Employee List</h2>
      {employees.map(emp => (
        <EmployeeCard key={emp.id} employee={emp} />
      ))}
    </div>
  );
}

export default EmployeesList;
