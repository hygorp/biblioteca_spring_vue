import { createWebHistory, createRouter } from "vue-router";

const routes = [
    {
        path: "/books",
        alias: "/books",
        name: "Books",
        component: () => import("./components/BooksList.vue")
    },
    {
        path: "/books/add",
        alias: "/books/add",
        name: "Add Book",
        component: () => import("./components/BooksCreate.vue")
    },
    {
        path: "/books/:id/details",
        alias: "/books/:id/details",
        name: "Book Detail",
        component: () => import("./components/BooksDetails.vue")
    },
    {
        path: "/clients",
        alias: "/clients",
        name: "Clients",
        component: () => import("./components/ClientsList.vue")
    },
    {
        path: "/clients/add",
        alias: "/clients/add",
        name: "Add Client",
        component: () => import("./components/ClientsCreate.vue")
    },
    {
        path: "/clients/:id/details",
        alias: "/clients/:id/details",
        name: "Client Detail",
        component: () => import("./components/ClientsDetails.vue")
    },
    {
        path: "/authors",
        alias: "/authors",
        name: "Authors",
        component: () => import("./components/AuthorsList.vue")
    },
    {
        path: "/authors/add",
        alias: "/authors/add",
        name: "Add Author",
        component: () => import("./components/AuthorsCreate.vue")
    },
    {
        path: "/authors/:id/details",
        alias: "/authors/:id/details",
        name: "Author Detail",
        component: () => import("./components/AuthorsDetails.vue")
    },
    {
        path: "/genres",
        alias: "/genres",
        name: "Genres",
        component: () => import("./components/GenresList.vue")
    },
    {
        path: "/genres/add",
        alias: "/genres/add",
        name: "Add Genre",
        component: () => import("./components/GenresCreate.vue")
    },
    {
        path: "/genres/:id/details",
        alias: "/genres/:id/details",
        name: "Genre Detail",
        component: () => import("./components/GenreDetails.vue")
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;