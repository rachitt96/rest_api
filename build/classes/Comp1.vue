<template>
	<div>
		<form @submit="validate">
		<div>
			<label> A </label>
			<toggle-button @change="updateOne($event.value)" color="#82C7EB"/>
			<p> {{ val1 }} </p>
		</div>

		<br>

		<div>
			<label> B </label>
			<toggle-button @change="updateTwo($event.value)"/>
			<p> {{ val2 }} </p>
		</div>

		<button type="submit">Submit</button>
		
		</form>

	</div>
</template>

<script>
	export default{
		data : function() {
			return {
				val1 : 0,
				val2 : 0
			}
		},

		methods: {
			updateOne : function (event) {
				this.val1 = event ? 1 : 0
			},

			updateTwo : function (event) {
				this.val2 = event ? 1 : 0
			},

			validate : function () {

			}
		}
	}
</script>