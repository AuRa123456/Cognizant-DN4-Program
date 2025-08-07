import React, { Component } from 'react';

class Getuser extends Component {
  constructor(props) {
    super(props);
    this.state = {
      user: null,
      loading: true,
      error: null
    };
  }

  componentDidMount() {
    fetch('https://api.randomuser.me/')
      .then(response => {
        if (!response.ok) throw new Error("API fetch failed");
        return response.json();
      })
      .then(data => {
        const person = data.results[0];
        this.setState({
          user: {
            title: person.name.title,
            firstname: person.name.first,
            image: person.picture.large
          },
          loading: false
        });
      })
      .catch(error => this.setState({ error, loading: false }));
  }

  render() {
    const { user, loading, error } = this.state;

    if (loading) return <p>Loading...</p>;
    if (error) return <p>Error: {error.message}</p>;

    return (
      <div style={{ textAlign: 'center' }}>
        <h2>User Info</h2>
        <p><strong>Title:</strong> {user.title}</p>
        <p><strong>Firstname:</strong> {user.firstname}</p>
        <img src={user.image} alt="User" />
      </div>
    );
  }
}

export default Getuser;