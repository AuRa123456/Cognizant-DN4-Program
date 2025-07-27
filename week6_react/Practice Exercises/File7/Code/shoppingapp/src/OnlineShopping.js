import React from 'react';
import Cart from './Cart';

class OnlineShopping extends React.Component {
  render() {
    const cartItems = [
      { itemname: 'Mobile Phone', price: 15000 },
      { itemname: 'Bluetooth Speaker', price: 3000 },
      { itemname: 'Laptop', price: 55000 },
      { itemname: 'Smart Watch', price: 7000 },
      { itemname: 'Backpack', price: 1200 },
    ];

    return (
      <div>
        <h2>Shopping Cart</h2>
        {cartItems.map((item, index) => (
          <Cart key={index} itemname={item.itemname} price={item.price} />
        ))}
      </div>
    );
  }
}

export default OnlineShopping;