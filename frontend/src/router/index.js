import { createRouter, createWebHistory } from "vue-router";
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

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
