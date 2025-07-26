// Posts.js
import React from 'react';
import Post from './Post';

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false,
      error: null
    };
  }

  componentDidMount() {
    this.loadPosts();
  }

  loadPosts() {
    fetch("https://jsonplaceholder.typicode.com/posts")
      .then(response => {
        if (!response.ok) {
          throw new Error("Failed to fetch posts");
        }
        return response.json();
      })
      .then(data => {
        this.setState({ posts: data });
      })
      .catch(error => {
        this.setState({ hasError: true, error: error.message });
      });
  }

  componentDidCatch(error, info) {
    alert("An error occurred: " + error.toString());
    console.error("Error caught in Posts:", error, info);
  }

  render() {
    if (this.state.hasError) {
      return <h2>Error loading posts: {this.state.error}</h2>;
    }

    return (
      <div>
        <h1>All Blog Posts</h1>
        {this.state.posts.map(post => (
          <Post key={post.id} title={post.title} body={post.body} />
        ))}
      </div>
    );
  }
}

export default Posts;