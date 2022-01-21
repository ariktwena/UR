import React, { useState } from "react";

import SelectWheel from "./SelectWheel.component";

export default function Form(props) {
  const { facade } = props;
  const defultPlayer = {
    playerName: "",
    email: "",
  };

  const [player, setPlayer] = useState({ ...defultPlayer });
  const [game, setGame] = useState(false);

  const getPlayer = (event) => {
    const target = event.target;
    const value = target.type === "checkbox" ? target.checked : target.value;
    const name = target.name;
    player[name] = value;
    setPlayer({ ...player, [name]: value });
  };

  const playGame = () => {
    const regularExpresion =
      /^(([^<>()[\]\.,;:\s@\"]+(\.[^<>()[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;
    if (
      player.playerName.length >= 2 &&
      regularExpresion.test(String(player.email).toLowerCase())
    ) {
      setGame(true);
    }
  };

  return (
    <div>
      <br />
      <div className="container">
        {game === true ? (
          ""
        ) : (
          <div className="row">
            <div className="col-md-4"></div>
            <div className="col-md-4">
              <h3 className="text-center">
                Skriv dit navn og e-mail for at vinde store
                præmier&#129310;&#127996;
              </h3>
              <br />

              <form
                className="form-horizontal text-center"
                onChange={getPlayer}
              >
                <div className="form-group">
                  <label
                    className="control-label col-sm-3"
                    htmlFor="playerName"
                  >
                    Navn:
                  </label>
                  <div className="col-sm-12">
                    <input
                      className="form-control"
                      name="playerName"
                      id="playerName"
                      type="text"
                      placeholder="Skriv dit navn her..."
                    />
                  </div>
                </div>
                <div className="form-group">
                  <label className="control-label col-sm-3" htmlFor="email">
                    E-mail:
                  </label>
                  <div className="col-sm-12">
                    <input
                      className="form-control"
                      name="email"
                      id="email"
                      type="email"
                      placeholder="Skriv din email her..."
                    />
                  </div>
                </div>
              </form>
              <div className="text-center">
                <button className="btn btn-primary" onClick={playGame}>
                  Spil!!
                </button>
              </div>
            </div>
            <div className="col-md-4"></div>
          </div>
        )}
      </div>
      {game === false ? (
        ""
      ) : (
        <div className="row">
          <div className="col-md-2"></div>
          <div className="col-md-8">
            <SelectWheel facade={facade} player={player} />
          </div>
          <div className="col-md-2"></div>
        </div>
      )}
    </div>
  );
}
