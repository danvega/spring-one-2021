<template>
  <transition name="fade">
    <InfoBar v-if="isSaved">
      The product was successfully added to the cart!
    </InfoBar>
  </transition>
  <h2 class="text-4xl font-bold text-gray-800 mb-8">Scoops</h2>
  <section class="grid grid-cols-2 gap-16">
    <ProductList :products="products" @onProductSaved="onProductSaved">
    </ProductList>
  </section>
</template>

<script setup>
import {onMounted, reactive, ref} from "vue";
import SiteFooter from "../components/SiteFooter.vue";
import SiteHeader from "../components/SiteHeader.vue";
import InfoBar from "../components/InfoBar.vue";
import ProductList from "../components/ProductList.vue";
import { useStore } from 'vuex'

const store = useStore()
const products = ref([]);
const isSaved = ref(false);

onMounted(async () => {
  let response = await fetch("/api/products");
  products.value = await response.json();
})

function onProductSaved() {
  store.dispatch('updateCartTotal')
  isSaved.value = true;
  setTimeout(() => {
    isSaved.value = false;
  },5000);
}

</script>
