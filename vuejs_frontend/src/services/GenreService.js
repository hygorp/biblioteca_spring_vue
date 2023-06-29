import http from "../http-common"

class GenreService {
    findAll(){
        return http.get("/genres");
    }

    create(data) {
        return http.post("/genres", data);
    }
}

export default new GenreService();