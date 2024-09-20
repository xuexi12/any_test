<script setup>
import { login } from "@/api/auth";
import { ref } from "vue";

const username = ref("");
const password = ref("");
const message = ref("");

const handleLogin = async () => {
  try {
    const response = await login(username.value, password.value);
    message.value = response;
  } catch (error) {
    message.value = "登录失败: " + error.message;
  }
};
</script>

<template>
  <div>
    <h2>登录</h2>
    <form @submit.prevent="handleLogin">
      <div>
        <label for="username">用户名:</label>
        <input id="username" v-model="username" type="text" required />
      </div>
      <div>
        <label for="password">密码:</label>
        <input id="password" v-model="password" type="password" required />
      </div>
      <button type="submit">登录</button>
    </form>
    <p>{{ message }}</p>
  </div>
</template>

<style scoped>
form {
  display: flex;
  flex-direction: column;
  gap: 10px;
  max-width: 300px;
  margin: 0 auto;
}
</style>
