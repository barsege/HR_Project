import axios from "axios";

const EMPLOYEE_REST_API_URL = 'http://localhost:8080/employee_Inv_Info/search?query'

class EmployeeInvInfoService {
    getInventoryInfo() {
        return axios.get(EMPLOYEE_REST_API_URL);
    }
}

export default new EmployeeInvInfoService();