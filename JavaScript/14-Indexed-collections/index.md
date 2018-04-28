## Arrays

An array is an ordered set of values that you refer to with a name and an index. For example, you could have an array called emp that contains employees' names indexed by their numerical employee number. So emp[1] would be employee number one, emp[2] employee number two, and so on.

JavaScript does not have an explicit array data type. However, you can use the predefined Array object and its methods to work with arrays in your applications. The Array object has methods for manipulating arrays in various ways, such as joining, reversing, and sorting them. It has a property for determining the array length and other properties for use with regular expressions.

**Creating an array**

The following statements create equivalent arrays:

```
var arr = new Array(element0, element1, ..., elementN);
var arr = Array(element0, element1, ..., elementN);
var arr = [element0, element1, ..., elementN];
```

element0, element1, ..., elementN is a list of values for the array's elements. When these values are specified, the array is initialized with them as the array's elements. The array's length property is set to the number of arguments.

The bracket syntax is called an "array literal" or "array initializer." It's shorter than other forms of array creation, and so is generally preferred. See Array literals for details.

To create an array with non-zero length, but without any items, either of the following can be used:

```
var arr = new Array(arrayLength);
var arr = Array(arrayLength);

// This has exactly the same effect
var arr = [];
arr.length = arrayLength;
```

*Note* : in the above code, arrayLength must be a Number. Otherwise, an array with a single element (the provided value) will be created. Calling arr.length will return arrayLength, but the array actually contains empty (undefined) elements. Running a for...in loop on the array will return none of the array's elements.

In addition to a newly defined variable as shown above, arrays can also be assigned as a property of a new or an existing object:

```
var obj = {};
// ...
obj.prop = [element0, element1, ..., elementN];

// OR
var obj = {prop: [element0, element1, ...., elementN]};
```

If you wish to initialize an array with a single element, and the element happens to be a Number, you must use the bracket syntax. When a single Number value is passed to the Array() constructor or function, it is interpreted as an arrayLength, not as a single element.

```
var arr = [42];      // Creates an array with only one element:
                     // the number 42.

var arr = Array(42); // Creates an array with no elements
                     // and arr.length set to 42; this is
                     // equivalent to:
var arr = [];
arr.length = 42;
```

Calling Array(N) results in a RangeError, if N is a non-whole number whose fractional portion is non-zero. The following example illustrates this behavior.

```
var arr = Array(9.3);  // RangeError: Invalid array length
```
If your code needs to create arrays with single elements of an arbitrary data type, it is safer to use array literals. Or, create an empty array first before adding the single element to it.

**Populating an array**

You can populate an array by assigning values to its elements. For example,

```
var emp = [];
emp[0] = 'Casey Jones';
emp[1] = 'Phil Lesh';
emp[2] = 'August West';
```

Note : if you supply a non-integer value to the array operator in the code above, a property will be created in the object representing the array, instead of an array element.

```
var arr = [];
arr[3.4] = 'Oranges';
console.log(arr.length);                // 0
console.log(arr.hasOwnProperty(3.4));   // true
```

You can also populate an array when you create it:

```
var myArray = new Array('Hello', myVar, 3.14159);
var myArray = ['Mango', 'Apple', 'Orange']
```

**Referring to array elements**

You refer to an array's elements by using the element's ordinal number. For example, suppose you define the following array:

```
var myArray = ['Wind', 'Rain', 'Fire'];
```

You then refer to the first element of the array as myArray[0] and the second element of the array as myArray[1]. The index of the elements begins with zero.

Note : the array operator (square brackets) is also used for accessing the array's properties (arrays are also objects in JavaScript). For example,

```
var arr = ['one', 'two', 'three'];
arr[2];  // three
arr['length'];  // 3
```

**Understanding length**

At the implementation level, JavaScript's arrays actually store their elements as standard object properties, using the array index as the property name. The length property is special; it always returns the index of the last element plus one (in the following example, Dusty is indexed at 30, so cats.length returns 30 + 1). Remember, JavaScript Array indexes are 0-based: they start at 0, not 1. This means that the length property will be one more than the highest index stored in the array:

```
var cats = [];
cats[30] = ['Dusty'];
console.log(cats.length); // 31
```

You can also assign to the length property. Writing a value that is shorter than the number of stored items truncates the array; writing 0 empties it entirely:

