## Java Script Reserved words

abstract, as, boolean, break, byte, case, catch, char, class, continue, const, debugger, default, delete
do, double, else, enum, export, extends , false, final, finally, float , for, function, goto, if, implements
import, in, instanceof, int, interface, is, long, namespace, native, new, null, package, private, protected
public, return, short, static, super, switch, synchronized, this, throw, throws, transient, true, try, typeof
use, var, void, volatile, while, with

## Basic syntax & comments

* JavaScript is case-sensitive and uses the Unicode character set.
* instructions are called statements and are separated by a semicolon (;). A semicolon is not necessary after every 
  statement if we are writing a command from a new line. If we want to write more than one command in one line then 
  they should separated by a semicolon (;). Although, a semicolon (;) after every commands is the best practice. 
  
* // a one line comment
 
* /* this is a longer, 
   multi-line comment
 */
 
## Declarations

There are three kinds of declarations in JavaScript.


var - Declares a variable, optionally initializing it to a value. You use variables as symbolic names for values in
 your application. A JavaScript identifier must start with a letter, underscore (_), or dollar sign ($); subsequent characters can 
 also be digits (0-9).
 
let - Declares a block-scoped, local variable, optionally initializing it to a value.

const - Declares a block-scoped, read-only named constant. 

**Declaring Variables**

You can declare a variable in three ways:

1. With the keyword var. For example, var x = 42. This syntax can be used to declare both local and global variables.

2. By simply assigning it a value. For example, x = 42. This always declares a global variable, if it is declared outside of any function. It generates a strict JavaScript warning. You shouldn't use this variant.

3. With the keyword let. For example, let y = 13. This syntax can be used to declare a block-scope local variable. See Variable scope below.

**Evaluating Variables**

A variable declared using the var or let statement with no assigned value specified has the value of undefined.

An attempt to access an undeclared variable will result in a ReferenceError exception being thrown:
```
var a;
console.log('The value of a is ' + a); // The value of a is undefined

console.log('The value of b is ' + b); // The value of b is undefined
var b;

console.log('The value of c is ' + c); // Uncaught ReferenceError: c is not defined

let x;
console.log('The value of x is ' + x); // The value of x is undefined

console.log('The value of y is ' + y); // Uncaught ReferenceError: y is not defined
let y;
```

You can use undefined to determine whether a variable has a value. In the following code, the variable input is not
 assigned a value, and the if statement evaluates to true.
 
```
 var input;
	if (input === undefined) {
	  doThis();
	} else {
	  doThat();
	}
```

The undefined value behaves as false when used in a boolean context. For example, the following code executes the 
function myFunction because the myArray element is undefined:

var myArray = [];
if (!myArray[0]) myFunction();

The undefined value converts to NaN when used in numeric context.

```
var a;
a + 2;  // Evaluates to NaN
```

When you evaluate a null variable, the null value behaves as 0 in numeric contexts and as false in boolean contexts. For example:

```
var n = null;
console.log(n * 32); // Will log 0 to the console
```
	
## Variable scope

When you declare a variable outside of any function, it is called a global variable, because it is available to any 
other code in the current document. When you declare a variable within a function, it is called a local variable, 
because it is available only within that function.

## Variable hoisting

Another unusual thing about variables in JavaScript is that you can refer to a variable declared later, without 
getting an exception. This concept is known as hoisting; variables in JavaScript are in a sense "hoisted" or lifted 
to the top of the function or statement. However, variables that are hoisted will return a value of undefined. So 
even if you declare and initialize after you use or refer to this variable, it will still return undefined.

```
/**
 * Example 1
 */
console.log(x === undefined); // true
var x = 3;

/**
 * Example 2
 */
// will return a value of undefined
var myvar = 'my value';
 
(function() {
  console.log(myvar); // undefined
  var myvar = 'local value';
})();
```

The above examples will be interpreted the same as:

```
/**
 * Example 1
 */
var x;
console.log(x === undefined); // true
x = 3;
 
/**
 * Example 2
 */
var myvar = 'my value';
 
(function() {
  var myvar;
  console.log(myvar); // undefined
  myvar = 'local value';
})();
```


