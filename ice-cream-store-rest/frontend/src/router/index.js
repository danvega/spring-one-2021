import { createRouter, createWebHistory } from 'vue-router'

import Home from '/src/views/Home.vue'
import Locations from '/src/views/Locations.vue'
import About from '/src/views/About.vue'
import Contact from '/src/views/Contact.vue'

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home,
    },
    {
        path: '/locations',
        name: 'Locations',
        component: Locations,
    },
    {
        path: '/about',
        name: 'About',
        component: About,
    },
    {
        path: '/contact',
        name: 'Contact',
        component: Contact,
    },
]
const router = createRouter({
    history: createWebHistory(),
    routes,
})

export default router
