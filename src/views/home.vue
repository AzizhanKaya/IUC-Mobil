<script setup>
import { ref } from 'vue';
import { Swiper, SwiperSlide } from 'swiper/vue';
import 'swiper/css';
import 'swiper/css/navigation';
import { Navigation } from 'swiper/modules';
import { Icon } from '@iconify/vue/dist/iconify.js';
const swiperRef = ref(null);

const slides = [
  {
    img: 'https://cdn.iuc.edu.tr/FileHandler2.ashx?f=iuc-izmir-biyotip-ve-genom-merkezi-ziyareti.JPG',
    header: 'Üniversitemizden İzmir Biyotıp ve Genom Merkezi’ne Ziyaret',
    link: 'https://www.iuc.edu.tr/tr/haber/universitemizden-izmir-biyotip-ve-genom-merkezine-ziyaret-51007800730071006400770059004F0030005300370039007900700046006200610041004F003200370077003200',
  },
  {
    img: 'https://cdn.iuc.edu.tr/FileHandler2.ashx?f=entertech-istanbul-teknokent--yildiz-teknopark-protokol-imza-toreni.jpeg',
    header: 'Entertech İstanbul Teknokent ve YTÜ Yıldız Teknopark Arasında İş Birliği Protokolü İmzalandı',
    link: 'https://www.iuc.edu.tr/tr/haber/entertech-istanbul-teknokent-ve-ytu-yildiz-teknopark-arasinda-is-birligi-protoko-77004F00580054002D005F002D005F00360033007A0039007900700046006200610041004F003200370077003200',
  },
  {
    img: 'https://cdn.iuc.edu.tr/FileHandler2.ashx?f=psby_degerlendirme-raporu_1.jpg',
    header: 'Ormancılık Meslek Yüksekokulundan Akreditasyon Başarısı',
    link: 'https://www.iuc.edu.tr/tr/haber/ormancilik-meslek-yuksekokulundan-akreditasyon-basarisi-2D007A0072006D0054006C003800770036006300330039007900700046006200610041004F003200370077003200',
  },
];
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
      <Swiper
        :slides-per-view="1"
        :space-between="10"
        @swiper="(swiper) => (swiperRef.value = swiper.el)"
      >
        <SwiperSlide v-for="(item, index) in slides" :key="index">
          <a :href="item.link" target="_blank" class="slide">
            <div class="image-container">
              <img :src="item.img" :alt="item.header" />
              <h2 class="slide-title">{{ item.header }}</h2>
            </div>
          </a>
        </SwiperSlide>
      </Swiper>
    </div>
    <div ref="swiperRef" class="news">
      <span>Etkinlikler</span>
      <Swiper
        :slides-per-view="1"
        :space-between="10"
        @swiper="(swiper) => (swiperRef.value = swiper.el)"
      >
        <SwiperSlide v-for="(item, index) in slides" :key="index">
          <a :href="item.link" target="_blank" class="slide">
            <div class="image-container">
              <img :src="item.img" :alt="item.header" />
              <h2 class="slide-title">{{ item.header }}</h2>
            </div>
          </a>
        </SwiperSlide>
      </Swiper>
    </div>
    <div ref="swiperRef" class="news">
      <span>Duyurular</span>
      <Swiper
        :slides-per-view="1"
        :space-between="10"
        @swiper="(swiper) => (swiperRef.value = swiper.el)"
      >
        <SwiperSlide v-for="(item, index) in slides" :key="index">
          <a :href="item.link" target="_blank" class="slide">
            <div class="image-container">
              <img :src="item.img" :alt="item.header" />
              <h2 class="slide-title">{{ item.header }}</h2>
            </div>
          </a>
        </SwiperSlide>
      </Swiper>
    </div>
    <div ref="swiperRef" class="news">
      <span>Duyurular</span>
      <Swiper
        :slides-per-view="1"
        :space-between="10"
        @swiper="(swiper) => (swiperRef.value = swiper.el)"
      >
        <SwiperSlide v-for="(item, index) in slides" :key="index">
          <a :href="item.link" target="_blank" class="slide">
            <div class="image-container">
              <img :src="item.img" :alt="item.header" />
              <h2 class="slide-title">{{ item.header }}</h2>
            </div>
          </a>
        </SwiperSlide>
      </Swiper>
    </div>
  </div>
</template>

<style scoped>

.home-scroll {
  height: 100%;
  overflow-y: scroll;
  padding-bottom: 125px;
  scrollbar-width: none;
  scroll-snap-type: y mandatory;
}

header {
  background-color: #14243b;
  height: clamp(50px, 5%, 100px);
  z-index: 10;
  position: relative;
  overflow: hidden;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding-inline: 25%;
  width: 150%;
  left: 50%;
  transform: translateX(-50%);
}

header img {
  object-fit: contain;
  height: 120%;
  transform: translateY(-3%);
}

.profile{
  color: white;
  font-size: 2em;
  transform: translateY(8%);
  margin-right: 3%;
}




.news {
  width: 100%;
  max-width: 600px;
  margin: auto;
}

span {
  width: 100%;
  text-decoration: underline;
  font-size: 1.5em;
}

.slide {
  display: flex;
  flex-direction: column;
  align-items: center;
  text-decoration: none;
  color: white;
}

.image-container {
  position: relative;
  width: 100%;
  height: 250px; 
  overflow: hidden;
  padding: 10px;
}

.image-container img {
  width: 100%;
  height: 100%;
  object-fit: cover;
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
  font-size: 14px;
  font-weight: bold;
  color: white;
  text-shadow: 2px 2px 4px black;
  border-radius: 5px;
  text-align: left;
  font-size: 1em;
}
</style>