Because of hoisting, all var statements in a function should be placed as near to the top of the function as
 possible. This best practice increases the clarity of the code.

In ECMAScript 2015, let (const) will not hoist the variable to the top of the block. However, referencing the 
variable in the block before the variable declaration results in a ReferenceError. The variable is in a 
"temporal dead zone" from the start of the block until the declaration is processed.

```
console.log(x); // ReferenceError
let x = 3;
```

**Function hoisting**

For functions, only the function declaration gets hoisted to the top and not the function expression.

```
/* Function declaration */

foo(); // "bar"

function foo() {
  console.log('bar');
}


/* Function expression */

baz(); // TypeError: baz is not a function

var baz = function() {
  console.log('bar2');
};
```

### Global variables
Global variables are in fact properties of the global object. In web pages the global object is window, so you can 
set and access global variables using the window.variable syntax.

Consequently, you can access global variables declared in one window or frame from another window or frame by 
specifying the window or frame name. For example, if a variable called phoneNumber is declared in a document, 
you can refer to this variable from an iframe as parent.phoneNumber.

### Constants

You can create a read-only, named constant with the const keyword. The syntax of a constant identifier is the same 
as for a variable identifier: it must start with a letter, underscore or dollar sign ($) and can contain alphabetic,
 numeric, or underscore characters.

```
const PI = 3.14;
```

A constant cannot change value through assignment or be re-declared while the script is running. It has to be 
initialized to a value.

The scope rules for constants are the same as those for let block-scope variables. If the const keyword is omitted,
 the identifier is assumed to represent a variable.

You cannot declare a constant with the same name as a function or variable in the same scope. For example:

```
// THIS WILL CAUSE AN ERROR
function f() {};
const f = 5;

// THIS WILL CAUSE AN ERROR ALSO
function f() {
  const g = 5;
  var g;

  //statements
}
```

However, the properties of objects assigned to constants are not protected, so the following statement is executed 
without problems.

```
const MY_OBJECT = {'key': 'value'};
MY_OBJECT.key = 'otherValue';
```

## Data structures and types
**Data types**

The latest ECMAScript standard defines seven data types:

* Six data types that are primitives:
	1. Boolean. true and false.
	1. null. A special keyword denoting a null value. Because JavaScript is case-sensitive, null is not the same as Null, NULL, or any other variant.
	1. undefined. A top-level property whose value is undefined.
	1. Number. 42 or 3.14159.
	1. String. "Howdy"
	1. Symbol (new in ECMAScript 2015). A data type whose instances are unique and immutable.
* and **Object**

**Data type conversion**

JavaScript is a dynamically typed language. That means you don't have to specify the data type of a variable when 
you declare it, and data types are converted automatically as needed during script execution. So, for example, you
 could define a variable as follows:

```
var answer = 42;
```

And later, you could assign the same variable a string value, for example:

```
answer = 'Thanks for all the fish...';
```

Because JavaScript is dynamically typed, this assignment does not cause an error message.

In expressions involving numeric and string values with the + operator, JavaScript converts numeric values to strings. For example, consider the following statements:

```
x = 'The answer is ' + 42 // "The answer is 42"
y = 42 + ' is the answer' // "42 is the answer"
```
In statements involving other operators, JavaScript does not convert numeric values to strings. For example:

```
'37' - 7 // 30
'37' + 7 // "377"
```

**Converting strings to numbers**

In the case that a value representing a number is in memory as a string, there are methods for conversion.

*parseInt()* - parseInt will only return whole numbers, so its use is diminished for decimals
*parseFloat()*

A best practice for parseInt is to always include the radix parameter. The radix parameter is used to specify which
 numerical system is to be used.

An alternative method of retrieving a number from a string is with the + (unary plus) operator:

```
'1.1' + '1.1' = '1.11.1'
(+'1.1') + (+'1.1') = 2.2
```   

// Note: the parentheses are added for clarity, not required.

