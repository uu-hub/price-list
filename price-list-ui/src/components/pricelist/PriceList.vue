<template>
  <div id="price-list" class="body-wrapper">
    <el-table :data="tableData" style="width: 100%" height="250">
      <el-table-column fixed prop="goodsName" label="商品名" width="150">
      </el-table-column>
      <el-table-column prop="goodsPrice" label="商品价格" width="120"> </el-table-column>
      <el-table-column prop="unit" label="单位" width="120">
      </el-table-column>
      <el-table-column prop="spec" label="规格" width="120"> </el-table-column>
      <el-table-column prop="type" label="种类" width="300">
      </el-table-column>
      <el-table-column prop="supermarket" label="超市" width="120"> </el-table-column>
      <el-table-column prop="recordDate" label="记录日期" width="120"> </el-table-column>
    </el-table>
  </div>
</template>

<script>
  export default {
    data() {
      return {
      }
    }
  }
</script>

<style scoped>
#cluster-manage {
  min-width: 1000px;
}

.manage-header-wrapper {
  padding-bottom: 20px;
  border-bottom: 1px solid #dcdfe6;
}

.base-info-operation-wrapper {
  margin-top: 20px;
  display: flex;
  align-items: center;
}

.bad {
  color: #f4516c;
}

.base-info-item {
  margin-right: 20px;
}

.batch-title {
  margin-bottom: 10px;
  color: #909399;
  font-size: 14px;
}

.nodes-wrapper,
.table-wrapper {
  margin-top: 20px;
}

.el-table >>> .info-row {
  background: #fafafa !important;
}

.master-line {
  background-color: #f5f7fa;
}

.status-icon {
  font-size: 16px;
}

.normal-status {
  color: #40c9c6;
}

.bad-status {
  color: #f4516c;
}

.refresh {
  font-size: 20px;
  cursor: pointer;
  color: #909399;
}

.refresh:hover {
  color: #2c3e50;
}

.dialog-footer {
  display: flex;
  justify-content: flex-end;
}
</style>