```
var cats = ['Dusty', 'Misty', 'Twiggy'];
console.log(cats.length); // 3

cats.length = 2;
console.log(cats); // logs "Dusty, Misty" - Twiggy has been removed

cats.length = 0;
console.log(cats); // logs nothing; the cats array is empty

cats.length = 3;
console.log(cats); // [undefined, undefined, undefined]
```

**Iterating over arrays**

A common operation is to iterate over the values of an array, processing each one in some way. The simplest way to do this is as follows:

```
var colors = ['red', 'green', 'blue'];
for (var i = 0; i < colors.length; i++) {
  console.log(colors[i]);
}
```

If you know that none of the elements in your array evaluate to false in a boolean context — if your array consists only of DOM nodes, for example, you can use a more efficient idiom:

```
var divs = document.getElementsByTagName('div');
for (var i = 0, div; div = divs[i]; i++) {
  /* Process div in some way */
}
```

This avoids the overhead of checking the length of the array, and ensures that the div variable is reassigned to the current item each time around the loop for added convenience.

The forEach() method provides another way of iterating over an array:

```
var colors = ['red', 'green', 'blue'];
colors.forEach(function(color) {
  console.log(color);
});
// red
// green
// blue
```

Alternatively, You can shorten the code for the forEach parameter with ES6 Arrow Functions:

```
var colors = ['red', 'green', 'blue'];
colors.forEach(color => console.log(color)); 
// red
// green
// blue
```
The function passed to forEach is executed once for every item in the array, with the array item passed as the argument to the function. Unassigned values are not iterated in a forEach loop.

Note that the elements of array that are omitted when the array is defined are not listed when iterating by forEach, but are listed when undefined has been manually assigned to the element:
```
var array = ['first', 'second', , 'fourth'];

array.forEach(function(element) {
  console.log(element);
});
// first
// second
// fourth

if (array[2] === undefined) { 
  console.log('array[2] is undefined'); // true
} 

array = ['first', 'second', undefined, 'fourth'];

array.forEach(function(element) {
  console.log(element);
});
// first
// second
// undefined
// fourth
```

Since JavaScript elements are saved as standard object properties, it is not advisable to iterate through JavaScript arrays using for...in loops because normal elements and all enumerable properties will be listed.

**Array methods**

The Array object has the following methods:

`concat()` joins two arrays and returns a new array.

```
var myArray = new Array('1', '2', '3');
myArray = myArray.concat('a', 'b', 'c'); 
// myArray is now ["1", "2", "3", "a", "b", "c"]
```
`join(deliminator = ',')` joins all elements of an array into a string.

```
var myArray = new Array('Wind', 'Rain', 'Fire');
var list = myArray.join(' - '); // list is "Wind - Rain - Fire"
```
`push()` adds one or more elements to the end of an array and returns the resulting length of the array.

```
var myArray = new Array('1', '2');
myArray.push('3'); // myArray is now ["1", "2", "3"]
```

`pop()` removes the last element from an array and returns that element.
```
var myArray = new Array('1', '2', '3');
var last = myArray.pop(); 
// myArray is now ["1", "2"], last = "3"
```

`shift()` removes the first element from an array and returns that element.

```
var myArray = new Array('1', '2', '3');
var first = myArray.shift(); 
// myArray is now ["2", "3"], first is "1"
```

`unshift()` adds one or more elements to the front of an array and returns the new length of the array.

```
var myArray = new Array('1', '2', '3');
myArray.unshift('4', '5'); 
// myArray becomes ["4", "5", "1", "2", "3"]
```

`slice(start_index, upto_index)` extracts a section of an array and returns a new array.
```
var myArray = new Array('a', 'b', 'c', 'd', 'e');
myArray = myArray.slice(1, 4); // starts at index 1 and extracts all elements
                               // until index 3, returning [ "b", "c", "d"]
```

`splice(index, count_to_remove, addElement1, addElement2, ...)` removes elements from an array and (optionally) replaces them. It returns the items which were removed from the array.
```
var myArray = new Array('1', '2', '3', '4', '5');
myArray.splice(1, 3, 'a', 'b', 'c', 'd'); 
// myArray is now ["1", "a", "b", "c", "d", "5"]
// This code started at index one (or where the "2" was), 
// removed 3 elements there, and then inserted all consecutive
// elements in its place.
```
`reverse()` transposes the elements of an array, in place: the first array element becomes the last and the last becomes the first. It returns a reference to the array.
```
var myArray = new Array('1', '2', '3');
myArray.reverse(); 
// transposes the array so that myArray = ["3", "2", "1"]
```
`sort()` sorts the elements of an array in place, and returns a reference to the array.
```
var myArray = new Array('Wind', 'Rain', 'Fire');
myArray.sort(); 
// sorts the array so that myArray = ["Fire", "Rain", "Wind"]
```
sort() can also take a callback function to determine how array elements are compared.

