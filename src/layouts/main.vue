<script>
import { useRoute } from 'vue-router';
import { Icon } from '@iconify/vue';

export default {
  components: {
    Icon
  },
  setup() {
    const route = useRoute();
    
    const navItems = [
      { path: '/', iconFilled: 'mdi:home', iconOutline: 'mdi:home-outline' },
      { path: '/community', iconFilled: 'fluent:people-community-16-filled', iconOutline: 'fluent:people-community-16-regular' },
      { path: '/connections', iconFilled: 'streamline:cards-solid', iconOutline: 'streamline:cards' },
      { path: '/chat', iconFilled: 'bxs:chat', iconOutline: 'bx:chat' },
      { path: '/settings', iconFilled: 'ic:round-settings', iconOutline: 'fluent:settings-32-regular' }
    ];

    return { route, navItems };
  }
};
</script>

<template>
    <main>
        <router-view />
        <footer>
            <nav>
                <RouterLink v-for="item in navItems" :key="item.path" :to="item.path">
                    <Icon :icon="route.path === item.path ? item.iconFilled : item.iconOutline" />
                </RouterLink>
            </nav>
        </footer>
    </main>
</template>

<style scoped>

    main {
        position: relative;
        height: 100%;
    }

    footer {
        position: absolute;
        bottom: 1em;
        width: 95%;
        left: 50%;
        transform: translateX(-50%);
        border-radius: 20px;
        padding: 5px;
        backdrop-filter: blur(50px);
        background-color: #00445a6b;
        box-shadow: 0px 5px 15px 0px rgba(0, 0, 0, 0.3);
        z-index: 10;
    }

    nav {
        display: flex;
        justify-content: space-around;
    }

    nav > * > * {
        color: #333;
        font-size: 2em;
        font-weight: 100;
         
    }

    .router-link-exact-active > * {
        color: #111;
    }
</style>