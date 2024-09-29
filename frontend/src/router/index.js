import { createRouter, createWebHistory } from "vue-router";
import HelloWorld from "@/components/HelloWorld.vue";
import XiaBan from "@/views/Xiaban.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: HelloWorld,
  },
  {
    path: "/xiaban",
    name: "XiaBan",
    component: XiaBan,
  },
  // 在这里添加更多路由...
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
