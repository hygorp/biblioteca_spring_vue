import http from "../http-common"

class AuthorService {
    findAll(){
        return http.get("/authors");
    }

    getById(id) {
        return http.get(`/authors/${id}`);
    }

    create(data) {
        return http.post("/authors", data);
    }

    update(id, data) {
        return http.put(`/authors/${id}`, data)
    }

    delete(id) {
        return http.delete(`/authors/details/delete/${id}`)
    }
}

export default new AuthorService();