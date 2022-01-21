import React, { useState, useEffect } from "react";
import { MDBDataTableV5 } from "mdbreact";

export default function Companies(props) {
  const { facade } = props;

  const defaultCompanyList = {
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
        label: "Company Name",
        field: "companyName",
        sort: "enabled",
        width: 270,
      },
    ],
    rows: [],
  };

  const [CompanyList, setCompanyList] = useState({ ...defaultCompanyList });

  useEffect(() => {
    facade.getAllCompanies((list) => {
      defaultCompanyList.rows = [...list];
      setCompanyList({ ...defaultCompanyList });
    });
  }, []);

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-2"></div>
        <div className="col-md-8">
          <h3 className="text-center">Companies</h3>
          <br />
          <MDBDataTableV5
            hover
            entriesOptions={[10, 25, 50]}
            entries={10}
            pagesAmount={4}
            data={CompanyList}
            fullPagination
          />
        </div>
        <div className="col-md-2"></div>
      </div>
    </div>
  );
}
