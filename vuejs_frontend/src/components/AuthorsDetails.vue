<template>
  <div class="container" v-if="currentAuthor" >
    <form>
      <h1>Edit Author</h1>
      <div class="row g-2 mb-3">
        <div class="col-md-1">
          <label for="genre-id">#ID</label>
          <input type="text" class="form-control" id="author-id" v-model="currentAuthor.id" disabled>
        </div>

        <div class="col-md-10">
          <label for="genre-name">Author Name</label>
          <input type="text" class="form-control" id="author-name" v-model="currentAuthor.name">
        </div>
      </div>
      <button type="submit" class="btn btn-primary" @click="edit(currentAuthor.id, currentAuthor)">Save Changes</button>
    </form>
  </div>
</template>

<script>

import AuthorService from "@/services/AuthorService";

export default {
  name: "author-details",
  data() {
    return {
      currentAuthor: {
        id: null,
        name: null
      }
    }
  },
  methods: {
    details(id){
      AuthorService.getById(id).then(response => {
        this.currentAuthor = response.data;
        console.log(response.data);
      })
    },
    edit(id, name){
      AuthorService.update(id, name).then(response => {
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