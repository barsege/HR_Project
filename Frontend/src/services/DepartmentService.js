import axios from "axios";

const EMPLOYEE_REST_API_URL = 'http://localhost:8080/departments/search?query'

class DepartmentService {
    getDepartments() {
        return axios.get(EMPLOYEE_REST_API_URL);
    }
}

export default new DepartmentService();