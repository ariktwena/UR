import jwt_decode from "jwt-decode";
import { SERVER_URL } from "./settings";

function handleHttpErrors(res) {
  if (!res.ok) {
    //console.log(res);
    //   document.getElementById("errorMsg").style.display = "block";
    //   const message = res.statusText === "" ? "Something went wrong... :(" : "";
    //   document.getElementById("errorMsg").innerHTML =
    //     "Status code: " + res.status + ", message: " + message;

    return Promise.reject({ status: res.status, fullError: res.json() });
  }
  return res.json();
}

function apiUtils() {
  function makeOptions(method, addToken, body) {
    // console.log(method);
    method = method ? method : "GET";
    var opts = {
      method: method,
      headers: {
        ...(["PUT", "POST"].includes(method) && {
          //using spread operator to conditionally add member to headers object.
          "Content-type": "application/json",
        }),
        Accept: "application/json",
      },
    };
    // console.log(method);
    if (addToken && loggedIn()) {
      opts.headers["x-access-token"] = getToken();
    }
    if (body) {
      opts.body = JSON.stringify(body);
    }
    return opts;
  }

  function fetchAny(url, callback, method, body) {
    // console.log(url);
    //console.log(callback);
    // console.log(method);
    //console.log(body);
    const options = makeOptions(method, true, body);
    //console.log(options);
    fetch(url, options)
      .then((res) => handleHttpErrors(res))
      .then((data) => callback(data))
      .catch((err) => {
        if (err.status) {
          err.fullError.then((e) => console.log(e.detail));
        } else {
          // console.log("Network error");
        }
      });
  }

  function login(user, password) {
    /*TODO*/
    const options = makeOptions("POST", true, {
      username: user,
      password: password,
    });

    return fetch(SERVER_URL + "/api/login", options)
      .then(handleHttpErrors)
      .then((res) => {
        // console.log(res);
        // document.getElementById("error").innerHTML = "";
        setToken(res.token);
      });
  }

  function fetchWelcomeData() {
    /*TODO */
    const options = makeOptions("GET", true); //True add's the token
    return fetch(SERVER_URL + "/api/info/admin", options).then(
      handleHttpErrors
    );
  }

  const setToken = (token) => {
    const tokenData = jwt_decode(token);
    // console.log(tokenData);
    localStorage.setItem("role", tokenData.roles);
    // if (localStorage.getItem("role") === "admin") {
    //   console.log("YES");
    // } else {
    //   console.log("NO");
    // }
    localStorage.setItem("jwtToken", token);
  };

  const getToken = () => {
    return localStorage.getItem("jwtToken");
  };

  const loggedIn = () => {
    const loggedIn = getToken() != null;
    return loggedIn;
  };

  const logout = () => {
    localStorage.removeItem("jwtToken");
    localStorage.removeItem("role");
  };

  return {
    makeOptions,
    fetchAny,
    login,
    fetchWelcomeData,
    setToken,
    getToken,
    loggedIn,
    logout,
  };
}

const utils = apiUtils();
export default utils;
