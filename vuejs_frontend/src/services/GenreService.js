import http from "../http-common"

class GenreService {
    findAll(){
        return http.get("/genres");
    }

    create(data) {
        return http.post("/genres", data);
    }

    delete(id) {
        return http.delete(`/genres/${id}`)
    }
}

export default new GenreService();