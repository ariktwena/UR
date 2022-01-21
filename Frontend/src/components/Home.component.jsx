import React from "react";

export default function Home() {
  return (
    <div>
      <br />
      <div className="container">
        <div className="row">
          <div className="col-md-2"></div>
          <div className="col-md-8">
            <h3 className="text-center">MeeW Case &#129299;</h3>
            <br />
            <p>
              For at logge ind som admin, skal i skrive brugernavn: admin og
              kodeord: 1234
            </p>
            <p>Wheel -> Her kan man spinne et Wheel. Denne side er offentlig</p>
            <p>
              Spins -> Her kan man se den data der bliver indsamlet hver gang en
              bruger spinner et Wheel. Siden er kun tilgængelig for admin.
            </p>
            <p>
              Companies -> Her kan man se de virksomheder som har et Wheel.
              Siden er kun tilgængelig for admin.
            </p>
            <p>
              Players -> Her kan man se den data man indsamler på spillerne.
              Siden er kun tilgængelig for admin.
            </p>
          </div>
          <div className="col-md-2"></div>
        </div>
      </div>
    </div>
  );
}
