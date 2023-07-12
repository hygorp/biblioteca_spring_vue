<template>
  <div class="container" v-if="!submitted">
    <form @submit="create">
      <div class="mb-3">
        <label for="title">Title</label>
        <input type="text" class="form-control" id="title" v-model="book.title" required>
      </div>

      <div class="mb-3">
        <label for="description">Description</label>
        <input type="text" class="form-control" id="description" v-model="book.description" required>
      </div>

      <div class="mb-3">
        <label for="year">Year</label>
        <input type="text"  class="form-control" id="year" v-model="book.year" required>
      </div>

      <div class="mb-3">
        <label for="price">Price</label>
        <input type="text" class="form-control" id="price" v-model="book.price" required>
      </div>

      <div class="mb-3">
        <label for="price">#isbn</label>
        <input type="text" class="form-control" id="isbn" v-model="book.isbn" required>
      </div>

      <div class="mb-3">
        <label for="price">Image</label>
        <input type="text" class="form-control" id="image" v-model="book.imgUrl" required>
      </div>

      <div class="mb-3">
        <label for="authors">Authors</label>
        <select class="form-select" v-model="book.authors" multiple>
          <option v-for="(author, index) in authorsList" v-bind:key="index" v-bind:value="author">{{author.name}}</option>
        </select>
      </div>

      <div class="mb-3">
        <label for="genres">Genres</label>
        <select class="form-select" v-model="book.genres" multiple>
          <option v-for="(genre, index) in genresList" v-bind:key="index" v-bind:value="genre">{{genre.name}}</option>
        </select>
      </div>

      <button type="submit" class="btn btn-primary">Submit</button>

    </form>
  </div>
</template>

<style>
.container{
  margin-top: 2%;
}
</style>

<script>

  import BookService from "@/services/BookService";
  import AuthorService from "@/services/AuthorService";
  import GenreService from "@/services/GenreService";

  export default {
    name: "book-create",
    data() {
      return {
        book: {
          id: null,
          title: "",
          description: "",
          year: "",
          price: "",
          isbn: "",
          imgUrl: "",
          authors: [],
          genres: [],
        },
        submitted: false,
        authorsList: [],
        genresList: []
      };
    },
    methods: {
      getAuthors(){
        AuthorService.findAll().then(response => {
          this.authorsList = response.data;
        });
      },
      getGenres(){
        GenreService.findAll().then(response => {
          this.genresList = response.data;
        });
      },
      create() {
        const data = {
          title: this.book.title,
          description: this.book.description,
          year: this.book.year,
          price: this.book.price,
          isbn: this.book.isbn,
          imgUrl: this.book.imgUrl,
          authors: this.book.authors.map(author => ({ id: author.id})),
          genres: this.book.genres.map(genre => ({ id: genre.id}))
        };
        BookService.create(data).then(response => {
          this.book.id = response.data.id;
        }).catch(e => {
          console.log(e)
        });
      }
    },
    mounted() {
      this.getAuthors();
      this.getGenres();
    }
  }

</script>