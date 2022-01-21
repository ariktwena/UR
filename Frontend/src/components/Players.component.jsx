import React, { useState, useEffect } from "react";
import { MDBDataTableV5 } from "mdbreact";

export default function Players(props) {
  const { facade } = props;

  const defaultPlayerList = {
    columns: [
      {
        label: "Id",
        field: "id",
        width: 150,
        sort: "enabled",
        attributes: {
          "aria-controls": "DataTable",
          "aria-label": "Name",
        },
      },
      {
        label: "Name",
        field: "playerName",
        width: 150,
        sort: "enabled",
      },
      {
        label: "Email",
        field: "email",
        sort: "enabled",
        width: 270,
      },
    ],
    rows: [],
  };

  const [playerList, setPlayerList] = useState({ ...defaultPlayerList });

  useEffect(() => {
    facade.getAllPlayers((list) => {
      defaultPlayerList.rows = [...list];
      setPlayerList({ ...defaultPlayerList });
    });
  }, []);

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-2"></div>
        <div className="col-md-8">
          <h3 className="text-center">Players</h3>
          <br />
          <MDBDataTableV5
            hover
            entriesOptions={[10, 25, 50]}
            entries={10}
            pagesAmount={4}
            data={playerList}
            fullPagination
          />
        </div>
        <div className="col-md-2"></div>
      </div>
    </div>
  );
}
