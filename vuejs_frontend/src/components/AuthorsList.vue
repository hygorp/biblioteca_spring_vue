<template>
  <div class="container">
    <h1 class="text-center">Authors List</h1>
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
        <tr v-for="(author, index) in authors" v-bind:key="index">
          <td>{{author.id}}</td>
          <td>{{author.name}}</td>
          <td class="col-md-2">
            <div class="btn-group">
              <button type="button" class="btn btn-outline-primary btn-sm">Edit</button>
              <button type="submit" class="btn btn-outline-danger btn-sm" @click="deleteAuthors(author.id)">Delete</button>
            </div>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>

import AuthorService from "@/services/AuthorService";

export default {
  name: 'authors-view',
  data(){
    return {
      authors: []
    }
  },
  methods: {
    getAuthors() {
      AuthorService.findAll().then((response) => {
        this.authors = response.data;
        console.log(this.authors);
      });
    },
    deleteAuthors(id) {
      AuthorService.delete(id).then(response => {
        console.log(response.data);
        window.location.replace("/authors");
      })
    }
  },
  mounted() {
    this.getAuthors();
  }
}
</script>

<style>
.container{
  padding-top: 8%;
}
</style>