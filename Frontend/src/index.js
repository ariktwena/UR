import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import App from "./App";
import utils from "./utils"
import facade from "./facades/meewFacade";
import { BrowserRouter as Router } from "react-router-dom";

// Importing the Bootstrap CSS
import "bootstrap/dist/css/bootstrap.min.css";
import '@fortawesome/fontawesome-free/css/all.min.css'; 
import 'bootstrap-css-only/css/bootstrap.min.css'; 
import 'mdbreact/dist/css/mdb.css';

const AppWithRouter = () => {
  return (
    <Router>
      <App facade={facade} utils={utils} />
    </Router>
  );
};
ReactDOM.render(<AppWithRouter />, document.getElementById("root"));
