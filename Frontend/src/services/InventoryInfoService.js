import axios from "axios";

const EMPLOYEE_REST_API_URL = 'http://localhost:8080/inventoryInfo/search?query'

class InventoryInfoService {
    getInventoryInfo() {
        return axios.get(EMPLOYEE_REST_API_URL);
    }
}

export default new InventoryInfoService();