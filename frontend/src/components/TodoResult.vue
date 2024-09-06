<script setup>
import { onMounted, ref } from "vue"
const data = ref({})

onMounted(async () => {
  const res = await fetch("https://jsonplaceholder.typicode.com/todos/1")
  data.value = await res.json()
})
</script>

<template>
  <div class="todo-res">
    {{ JSON.stringify(data) }}
  </div>
</template>

<style scoped>
.todo-res {
  margin-top: 20px;
}
</style>
