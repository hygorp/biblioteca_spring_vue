<template>
  <div class="container" v-if="currentAuthor">
    <h4 class="display-1">{{ currentAuthor.name }}</h4>
    <p><strong>Collection</strong></p>

    <table class="table">
      <thead>
      <tr>
        <th scope="col">Title</th>
        <th scope="col">Year</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="collection in currentAuthor.books" v-bind:key="collection.id">
        <td>{{collection.title}}</td>
        <td>{{collection.year}}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>

import AuthorService from "@/services/AuthorService";

export default {
  name: "author-details",
  data() {
    return {
      currentAuthor: null
    }
  },
  methods: {
    details(id){
      AuthorService.getById(id).then(response => {
        this.currentAuthor = response.data;
        console.log(response.data);
      })
    }
  },
  mounted() {
    this.details(this.$route.params.id);
  }
}
</script>