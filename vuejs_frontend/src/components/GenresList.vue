<template>
  <div class="container">
    <h1 class="text-center">Genres  List</h1>
    <div class="table-responsive">
      <table class="table table-striped">
        <thead class="table-dark">
          <tr>
            <th>Id</th>
            <th>Name</th>
          </tr>
        </thead>

        <tbody>
          <tr v-for="(genre, index) in genres" v-bind:key="index">
            <td>{{genre.id}}</td>
            <td>{{genre.name}}</td>
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