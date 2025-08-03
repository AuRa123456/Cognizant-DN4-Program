import React, { Component } from 'react';

class Counter extends Component {
  constructor() {
    super();
    this.state = { count: 0 };
  }

  increment = () => {
    this.setState(prev => ({ count: prev.count + 1 }));
    this.sayHello();
  };

  sayHello = () => {
    console.log("Hello! This is a static message from the increment function.");
  };

  decrement = () => {
    this.setState(prev => ({ count: prev.count - 1 }));
  };

  render() {
    return (
      <div>
        <h2>Counter Example</h2>
        <p>Count: {this.state.count}</p>
        <button onClick={this.increment}>Increment</button>{' '}
        <button onClick={this.decrement}>Decrement</button>
      </div>
    );
  }
}

export default Counter;