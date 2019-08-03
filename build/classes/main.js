import Vue from 'vue'
import App from './App.vue'
import Component1 from './Comp1.vue'
import ToggleButton from 'vue-js-toggle-button'

Vue.component('app-msg', Component1)
Vue.use(ToggleButton)

new Vue({
  el: '#app',
  render: h => h(Component1)
})
