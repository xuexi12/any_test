<script setup>
import HelloWorld from "./components/HelloWorld.vue";
import TodoResult from "./components/TodoResult.vue";
</script>

<template>
  <main class="main">
    <HelloWorld msg="Any Test" />
    <TodoResult />
  </main>
</template>

<style scoped>
.main {
  max-width: 1280px;
  margin: 0 auto;
  padding: 2rem;
  text-align: center;
}
</style>
