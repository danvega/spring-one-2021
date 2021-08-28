<template>
  <form v-for="product in products" method="post" @submit.prevent="onAddToCart($event)">
    <input type="hidden" name="id" :value="product.id"/>
    <input type="hidden" name="name" :value="product.name"/>
    <input type="hidden" name="price" :value="product.price"/>
    <input type="hidden" name="category" :value="product.category"/>
    <div class="bg-white border-2 rounded-none flex p-4">
      <div class="flex-1">
        <div class="flex flex-col">
          <h3>{{product.name}}</h3>
          <div>{{product.price}}</div>
          <div class="mt-8">
            <button class="bg-blue-400 hover:bg-blue-500 text-white font-bold py-2 px-4 rounded flex">
              <svg v-if="isSaving && currentProduct == product.id" class="animate-spin -ml-1 mr-3 h-5 w-5 text-white" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24">
                <circle class="opacity-25" cx="12" cy="12" r="10" stroke="currentColor" stroke-width="4"></circle>
                <path class="opacity-75" fill="currentColor" d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4zm2 5.291A7.962 7.962 0 014 12H0c0 3.042 1.135 5.824 3 7.938l3-2.647z"></path>
              </svg>
              Add to Cart
            </button>
          </div>
        </div>
      </div>
      <div class="bg-blue-100 rounded-full h-32 w-32 text-2xl font-medium">
        <p class="text-center mt-8">{{product.name}}</p>
      </div>
    </div>
  </form>
</template>

<script setup>
import {defineProps, getCurrentInstance, onMounted, reactive, ref} from "vue";

const props = defineProps({
  products: Array
})
const emit = defineEmits(['onProductSaved'])
const product = reactive({
  id: null,
  name: '',
  price: '',
  category: '',
});
const isSaving = ref(false);
const currentProduct = ref(null);
const instance = getCurrentInstance();

function onAddToCart($event) {
  const id = $event.target.id.value;
  currentProduct.value = id;
  product.id = id;
  product.name = $event.target.name.value;
  product.price = $event.target.price.value;
  product.category = $event.target.category.value;

  isSaving.value = true;
  (async () => {
    const response = await fetch('/api/cart', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(product)
    });
    const updated = await response.json();
    currentProduct.value = null;

    // when add to cart is done emit an event that a product was saved.
    // so that + 1 can be added to the cart
    // this.saved can be updated to true
    instance.emit('onProductSaved')

  })();


}

</script>
