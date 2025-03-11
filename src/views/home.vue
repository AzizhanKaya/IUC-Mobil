<script setup>
    import { ref } from 'vue';
    import { Swiper, SwiperSlide } from 'swiper/vue';
    import 'swiper/css';
    import { Icon } from '@iconify/vue/dist/iconify.js';
    import  Vote  from '../components/vote.vue'

    const swiperRef = ref(null);
    const slides = ref([]);
    const isLoading = ref(true);

    const fetchNews = async () => {
        try {
            const response = await fetch("https://service-cms.iuc.edu.tr/api/webclient/f_getNewsBox?siteKey=8FF2191E5F0343B5AA2F9BF774F93F5A");
            const data = await response.json();
            
            slides.value = data?.Data?.map(item => ({
                img: "https://cdn.iuc.edu.tr/FileHandler.ashx?f=" + item.Img,
                header: item.Header,
                link: "https://iuc.edu.tr/tr/haber/" + item.Route,
            }));

            
        } catch (error) {
            console.error("Haberler yüklenirken hata oluştu:", error);
        } finally {
            isLoading.value = false;
        }
    };

    fetchNews();

</script>

<template>
    <header>
        <img src="/banner.png">
        <div class="profile">
            <Icon icon="iconamoon:profile-circle-fill"> </Icon>
        </div>
    </header>

  <div class="home-scroll">
    <div ref="swiperRef" class="news">

      <span>Haberler</span>

      <template v-if="isLoading">
        <div class="skeleton-slide"></div>
      </template>

      <template v-else>
            <Swiper
                :slides-per-view="1"
                :space-between="10"
                @swiper="(swiper) => (swiperRef.value = swiper.el)"
            >
                <SwiperSlide v-for="(item, index) in slides" :key="index">
                    <a :href="item.link" target="_blank" class="slide">
                        <div class="image-container">
                            <img :src="item.img" />
                            <h2 class="slide-title">{{ item.header }}</h2>
                        </div>
                    </a>
                </SwiperSlide>

            </Swiper>
        </template>
    </div>

    <Vote />
  </div>
</template>

<style scoped>






.home-scroll {
  height: 100%;
  overflow-y: scroll;
  scrollbar-width: none;
  
}

.home-scroll > * {
  max-width: 600px;
}

header {
  background-color: #14243b;
  box-sizing: content-box;
  padding-top: var(--safe-inset-top, 20px);
  padding-inline: 25%;
  width: 100%;
  left: 50%;
  top: 0;
  transform: translateX(-50%);
  height: clamp(75px, 5%, 150px);
  z-index: 10;
  position: relative;
  overflow: hidden;
  display: flex;
  align-items: center;
  justify-content: space-between;
}

header img {
  object-fit: contain;
  height: 90%;
  transform: translateY(10%);
}

.profile{
  color: white;
  font-size: 2em;
  transform: translateY(10px);
  padding-right: 5%;
}

.news {
  width: 100%;
  margin: auto;
}

span {
  width: 100%;
  text-decoration: underline;
  font-size: 1.5em;
}

.slide {
  display: flex;
  align-items: center;
  text-decoration: none;
  color: white;
}

.image-container {
  width: 100%;
  height: 250px; 
  overflow: hidden;
  padding: 10px;
}

.image-container img {
  width: 100%;
  height: 100%;
  object-fit: contain;
  border-radius: 15px;
}

.slide-title {
  position: absolute;
  margin: 0;
  padding: 5px;
  bottom: 20px;
  left: 50%;
  transform: translateX(-50%);
  width: 90%;
  padding: 5px;
  font-weight: bold;
  color: white;
  text-shadow: 2px 2px 4px black;
  border-radius: 5px;
  text-align: left;
  font-size: 1em;
  line-height: 1.4em;
}

.skeleton-slide {
  
  height: 250px;
  background: linear-gradient(90deg, #e0e0e0 25%, #f0f0f0 50%, #e0e0e0 75%);
  background-size: 400% 100%;
  animation: loading 1.5s infinite;
  border-radius: 15px;
  margin: 10px;
}

@keyframes loading {
  0% { background-position: 100% 0; }
  100% { background-position: -100% 0; }
}
</style>
