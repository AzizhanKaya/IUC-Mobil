<script setup>
	import Chat from '../components/chat.vue';
	import { ref, computed } from 'vue';

	const rooms = [
		{
			name: 'Aziz',
			lastMessage: 'HelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHello',
			time: '12:00',
		},
		{ name: 'Room 2', lastMessage: 'Hello', time: '12:00', unreadCount: 10 },
		{ name: 'Room 1', lastMessage: 'Hello', time: '12:00' },
		{ name: 'Room 2', lastMessage: 'Hello', time: '12:00', unreadCount: 10 },
		{ name: 'Room 1', lastMessage: 'Hello', time: '12:00' },
		{ name: 'Room 2', lastMessage: 'Hello', time: '12:00', unreadCount: 10 },
		{ name: 'Room 1', lastMessage: 'Hello', time: '12:00' },
		{ name: 'Room 2', lastMessage: 'Hello', time: '12:00', unreadCount: 10 },
		{ name: 'Room 1', lastMessage: 'Hello', time: '12:00' },
	];

	const selectedRoom = ref(null);
	const isChatOpen = ref(false);

	const openChat = (room) => {
		selectedRoom.value = room;
		isChatOpen.value = true;
	};

	const closeChat = () => {
		isChatOpen.value = false;
	};
</script>

<template>
	<div class="chats">
		<div class="header">
			<h1>Sohbetler</h1>
			<div class="search">
				<input type="text" placeholder="Ara..." />
			</div>
		</div>

		<div class="rooms">
			<div class="room" v-for="room in rooms" :key="room.name" @click="openChat(room)">
				<img src="/profile-pic.png" />

				<div class="content">
					<div class="name">{{ room.name }}</div>
					<div class="last-message">{{ room.lastMessage }}</div>
				</div>

				<div class="message-info">
					<div class="time">{{ room.time }}</div>
					<div class="unread-count" v-if="room.unreadCount > 0">
						{{ room.unreadCount }}
					</div>
				</div>
			</div>
		</div>
	</div>

	<Teleport to="#app">
		<Chat v-if="selectedRoom" :room="selectedRoom" :is-open="isChatOpen" @close="closeChat" />
	</Teleport>
</template>

<style scoped>
	.chats {
		height: 100%;
		overflow-y: scroll;
		overflow-x: hidden;
		padding-bottom: 75px;
		padding-top: var(--safe-inset-top, 20px);
	}

	.header {
		padding-top: 20px;
		border-bottom: 1px solid #e0e0e0;
		font-size: 1.2em;
	}

	.search {
		padding: 10px;
		padding-left: 10px;
		position: relative;
		left: 50%;
		transform: translateX(-50%);
	}

	.search input {
		width: 100%;
		height: 100%;
		padding: 2px;
		padding-left: 30px;
		border: 2px solid transparent;
		font-size: 1.2rem;
		border-radius: 20px;
		outline: none;
		background-color: #e3e7e9;
		color: #0d0c22;
		transition: 0.3s ease;
		font-weight: 200;
	}

	input:focus,
	.login input:hover {
		border-color: rgba(129, 140, 248);
		background-color: #fff;
	}

	.room {
		display: block;
		border-bottom: 1px solid #e0e0e0;
		padding: 15px;
		white-space: nowrap;
		cursor: pointer;
		-webkit-tap-highlight-color: transparent;
	}

	.room:active {
		background-color: #f5f5f5;
	}

	.room img {
		width: clamp(50px, 15%, 75px);
		aspect-ratio: 1/1;
		border-radius: 50%;
		float: left;
		margin-right: 10px;
	}

	.content {
		display: inline-block;
		vertical-align: middle;
		max-width: calc(100% - 120px);
		overflow: hidden;
		text-overflow: ellipsis;
	}

	.name {
		font-size: 1.5em;
		font-weight: bold;
		color: #555;
	}

	.last-message {
		font-size: 1em;
		color: #555;
		display: block;
		overflow: hidden;
		text-overflow: ellipsis;
		white-space: nowrap;
	}

	.message-info {
		display: inline-block;
		vertical-align: middle;
		float: right;
		text-align: right;
	}

	.time {
		color: #aaa;
		font-size: 12px;
	}

	.unread-count {
		color: #fff;
		background-color: #007bff;
		width: 20px;
		height: 20px;
		border-radius: 50%;
		text-align: center;
		line-height: 20px;
		font-size: 12px;
		display: inline-block;
	}
</style>
