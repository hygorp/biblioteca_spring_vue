<template>
  <div class="container" v-if="currentGenre" >
    <form>
      <h1>Edit Genre</h1>
      <div class="row g-2 mb-3">
        <div class="col-md-1">
          <label for="genre-id">#ID</label>
          <input type="text" class="form-control" id="genre-id" v-model="currentGenre.id" disabled>
        </div>

        <div class="col-md-10">
          <label for="genre-name">Genre Name</label>
          <input type="text" class="form-control" id="genre-name" v-model="currentGenre.name">
        </div>
      </div>
      <button type="submit" class="btn btn-primary" @click="edit(currentGenre.id, currentGenre)">Save Changes</button>
    </form>
  </div>
</template>

<script>
import GenreService from "@/services/GenreService";
import genreService from "@/services/GenreService";
export default {
  name: "genre-details",
  data() {
    return {
      currentGenre: {
        id: null,
        name: null
      }
    }
  },
  methods: {
    details(id){
      GenreService.findById(id).then(response => {
        this.currentGenre = response.data;
        console.log(response.data);
      })
    },
    edit(id, name){
      genreService.update(id, name).then(response => {
        console.log(response.data);
      })
    }
  },
  mounted() {
    this.details(this.$route.params.id);
  }
}

</script>

<style>
.container{
  padding-top: 8%;
}
</style>