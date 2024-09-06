<script setup>
import { getApi } from "@/api";
import { onMounted, ref } from "vue";
const posts = ref({});

onMounted(async () => {
  posts.value = await getApi("/posts");
});
</script>

<template>
  <div class="posts">
    <div v-for="post in posts" :key="post.id">
      <div>{{ post.title }}</div>
    </div>
  </div>
</template>

<style scoped>
.posts {
  margin-top: 20px;
}
</style>
