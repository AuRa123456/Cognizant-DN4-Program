import React from 'react';

const OfficeSpace = () => {
  const offices = [
    {
      id: 1,
      name: "Skyline Tower",
      rent: 55000,
      address: "Downtown, Mumbai",
      image: "https://photos.zillowstatic.com/fp/e3d57d224cfa0be8ec15b687c28bb1fa-se_large_800_400.webp"
    },
    {
      id: 2,
      name: "Tech Park",
      rent: 65000,
      address: "Electronic City, Bangalore",
      image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ9ukKSMLB4SKFTqNPsVxvLHss8TrZk9vtnUQ&s"
    },
    {
      id: 3,
      name: "Green Plaza",
      rent: 60000,
      address: "Sector 5, Noida",
      image: "https://paradisegroupncr.com/wp-content/uploads/2024/03/16980448372.jpg.webp"
    }
  ];

  return (
    <div style={{ display: 'flex', gap: '20px', flexWrap: 'wrap' }}>
      {offices.map(office => (
        <div key={office.id} style={{ border: "1px solid #ccc", padding: "10px", width: "250px" }}>
          <h3>{office.name}</h3>
          <img src={office.image} alt={office.name} style={{ width: "100%" }} />
          <p><strong>Address:</strong> {office.address}</p>
          <p>
            <strong>Rent:</strong>{' '}
            <span style={{ color: office.rent < 60000 ? 'red' : office.rent > 60000 ? 'green' : 'black' }}>
              ₹{office.rent}
            </span>
          </p>
        </div>
      ))}
    </div>
  );
};

export default OfficeSpace;