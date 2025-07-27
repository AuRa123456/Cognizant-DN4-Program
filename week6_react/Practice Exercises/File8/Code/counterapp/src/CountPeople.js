import React, { Component } from 'react';

class CountPeople extends Component {
  constructor(props) {
    super(props);
    this.state = {
      entryCount: 0,
      exitCount: 0,
    };
  }

  updateEntry = () => {
    this.setState((prevState) => ({
      entryCount: prevState.entryCount + 1,
    }));
  };

  updateExit = () => {
    this.setState((prevState) => ({
      exitCount: prevState.exitCount + 1,
    }));
  };

  render() {
    return (
      <div style={styles.container}>
        <h2>Entry/Exit Counter</h2>
        <div style={styles.counter}>
          <p>People Entered: {this.state.entryCount}</p>
          <p>People Exited: {this.state.exitCount}</p>
        </div>
        <div style={styles.buttons}>
          <button onClick={this.updateEntry}>Login</button>
          <button onClick={this.updateExit}>Exit</button>
        </div>
      </div>
    );
  }
}

const styles = {
  container: {
    textAlign: 'center',
    marginTop: '50px',
    fontFamily: 'Arial, sans-serif',
  },
  counter: {
    margin: '20px',
    fontSize: '18px',
  },
  buttons: {
    display: 'flex',
    justifyContent: 'center',
    gap: '20px',
  },
};

export default CountPeople;