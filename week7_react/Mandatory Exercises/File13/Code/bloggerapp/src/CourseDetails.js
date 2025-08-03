import React from 'react';

const courses = [
  { id: 'c1', name: 'React', duration: '6 weeks' },
  { id: 'c2', name: 'Node.js', duration: '4 weeks' },
  { id: 'c3', name: 'MongoDB', duration: '3 weeks' },
];

const CourseDetails = () => (
  <div>
    <h2>Course Details</h2>
    {courses.map(course => (
      <div key={course.id}>
        <p>{course.name} - {course.duration}</p>
      </div>
    ))}
  </div>
);

export default CourseDetails;