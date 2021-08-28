<template>
  <div class="bg-gray-100 bg-opacity-20">
    <div id="app" class="flex flex-col min-h-screen">
      <SiteHeader :cartTotal="cartTotal"/>
      <main class="container mx-auto py-8 flex-1">
        <router-view/>
      </main>
      <SiteFooter/>
    </div>
  </div>
</template>

<script setup>
import SiteFooter from "./components/SiteFooter.vue";
import SiteHeader from "./components/SiteHeader.vue";

</script>
