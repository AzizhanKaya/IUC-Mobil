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
            swiper: null,
            screenWidth: null,
            isAnimating: false,
            isOpen: false,
        }
    },
    mounted() {
        this.swiper = this.$refs.swiper;
        this.screenWidth = window.innerWidth;
        this.swiper.style.transform = `translate3d(${this.screenWidth}px, 0px, 0px)`;
    },
    methods: {
        touchStart(e) {
            if (this.isAnimating) return;
            
            this.startX = e.touches[0].clientX;
            this.startY = e.touches[0].clientY;
            
            setTimeout(() => {
                this.direction = Math.abs(this.x - this.startX) > Math.abs(this.y - this.startY) ? 'horizontal' : 'vertical';
            }, 10);

        },
        touchMove(e) {
            if (this.isAnimating) return;
            
            this.x = e.touches[0].clientX;
            
            if (!this.direction) {
                this.y = e.touches[0].clientY;
                return;
            }

            if (this.direction === 'horizontal') {
                e.preventDefault();
                this.swiper.style
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
        },
        open() {
            this.isAnimating = true;
            this.x = 0;
            this.isOpen = true;
            
            setTimeout(() => {
                this.isAnimating = false;
            }, 300);
        },
        close() {
            this.isAnimating = true;
            this.x = this.screenWidth;
            this.isOpen = false;
            
            setTimeout(() => {
                this.isAnimating = false;
            }, 300);
        },
    },
    computed: {
        style() {
            if (this.direction !== 'horizontal') return {};

            return {
                transition: this.isAnimating ? 'transform 0.3s ease-out' : 'none',
                transform: `translate3d(${this.x}px, 0px, 0px)`
            }
        }
    }
}
</script>

<style scoped>
    .swiper {
        position: absolute;
        width: 100%;
        background: white;
        will-change: transform;
    }
</style>

