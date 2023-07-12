<template>
  <div class="container" v-if="!submitted">
    <form @submit="create">
      <fieldset>
        <legend>Personal Info</legend>
        <div class="row g-2 mb-3">
          <div class="col-md-8">
            <label for="client-name">Name</label>
            <input type="text" class="form-control" id="client-name" v-model="client.name">
          </div>

          <div class="col-md-4">
            <label for="client-document">Document Number</label>
            <input type="text" class="form-control" id="client-document" v-model="client.document">
          </div>
        </div>

        <div class="col-md-12 mb-3">
          <label for="client-email">Email</label>
          <input type="email" class="form-control" id="client-email" v-model="client.email">
        </div>
      </fieldset>

      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
  </div>
</template>

<script>

import ClientService from "@/services/ClientService";

export default {
  name: "client-create",
  data() {
    return {
      client: {
        id: null,
        name: "",
        document: "",
        email: "",
        addresses: []
      },
      submitted: false,

    }
  },
  methods: {
    create() {
      const data = {
        name: this.client.name,
        document: this.client.document,
        email: this.client.email,
        addresses: this.client.addresses.map(address => ({id: address.id}))
      };
      ClientService.create(data).then(response => {
        this.client.id = response.data.id;
      }).catch(e => {
        console.log(e)
      });
    }
  },
  mounted() {

  }
}

</script>

<style scoped>
.container{
  padding-top: 8%;
}
</style>