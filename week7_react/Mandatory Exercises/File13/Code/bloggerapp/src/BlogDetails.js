import React from 'react';

const blogs = [
  { id: 101, title: "React Basics", author: "Sam" },
  { id: 102, title: "Understanding JSX", author: "Priya" },
  { id: 103, title: "Hooks Deep Dive", author: "Alex" },
];

const BlogDetails = () => (
  <div>
    <h2>Blog Details</h2>
    {blogs.length > 0 ? (
      blogs.map(blog => (
        <div key={blog.id}>
          <p><strong>{blog.title}</strong> - by {blog.author}</p>
        </div>
      ))
    ) : (
      <p>No blogs available.</p>
    )}
  </div>
);

export default BlogDetails;