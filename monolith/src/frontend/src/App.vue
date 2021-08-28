<template>
  <h1>{{msg}}</h1>
</template>

<script setup>
  import {ref, onMounted} from "vue";

  let msg = ref("")

  onMounted(async () => {
    const response = await fetch("/api/messages/hello");
    msg.value = await response.text();
  })

</script>
