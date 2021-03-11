<template>
  <div class="page-container">
    <p class="code">404</p>
    <div>
      <el-link @click="toPriceList()">Back to home page</el-link>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    toPriceList() {
      this.$router.push({
        name: "pricelist"
      });
    }
  },
  computed: {
  }
};
</script>

<style scoped>
/** <style lang="scss" scoped> */
.page-container {
  font-size: 32px;
  text-align: center;
  color: rgb(192, 204, 218);
}
.code {
  color: #007fff;
  font-size: 68px;
}
</style>