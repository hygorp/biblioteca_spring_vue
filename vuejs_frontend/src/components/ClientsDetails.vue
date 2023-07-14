<template>
  <div class="container" v-if="currentClient">
    <form>
      <fieldset>
        <legend>Personal Info</legend>
        <div class="row g-2 mb-3">
          <div class="col-md-1">
            <label for="client-id">#ID</label>
            <input type="text" class="form-control" id="client-id" v-model="currentClient.id" disabled>
          </div>

          <div class="col-md-7">
            <label for="client-name">Name</label>
            <input type="text" class="form-control" id="client-name" v-model="currentClient.name">
          </div>

          <div class="col-md-4">
            <label for="client-document">Document Number</label>
            <input type="text" class="form-control" id="client-document" v-model="currentClient.document">
          </div>
        </div>

        <div class="col-md-12 mb-3">
          <label for="client-email">Email</label>
          <input type="email" class="form-control" id="client-email" v-model="currentClient.email">
        </div>
      </fieldset>

      <fieldset>
        <legend>Address Info</legend>
        <div class="address-form" v-if="currentClient.addresses.length">
          <div class="address" v-for="(address, index) in currentClient.addresses" v-bind:key="index">
            <table class="table table-striped">
              <thead class="table-dark">
                <tr>
                  <th>Address</th>
                  <th>Postal Code</th>
                  <th>City</th>
                  <th>State</th>
                </tr>
              </thead>

              <tbody>
                <tr>
                  <td>{{address.address}}</td>
                  <td>{{address.postalCode}}</td>
                  <td>{{address.city}}</td>
                  <td>{{address.state}}</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
        <div v-else>
          <p>Address not found.</p>
        </div>

      </fieldset>

      <button type="button" class="btn btn-primary" @click="showModal">Add Address</button>

      <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
      </div>
    </form>
  </div>
</template>

<script>

import ClientService from "@/services/ClientService";

export default {
  name: "client-details",
  data() {
    return {
      currentClient: {
        id: null,
        name: "",
        document: "",
        email: "",
        addresses: []
      }
    }
  },
  methods: {
    details(id){
      ClientService.findById(id).then(response => {
        this.currentClient = response.data;
        console.log(response.data);
      })
    }
  },
  mounted() {
    this.details(this.$route.params.id);
  }
}

</script>

<style scoped>
.container{
  padding-top: 8%;
}
</style>