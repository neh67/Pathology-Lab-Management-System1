import React, { useEffect, useState } from "react";
import Services from "../Services/Services";

export default function BestOffers() {
  const [offers, setOffers] = useState([]);

  useEffect(() => {
    Services.getBestOffers()
      .then((res) => {
        setOffers(res.data);
      })
      .catch((err) => {
        alert(err.message);
      });
  }, []);

  return (
    <div className="container mt-3 rounded Test">
      <h3 className="text-center">Best Offers</h3>
      <div className="row">
        {/* ===================================== */}
        {offers &&
          offers.map((offer) => (
            <div className="product-cart rounded col-md-3 col-xs-6 mt-3">
              <div className="img">
                <img
                  className="img-fluid"
                  src={`Files/TestImage/${offer.testImagePath}`}
                  alt=""
                />
              </div>
              <div className="title mt-3 text-center">
                <h6>{offer.testType}</h6>
              </div>
              <div className="price">
                <span className="off">{offer.discount}% off</span>
                <span className="dis-price">
                  ₹{offer.finalPrice}{" "}
                  <del className="actual-price">₹{offer.actualPrice}</del>
                </span>
              </div>
              <div className="action-btn mt-3 ">
                <button className="card">Add to cart</button>
                <button className="buy">Buy Now</button>
              </div>
            </div>
          ))}
        {/* ======================================= */}
      </div>
    </div>
  );
}