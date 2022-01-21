import React, { useState, useEffect } from "react";
import { MDBDataTableV5 } from "mdbreact";

export default function Spins(props) {
  const { facade } = props;

  const defaultSpinList = {
    columns: [
      {
        label: "Spin Id",
        field: "id",
        width: 150,
        sort: "enabled",
        attributes: {
          "aria-controls": "DataTable",
          "aria-label": "Name",
        },
      },
      {
        label: "Fields",
        field: "fieldNumbers",
        sort: "enabled",
        width: 270,
      },
      {
        label: "Arch Size",
        field: "arcSize",
        sort: "enabled",
        width: 270,
      },
      {
        label: "Top",
        field: "top",
        sort: "enabled",
        width: 270,
      },
      {
        label: "Off Set",
        field: "offSet",
        sort: "enabled",
        width: 270,
      },
      {
        label: "Rotate",
        field: "rotate",
        sort: "enabled",
        width: 270,
      },
      {
        label: "Array Number",
        field: "resultNumber",
        sort: "enabled",
        width: 270,
      },
      {
        label: "Prize Name",
        field: "resultName",
        sort: "enabled",
        width: 270,
      },
      {
        label: "Prize Value",
        field: "resultValue",
        sort: "enabled",
        width: 270,
      },
      {
        label: "Player Name",
        field: "playerName",
        sort: "enabled",
        width: 270,
      },
      {
        label: "Player Id",
        field: "playerId",
        sort: "enabled",
        width: 270,
      },
      {
        label: "Wheel Id",
        field: "wheelId",
        sort: "enabled",
        width: 270,
      },
      {
        label: "Wheel Name",
        field: "wheelName",
        sort: "enabled",
        width: 270,
      },
    ],
    rows: [],
  };

  const [spinList, setSpinList] = useState({ ...defaultSpinList });

  useEffect(() => {
    facade.getAllSpins((list) => {
      let x;
      let editedList = list.map(
        (s) =>
          (x = {
            ...s,
            playerId: s.player.id,
            playerName: s.player.playerName,
            wheelId: s.wheel.id,
            wheelName: s.wheel.wheelName,
          })
      );
      defaultSpinList.rows = [...editedList];
      setSpinList({ ...defaultSpinList });
    });
  }, []);

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-12">
          <h3 className="text-center">Spin Stats</h3>
          <br />
          <MDBDataTableV5
            hover
            entriesOptions={[10, 25, 50]}
            entries={10}
            pagesAmount={4}
            data={spinList}
            fullPagination
          />
        </div>
      </div>
    </div>
  );
}
