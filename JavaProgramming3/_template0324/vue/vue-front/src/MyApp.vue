<template>
<div id="app">
  <h1>{{ count }}</h1>
        <button @click="increment" class="btn btn-primary">+</button>
        <button @click="decrement" class="btn btn-primary">-</button>
        <button v-on:click="sayHi('...', $event)">Click</button>
        <p v-if="isLoading">로딩 중입니다...</p>
        <p v-else>로딩이 끝남</p>
</div>
</template>

<script>
export default {
  data() {
    return {
      count: 0,
      isLoading: true
    }
  },
  mounted: function() {
    setTimeout(() => {
      this.isLoading = false
    }, 1000)
  },
  methods: {
    increment() {
      this.count++;
    },
    decrement() {
      this.count--;
    },
    sayHi: function(e) {
      //alert('안녕');
      console.log(e);
    }
  }
}
</script>
