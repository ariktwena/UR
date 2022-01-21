import React from "react";
import {
  // BrowserRouter as Router,
  // Switch,
  // Route,
  // Link,
  NavLink,
  // Redirect,
  //   useLocation,
  // Prompt,
  // useRouteMatch,
  // useParams,
  // useHistory,
} from "react-router-dom";

export default function Header({ isLoggedIn, loginMsg }) {
  return (
    <div>
      <ul className="header">
        <li>
          <NavLink exact activeClassName="active" to="/">
            Home
          </NavLink>
        </li>

        {isLoggedIn === false ? (
          <React.Fragment>
            <li>
              <NavLink activeClassName="active" to="/wheel">
                Wheel
              </NavLink>
            </li>
          </React.Fragment>
        ) : (
          <React.Fragment>
            <li>
              <NavLink activeClassName="active" to="/spins">
                Spins
              </NavLink>
            </li>
            <li>
              <NavLink activeClassName="active" to="/companies">
                Companies
              </NavLink>
            </li>
            <li>
              <NavLink activeClassName="active" to="/players">
                Players
              </NavLink>
            </li>
          </React.Fragment>
        )}
        <li>
          <NavLink activeClassName="active" to="/login-out">
            {loginMsg}
          </NavLink>
        </li>
      </ul>
      <hr />
    </div>
  );
}
