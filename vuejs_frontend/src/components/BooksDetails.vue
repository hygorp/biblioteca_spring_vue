<template>
  <div class="content">
    <div class="book-detail row" v-if="currentBook">
      <div class="book-cover col-2">
        <img class="img-thumbnail" alt="" v-bind:src="currentBook.imgUrl">
      </div>

      <div class="book-data">
        <form>
          <div class="row g-2 mb-3">
            <div class="col-md-10">
              <label for="title">Title</label>
              <input type="text" class="form-control" id="title" v-model="currentBook.title">
            </div>

            <div class="col-md-2">
              <label for="year">Year</label>
              <input type="text" class="form-control" id="year" v-model="currentBook.year">
            </div>
          </div>

          <div class="row g-2 mb-3">
            <div class="col-md-6">
              <label for="price">Price</label>
              <input type="text" class="form-control" id="price" v-model="currentBook.price">
            </div>

            <div class="col-md-6">
              <label for="price">#isbn</label>
              <input type="text" class="form-control" id="isbn" v-model="currentBook.isbn">
            </div>
          </div>

          <div class="row g-2 mb-3">
            <div class="col-md-6" v-for="genre in currentBook.genres" v-bind:key="genre.id">
              <label for="genres">Genres</label>
              <input type="text" class="form-control" id="genres" v-model="genre.name">
            </div>

            <div class="col-md-6" v-for="author in currentBook.authors" v-bind:key="author.id">
              <label for="authors">Authors</label>
              <input type="text" class="form-control" id="authors" v-model="author.name">
            </div>
          </div>

          <div class="mb-3">
            <label for="imgurl">Image</label>
            <input type="url" class="form-control" id="imgurl" v-model="currentBook.imgUrl">
          </div>

          <div class="mb-3">
            <label for="description">Description</label>
            <textarea rows="4" class="form-control" id="description" v-model="currentBook.description"></textarea>
          </div>

          <div class="row justify-content-md-center">
            <div class="col col-lg-2">
              <button type="button" class="btn btn-success btn-sm">Save Changes</button>
            </div>

            <div class="col col-lg-2">
              <button type="button" class="btn btn-danger btn-sm">Delete Book</button>
            </div>
          </div>

        </form>
      </div>
    </div>
  </div>
</template>

<script>

  import BookService from "@/services/BookService";

  export default {
    name: 'book-details',
    data() {
      return {
        currentBook: null
      };
    },
    methods: {
      details(id) {
        BookService.getById(id).then(response => {
          this.currentBook = response.data;
          console.log(response.data);
        });
      },
      delete() {
        BookService.delete(this.currentBook.id).then(response => {
          console.log(response.data);
          this.$router.push({ name: "books" });
        })
      }
    },
    mounted() {
      this.message = '';
      this.details(this.$route.params.id);
    }
  }

</script>

<style>
  .content{
    width: 100%;
    height: 100%;
  }
  .book-detail{
    margin: 5% auto;
    width: 80%;
    height: 590px;
    padding: 20px 0 0;
    border-radius: 4px;
    box-shadow: 0 1px 1px 0 rgba(0,0,0,.1), 0 -1px 2px 0 rgba(0,0,0,.1);
  }
  .book-cover{
    margin-top: 20px ;
    width: auto;
    margin-right: 15px;
    float: left;
  }
  .book-cover img{
    width: 100%;
    max-height: 520px;
  }
  .book-data{
    width: 70%;
    margin-top: 30px;
  }
</style>