## Literals
literals are used to represent values in JavaScript. These are fixed values, not variables, that you literally 
provide in your script. literals types are as follows :

1. *Array literals* - An array literal is a list of zero or more expressions, each of which represents an array 
element, enclosed in square brackets ([]). When you create an array using an array literal, it is initialized 
with the specified values as its elements, and its length is set to the number of arguments specified.

The following example creates the coffees array with three elements and a length of three:

```
var coffees = ['French Roast', 'Colombian', 'Kona'];
```

If an array is created using a literal in a top-level script, JavaScript interprets the array each time it 
evaluates the expression containing the array literal. In addition, a literal used in a function is created each 
time the function is called.

**Extra commas in array literals**

You do not have to specify all elements in an array literal. If you put two commas in a row, the array is created 
with undefined for the unspecified elements. The following example creates the fish array:

```
var fish = ['Lion', , 'Angel'];
```

This array has two elements with values and one empty element (fish[0] is "Lion", fish[1] is undefined, and fish[2] 
is "Angel").

If you include a trailing comma at the end of the list of elements, the comma is ignored. In the following example,
 the length of the array is three. There is no myList[3]. All other commas in the list indicate a new element.
```
var myList = ['home', , 'school', ];
```

1. Boolean literals - The Boolean type has two literal values: true and false. Do not confuse the primitive Boolean 
values true and false with the true and false values of the Boolean object. The Boolean object is a wrapper around 
the primitive Boolean data type. 

1. Floating-point literals - A floating-point literal can have the following parts:

* A decimal integer which can be signed (preceded by "+" or "-"),
* A decimal point ("."),
* A fraction (another decimal number),
* An exponent.

The exponent part is an "e" or "E" followed by an integer, which can be signed (preceded by "+" or "-"). A floating-point literal must have at least one digit and either a decimal point or "e" (or "E").

More succinctly, the syntax is:
```
[(+|-)][digits][.digits][(E|e)[(+|-)]digits]
```
For example:
```
3.1415926
-.123456789
-3.1E+12
.1e-23
```
1. Integers - Integers can be expressed in decimal (base 10), hexadecimal (base 16), octal (base 8) and binary 
(base 2).

