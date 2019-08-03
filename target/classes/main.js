import Vue from 'vue'
import App from './App.vue'
import comp1 from './components/Comp1.vue'

Vue.config.productionTip = false

new Vue({
  render: h => h(comp1)
}).$mount('#app')
