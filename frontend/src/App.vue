<script setup>
import HelloWorld from "./components/HelloWorld.vue";
import Login from "./components/Login.vue";
</script>

<template>
  <main class="main">
    <HelloWorld msg="Any Test" />
    <Login />
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