The sort method and other methods below that take a callback are known as iterative methods, because they iterate over the entire array in some fashion. Each one takes an optional second argument called thisObject. If provided, thisObject becomes the value of the this keyword inside the body of the callback function. If not provided, as with other cases where a function is invoked outside of an explicit object context, this will refer to the global object (window).

The callback function is actually called with three arguments. The first is the value of the current item, the second is its array index, and the third is a reference to the array itself. JavaScript functions ignore any arguments that are not named in the parameter list so it is safe to provide a callback function that only takes a single argument, such as alert.

The function below compares two values and returns one of three values:

For instance, the following will sort by the last letter of a string:
```
var sortFn = function(a, b) {
  if (a[a.length - 1] < b[b.length - 1]) return -1;
  if (a[a.length - 1] > b[b.length - 1]) return 1;
  if (a[a.length - 1] == b[b.length - 1]) return 0;
}
myArray.sort(sortFn); 
// sorts the array so that myArray = ["Wind","Fire","Rain"]

    if a is less than b by the sorting system, return -1 (or any negative number)
    if a is greater than b by the sorting system, return 1 (or any positive number)
    if a and b are considered equivalent, return 0.
```

`indexOf(searchElement[, fromIndex])` searches the array for searchElement and returns the index of the first match.
```
var a = ['a', 'b', 'a', 'b', 'a'];
console.log(a.indexOf('b')); // logs 1
// Now try again, starting from after the last match
console.log(a.indexOf('b', 2)); // logs 3
console.log(a.indexOf('z')); // logs -1, because 'z' was not found
```

`lastIndexOf(searchElement[, fromIndex])` works like indexOf, but starts at the end and searches backwards.
```
var a = ['a', 'b', 'c', 'd', 'a', 'b'];
console.log(a.lastIndexOf('b')); // logs 5
// Now try again, starting from before the last match
console.log(a.lastIndexOf('b', 4)); // logs 1
console.log(a.lastIndexOf('z')); // logs -1

`forEach(callback[, thisObject])` executes callback on every array item and returns undefined.

var a = ['a', 'b', 'c'];
a.forEach(function(element) { console.log(element); }); 
// logs each item in turn
```

`map(callback[, thisObject])` returns a new array of the return value from executing callback on every array item.
```
var a1 = ['a', 'b', 'c'];
var a2 = a1.map(function(item) { return item.toUpperCase(); });
console.log(a2); // logs ['A', 'B', 'C']

`filter(callback[, thisObject])` returns a new array containing the items for which callback returned true.

var a1 = ['a', 10, 'b', 20, 'c', 30];
var a2 = a1.filter(function(item) { return typeof item === 'number'; });
console.log(a2); // logs [10, 20, 30]
```
`every(callback[, thisObject])` returns true if callback returns true for every item in the array.
```
function isNumber(value) {
  return typeof value === 'number';
}
var a1 = [1, 2, 3];
console.log(a1.every(isNumber)); // logs true
var a2 = [1, '2', 3];
console.log(a2.every(isNumber)); // logs false
```
`some(callback[, thisObject])` returns true if callback returns true for at least one item in the array.
```
function isNumber(value) {
  return typeof value === 'number';
}
var a1 = [1, 2, 3];
console.log(a1.some(isNumber)); // logs true
var a2 = [1, '2', 3];
console.log(a2.some(isNumber)); // logs true
var a3 = ['1', '2', '3'];
console.log(a3.some(isNumber)); // logs false
```
`reduce(callback[, initialValue])` applies callback(firstValue, secondValue) to reduce the list of items down to a single value and returns that value.
```
var a = [10, 20, 30];
var total = a.reduce(function(first, second) { return first + second; }, 0);
console.log(total) // Prints 60
```
`reduceRight(callback[, initialValue])` works like reduce(), but starts with the last element.

