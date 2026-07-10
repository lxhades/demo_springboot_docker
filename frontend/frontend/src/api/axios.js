import axios from "axios";

const API_URL = "http://localhost:8080/api/";

const axiosClient = axios.create({
    baseURL: API_URL,
    timeout: 10000,
    headers: {
        "Content-Type": "application/json"
    }
});

export const getHello = () => {
    return axiosClient.get("user/1");
};

export default axiosClient;