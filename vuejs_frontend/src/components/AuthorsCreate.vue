<template>
  <div class="container" v-if="!submitted">
    <form @submit="create">
      <div class="mb-3">
        <label for="name">Author Name</label>
        <input type="text" class="form-control" id="author-name" v-model="author.name" :class="isValidField">
        <div id="emailHelp" class="form-text">Add just one Author.</div>
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
  </div>
</template>

<script>

import AuthorService from "@/services/AuthorService";
import {toast} from "vue3-toastify";

export default {
  name: "author-create",
  data() {
    return {
      author: {
        id: null,
        name: ""
      },
      submitted: false,
      isValidField: ""
    };
  },
  methods: {
    create(event) {
      const data = {
        name: this.author.name
      };
      if(data.name == null || data.name === "" || data.name.length <=0){
        event.preventDefault();
        this.isValidField = "is-invalid"
        toast.error("Author name is Required", {position: toast.POSITION.TOP_CENTER});
      }else {
        AuthorService.create(data).then(response => {
          this.author.id = response.data.id;
        }).catch(e => {
          console.log(e)
        });
      }
    }
  }
}
</script>

<style>
.container{
  padding-top: 8%;
}
</style>