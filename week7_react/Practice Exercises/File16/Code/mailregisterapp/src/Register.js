import React, { useState } from 'react';

function Register() {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    password: '',
  });

  const [errors, setErrors] = useState({});

  const validate = () => {
    let inputErrors = {};

    if (formData.name.trim().length < 5) {
      inputErrors.name = "Name must be at least 5 characters.";
    }

    if (!formData.email.includes("@") || !formData.email.includes(".")) {
      inputErrors.email = "Email must contain '@' and '.'";
    }

    if (formData.password.length < 8) {
      inputErrors.password = "Password must be at least 8 characters.";
    }

    setErrors(inputErrors);
    return Object.keys(inputErrors).length === 0;
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prev => ({ ...prev, [name]: value }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (validate()) {
      alert("Form submitted successfully!");
      // You can clear the form or send data to the backend here
    }
  };

  return (
    <div style={{ maxWidth: '400px', margin: 'auto' }}>
      <h2>Register</h2>
      <form onSubmit={handleSubmit} noValidate>
        <div>
          <label>Name:</label><br />
          <input type="text" name="name" value={formData.name} onChange={handleChange} />
          {errors.name && <div style={{ color: 'red' }}>{errors.name}</div>}
        </div>
        <div>
          <label>Email:</label><br />
          <input type="email" name="email" value={formData.email} onChange={handleChange} />
          {errors.email && <div style={{ color: 'red' }}>{errors.email}</div>}
        </div>
        <div>
          <label>Password:</label><br />
          <input type="password" name="password" value={formData.password} onChange={handleChange} />
          {errors.password && <div style={{ color: 'red' }}>{errors.password}</div>}
        </div>
        <button type="submit">Register</button>
      </form>
    </div>
  );
}

export default Register;