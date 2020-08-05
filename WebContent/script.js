const button = document.querySelector('#buttonId');

const hoverAnimation = () => {
	console.log("hoverAnimation has been called")
	anime({
		targets:button,
		width: '100%',
		scale: {
			delay: 800,
			value: 1.5
		}, 
		duration: 1500
	})
}

const hoverOffAnimation = () => {
	
	anime({
		targets:button,
		width: '50%',
		scale: {
			delay: 800,
			value: 1
		}, 
		duration: 1500
	})
}
console.log('we have arrived here, but there are some issues with the event listeners')