<template>
  <div class="container" v-if="!submitted">
    <form>
      <div class="mb-3">
        <label for="name">Author Name</label>
        <input type="text" class="form-control" id="author-name" v-model="author.name">
        <div id="emailHelp" class="form-text">Add just one Author.</div>
      </div>
      <button type="submit" class="btn btn-primary" @click="create">Submit</button>
    </form>
  </div>
</template>

<script>

import AuthorService from "@/services/AuthorService";

export default {
  name: "author-create",
  data() {
    return {
      author: {
        id: null,
        name: ""
      },
      submitted: false
    };
  },
  methods: {
    create() {
      const data = {
        name: this.author.name
      };
      AuthorService.create(data).then(response => {
        this.author.id = response.data.id;
      }).catch(e => {
        console.log(e)
      });
    }
  }
}
</script>

<style>
.container{
  padding-top: 8%;
}
</style>