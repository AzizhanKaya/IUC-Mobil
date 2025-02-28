<script setup>

    import { Icon } from '@iconify/vue';

    import { ref } from 'vue';
    const messages = [
        {
            content: "Merhaba",
            sender: true
        },
        {
            content: "MerhabaMerhabaMerhabaMerhabaMerhabaMerhabaMerhabaMerhaba",
            sender: false
        },
        {
            content: "Merhaba",
            sender: true
        },
        {
            content: "Merhaba",
            sender: false
        },
        {
            content: "Merhaba",
            sender: true
        },
        {
            content: "Merhaba",
            sender: true
        },
        {
            content: "MerhabaMerhabaMerhabaMerhabaMerhabaMerhabaMerhabaMerhaba",
            sender: false
        },
        {
            content: "Merhaba",
            sender: true
        },
        {
            content: "Merhaba",
            sender: false
        },
        {
            content: "Merhaba",
            sender: true
        },
        {
            content: "Merhaba",
            sender: true
        },
        {
            content: "MerhabaMerhabaMerhabaMerhabaMerhabaMerhabaMerhabaMerhaba",
            sender: false
        },
        {
            content: "Merhaba",
            sender: true
        },
        {
            content: "Merhaba",
            sender: false
        },
        {
            content: "Merhaba",
            sender: true
        },
    ]

</script>


<template>

    <div class="chat">
        <header>
            <img src="/profile-pic.png">
            <div class="name">Aziz</div>
        </header>

        <main>

            <div class="message" v-for="message in messages" :key="message.id" :class="{'user': message.sender}">
                {{ message.content }}
            </div>

        </main>


        <footer>
            <Icon icon="mdi:plus" />
            <input type="text" @focus="inputFocused = true" @blur="inputFocused = false">
        
            <Icon icon="mdi:send" />
        </footer>

    </div>
</template>


<style scoped>


.chat {
    display: flex;
    flex-direction: column;
    height: 100%;
    position: absolute;
    top: 0;
    left: 0;
    background-color: #fff;
    overflow: hidden;
    touch-action: none;
    
}

header {
    display: flex;
    align-items: center;
    padding: 10px;
    background-color: #f0f0f0;
}

header img {
    width: 40px;
    height: 40px;
    border-radius: 50%;
}

.name {
    font-size: 1.7em;
    font-weight: 500;
    margin-left: 10px;
}

main {
    display: flex;
    padding: 10px;
    flex-direction: column;
    gap: 10px;
    flex: 1;
    overflow-y: scroll;
}

.message {
    width: fit-content;
    max-width: 80%;
    padding: 10px;
    border-radius: 10px;
    background-color: #f0f0f0;
    text-wrap: wrap;
    word-break: break-all;
}

.message.user {
    align-self: flex-end;
    background-color: #007bff;
    color: #fff;
}

footer {
    display: flex;
    align-items: center;
    padding: 10px;
    background-color: #f0f0f0;
    width: 100%;
    gap: 10px;
}


footer input {
    width: 100%;
    padding: 10px;
    border-radius: 10px;
    border: none;
}

footer svg {
    width: 30px;
    height: 30px;
    border-radius: 50%;
    cursor: pointer;
    padding: 5px;
    flex-shrink: 0;
    color: #2b2b2b;
}

footer svg:active {
    scale: 0.8;
    background-color: #a5a5a5;
    transition: all 0.1s ease-in-out;
}




</style>