## Currying
    currying is a function which takes every argument by itself then return a new function that expects next dependencies untill all depencies are used & return value
	
	```
	let dragons =[
	  {name: 'fluffykins', element:'lightning'},
	  {name: 'noomi', element:'lightning'},
	  {name: 'karo', element:'fire'},
	  {name: 'doomer', element:'timewrap'}
	]

	let hasElement = 
	(element, obj) =>obj.element === element

	let lightingDragons =
	dragons.filter(x=>hasElement('lightning',x))

	console.log(lightingDragons)

	let dragon =
				name =>
					size =>
						element =>
							name +' is a '+
							size +' dragon that breates '+
							element + '!'
						
    let output = dragon('karo')('large')('ice')
    console.log(output)
	```