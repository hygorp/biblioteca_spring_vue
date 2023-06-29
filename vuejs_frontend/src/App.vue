<template>
  <div id="app">
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
      <div class="container-fluid">
        <a class="navbar-brand" href="/">Biblioteca</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav">
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                Books
              </a>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="/books">Book List</a></li>
                <li><a class="dropdown-item" href="/books/add">Book Add</a></li>
              </ul>
            </li>

            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                Clients
              </a>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="/clients">Client List</a></li>
                <li><a class="dropdown-item" href="/clients/add">Cliend Add</a></li>
              </ul>
            </li>

            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                Orders
              </a>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="/orders">Order List</a></li>
                <li><a class="dropdown-item" href="/orders/add">Order Add</a></li>
              </ul>
            </li>

            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                Authors
              </a>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="/authors">Authors List</a></li>
                <li><a class="dropdown-item" href="/authors/add">Authors Add</a></li>
              </ul>
            </li>

            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                Genres
              </a>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="/genres">Genre List</a></li>
                <li><a class="dropdown-item" href="/genres/add">Genre Add</a></li>
              </ul>
            </li>

          </ul>
        </div>
      </div>
    </nav>
    <div class="content">
      <router-view />
    </div>
  </div>
</template>

<script>

export default {
  name: 'app',
}

</script>