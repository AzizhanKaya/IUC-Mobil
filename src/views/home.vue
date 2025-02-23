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

    <div class="oylama">
      <h1>Oylama ></h1>
      <span class="soru">Soru?</span>
      <ul>
        <li>
          1.Seçenek
        </li>
        <li>
          2.Seçenek
        </li>
      </ul>
    </div>
    
  </div>
</template>

<style scoped>


.oylama {
  border: 1px solid black;
  box-shadow: 0px 1px 5px 1px rgba(0, 0, 0, 0.2);
  border-radius: 15px;
  overflow: hidden;
  padding: 20px;
  padding-top: 10px;
  margin-inline: 10px;
  background: linear-gradient(to bottom, black 30%, white 30%);
}

.oylama h1 {
  color: white;
  width: 105%;
  
  
}

.oylama .soru{

}

.oylama li {
  list-style-type: none;
  background-color: white;
  width: 80%;
  border: 1px solid black;
  border-radius: 20px;
  margin: 10px;
  line-height: 30px;
  padding-left: 20px;
}



.home-scroll {
  height: 100%;
  overflow-y: scroll;
  scrollbar-width: none;
}

header {
  background-color: #14243b;
  box-sizing: content-box;
  padding-top: var(--safe-inset-top);
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
  transform: translateY(10%) ;
}

.profile{
  color: white;
  font-size: 2em;
  padding-top: 5%;
  padding-right: 5%;
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
