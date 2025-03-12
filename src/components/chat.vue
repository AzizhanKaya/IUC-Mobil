<script setup>
import { ref, computed, onMounted, watch, nextTick } from 'vue';
import { Icon } from '@iconify/vue';

const props = defineProps({
    room: Object,
    isOpen: Boolean
});

const emit = defineEmits(['close']);

const messages = ref([
    { content: "Merhaba", sender: true },
    { content: "MerhabaMerhabaMerhabaMerhabaMerhabaMerhabaMerhabaMerhaba", sender: false },
    { content: "Merhaba", sender: true },
    { content: "Merhaba", sender: false },
    { content: "Merhaba", sender: true },
    { content: "MerhabaMerhabaMerhabaMerhabaMerhabaMerhabaMerhabaMerhaba", sender: false },
    { content: "Merhaba", sender: true },
    { content: "Merhaba", sender: false },
    { content: "Merhaba", sender: true },
    { content: "MerhabaMerhabaMerhabaMerhabaMerhabaMerhabaMerhabaMerhaba", sender: false },
    { content: "Merhaba", sender: true },
    { content: "Merhaba", sender: false },
    { content: "Merhaba", sender: true },
    { content: "MerhabaMerhabaMerhabaMerhabaMerhabaMerhabaMerhabaMerhaba", sender: false },
    { content: "Merhaba", sender: true },
    { content: "Merhaba", sender: false },
    { content: "Merhaba", sender: true },
    { content: "MerhabaMerhabaMerhabaMerhabaMerhabaMerhabaMerhabaMerhaba", sender: false },
    { content: "Merhaba", sender: true },
    { content: "Merhaba", sender: false },
    { content: "Merhaba", sender: true },
    { content: "MerhabaMerhabaMerhabaMerhabaMerhabaMerhabaMerhabaMerhaba", sender: false },
    { content: "Merhaba", sender: true },
    { content: "Merhaba", sender: false },
]);

const inputText = ref('');
const inputFocused = ref(false);
const swiperEl = ref(null);
const mainEl = ref(null);
const screenWidth = ref(0);
const startX = ref(0);
const startY = ref(0);
const currentX = ref(0);
const isDragging = ref(false);
const direction = ref(null);
const isAnimating = ref(false);
const isScrolling = ref(false);
const isInitialized = ref(false);

onMounted(async () => {
    screenWidth.value = window.innerWidth;
    currentX.value = screenWidth.value;
    await nextTick();
    
    setTimeout(() => {
        isInitialized.value = true;
        
        
        if (props.isOpen) {
            openChat();
        }
    }, 50);
    
    if (mainEl.value) {
        mainEl.value.addEventListener('scroll', () => {
            isScrolling.value = true;
            
            clearTimeout(scrollTimeout.value);
            scrollTimeout.value = setTimeout(() => {
                isScrolling.value = false;
            }, 100);
        });
    }
});

const scrollTimeout = ref(null);

watch(() => props.isOpen, (newVal) => {
    if (isInitialized.value) {
        if (newVal) {
            openChat();
        } else {
            closeChat();
        }
    }
});

const openChat = () => {
    isAnimating.value = true;
    currentX.value = 0;
    
    setTimeout(() => {
        if (!isAnimating.value) return;
        isAnimating.value = false;
    }, 300);
};

const closeChat = () => {
    isAnimating.value = true;
    currentX.value = screenWidth.value;
    
    setTimeout(() => {
        if (!isAnimating.value) return;
        isAnimating.value = false;
        emit('close');
    }, 300);
};

const touchStart = (e) => {
    if (isAnimating.value) return;
    
    startX.value = e.touches[0].clientX;
    startY.value = e.touches[0].clientY;
    isDragging.value = true;
    direction.value = null;
};

const touchMove = (e) => {
    if (isAnimating.value || !isDragging.value) return;
    
    const currentTouchX = e.touches[0].clientX;
    const currentTouchY = e.touches[0].clientY;
    const deltaX = currentTouchX - startX.value;
    const deltaY = currentTouchY - startY.value;
    
    // Determine direction after a small movement
    if (direction.value === null) {
        // Only set direction after a minimum threshold to avoid misdetection
        if (Math.abs(deltaX) > 10 || Math.abs(deltaY) > 10) {
            direction.value = Math.abs(deltaX) > Math.abs(deltaY) ? 'horizontal' : 'vertical';
        } else {
            return; // Wait until we can determine direction
        }
    }
    
    // Only handle horizontal swipes and only from the left edge or if already dragging
    if (direction.value === 'horizontal') {
        // Only allow horizontal dragging if:
        // 1. We're swiping right (to close)
        // 2. We started from near the left edge (for opening menu)
        if (deltaX > 0) {
            // Prevent default only when we're sure we want to handle this
            // and the event is cancelable
            if (e.cancelable && !isScrolling.value) {
                e.preventDefault();
            }
            
            // Only allow dragging to the right (to close)
            currentX.value = Math.max(0, deltaX);
        }
    }
};

const touchEnd = (e) => {
    if (!isDragging.value || isAnimating.value) return;
    
    isDragging.value = false;
    
    if (direction.value === 'horizontal') {
        const threshold = screenWidth.value * 0.3;
        
        if (currentX.value > threshold) {
            closeChat();
        } else {
            openChat();
        }
    }
    
    direction.value = null;
};

const sendMessage = () => {
    if (inputText.value.trim()) {
        messages.value.push({
            content: inputText.value,
            sender: true
        });
        inputText.value = '';
    }
};

const swiperStyle = computed(() => {
    return {
        transform: `translate3d(${currentX.value}px, 0, 0)`,
        transition: isAnimating.value ? 'transform 0.3s ease-out' : 'none',
        visibility: isInitialized.value ? 'visible' : 'hidden'
    };
});
</script>

<template>
    <div 
        ref="swiperEl"
        class="swiper-chat" 
        @touchstart.passive="touchStart"
        @touchmove.passive="touchMove"
        @touchend.passive="touchEnd"
        :style="swiperStyle"
    >
        <div class="chat">
            <header>
                <div class="back-button" @click="closeChat">
                    <Icon icon="mdi:arrow-left" />
                </div>
                <img src="/profile-pic.png">
                <div class="name">{{ room.name }}</div>
            </header>

            <main ref="mainEl">
                <div class="message" v-for="(message, index) in messages" :key="index" :class="{'user': message.sender}">
                    {{ message.content }}
                </div>
            </main>

            <footer>
                <Icon icon="mdi:plus" />
                <input 
                    type="text" 
                    v-model="inputText"
                    @focus="inputFocused = true" 
                    @blur="inputFocused = false"
                    @keyup.enter="sendMessage"
                    placeholder="Mesajınızı yazın..."
                >
                <Icon icon="mdi:send" @click="sendMessage" />
            </footer>
        </div>
    </div>
</template>

<style scoped>
.swiper-chat {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: aliceblue;
}

.chat {
    display: flex;
    flex-direction: column;
    height: 100%;
    overflow: hidden;
}

header {
    display: flex;
    align-items: center;
    padding: 10px;
    background-color: #f0f0f0;
    z-index: 10;
}

.back-button {
    display: flex;
    align-items: center;
    justify-content: center;
    margin-inline: 10px;
    cursor: pointer;
    -webkit-tap-highlight-color: transparent;
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
    overflow-y: auto;
    -webkit-overflow-scrolling: touch;
}

.message {
    width: fit-content;
    max-width: 80%;
    padding: 10px;
    border-radius: 10px;
    background-color: #50f080;
    text-wrap: wrap;
    word-break: break-all;
    color: #222;
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
    z-index: 10;
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