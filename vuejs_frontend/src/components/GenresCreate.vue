<template>
  <div class="container" v-if="!submitted" >
    <form @submit="create" class="needs-validation" novalidate>
      <div class="mb-3">
        <label for="genre-name">Genre Name</label>
        <input type="text" class="form-control" id="genre-name" v-model="genre.name" :class="isValidField">
        <div id="emailHelp" class="form-text">Add just one Genre.</div>
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
  </div>
</template>

<script>
import GenreService from "@/services/GenreService";
import {toast} from "vue3-toastify";

export default {
  name: "genre-create",
  data() {
    return {
      genre: {
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
        name: this.genre.name
      };
      if(data.name == null || data.name === "" || data.name.length <=0){
        event.preventDefault();
        this.isValidField = "is-invalid"
        toast.error("Genre name is Required", {position: toast.POSITION.TOP_CENTER});
      }else{
        GenreService.create(data).then(response => {
          this.genre.id = response.data.id;
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