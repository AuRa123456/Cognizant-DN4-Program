import React, { useState } from 'react';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';

function App() {
  const [selected, setSelected] = useState('book');

  const renderComponent = () => {
    switch (selected) {
      case 'book':
        return <BookDetails />;
      case 'blog':
        return <BlogDetails />;
      case 'course':
        return <CourseDetails />;
      default:
        return <p>Please select a section.</p>;
    }
  };

  return (
    <div style={{ padding: '20px' }}>
      <h1>Blogger App</h1>
      <div style={{ marginBottom: '15px' }}>
        <button onClick={() => setSelected('book')}>Book Details</button>{' '}
        <button onClick={() => setSelected('blog')}>Blog Details</button>{' '}
        <button onClick={() => setSelected('course')}>Course Details</button>
      </div>

      {renderComponent()}

      <hr />
      {selected === 'blog' ? <p>You selected Blog section</p> : <p>You're not in Blog section</p>}

      {selected === 'course' && <p>You are in Course section</p>}
    </div>
  );
}

export default App;