<template>
  <div>
	<form>

		<div>
			<label>knee</label>
			<toggle-button :sync = "true" :value="initialKnee" @change="updateKnee"></toggle-button>
		</div>

		<br />

		<div>
			<label>hip</label>
			<toggle-button :sync = "true" :value = "initialHip" @change= "updateHip"></toggle-button>
		</div>

		<br />

		<div>
			<label>spinal</label>
			<toggle-button :sync = "true" :value = "initialSpinal" @change = "updateSpinal"></toggle-button>
		</div>

		<br />

		<div>
			<label>wrist</label>
			<toggle-button :sync = "true" :value = "initialWrist" @change = "updateWrist"></toggle-button>
		</div>

		<br />

		<div>
			<label>whiplash</label>
			<toggle-button :sync = "true" :value = "initialWhiplash" @change = "updateWhiplash"></toggle-button>
		</div>

		<br />

		<div>
			<input type = "button" value = "submit" @click = "postRequest">

			<input type = "button" value = "update" @click = "putRequest">
		</div>

	</form>

	<comp2 :diagnosysList = "diagnosys"></comp2>
  </div>
</template>

<script>

	import { ToggleButton } from 'vue-js-toggle-button'
	import axios from 'axios'
	import Component2 from './Comp2.vue'

	//Vue.use(ToggleButton)

	export default {
		
		data() {
			return {
				kneeVal : 0,
				hipVal : 0,
				spinalVal : 0,
				wristVal : 0,
				whiplashVal : 0,
				initialKnee : false,
				initialHip : false,
				initialSpinal : false,
				initialWrist : false,
				initialWhiplash : false,

				diagnosys: {
					"knee": 0,
					"hip": 0,
					"spinal": 0,
					"wrist": 0,
					"whiplash": 0
				}
			}
		},

		methods: {
			updateKnee(kneeEvent) {
				this.initialKnee = kneeEvent.value;
			},

			updateHip(hipEvent) {
				this.initialHip = hipEvent.value;
			},

			updateSpinal(spinalEvent) {
				this.initialSpinal = spinalEvent.value;
			},

			updateWrist(wristEvent) {
				this.initialWrist = wristEvent.value;
			},

			updateWhiplash(whiplashEvent) {
				this.initialWhiplash = whiplashEvent.value;
			},

			postRequest() {
				axios.post('http://localhost:8089/rest_apia/webapi/task1/insertTask', {
					knee : this.kneeVal,
					hip: this.hipVal,
					spinal : this.spinalVal,
					wrist : this.wristVal,
					whiplash : this.whiplashVal
				})
			},

			putRequest() {
				axios.put('http://localhost:8089/rest_api/webapi/task1/putTask', {
					knee : this.kneeVal,
					hip: this.hipVal,
					spinal : this.spinalVal,
					wrist : this.wristVal,
					whiplash : this.whiplashVal
				})
			},

			getInitialState() {
				axios.get('http://localhost:8089/rest_api/webapi/task1/getTask')
					.then(response => {
						this.initialKnee = !! response.data.knee,
						this.initialHip = !! response.data.hip,
						this.initialSpinal = !! response.data.spinal,
						this.initialWrist = !! response.data.wrist,
						this.initialWhiplash = !! response.data.whiplash
					})
			}
			
		},

		watch: {
			initialWhiplash: function(newVal, oldVal) {
				this.diagnosys.whiplash = this.whiplashVal = newVal ? 1 : 0;
			},

			initialHip: function(newVal, oldVal) {
				this.diagnosys.hip = this.hipVal = newVal ? 1 : 0;
			},

			initialSpinal: function(newVal, oldVal) {
				this.diagnosys.spinal = this.spinalVal = newVal ? 1 : 0;
			},

			initialKnee: function(newVal, oldVal) {
				this.diagnosys.knee = this.kneeVal = newVal ? 1 : 0;
			},

			initialWrist: function(newVal, oldVal) {
				this.diagnosys.wrist = this.wristVal = newVal ? 1 : 0;
			}
 		},

		created() {
			this.getInitialState()
		},

		components: {
			ToggleButton,
			'comp2' : Component2
		}
	}
</script>

