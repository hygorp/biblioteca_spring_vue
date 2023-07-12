import http from "../http-common"

class GenreService {
    findAll(){
        return http.get("/genres");
    }

    findById(id) {
        return http.get(`/genres/${id}`)
    }

    create(data) {
        return http.post("/genres", data);
    }

    update(id, name) {
        return http.put(`/genres/${id}`, name);
    }

    delete(id) {
        return http.delete(`/genres/${id}`)
    }
}

export default new GenreService();