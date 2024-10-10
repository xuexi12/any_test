import { defineConfig } from "vite";
import vue from "@vitejs/plugin-vue";

// https://vitejs.dev/config/
export default defineConfig(({}) => {
  return {
    plugins: [vue()],
    server: {
      port: 5174,
    },
    base: process.env.VITE_BASE_PATH ?? "/",
    resolve: {
      alias: {
        "@": "/src",
      },
    },
  };
});
