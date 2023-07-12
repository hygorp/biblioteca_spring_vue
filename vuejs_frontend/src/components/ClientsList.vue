<template>
  <div class="container">
    <h1 class="text-center">Clients  List</h1>
    <div class="table-responsive">
      <table class="table table-striped">
        <thead class="table-dark">
        <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Document</th>
          <th>Email</th>
          <th>Actions</th>
        </tr>
        </thead>

        <tbody>
        <tr v-for="(client, index) in clients" v-bind:key="index">
          <td>{{client.id}}</td>
          <td>{{client.name}}</td>
          <td>{{client.document}}</td>
          <td>{{client.email}}</td>
          <td class="col-md-2">
            <div class="btn-group">
              <a type="button" class="btn btn-outline-primary btn-sm" v-bind:href="`/clients/${client.id}/details`">Edit</a>
              <button type="submit" class="btn btn-outline-danger btn-sm" @click="deleteGenres(client.id)">Delete</button>
            </div>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>

import ClientService from "@/services/ClientService";

export default {
  name: 'clients-view',
  data(){
    return {
      clients: []
    }
  },
  methods: {
    getClients() {
      ClientService.findAll().then((response) => {
        this.clients = response.data;
        console.log(this.clients);
      });
    },
    deleteGenres(id) {
      ClientService.delete(id).then(response => {
        console.log(response.data);
        window.location.replace("/clients");
      })
    }
  },
  mounted() {
    this.getClients();
  }
}

</script>

<style scoped>
.container{
  padding-top: 8%;
}
</style>