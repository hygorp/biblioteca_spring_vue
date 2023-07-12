import http from '../http-common'

class ClientService {

    findAll() {
        return http.get("/clients");
    }

    findById(id) {
        return http.get(`/clients/${id}`);
    }

    create(data) {
        return http.post("/clients", data);
    }

    update(id, data) {
        return http.put(`/clients/${id}`, data);
    }

    delete(id) {
        return http.delete(`/clients/${id}`);
    }
}

export default new ClientService();