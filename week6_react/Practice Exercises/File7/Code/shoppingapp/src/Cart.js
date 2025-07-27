import React from 'react';

class Cart extends React.Component {
  render() {
    const { itemname, price } = this.props;
    return (
      <div className="cart-item">
        <p><strong>Item:</strong> {itemname}</p>
        <p><strong>Price:</strong> ₹{price}</p>
      </div>
    );
  }
}

export default Cart;