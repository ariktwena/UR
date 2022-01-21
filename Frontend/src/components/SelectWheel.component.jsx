import React, { useState, useEffect } from "react";
import Wheel from "./Wheel.component";

export default function SelectWheel(props) {
  const { facade, player } = props;

  const defaultWheelList = [];
  const defaultWheel = {
    wheelName: "",
    id: -1,
    fields: [],
    company: {
      companyName: "",
    },
    spins: [],
  };

  const [wheelList, setWheelList] = useState([...defaultWheelList]);
  const [wheel, setWheel] = useState({ ...defaultWheel });

  useEffect(() => {
    facade.getAllWheels((allWheels) => {
      setWheelList([...allWheels]);
    });
  }, []);

  const wheelSelector = (event) => {
    if (event.target.value === "-1") {
      setWheel({ ...defaultWheel });
    } else {
      facade.getWheelById(event.target.value, (selectedWheel) => {
        setWheel({ ...selectedWheel });
      });
    }
  };

  return (
    <div>
      <br />
      <div className="container">
        <div className="row">
          <div className="col-md-4"></div>
          <div className="col-md-4">
            <h3 className="text-center">Vælg et Lykkehjul</h3>

            <form>
              <div className="form-group" onChange={wheelSelector}>
                <select className="form-control" id="wheelSelector">
                  <option value="-1">--- Intet Valgt ---</option>
                  {wheelList.map((wheel) => (
                    <option key={wheel.id} value={wheel.id}>
                      {wheel.wheelName}
                    </option>
                  ))}
                </select>
              </div>
            </form>

            <br />
          </div>
          <div className="col-md-4"></div>
        </div>

        {wheel.id > -1 ? (
          <div className="row">
            <div className="col-md-2"></div>
            <div className="col-md-8">
              <Wheel facade={facade} player={player} wheel={wheel} />
            </div>
            <div className="col-md-2"></div>
          </div>
        ) : (
          ""
        )}
      </div>
    </div>
  );
}
