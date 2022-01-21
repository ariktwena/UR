import React from "react";
import {
  // BrowserRouter as Router,
  // Switch,
  Route,
  // Link,
  // NavLink,
  Redirect,
  useLocation,
  // Prompt,
  // useRouteMatch,
  // useParams,
  // useHistory,
} from "react-router-dom";

export default function PrivateRoute({
  component: Component,
  isLoggedIn,
  isAdmin,
  ...props
}) {
  const { pathname } = useLocation();
  return (
    <Route>
      {isLoggedIn === true && isAdmin === true ? (
        <Component {...props} />
      ) : (
        <Redirect to={{ pathname: "/login-out", state: { from: pathname } }} />
      )}
    </Route>
  );
}
