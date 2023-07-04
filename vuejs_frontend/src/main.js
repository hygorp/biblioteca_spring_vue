import { createApp } from 'vue'
import App from './App.vue'
import router from "@/router";
import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import {toast} from "vue3-toastify";
import 'vue3-toastify/dist/index.css';


createApp(App).use(router, toast).mount('#app')
