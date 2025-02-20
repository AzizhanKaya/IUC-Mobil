<template>
  <div 
    ref="swiper"
    class="swiper" 
    @touchstart="touchStart"
    @touchmove="touchMove"
    @touchend="touchEnd"
    :style="style"
  >
    <slot></slot>
  </div>
</template>

<script>
export default {
    name: 'Swiper',
    data() {
        return {
            startX: 0,
            startY: 0,
            x: 0,
            y: 0,
            direction: null,
            isTouching: false,
            swiper: null,
            screenWidth: null,
            isAnimating: false,
            initialTransform: null,
            isOpen: false,
        }
    },
    mounted() {
        this.swiper = this.$refs.swiper;
        this.screenWidth = window.innerWidth;
        this.initialTransform = this.screenWidth;
        this.swiper.style.transform = `translate3d(${this.initialTransform}px, 0px, 0px)`;
    },
    methods: {
        touchStart(e) {
            if (this.isAnimating) return;
            
            this.startX = e.touches[0].clientX;
            this.startY = e.touches[0].clientY;
            this.initialTransform = this.x || this.initialTransform;
            
            setTimeout(() => {
                this.direction = Math.abs(this.x - this.startX) > Math.abs(this.y - this.startY) ? 'horizontal' : 'vertical';
            }, 10);

            this.isTouching = true;
        },
        touchMove(e) {
            if (this.isAnimating) return;
            
            this.x = e.touches[0].clientX - this.startX + this.initialTransform;
            
            if (!this.direction) {
                this.y = e.touches[0].clientY;
                return;
            }

            if (this.direction === 'horizontal') {
                e.preventDefault();
            }
        },
        touchEnd() {
            if (this.direction === 'horizontal') {
                const threshold = this.screenWidth * 0.5;
                
                if (this.x > threshold) {
                    this.close();
                } else {
                    this.open();
                }
            }
            
            this.direction = null;
            this.isTouching = false;
        },
        open() {
            this.isAnimating = true;
            this.x = 0;
            this.isOpen = true;
            this.$emit('swipe-left');
            
            setTimeout(() => {
                this.isAnimating = false;
            }, 300);
        },
        close() {
            this.isAnimating = true;
            this.x = this.screenWidth;
            this.isOpen = false;
            this.$emit('swipe-right');
            
            setTimeout(() => {
                this.isAnimating = false;
            }, 300);
        },
    },
    computed: {
        style() {
            if (this.direction !== 'horizontal' && !this.isAnimating) return {};

            return {
                transition: this.isTouching ? 'none' : 'transform 0.3s ease-out',
                transform: `translate3d(${this.x}px, 0px, 0px)`
            }
        }
    }
}
</script>

<style scoped>
    .swiper {
        position: fixed;
        top: 0;
        left: 0;
        bottom: 0;
        width: 100%;
        background: white;
        touch-action: pan-y;
        will-change: transform;
    }
</style>

