<script setup>
import { ref, onMounted, onUnmounted } from "vue";
import { useRoute, useRouter } from "vue-router";

const route = useRoute();
const router = useRouter();
const countdown = ref("");
const isEnded = ref(false);

let timer;
onMounted(() => {
  updateCountdown();
  timer = setInterval(updateCountdown, 1000);
});

onUnmounted(() => {
  clearInterval(timer);
  document.title = "结束";
});
function getTargetTime() {
  const targetParam = route.query.off;
  if (targetParam && /^\d{4}$/.test(targetParam)) {
    const hours = parseInt(targetParam.slice(0, 2), 10);
    const minutes = parseInt(targetParam.slice(2), 10);

    if (hours >= 0 && hours < 24 && minutes >= 0 && minutes < 60) {
      const now = new Date();
      return new Date(
        now.getFullYear(),
        now.getMonth(),
        now.getDate(),
        hours,
        minutes,
        0,
      );
    }
  }

  router.replace({ query: { off: "1730" } });
  return new Date(new Date().setHours(17, 30, 0, 0));
}

function updateCountdown() {
  const now = new Date();
  const target = getTargetTime();

  if (now > target) {
    document.title = "结束";
    countdown.value = "结束";
    isEnded.value = true;
  } else {
    const diff = target - now;
    const hours = Math.floor(diff / 3600000);
    const minutes = Math.floor((diff % 3600000) / 60000);
    const seconds = Math.floor((diff % 60000) / 1000);

    const countdownString = `${hours.toString().padStart(2, "0")}:${minutes.toString().padStart(2, "0")}:${seconds.toString().padStart(2, "0")}`;
    countdown.value = countdownString;
    document.title = `${countdownString}`;
    isEnded.value = false;
  }
}

function handleClick() {
  navigator.clipboard.writeText(countdown.value);
}
</script>

<template>
  <div class="container">
    <div v-if="!isEnded" class="countdown">
      <p class="countdown-text" @click="handleClick">{{ countdown }}</p>
    </div>
    <p v-else class="ended">结束</p>
  </div>
</template>

<style scoped>
.container {
  user-select: none;
  height: 100vh;
  display: flex;
  justify-content: center;
  padding-top: 20vh;
  font-weight: bold;
  color: #cf5659;
}

.countdown-text {
  cursor: pointer;
}

.countdown {
  font-size: 22vw;
}

.ended {
  font-size: 10vw;
}
</style>
