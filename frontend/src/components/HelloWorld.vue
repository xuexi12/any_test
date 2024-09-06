<script setup>
import { ref } from "vue";

const { msg } = defineProps({
  msg: String,
});

const count = ref(0);
</script>

<template>
  <div>
    <h1>{{ msg }}</h1>
    <p>Count: {{ count }}</p>
    <button @click="count++">Increment</button>
  </div>
</template>

<style scoped></style>
