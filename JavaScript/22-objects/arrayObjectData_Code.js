//array of objects
let arr = [{"id":1,"name":"Abhay"},
{"id":2,"name":"Awanish"},
{"id":3,"name":"Alok"},
{"id":4,"name":"Abhishek"},
{"id":5,"name":"Rajan"},
{"id":6,"name":"Prabha"},
{"id":7,"name":"Pari"}
];

//to read id column from array of objects using map() method
let result = arr.map(item => item.id);
console.log(result); //prints 1,2,3,4,5,6,7

//Create new object from existing array of objects, where keys are changed

var output = [];

//Solution using for - loop
for (var i =0; i < arr.length; i++){
	var newItem={}; //declare an js object
	newItem.label = arr[i].id; //read field data
	newItem.name = arr[i].name; //read field data
	
	output.push(newItem); //push object to array
}

console.log("Result for For - Loop "+JSON.stringify(output)); //print array of objects 

//Code using For Each

var newOutput = [];

arr.forEach(function(item){
	console.log("item " +JSON.stringify(item));
	var newItem = {};
	newItem.label = item.id; //read field data
	newItem.name = item.name; //read field data
	newOutput.push(newItem);
});

console.log("Result for For - Each "+JSON.stringify(output)); //print new array of objects


let result1 = newOutput.filter(obj => {return obj.id === 1})
console.log(result1)