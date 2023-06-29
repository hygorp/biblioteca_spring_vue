<template>
  <div class="container" v-if="!submitted" >
    <form>
      <div class="mb-3">
        <label for="name">Genre Name</label>
        <input type="text" class="form-control" id="genre-name" v-model="genre.name">
        <div id="emailHelp" class="form-text">Add just one Genre.</div>
      </div>
      <button type="submit" class="btn btn-primary" @click="create">Submit</button>
    </form>
  </div>
</template>

<script>
  import GenreService from "@/services/GenreService";

  export default {
    name: "genre-create",
    data() {
      return {
        genre: {
          id: null,
          name: ""
        },
        submitted: false,
      };
    },
    methods: {
      create() {
        const data = {
          name: this.genre.name
        };
        GenreService.create(data).then(response => {
          this.genre.id = response.data.id;
        }).catch(e => {
          console.log(e)
        });
      }
    },
  }
</script>

<style>
  .container{
    padding-top: 8%;
  }
</style>