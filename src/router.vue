<script>
	import { createRouter, createWebHistory } from 'vue-router';
	import Home from '@/views/home';
	import Community from '@/views/community';
	import Connections from '@/views/connections';
	import Chat from '@/views/chats';
	import Settings from '@/views/settings';
	import Main from '@/layouts/main.vue';

	const routes = [
		{
			path: '/',
			component: Main,
			children: [
				{ path: '/', name: 'Home', component: Home },
				{ path: '/community', name: 'Community', component: Community },
				{ path: '/connections', name: 'Connections', component: Connections },
				{ path: '/chats', name: 'Chat', component: Chat },
				{ path: '/settings', name: 'Settings', component: Settings },
			],
		},
	];

	const router = createRouter({
		history: createWebHistory(),
		routes,
	});

	export default router;
</script>
