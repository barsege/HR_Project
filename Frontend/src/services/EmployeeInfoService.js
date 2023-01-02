import axios from "axios";

const EMPLOYEE_REST_API_URL = 'http://localhost:8080/employee_info/searchAll?query'

class EmployeeInfoService {
    getEmployeeInfo() {
        return axios.get(EMPLOYEE_REST_API_URL);
    }
}

export default new EmployeeInfoService();