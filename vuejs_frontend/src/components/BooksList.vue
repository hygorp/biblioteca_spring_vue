<template>
  <div class="content">
    <div class="section" v-for="book in books" v-bind:key="book.id">
      <div class="book-cover">
        <img class="img-thumbnail" alt="" v-bind:src="book.imgUrl">
      </div>

      <div class="book-info">
        <h5><strong>{{book.title}}</strong></h5>
        <p v-for="(author, index) in book.authors" v-bind:key="index"><small>Authors: {{author.name}} | Year: {{book.year}}</small></p>
        <h4 class="btn btn-danger btn-sm"><em><strong>$ {{book.price}}</strong></em></h4>
        <p></p>
        <p>
          <strong>Synopsis:</strong>
          <br>
          <em>
            {{book.description}}
          </em>
        </p>
        <p v-for="(genre, index) in book.genres" v-bind:key="index"><small>Genres: {{genre.name}}</small></p>
        <a class="btn btn-primary btn-sm" v-bind:href="`/books/${book.id}/details`">More Details</a>
      </div>
    </div>
  </div>
</template>

<script>
  import BookService from "@/services/BookService";

  export default {
    name: 'books-view',
    data(){
      return {
        books: []
      }
    },
    methods: {
      getBooks() {
        BookService.findAll().then((response) => {
          this.books = response.data;
          console.log(this.books);
        });
      }
    },
    mounted() {
      this.getBooks();
    }
  }
</script>

<style>
  .content{
    width: 100%;
    height: 100%;
  }
  .section{
    width: 80%;
    height: 350px;
    padding: 15px;
    margin: 15px;
    border-radius: 4px;
    box-shadow: 0 1px 1px 0 rgba(0,0,0,.1), 0 -1px 2px 0 rgba(0,0,0,.1);
    float: left;
  }
  .book-cover{
    width: 220px;
    float: left;
    margin-right: 15px;
  }
  .book-cover img{
    width: 100%;
    max-width: 220px;
    max-height: 320px;
  }
  .book-info{
    width: auto;
    height: 220px;
    margin-top: 15px;
  }
</style>