<template>
<div id="app">
  <h1>{{ count }}</h1>
        <button @click="increment" class="btn btn-primary">+</button>
        <button @click="decrement" class="btn btn-primary">-</button>
</div>
</template>

<script>
export default {
  data() {
    return {
      count: 0
    }
  },
  methods: {
    increment() {
      this.count++;
    },
    decrement() {
      this.count--;
    }
  }
}
</script>