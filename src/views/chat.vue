<script setup>

import Chat from "../components/chat.vue";

const rooms = [
    {
        name: 'Aziz',
        lastMessage: 'HelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHello',
        time: '12:00',
    },
    {
        name: 'Room 2',
        lastMessage: 'Hello',
        time: '12:00',
        unreadCount: 10
    },
    {
        name: 'Room 1',
        lastMessage: 'Hello',
        time: '12:00',
    },
    {
        name: 'Room 2',
        lastMessage: 'Hello',
        time: '12:00',
        unreadCount: 10
    },
    {
        name: 'Room 1',
        lastMessage: 'Hello',
        time: '12:00',
    },
    {
        name: 'Room 2',
        lastMessage: 'Hello',
        time: '12:00',
        unreadCount: 10
    },
    {
        name: 'Room 1',
        lastMessage: 'Hello',
        time: '12:00',
    },
    {
        name: 'Room 2',
        lastMessage: 'Hello',
        time: '12:00',
        unreadCount: 10
    },
    {
        name: 'Room 1',
        lastMessage: 'Hello',
        time: '12:00',
    },
    
]

</script>


<template>
    <div class="chats">

    
        <div class="header">
            <h1>Sohbetler</h1>
            <div class="search">
                <input type="text" placeholder="Ara...">
            </div>
        </div>

        
        
        <div class="rooms">
            <div class="room" v-for="room in rooms" :key="room.name">
                <img src="/profile-pic.png" />

                
                <div class="content">
                    <div class="name">{{ room.name }}</div>
                    <div class="last-message">{{ room.lastMessage }}</div>
                </div>
                

                <div class="message-info">
                    <div class="time">{{ room.time }}</div>
                    <div class="unread-count" v-if="room.unreadCount > 0">{{ room.unreadCount }}</div>
                </div>
            </div>
        </div>
        
    </div>

    <Teleport to="#app">
        <Chat />
    </Teleport>
    
</template>

<style scoped>

    .chats{
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
        transition: .3s ease;
        font-weight: 200;
    }

    input:focus, .login input:hover {
        border-color: rgba(129, 140, 248);
        background-color: #fff;
    }

    .rooms {
        display: flex;
        flex-direction: column;
    }

    .room {
        display: flex;
        align-items: center;
        gap: 10px;
        border-bottom: 1px solid #e0e0e0;
        padding: 15px;
    }

    .room img {
        width: clamp(50px, 15%, 75px);
        aspect-ratio: 1/1;
        border-radius: 50%;
        flex-shrink: 0;
    }

    .content {
        display: flex;
        flex-direction: column;
        flex-grow: 1;
        gap: 3px;
    }

    .content * {
        white-space: nowrap;
        text-overflow: ellipsis;
        overflow: hidden;
    }

    .name {
        line-height: 20px;
        font-size: 1.5em;
        font-weight: bold;
        color: #555;
    }

    .last-message {
        font-size: 1em;
        color: #555;
        max-width: 20ch;
    }
    
    .message-info{
        display: flex;
        flex-direction: column;
        align-items: flex-end;
        gap: 15px;
    }
    
    .time {
        color: #aaa;
        font-size: 12px;
        margin-left: auto;
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
    }

</style>