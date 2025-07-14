<script>
	import Login from '@/views/login.vue';
	import { getInsets } from 'tauri-plugin-safe-area-insets';

	export default {
		components: {
			Login,
		},
		data() {
			return {
				isLogined: false,
				isLoading: true,
			};
		},
		mounted() {
			document.addEventListener('readystatechange', () => {
				if (document.readyState === 'complete') {
					this.finishLoading();
				}
			});

			getInsets()
				.then((insets) => {
					document.documentElement.style.setProperty('--safe-inset-top', `${insets.top}px`);
					document.documentElement.style.setProperty('--safe-inset-bottom', `${insets.bottom}px`);
					document.documentElement.style.setProperty('--safe-inset-left', `${insets.left}px`);
					document.documentElement.style.setProperty('--safe-inset-right', `${insets.right}px`);
				})
				.catch((error) => {
					console.error('Error getting insets:', error);
				});
		},
		methods: {
			finishLoading() {
				this.isLoading = false;
			},
		},
	};
</script>

<template>
	<template v-if="isLoading"> ... </template>

	<template v-else>
		<Transition name="slide-fade" appear mode="out-in">
			<div class="login-wrapper" v-if="!isLogined">
				<Login @login="isLogined = true" />
			</div>
		</Transition>

		<Transition name="slide">
			<div v-if="isLogined" class="main-content">
				<RouterView />
			</div>
		</Transition>
	</template>
</template>

<style scoped>
	.login-wrapper {
		left: 50%;
		top: 50%;
		transform: translate3d(-50%, -50%, 0);
		position: absolute;
		display: flex;
		justify-content: center;
		align-items: center;
		width: 100%;
		height: 100%;
	}

	.main-content {
		border-top-left-radius: 50px;
		border-bottom-left-radius: 50px;
		width: calc(100% + 50px);
		height: 100%;
		background-color: aliceblue;
		position: absolute;
		transform: translate3d(-50px, 0, 0);
		padding-left: 50px;
		overflow: hidden;
	}

	.slide-fade-enter-to,
	.slide-fade-leave-from {
		transform: translate3d(0, -50%, 0) translateX(-50%);
		opacity: 1;
	}
	.slide-fade-enter-from,
	.slide-fade-leave-to {
		transform: translate3d(0, -20%, 0) translateX(-50%);
		opacity: 0;
	}
	.slide-fade-enter-active {
		transition: all 0.5s;
	}
	.slide-fade-leave-active {
		transition: all 0.5s ease-in-out;
	}

	.slide-enter-to,
	.slide-leave-from {
		transform: translate3d(-50px, 0, 0);
	}
	.slide-enter-from,
	.slide-leave-to {
		transform: translate3d(calc(100% + 50px), 0, 0);
	}
	.slide-enter-active {
		transition: transform 1s ease;
	}
</style>

<style>
	html {
		height: 100%;
		background-color: aliceblue;
	}

	body {
		background: linear-gradient(45deg, rgb(77, 20, 120) 10%, rgb(77, 134, 179) 100%);
		background-size: 200% 200%;
		animation: gradientAnimation 5s ease infinite;
		margin: 0;
		height: 100%;
		overflow: hidden;
	}

	* {
		box-sizing: border-box;
		margin: 0;
	}

	body::before {
		content: '';
		position: absolute;
		width: 100%;
		height: 30%;
		background: linear-gradient(to bottom, rgba(255, 255, 255, 0.5), rgba(255, 255, 255, 0));
		filter: opacity(60%);
		z-index: -10;
		pointer-events: none;
	}

	@keyframes gradientAnimation {
		0% {
			background-position: 0% 50%;
		}
		50% {
			background-position: 100% 50%;
		}
		100% {
			background-position: 0% 50%;
		}
	}

	#app {
		font-family: system-ui, -apple-system, 'Helvetica Neue', Helvetica, sans-serif, serif, Arial;
	}

	a,
	button,
	input,
	textarea,
	select,
	option,
	label,
	svg {
		-webkit-tap-highlight-color: transparent;
	}
</style>
