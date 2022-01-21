import utils from "../utils";
import { SERVER_URL } from "../settings";

function apiFacade() {
   function getAllWheels(callback) {
    utils.fetchAny(SERVER_URL + "/api/wheel", callback);
  }

  function getWheelById(id, callback) {
    utils.fetchAny(SERVER_URL + "/api/wheel/" + id, callback);
  }

  function getAllCompanies(callback) {
    utils.fetchAny(SERVER_URL + "/api/wheel/companies", callback);
  }

  function getAllSpins(callback) {
    utils.fetchAny(SERVER_URL + "/api/wheel/spins", callback);
  }

  function getAllPlayers(callback) {
    utils.fetchAny(SERVER_URL + "/api/wheel/players", callback);
  }

  function createWheel(wheel, callback) {
    utils.fetchAny(SERVER_URL + "/api/wheel", callback, "POST", wheel);
  }

  function createSpin(player, id, callback) {
    console.log(player)
    console.log(id)
    utils.fetchAny(SERVER_URL + "/api/wheel/" + id, callback, "POST", player);
  }

  return {
    getAllWheels,
    getWheelById,
    getAllCompanies,
    getAllSpins,
    getAllPlayers,
    createWheel,
    createSpin
  };
}
const facade = apiFacade();
export default facade;
