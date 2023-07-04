<template>
  <div class="container">
    <h1 class="text-center">Genres  List</h1>
    <div class="table-responsive">
      <table class="table table-striped">
        <thead class="table-dark">
          <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Actions</th>
          </tr>
        </thead>

        <tbody>
          <tr v-for="(genre, index) in genres" v-bind:key="index">
            <td>{{genre.id}}</td>
            <td>{{genre.name}}</td>
            <td class="col-md-2">
              <div class="btn-group">
                <button type="button" class="btn btn-outline-primary btn-sm">Edit</button>
                <button type="submit" class="btn btn-outline-danger btn-sm" @click="deleteGenres(genre.id)">Delete</button>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
  import GenreService from "@/services/GenreService";

  export default {
    name: 'genres-view',
    data(){
      return {
        genres: []
      }
    },
    methods: {
      getGenres() {
        GenreService.findAll().then((response) => {
          this.genres = response.data;
          console.log(this.genres);
        });
      },
      deleteGenres(id) {
        GenreService.delete(id).then(response => {
          console.log(response.data);
          window.location.replace("/genres");
        })
      }
    },
    mounted() {
      this.getGenres();
    }
  }
</script>

<style>
  .container{
    padding-top: 8%;
  }
</style>