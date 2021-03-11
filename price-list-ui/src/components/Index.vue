<template>
  <el-container id="index">
    <el-header class="header header-wrapper">
      <div class="grid-content logo-wrapper">
        <i class="el-icon-s-fold aside-operation" @click="collapseHandler"></i>
        <img src="../assets/redis-manager.png" style="width: 150px; height: 15px" />
      </div>
      <div class="grid-content right-content" id="right-content">
        <div class="user-info">
          <!-- <span class="user-name">Redis</span> -->
          <el-dropdown @command="handleCommand" class="user-dropdown">
            <el-image
              :src="currentUser.avatar"
              @error="errorHandler"
              fit="cover"
            >{{ currentUser.userName }}</el-image>
            <el-dropdown-menu slot="dropdown" style="min-width: 180px">
              <el-dropdown-item disabled>
                Signed in as
                <b>{{ currentUser.userName }}</b>
              </el-dropdown-item>
              <el-dropdown-item command="profile" divided>Profile</el-dropdown-item>
              <el-dropdown-item divided @click.native="signOut">Sign out</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>
      </div>
    </el-header>
    <el-container class="aside-main-wrapper">
      <el-aside :class="{'is-collapse':isCollapse}" style="width: 200px;">
        <el-row>
          <el-col :span="24">
            <el-menu
              default-active="1"
              @open="handleOpen"
              @close="handleClose"
              :collapse="isCollapse"
              :collapse-transition="false"
              background-color="#2a3542"
              text-color="#909399"
              active-text-color="#fff"
            >
              <!-- background-color="#2a3542"
              text-color="#909399"
              active-text-color="#fff"-->
              <el-menu-item index="1" @click="toPriceList()">
                <i class="el-icon-notebook-2"></i>
                <span slot="title">PriceList</span>
              </el-menu-item>
            </el-menu>
          </el-col>
        </el-row>
      </el-aside>
      <el-main class="main" :class="{'main-margin':isCollapse}" style="margin-left: 200px;">
        <transition name="fade" mode="out-in">
          <router-view v-if="active"></router-view>
        </transition>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
var elementResizeDetectorMaker = require("element-resize-detector");
import { store } from "@/vuex/store.js";
import API from "@/api/api.js";
import editCluster from "@/components/manage/EditCluster";
import message from "@/utils/message.js";
export default {
  components: {
    editCluster
  },
  data() {
    return {
      isCollapse: false,
      active: true,
      permission: true,
      importVisible: false
    };
  },
  methods: {
    signOut() {
      let url = "/user/signOut";
      API.post(
        url,
        null,
        response => {
          this.$router.push({
            name: "login"
          });
        },
        err => {
          message.error(err);
        }
      );
    },
    toPriceList() {
      this.$router.push({
        name: "pricelist"
      });
    },
    handleCommand(command) {
      if (command == "profile") {
        this.toUserProfile();
      }
    },
    toUserProfile() {
      this.$router.push({
        name: "profile",
        params: { userId: this.currentUser.userId }
      });
    },
    handleOpen(key, keyPath) {},
    handleClose(key, keyPath) {},
    errorHandler() {
      return true;
    },
    collapseHandler() {
      this.isCollapse = !this.isCollapse;
    },
    getUserFromSession() {
      let url = "/user/getUserFromSession";
      API.get(
        url,
        null,
        response => {
          let result = response.data;
          if (result.code == 0) {
            store.dispatch("setUser", result.data);
          } else {
            this.signOut();
          }
        },
        err => {
          message.error("Auto get user failed.");
        }
      );
    }
  },
  computed: {
    currentUser() {
      return store.getters.getUser;
    },
  },
  mounted() {
    this.getUserFromSession();
    if (this.$route.path == "/") {
      this.toPriceList();
    }
  },
  created() {
  }
};
</script>

<style>
#index {
  height: 100%;
}

/*页面下拉，header固定不动*/
.header {
  position: fixed;
  width: 100%;
  z-index: 100;
  overflow: hidden;
  padding: 0 !important;
  line-height: 40px;
  -webkit-box-shadow: 0 0 5px rgba(102, 102, 102, 0.05);
  -moz-box-shadow: 0 0 5px rgba(102, 102, 102, 0.05);
  box-shadow: 0 0 5px rgba(102, 102, 102, 0.05);
  border-bottom: 1px solid #dcdfe6;
  background-color: #ffffff;
}

.header-wrapper {
  padding: 10px 0;
  overflow: hidden;
  display: flex;
  justify-content: space-between;
}

.logo-wrapper {
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 180px;
  cursor: pointer;
  padding-left: 22px;
}

.aside-operation {
  font-size: 22px;
  margin-right: 5px;
}

.right-content {
  display: flex;
  justify-content: flex-end;
}

.links {
  padding: 0 10px;
  display: flex;
  align-items: center;
}

.link-icon {
  font-size: 14px !important;
}

.group-select {
  margin: 0 1rem;
}

.user-info {
  margin: 0 20px;
}

.user-dropdown {
  display: flex !important;
  align-items: center;
}

.image-overflow {
  flex: 1;
  overflow: hidden;
}

.el-image {
  height: 36px;
  width: 36px;
  border-radius: 50%;
  display: flex;
}

.image-slot {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  background: #f5f7fa;
  color: #909399;
  font-size: 12px;
  white-space: nowrap;
}
.aside-main-wrapper {
  margin-top: 60px;
}

.el-aside {
  position: fixed;
  height: 100%;
  z-index: 100;
  overflow: hidden;
  background-color: #2a3542;
}

.main {
  background-color: #f0f2f5;
}

.is-collapse {
  width: auto !important;
}

.main-margin {
  margin-left: 65px !important;
}

.grid-content {
  min-height: 40px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
</style>