* A decimal integer literal consists of a sequence of digits without a leading 0 (zero).
* A leading 0 (zero) on an integer literal, or a leading 0o (or 0O) indicates it is in octal. Octal integers can include only the digits 0-7.
* A leading 0x (or 0X) indicates a hexadecimal integer literal. Hexadecimal integers can include digits (0-9) and the letters a-f and A-F. (The case of a character does not change it's value, e.g. 0xa = 0xA = 10 and 0xf = 0xF = 15.)
* A leading 0b (or 0B) indicates a binary integer literal. Binary integers can only include the digits 0 and 1.

Some examples of integer literals are:
```
0, 117 and -345 (decimal, base 10)
015, 0001 and -0o77 (octal, base 8) 
0x1123, 0x00111 and -0xF1A7 (hexadecimal, "hex" or base 16)
0b11, 0b0011 and -0b11 (binary, base 2)
```

1. Object literals - An object literal is a list of zero or more pairs of property names and associated values of 
an object, enclosed in curly braces ({}). You should not use an object literal at the beginning of a statement. 
This will lead to an error or not behave as you expect, because the { will be interpreted as the beginning of a 
block.

The following is an example of an object literal. The first element of the car object defines a property, myCar, 
and assigns to it a new string, "Saturn"; the second element, the getCar property, is immediately assigned the 
result of invoking the function (carTypes("Honda")); the third element, the special property, uses an existing 
variable (sales).
```
var sales = 'Toyota';

function carTypes(name) {
  if (name === 'Honda') {
    return name;
  } else {
    return "Sorry, we don't sell " + name + ".";
  }
}

var car = { myCar: 'Saturn', getCar: carTypes('Honda'), special: sales };

console.log(car.myCar);   // Saturn
console.log(car.getCar);  // Honda
console.log(car.special); // Toyota
```

Additionally, you can use a numeric or string literal for the name of a property or nest an object inside another. 
The following example uses these options.
```
var car = { manyCars: {a: 'Saab', 'b': 'Jeep'}, 7: 'Mazda' };

console.log(car.manyCars.b); // Jeep
console.log(car[7]); // Mazda
```

Object property names can be any string, including the empty string. If the property name would not be a valid 
JavaScript identifier or number, it must be enclosed in quotes. Property names that are not valid identifiers also 
cannot be accessed as a dot (.) property, but can be accessed and set with the array-like notation("[]").

```
var unusualPropertyNames = {
  '': 'An empty string',
  '!': 'Bang!'
}
console.log(unusualPropertyNames.'');   // SyntaxError: Unexpected string
console.log(unusualPropertyNames['']);  // An empty string
console.log(unusualPropertyNames.!);    // SyntaxError: Unexpected token !
console.log(unusualPropertyNames['!']); // Bang!
```

**Enhanced Object literals**
In ES2015, object literals are extended to support setting the prototype at construction, shorthand for foo: foo 
assignments, defining methods, making super calls, and computing property names with expressions. Together, these 
also bring object literals and class declarations closer together, and let object-based design benefit from some 
of the same conveniences.

```
var obj = {
    // __proto__
    __proto__: theProtoObj,
    // Shorthand for ‘handler: handler’
    handler,
    // Methods
    toString() {
     // Super calls
     return 'd ' + super.toString();
    },
    // Computed (dynamic) property names
    [ 'prop_' + (() => 42)() ]: 42
};
```
Please note:

```
var foo = {a: 'alpha', 2: 'two'};
console.log(foo.a);    // alpha
console.log(foo[2]);   // two
//console.log(foo.2);  // Error: missing ) after argument list
//console.log(foo[a]); // Error: a is not defined
console.log(foo['a']); // alpha
console.log(foo['2']); // two
```

1. RegExp literals - A regex literal is a pattern enclosed between slashes. 
	```
	var re = /ab+c/;
	```

1. String literals - A string literal is zero or more characters enclosed in double (") or single (') quotation 
marks. A string must be delimited by quotation marks of the same type; that is, either both single quotation marks 
or both double quotation marks. The following are examples of string literals:
	```
	'foo'
	"bar"
	'1234'
	'one line \n another line'
	"John's cat"
	```
	
	You can call any of the methods of the String object on a string literal value—JavaScript automatically converts the string literal to a temporary String object, calls the method, then discards the temporary String object. You can also use the String.length property with a string literal:
```
console.log("John's cat".length) 

// Will print the number of symbols in the string including whitespace. 
// In this case, 10.
```

In ES2015, template literals are also available. Template literals are enclosed by the back-tick (` `)  
(grave accent) character instead of double or single quotes. Template strings provide syntactic sugar for 
constructing strings. This is similar to string interpolation features in Perl, Python and more. Optionally, a 
tag can be added to allow the string construction to be customized, avoiding injection attacks or constructing 
higher level data structures from string contents.
```
// Basic literal string creation
`In JavaScript '\n' is a line-feed.`

// Multiline strings
`In JavaScript template strings can run
 over multiple lines, but double and single
 quoted strings cannot.`

// String interpolation
var name = 'Bob', time = 'today';
`Hello ${name}, how are you ${time}?`

// Construct an HTTP request prefix is used to interpret the replacements and construction
POST`http://foo.org/bar?a=${a}&b=${b}
     Content-Type: application/json
     X-Credentials: ${credentials}
     { "foo": ${foo},
       "bar": ${bar}}`(myOnReadyStateChangeHandler);
```
You should use string literals unless you specifically need to use a String object.

**Using special characters in strings**
In addition to ordinary characters, you can also include special characters in strings

Character | Meaning
----------| --------
\0        | Null Byte
\b        | Backspace
\f        | Form feed
\n        | New Line
\r        | Carriage return
\t        | Tab
\v        | Vertical Tab
\'        | Apostrophe or single quote
\"        | Double quote
\\        | Backslash character