reduce and reduceRight are the least obvious of the iterative array methods. They should be used for algorithms that combine two values recursively in order to reduce a sequence down to a single value.

**Multi-dimensional arrays**

Arrays can be nested, meaning that an array can contain another array as an element. Using this characteristic of JavaScript arrays, multi-dimensional arrays can be created.

The following code creates a two-dimensional array.
```
var a = new Array(4);
for (i = 0; i < 4; i++) {
  a[i] = new Array(4);
  for (j = 0; j < 4; j++) {
    a[i][j] = '[' + i + ', ' + j + ']';
  }
}

This example creates an array with the following rows:

Row 0: [0, 0] [0, 1] [0, 2] [0, 3]
Row 1: [1, 0] [1, 1] [1, 2] [1, 3]
Row 2: [2, 0] [2, 1] [2, 2] [2, 3]
Row 3: [3, 0] [3, 1] [3, 2] [3, 3]
```

**Working with array-like objects**

Some JavaScript objects, such as the NodeList returned by document.getElementsByTagName() or the arguments object made available within the body of a function, look and behave like arrays on the surface but do not share all of their methods. The arguments object provides a length attribute but does not implement the forEach() method, for example.

Array prototype methods can be called against other array-like objects. for example:

```
function printArguments() {
  Array.prototype.forEach.call(arguments, function(item) {
    console.log(item);
  });
}
```
Array prototype methods can be used on strings as well, since they provide sequential access to their characters in a similar way to arrays:
```
Array.prototype.forEach.call('a string', function(chr) {
  console.log(chr);
});
```
## Typed arrays

JavaScript typed arrays are array-like objects and provide a mechanism for accessing raw binary data. As you already know, Array objects grow and shrink dynamically and can have any JavaScript value. JavaScript engines perform optimizations so that these arrays are fast. However, as web applications become more and more powerful, adding features such as audio and video manipulation, access to raw data using WebSockets, and so forth, it has become clear that there are times when it would be helpful for JavaScript code to be able to quickly and easily manipulate raw binary data in typed arrays.

**Buffers and views: typed array architecture**

To achieve maximum flexibility and efficiency, JavaScript typed arrays split the implementation into buffers and views. A buffer (implemented by the ArrayBuffer object) is an object representing a chunk of data; it has no format to speak of, and offers no mechanism for accessing its contents. In order to access the memory contained in a buffer, you need to use a view. A view provides a context — that is, a data type, starting offset, and number of elements — that turns the data into an actual typed array.

**ArrayBuffer**

The ArrayBuffer is a data type that is used to represent a generic, fixed-length binary data buffer. You can't directly manipulate the contents of an ArrayBuffer; instead, you create a typed array view or a DataView which represents the buffer in a specific format, and use that to read and write the contents of the buffer.

**Typed array views**

Typed array views have self descriptive names and provide views for all the usual numeric types like Int8, Uint32, Float64 and so forth. There is one special typed array view, the Uint8ClampedArray. It clamps the values between 0 and 255. This is useful for Canvas data processing, for example.

Type 	       |Value Range | Size in bytes | Description 		   | Web IDL type 	| Equivalent C type
---------------|------------|---------------|----------------------|----------------|------------------------
Int8Array 	   |-128 to 127 | 1 |	8-bit two's complement signed integer |	byte 	|int8_t
Uint8Array 	   |0 to 255 	| 1 |	8-bit unsigned integer 	|octet 	|uint8_t
Uint8ClampedArray| 	0 to 255| 	1 |	8-bit unsigned integer (clamped)| 	octet 	|uint8_t
Int16Array 	 |-32768 to 32767| 	2 |	16-bit two's complement signed integer |	short |	int16_t
Uint16Array 	 |0 to 65535| 	2 |	16-bit unsigned integer 	unsigned |short |	uint16_t
Int32Array |-2147483648 to 2147483647| 	4 |	32-bit two's complement signed integer |	long |	int32_t
Uint32Array 	 |0 to 4294967295| 	4 |	32-bit unsigned integer 	unsigned |long |	uint32_t
Float32Array |1.2x10-38 to 3.4x1038| 	4 |	32-bit IEEE floating point number ( 7 significant digits e.g. 1.1234567) unrestricted | float |	float
Float64Array 	 |5.0x10-324 to 1.8x10308 |	8 |	64-bit IEEE floating point number (16 significant digits e.g. 1.123...15) 	unrestricted |double |	double
