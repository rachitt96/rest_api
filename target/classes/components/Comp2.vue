<template>
	<div>
		<table>
			<tr>
				<th>Name</th>
				<th>Value</th>
			</tr>
			<tr v-for = "(value, key) in diagnosysList" :key = "key">
				<td v-if = "value == 1">
					{{ key }}
				</td>
				<td v-if = "value == 1">
					{{ value }}
				</td>
			</tr>
		</table>
	</div>
</template>

<script>
	import axios from 'axios'

	export default {
		props : ['diagnosysList'],

		data() {
			return {
				
			}
		},

		methods: {
			
		}
	}
</script>