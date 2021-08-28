<template>
  <header class="bg-pink-200 h-48">
    <div class="container mx-auto py-8 flex items-center">
      <menu class="flex-1 flex space-x-4">
        <router-link :to="{name: 'Home' }" class="text-gray-700 px-3 py-2 rounded-md text-sm font-medium" exact>Order Online</router-link>
        <router-link :to="{name: 'Locations' }" class="text-gray-700 hover:bg-pink-400 hover:text-white px-3 py-2 rounded-md text-sm font-medium">Locations</router-link>
        <router-link :to="{name: 'About'}" class="text-gray-700 hover:bg-pink-400 hover:text-white px-3 py-2 rounded-md text-sm font-medium">About Us</router-link>
        <router-link :to="{name: 'Contact'}" class="text-gray-700 hover:bg-pink-400 hover:text-white px-3 py-2 rounded-md text-sm font-medium">Contact Us</router-link>
      </menu>
      <div class="flex-1 ">
        <img src="/src/assets/img/ice_cream.png" class="h-28"/>
      </div>
      <div class="flex">
        <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M3 3h2l.4 2M7 13h10l4-8H5.4M7 13L5.4 5M7 13l-2.293 2.293c-.63.63-.184 1.707.707 1.707H17m0 0a2 2 0 100 4 2 2 0 000-4zm-8 2a2 2 0 11-4 0 2 2 0 014 0z" />
        </svg>
        <span class="ml-1 font-bold">{{store.state.cartTotal}}</span> <span class="ml-2">item(s)</span>
      </div>
    </div>
  </header>
</template>

<script setup>
import {defineProps, ref} from "vue";
import { useStore } from 'vuex'

const store = useStore()

</script>

<style>
.router-link-active {
  @apply bg-pink-400 text-white;
}
</style>
