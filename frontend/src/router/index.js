import {
  createRouter,
  createWebHashHistory,
  createWebHistory,
} from "vue-router";
import HelloWorld from "@/components/HelloWorld.vue";
import XiaBan from "@/views/Xiaban.vue";

const routes = [
  {
    path: "/",
    redirect: "/xiaban",
  },
  {
    path: "/home",
    name: "Home",
    component: HelloWorld,
  },
  {
    path: "/xiaban",
    name: "XiaBan",
    component: XiaBan,
  },
];

// 根据环境变量决定使用哪种 history 模式（github pages 需要使用 hash 模式）
const BASE = import.meta.env.VITE_BASE_PATH;
const isHashMode = BASE !== "/";

const router = createRouter({
  history: isHashMode ? createWebHashHistory(BASE) : createWebHistory(BASE),
  routes,
});

export default router;
