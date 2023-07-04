import http from "../http-common"

class BookService {

    findAll(){
        return http.get("/books");
    }

    getById(id) {
        return http.get(`/books/${id}`);
    }

    create(data) {
        return http.post("/books", data);
    }

    update(id, data) {
        return http.put(`/books/${id}`, data)
    }

    delete(id) {
        return http.delete(`/books/${id}`)
    }
}

export default new BookService();
