<script>
import { Icon } from "@iconify/vue";

export default {
  components: {
    Icon
  },
  data() {
    return {
      containerActive: false,
    };
  },
  methods: {
    handleFocus() {
      this.containerActive = true;
    },
    handleBlur() {
      const inputs = document.querySelectorAll(".login input");
      const activeInput = [...inputs].some((input) => input === document.activeElement);
      if (!activeInput) {
        this.containerActive = false;
      }
    },
    Logined() {
      this.$emit('login');
    }
  },
};
</script>

<template>
    <div class="login">
      <div class="header">
        <img src="../assets/icon-iüc.webp" alt="">
        <span>Login</span>
      </div>
      <div :class="['container', { active: containerActive }]">

        <div class="input-container">
          <Icon icon="mdi:account" class="input-icon" />
          <input id="username" type="text" placeholder="Kullanıcı adı" @focus="handleFocus" @blur="handleBlur">
        </div>

        <div class="input-container">
          <Icon icon="mdi:lock" class="input-icon" />
          <input id="password" type="password" placeholder="Şifre" @focus="handleFocus" @blur="handleBlur">
        </div>

        <button @click="Logined">Login!</button>
      </div>
    </div>
</template>

<style scoped>
  
  .login {
    width: clamp(300px, 90%, 400px);
    height: clamp(400px, 70%, 500px);
    background-color: aliceblue;
    border-radius: 25px;
    box-shadow: 7px -8px 20px 5px rgba(255, 255, 255, 0.1), 0px 10px 25px 5px rgba(0, 0, 0, 0.3);
    padding: 20px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    align-items: center;
    position: absolute;
    transform: translateY(-10%);
  }

  .header {
    display: flex;
    width: 100%;
    height: 40%;
    font-size: 2rem;
    padding: 20px;
    position: relative;
    text-decoration: none;
    flex-direction: column;
    align-items: center;
    box-sizing: content-box;
    justify-content: flex-end;
  }

  .header::after {
    content: '';
    width: 80%;
    height: 1px;
    background-color: rgba(36, 46, 45, 0.8);
    position: absolute;
    left: 50%;
    transform: translateX(-50%);
    bottom: 2px;
  }

  .header img{
    height: 90%;
    aspect-ratio: 1;
    object-fit: cover;
  }

  .container {
    width: 100%;
    height: 50%;
    background-color: rgb(241, 247, 248);
    border-radius: 20px;
    box-shadow: 0px 5px 25px 5px rgba(0, 0, 0, 0.3);
    display: flex;
    flex-direction: column;
    align-items: center;
    position: relative;
    gap: 0px;
    padding: 5%;
    padding-top: 10%;
    transform: translateY(0);
    transition: transform 0.4s;
    justify-content: space-evenly;
  }

  .container.active {
    transform: translateY(-50%);
  }

  .input-container {
    position: relative;
    width: 85%;
    flex: 1;
    margin: 5px;
  }

  input {
    width: 100%;
    height: 100%;
    padding: 0 5%;
    border: 2px solid transparent;
    font-size: 1.2rem;
    border-radius: 5px;
    outline: none;
    background-color: #e3e7e9;
    color: #0d0c22;
    transition: .5s ease;
    font-weight: 200;
    padding-left: 15%;
  }

  input::placeholder {
    color: #94a3b8;
  }

  input:focus, .login input:hover {
    border-color: rgba(129, 140, 248);
    background-color: #fff;
    box-shadow: 0 0 0 5px rgb(129 140 248 / 30%);
  }

  
  .input-icon {
    position: absolute;
    left: 3%;
    top: 50%;
    transform: translateY(-50%);
    font-size: 1.75em;
    color: #222;
  }


  button {
    border: 1px solid rgba(0, 0, 0, 0.1);
    border-radius: 5px;
    color: rgba(0, 0, 0, 0.85);
    cursor: pointer;
    font-size: 1.3rem;
    font-weight: 600;
    line-height: 1.25;
    padding: calc(.875rem - 1px) calc(1.5rem - 1px);
    position: relative;
    text-decoration: none;
    transition: all 250ms;
    width: 85%;
    box-shadow: 0px 1px 25px 1px rgba(0, 0, 0, 0.2);
    margin-top: 20px;
  }

  button:active {
    background-color: rgb(224, 224, 224);
    transform: translateY(+5px);
  }

</style>
