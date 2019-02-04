URL - https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference
https://guides.github.com/features/mastering-markdown/#GitHub-flavored-markdown
https://help.github.com/articles/basic-writing-and-formatting-syntax/
https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Regular_Expressions

# Grammar and types

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

# Control flow and error handling

A conditional statement is a set of commands that executes if a specified condition is true. JavaScript supports 
two conditional statements: if...else and switch.

## if...else
Use the if statement to execute a statement if a logical condition is true. Use the optional else clause to 
execute a statement if the condition is false. An if statement looks as follows:
```
if (condition) {
  statement_1;
} else {
  statement_2;
}
```

You may also compound the statements using else if to have multiple conditions tested in sequence, as follows:
```
if (condition_1) {
  statement_1;
} else if (condition_2) {
  statement_2;
} else if (condition_n) {
  statement_n;
} else {
  statement_last;
} 
```

It is advisable to not use simple assignments in a conditional expression, because the assignment can be confused with equality when glancing over the code. For example, do not use the following code:
```
if (x = y) {
  /* statements here */
}
```

If you need to use an assignment in a conditional expression, a common practice is to put additional parentheses around the assignment. For example:
```
if ((x = y)) {
  /* statements here */
}
```

**Falsy values**
The following values evaluate to false (also known as Falsy values):

* false
* undefined
* null
* 0
* NaN
* the empty string ("")

All other values, including all objects, evaluate to true when passed to a conditional statement.

Do not confuse the primitive boolean values true and false with the true and false values of the Boolean object. For example:

```
var b = new Boolean(false);
if (b) // this condition evaluates to true
if (b == true) // this condition evaluates to false
```
**Example**
In the following example, the function checkData returns true if the number of characters in a Text object is three; otherwise, it displays an alert and returns false.
```
function checkData() {
  if (document.form1.threeChar.value.length == 3) {
    return true;
  } else {
    alert('Enter exactly three characters. ' +
    document.form1.threeChar.value + ' is not valid.');
    return false;
  }
}
```

## switch
A switch statement allows a program to evaluate an expression and attempt to match the expression's value to a case label. If a match is found, the program executes the associated statement. 
A switch statement looks as follows:

```
switch (expression) {
  case label_1:
    statements_1
    [break;]
  case label_2:
    statements_2
    [break;]
    ...
  default:
    statements_def
    [break;]
}
```

The program first looks for a case clause with a label matching the value of expression and then transfers control
 to that clause, executing the associated statements. If no matching label is found, the program looks for the 
 optional default clause, and if found, transfers control to that clause, executing the associated statements. 
 If no default clause is found, the program continues execution at the statement following the end of switch. By 
 convention, the default clause is the last clause, but it does not need to be so.

The optional break statement associated with each case clause ensures that the program breaks out of switch once 
the matched statement is executed and continues execution at the statement following switch. If break is omitted, 
the program continues execution at the next statement in the switch statement.

**Example**
In the following example, if fruittype evaluates to "Bananas", the program matches the value with case "Bananas" 
and executes the associated statement. When break is encountered, the program terminates switch and executes the 
statement following switch. If break were omitted, the statement for case "Cherries" would also be executed.
```
switch (fruittype) {
  case 'Oranges':
    console.log('Oranges are $0.59 a pound.');
    break;
  case 'Apples':
    console.log('Apples are $0.32 a pound.');
    break;
  case 'Bananas':
    console.log('Bananas are $0.48 a pound.');
    break;
  case 'Cherries':
    console.log('Cherries are $3.00 a pound.');
    break;
  case 'Mangoes':
    console.log('Mangoes are $0.56 a pound.');
    break;
  case 'Papayas':
    console.log('Mangoes and papayas are $2.79 a pound.');
    break;
  default:
   console.log('Sorry, we are out of ' + fruittype + '.');
}
console.log("Is there anything else you'd like?");
```

## try/catch/throw
You can throw exceptions using the `throw` statement and handle them using the `try...catch` statements.

* throw statement
* try...catch statement

**Exception types**
Just about any object can be thrown in JavaScript. Nevertheless, not all thrown objects are created equal. While
 it is fairly common to throw numbers or strings as errors it is frequently more effective to use one of the 
 exception types specifically created for this purpose:

* ECMAScript exceptions
* DOMException and DOMError

**throw statement**
Use the throw statement to throw an exception. When you throw an exception, you specify the expression containing 
the value to be thrown:

```
throw expression;
```
You may throw any expression, not just expressions of a specific type. The following code throws several exceptions
 of varying types:
```
throw 'Error2';   // String type
throw 42;         // Number type
throw true;       // Boolean type
throw {toString: function() { return "I'm an object!"; } };
```
Note: You can specify an object when you throw an exception. You can then reference the object's properties in the catch block.
```
// Create an object type UserException
function UserException(message) {
  this.message = message;
  this.name = 'UserException';
}

// Make the exception convert to a pretty string when used as a string 
// (e.g. by the error console)

UserException.prototype.toString = function() {
  return this.name + ': "' + this.message + '"';
}

// Create an instance of the object type and throw it
throw new UserException('Value too high');
```

**try...catch statement**

The try...catch statement consists of a try block, which contains one or more statements, and a catch block, 
containing statements that specify what to do if an exception is thrown in the try block. That is, you want the 
try block to succeed, and if it does not succeed, you want control to pass to the catch block. If any statement 
within the try block (or in a function called from within the try block) throws an exception, control immediately 
shifts to the catch block. If no exception is thrown in the try block, the catch block is skipped. The finally 
block executes after the try and catch blocks execute but before the statements following the try...catch 
statement.

The following example uses a try...catch statement. The example calls a function that retrieves a month name from 
an array based on the value passed to the function. If the value does not correspond to a month number (1-12), 
an exception is thrown with the value "InvalidMonthNo" and the statements in the catch block set the monthName 
variable to unknown.

```
function getMonthName(mo) {
  mo = mo - 1; // Adjust month number for array index (1 = Jan, 12 = Dec)
  var months = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul',
                'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
  if (months[mo]) {
    return months[mo];
  } else {
    throw 'InvalidMonthNo'; //throw keyword is used here
  }
}

try { // statements to try
  monthName = getMonthName(myMonth); // function could throw exception
}
catch (e) {
  monthName = 'unknown';
  logMyErrors(e); // pass exception object to error handler -> your own function
}
```

**The catch block**
You can use a catch block to handle all exceptions that may be generated in the try block.

```
catch (catchID) {
  statements
}
```

The catch block specifies an identifier (catchID in the preceding syntax) that holds the value specified by the 
throw statement; you can use this identifier to get information about the exception that was thrown. JavaScript 
creates this identifier when the catch block is entered; the identifier lasts only for the duration of the catch 
block; after the catch block finishes executing, the identifier is no longer available.

For example, the following code throws an exception. When the exception occurs, control transfers to the catch 
block.

```
try {
  throw 'myException'; // generates an exception
}
catch (e) {
  // statements to handle any exceptions
  logMyErrors(e); // pass exception object to error handler
}
```
**The finally block**
The finally block contains statements to execute after the try and catch blocks execute but before the statements 
following the try...catch statement. The finally block executes whether or not an exception is thrown. If an 
exception is thrown, the statements in the finally block execute even if no catch block handles the exception.

You can use the finally block to make your script fail gracefully when an exception occurs; for example, you may 
need to release a resource that your script has tied up. The following example opens a file and then executes 
statements that use the file (server-side JavaScript allows you to access files). If an exception is thrown while 
the file is open, the finally block closes the file before the script fails.

```
openMyFile();
try {
  writeMyFile(theData); //This may throw an error
} catch(e) {  
  handleError(e); // If we got an error we handle it
} finally {
  closeMyFile(); // always close the resource
}
```
If the finally block returns a value, this value becomes the return value of the entire try-catch-finally production, regardless of any return statements in the try and catch blocks:

```
function f() {
  try {
    console.log(0);
    throw 'bogus';
  } catch(e) {
    console.log(1);
    return true; // this return statement is suspended
                 // until finally block has completed
    console.log(2); // not reachable
  } finally {
    console.log(3);
    return false; // overwrites the previous "return"
    console.log(4); // not reachable
  }
  // "return false" is executed now  
  console.log(5); // not reachable
}
f(); // console 0, 1, 3; returns false
```

## Error objects

Depending on the type of error, you may be able to use the 'name' and 'message' properties to get a more refined 
message. 'name' provides the general class of Error (e.g., 'DOMException' or 'Error'), while 'message' generally 
provides a more succinct message than one would get by converting the error object to a string.

If you are throwing your own exceptions, in order to take advantage of these properties (such as if your catch 
block doesn't discriminate between your own exceptions and system ones), you can use the Error constructor. 
For example:

```
function doSomethingErrorProne() {
  if (ourCodeMakesAMistake()) {
    throw (new Error('The message'));
  } else {
    doSomethingToGetAJavascriptError();
  }
}
....
try {
  doSomethingErrorProne();
} catch (e) {
  console.log(e.name); // logs 'Error'
  console.log(e.message); // logs 'The message' or a JavaScript error message)
}
```

## Promises

Promise objects allow you to control the flow of deferred and asynchronous operations.

A Promise is in one of these states:

* pending: initial state, not fulfilled or rejected.
* fulfilled: successful operation
* rejected: failed operation.
* settled: the Promise is either fulfilled or rejected, but not pending.

**Loading an image with XHR**
A simple example using Promise and XMLHttpRequest to load an image is available at the MDN GitHub js-examples repository. You can also see it in action. Each step is commented and allows you to follow the Promise and XHR architecture closely. Here is the uncommented version, showing the Promise flow so that you can get an idea:

```
function imgLoad(url) {
  return new Promise(function(resolve, reject) {
    var request = new XMLHttpRequest();
    request.open('GET', url);
    request.responseType = 'blob';
    request.onload = function() {
      if (request.status === 200) {
        resolve(request.response);
      } else {
        reject(Error('Image didn\'t load successfully; error code:' 
                     + request.statusText));
      }
    };
    request.onerror = function() {
      reject(Error('There was a network error.'));
    };
    request.send();
  });
}
```

# Loops and iteration
You can think of a loop as a computerized version of the game where you tell someone to take X steps in one direction then Y steps in another; for example, the idea "Go five steps to the east" could be expressed this way as a loop:
```
var step;
for (step = 0; step < 5; step++) {
  // Runs 5 times, with values of step 0 through 4.
  console.log('Walking east one step');
}
```
There are many different kinds of loops, but they all essentially do the same thing: they repeat an action some number of times (and it's actually possible that number could be zero). The various loop mechanisms offer different ways to determine the start and end points of the loop. There are various situations that are more easily served by one type of loop over the others.

## for

A for loop repeats until a specified condition evaluates to false. The JavaScript for loop is similar to the Java and C for loop. A for statement looks as follows:
```
for ([initialExpression]; [condition]; [incrementExpression])
  statement
```
When a for loop executes, the following occurs:

   * The initializing expression initialExpression, if any, is executed. This expression usually initializes one or more loop counters, but the syntax allows an expression of any degree of complexity. This expression can also declare variables.
   * The condition expression is evaluated. If the value of condition is true, the loop statements execute. If the value of condition is false, the for loop terminates. If the condition expression is omitted entirely, the condition is assumed to be true.
   * The statement executes. To execute multiple statements, use a block statement ({ ... }) to group those statements.
   * If present, the update expression incrementExpression is executed.
   * Control returns to step 2.

   **example**
   The following function contains a for statement that counts the number of selected options in a scrolling list (a <select> element that allows multiple selections). The for statement declares the variable i and initializes it to zero. It checks that i is less than the number of options in the <select> element, performs the succeeding if statement, and increments i by one after each pass through the loop.
   ```
    <form name="selectForm">
	  <p>
		<label for="musicTypes">Choose some music types, then click the button below:</label>
		<select id="musicTypes" name="musicTypes" multiple="multiple">
		  <option selected="selected">R&B</option>
		  <option>Jazz</option>
		  <option>Blues</option>
		  <option>New Age</option>
		  <option>Classical</option>
		  <option>Opera</option>
		</select>
	  </p>
	  <p><input id="btn" type="button" value="How many are selected?" /></p>
	</form>

	<script>
	function howMany(selectObject) {
	  var numberSelected = 0;
	  for (var i = 0; i < selectObject.options.length; i++) {
		if (selectObject.options[i].selected) {
		  numberSelected++;
		}
	  }
	  return numberSelected;
	}

	var btn = document.getElementById('btn');
	btn.addEventListener('click', function() {
	  alert('Number of options selected: ' + howMany(document.selectForm.musicTypes));
	});
	</script>
	```
## while
A while statement executes its statements as long as a specified condition evaluates to true. A while statement looks as follows:
```
while (condition)
  statement
```

If the condition becomes false, statement within the loop stops executing and control passes to the statement following the loop.

The condition test occurs before statement in the loop is executed. If the condition returns true, statement is executed and the condition is tested again. If the condition returns false, execution stops and control is passed to the statement following while.

To execute multiple statements, use a block statement ({ ... }) to group those statements.

**Example 1**
The following while loop iterates as long as n is less than three:

```
var n = 0;
var x = 0;
while (n < 3) {
  n++;
  x += n;
}
```

**Example 2**

Avoid infinite loops. Make sure the condition in a loop eventually becomes false; otherwise, the loop will never terminate. The statements in the following while loop execute forever because the condition never becomes false:

```
while (true) {
  console.log('Hello, world!');
}
```

## do...while
The do...while statement repeats until a specified condition evaluates to false. A do...while statement looks as follows:
```
do
  statement
while (condition);
```
statement executes once before the condition is checked. To execute multiple statements, use a block statement ({ ... }) to group those statements. If condition is true, the statement executes again. At the end of every execution, the condition is checked. When the condition is false, execution stops and control passes to the statement following do...while.

**Example**
In the following example, the do loop iterates at least once and reiterates until i is no longer less than 5.
```
var i = 0;
do {
  i += 1;
  console.log(i);
} while (i < 5);
```
## break/continue

**break**

Use the break statement to terminate a loop, switch, or in conjunction with a labeled statement.

    * When you use break without a label, it terminates the innermost enclosing while, do-while, for, or switch immediately and transfers control to the following statement.
    * When you use break with a label, it terminates the specified labeled statement.

The following example iterates through the elements in an array until it finds the index of an element whose value is theValue:

```	
for (var i = 0; i < a.length; i++) {
  if (a[i] == theValue) {
    break;
  }
}
```

**continue**

The continue statement can be used to restart a while, do-while, for, or label statement.

    * When you use continue without a label, it terminates the current iteration of the innermost enclosing while, do-while, or for statement and continues execution of the loop with the next iteration. In contrast to the break statement, continue does not terminate the execution of the loop entirely. In a while loop, it jumps back to the condition. In a for loop, it jumps to the increment-expression.
    * When you use continue with a label, it applies to the looping statement identified with that label.

The syntax of the continue statement looks like the following:
```
continue [label];
```
**Example 1**

The following example shows a while loop with a continue statement that executes when the value of i is three. Thus, n takes on the values one, three, seven, and twelve.
```
var i = 0;
var n = 0;
while (i < 5) {
  i++;
  if (i == 3) {
    continue;
  }
  n += i;
}
```


## for..in

The for...in statement iterates a specified variable over all the enumerable properties of an object. For each distinct property, JavaScript executes the specified statements. A for...in statement looks as follows:

```
for (variable in object) {
  statements
}
```

**Example**

The following function takes as its argument an object and the object's name. It then iterates over all the object's properties and returns a string that lists the property names and their values.

```
function dump_props(obj, obj_name) {
  var result = '';
  for (var i in obj) {
    result += obj_name + '.' + i + ' = ' + obj[i] + '<br>';
  }
  result += '<hr>';
  return result;
}
```

For an object car with properties make and model, result would be:

```
car.make = Ford
car.model = Mustang
```

Although it may be tempting to use this as a way to iterate over Array elements, the for...in statement will return the name of your user-defined properties in addition to the numeric indexes. Thus it is better to use a traditional for loop with a numeric index when iterating over arrays, because the for...in statement iterates over user-defined properties in addition to the array elements, if you modify the Array object, such as adding custom properties or methods.

## for..of
The for...of statement creates a loop Iterating over iterable objects (including Array, Map, Set, arguments object and so on), invoking a custom iteration hook with statements to be executed for the value of each distinct property.

```
for (variable of object) {
  statement
}
```

The following example shows the difference between a for...of loop and a for...in loop. While for...in iterates over property names, for...of iterates over property values:
```
var arr = [3, 5, 7];
arr.foo = 'hello';

for (var i in arr) {
   console.log(i); // logs "0", "1", "2", "foo"
}

for (var i of arr) {
   console.log(i); // logs 3, 5, 7
}
```
# Functions
Functions are one of the fundamental building blocks in JavaScript. A function is a JavaScript procedure—a set of statements that performs a task or calculates a value. To use a function, you must define it somewhere in the scope from which you wish to call it.

## Defining functions
A function definition (also called a function declaration, or function statement) consists of the function keyword, followed by:

    * The name of the function.
    * A list of parameters to the function, enclosed in parentheses and separated by commas.
    * The JavaScript statements that define the function, enclosed in curly brackets, { }.

	For example, the following code defines a simple function named square:

```
function square(number) {
  return number * number;
}
```
The function square takes one parameter, called number. The function consists of one statement that says to return the parameter of the function (that is, number) multiplied by itself. The return statement specifies the value returned by the function.
```
return number * number;
```
Primitive parameters (such as a number) are passed to functions by value; the value is passed to the function, but if the function changes the value of the parameter, this change is does not reflected globally or in the calling function.

If you pass an object (i.e. a non-primitive value, such as Array or a user-defined object) as a parameter and the function changes the object's properties, that change is visible outside the function, as shown in the following example:
```
function myFunc(theObject) {
  theObject.make = 'Toyota';
}

var mycar = {make: 'Honda', model: 'Accord', year: 1998};
var x, y;

x = mycar.make; // x gets the value "Honda"

myFunc(mycar);
y = mycar.make; // y gets the value "Toyota"
                // (the make property was changed by the function)
```

**Function expressions**

While the function declaration above is syntactically a statement, functions can also be created by a function expression. Such a function can be anonymous; it does not have to have a name. For example, the function square could have been defined as:
```
var square = function(number) { return number * number; };
var x = square(4); // x gets the value 16
```
However, a name can be provided with a function expression and can be used inside the function to refer to itself, or in a debugger to identify the function in stack traces:

```
var factorial = function fac(n) { return n < 2 ? 1 : n * fac(n - 1); };

console.log(factorial(3));
```
Function expressions are convenient when passing a function as an argument to another function. The following example shows a map function that should receive a function as first argument and an array as second argument. 

```
function map(f, a) {
  var result = [], // Create a new Array
      i;
  for (i = 0; i != a.length; i++)
    result[i] = f(a[i]);
  return result;
}
```
In the following code our function receives a function defined by a function expression and executes it for every element of the array received as a second argument. 

```
function map(f, a) {
  var result = []; // Create a new Array
  var i; // Declare variable
  for (i = 0; i != a.length; i++)
    result[i] = f(a[i]);
      return result;
}
var f = function(x) {
   return x * x * x; 
}
var numbers = [0, 1, 2, 5, 10];
var cube = map(f,numbers);
console.log(cube);
```

Function returns: [0, 1, 8, 125, 1000].

In JavaScript, a function can be defined based on a condition. For example, the following function definition defines myFunc only if num equals 0:

```
var myFunc;
if (num === 0) {
  myFunc = function(theObject) {
    theObject.make = 'Toyota';
  }
}
```
In addition to defining functions as described here, you can also use the Function constructor to create functions from a string at runtime, much like eval().

A method is a function that is a property of an object. 

## Calling functions

Calling the function actually performs the specified actions with the indicated parameters. For example, if you define the function square, you could call it as follows:

```
square(5);
```
The preceding statement calls the function with an argument of 5. The function executes its statements and returns the value 25.

Functions must be in scope when they are called, but the function declaration can be hoisted (appear below the call in the code), as in this example:

```
console.log(square(5));
/* ... */
function square(n) { return n * n; }
```
The scope of a function is the function in which it is declared, or the entire program if it is declared at the top level.

Function hoisting only works with function declaration and not with function expression.
```
console.log(square); // square is hoisted with an initial value undefined.
console.log(square(5)); // TypeError: square is not a function
var square = function(n) { 
  return n * n; 
}
```

The arguments of a function are not limited to strings and numbers. You can pass whole objects to a function. The show_props() function (defined in Working with objects) is an example of a function that takes an object as an argument.

A function can call itself. For example, here is a function that computes factorials recursively:

```
function factorial(n) {
  if ((n === 0) || (n === 1))
    return 1;
  else
    return (n * factorial(n - 1));
}
```

You could then compute the factorials of one through five as follows:

```
var a, b, c, d, e;
a = factorial(1); // a gets the value 1
b = factorial(2); // b gets the value 2
c = factorial(3); // c gets the value 6
d = factorial(4); // d gets the value 24
e = factorial(5); // e gets the value 120
```

There are other ways to call functions. There are often cases where a function needs to be called dynamically, or the number of arguments to a function vary, or in which the context of the function call needs to be set to a specific object determined at runtime. It turns out that functions are, themselves, objects, and these objects in turn have methods (see the Function object). 

## Function scope

Variables defined inside a function cannot be accessed from anywhere outside the function, because the variable is defined only in the scope of the function. However, a function can access all variables and functions defined inside the scope in which it is defined. In other words, a function defined in the global scope can access all variables defined in the global scope. A function defined inside another function can also access all variables defined in its parent function and any other variable to which the parent function has access.

```
// The following variables are defined in the global scope
var num1 = 20,
    num2 = 3,
    name = 'Chamahk';

// This function is defined in the global scope
function multiply() {
  return num1 * num2;
}

multiply(); // Returns 60

// A nested function example
function getScore() {
  var num1 = 2,
      num2 = 3;
  
  function add() {
    return name + ' scored ' + (num1 + num2);
  }
  
  return add();
}

getScore(); // Returns "Chamahk scored 5"
```

**Scope and the function stack**

**Recursion**

A function can refer to and call itself. There are three ways for a function to refer to itself:

    * the function's name
    * arguments.callee
    * an in-scope variable that refers to the function

For example, consider the following function definition:

```
var foo = function bar() {
   // statements go here
};

Within the function body, the following are all equivalent:

    bar()
    arguments.callee()
    foo()
```

A function that calls itself is called a recursive function. In some ways, recursion is analogous to a loop. Both execute the same code multiple times, and both require a condition (to avoid an infinite loop, or rather, infinite recursion in this case). For example, the following loop:

```
var x = 0;
while (x < 10) { // "x < 10" is the loop condition
   // do stuff
   x++;
}
```

can be converted into a recursive function and a call to that function:

```
function loop(x) {
  if (x >= 10) // "x >= 10" is the exit condition (equivalent to "!(x < 10)")
    return;
  // do stuff
  loop(x + 1); // the recursive call
}
loop(0);
```

However, some algorithms cannot be simple iterative loops. For example, getting all the nodes of a tree structure (e.g. the DOM) is more easily done using recursion:

```
function walkTree(node) {
  if (node == null) // 
    return;
  // do something with node
  for (var i = 0; i < node.childNodes.length; i++) {
    walkTree(node.childNodes[i]);
  }
}
```

Compared to the function loop, each recursive call itself makes many recursive calls here.

It is possible to convert any recursive algorithm to a non-recursive one, but often the logic is much more complex and doing so requires the use of a stack. In fact, recursion itself uses a stack: the function stack.

The stack-like behavior can be seen in the following example:

```
function foo(i) {
  if (i < 0)
    return;
  console.log('begin: ' + i);
  foo(i - 1);
  console.log('end: ' + i);
}
foo(3);

// Output:

// begin: 3
// begin: 2
// begin: 1
// begin: 0
// end: 0
// end: 1
// end: 2
// end: 3
```

**Nested functions and closures**

You can nest a function within a function. The nested (inner) function is private to its containing (outer) function. It also forms a closure. A closure is an expression (typically a function) that can have free variables together with an environment that binds those variables (that "closes" the expression).

Since a nested function is a closure, this means that a nested function can "inherit" the arguments and variables of its containing function. In other words, the inner function contains the scope of the outer function.

To summarize:

    * The inner function can be accessed only from statements in the outer function.

    * The inner function forms a closure: the inner function can use the arguments and variables of the outer function, while the outer function cannot use the arguments and variables of the inner function.

The following example shows nested functions:

```
function addSquares(a, b) {
  function square(x) {
    return x * x;
  }
  return square(a) + square(b);
}
a = addSquares(2, 3); // returns 13
b = addSquares(3, 4); // returns 25
c = addSquares(4, 5); // returns 41
```

Since the inner function forms a closure, you can call the outer function and specify arguments for both the outer and inner function:

```
function outside(x) {
  function inside(y) {
    return x + y;
  }
  return inside;
}
fn_inside = outside(3); // Think of it like: give me a function that adds 3 to whatever you give
                        // it
result = fn_inside(5); // returns 8

result1 = outside(3)(5); // returns 8
```

**Preservation of variables**

Notice how x is preserved when inside is returned. A closure must preserve the arguments and variables in all scopes it references. Since each call provides potentially different arguments, a new closure is created for each call to outside. The memory can be freed only when the returned inside is no longer accessible.

This is not different from storing references in other objects, but is often less obvious because one does not set the references directly and cannot inspect them.
Multiply-nested functions

Functions can be multiply-nested, i.e. a function (A) containing a function (B) containing a function (C). Both functions B and C form closures here, so B can access A and C can access B. In addition, since C can access B which can access A, C can also access A. Thus, the closures can contain multiple scopes; they recursively contain the scope of the functions containing it. This is called scope chaining. (Why it is called "chaining" will be explained later.)

Consider the following example:

```
function A(x) {
  function B(y) {
    function C(z) {
      console.log(x + y + z);
    }
    C(3);
  }
  B(2);
}
A(1); // logs 6 (1 + 2 + 3)
``

In this example, C accesses B's y and A's x. This can be done because:

    * B forms a closure including A, i.e. B can access A's arguments and variables.
    * C forms a closure including B.
    * Because B's closure includes A, C's closure includes A, C can access both B and A's arguments and variables. In other words, C chains the scopes of B and A in that order.

The reverse, however, is not true. A cannot access C, because A cannot access any argument or variable of B, which C is a variable of. Thus, C remains private to only B.
Name conflicts

When two arguments or variables in the scopes of a closure have the same name, there is a name conflict. More inner scopes take precedence, so the inner-most scope takes the highest precedence, while the outer-most scope takes the lowest. This is the scope chain. The first on the chain is the inner-most scope, and the last is the outer-most scope. Consider the following:

```
function outside() {
  var x = 5;
  function inside(x) {
    return x * 2;
  }
  return inside;
}

outside()(10); // returns 20 instead of 10
```

The name conflict happens at the statement return x and is between inside's parameter x and outside's variable x. The scope chain here is {inside, outside, global object}. Therefore inside's x takes precedences over outside's x, and 20 (inside's x) is returned instead of 10 (outside's x).

## Closures

JavaScript allows for the nesting of functions and grants the inner function full access to all the variables and functions defined inside the outer function (and all other variables and functions that the outer function has access to). However, the outer function does not have access to the variables and functions defined inside the inner function. This provides a sort of encapsulation for the variables of the inner function. Also, since the inner function has access to the scope of the outer function, the variables and functions defined in the outer function will live longer than the duration of the inner function execution, if the inner function manages to survive beyond the life of the outer function. A closure is created when the inner function is somehow made available to any scope outside the outer function.

```
var pet = function(name) {   // The outer function defines a variable called "name"
  var getName = function() {
    return name;             // The inner function has access to the "name" variable of the outer 
                             //function
  }
  return getName;            // Return the inner function, thereby exposing it to outer scopes
}
myPet = pet('Vivie');
   
myPet();                     // Returns "Vivie"
```

It can be much more complex than the code above. An object containing methods for manipulating the inner variables of the outer function can be returned.

```
var createPet = function(name) {
  var sex;
  
  return {
    setName: function(newName) {
      name = newName;
    },
    
    getName: function() {
      return name;
    },
    
    getSex: function() {
      return sex;
    },
    
    setSex: function(newSex) {
      if(typeof newSex === 'string' && (newSex.toLowerCase() === 'male' || 
        newSex.toLowerCase() === 'female')) {
        sex = newSex;
      }
    }
  }
}

var pet = createPet('Vivie');
pet.getName();                  // Vivie

pet.setName('Oliver');
pet.setSex('male');
pet.getSex();                   // male
pet.getName();                  // Oliver
```

In the code above, the name variable of the outer function is accessible to the inner functions, and there is no other way to access the inner variables except through the inner functions. The inner variables of the inner functions act as safe stores for the outer arguments and variables. They hold "persistent" and "encapsulated" data for the inner functions to work with. The functions do not even have to be assigned to a variable, or have a name.

```
var getCode = (function() {
  var apiCode = '0]Eal(eh&2';    // A code we do not want outsiders to be able to modify...
  
  return function() {
    return apiCode;
  };
}());

getCode();    // Returns the apiCode
```

There are, however, a number of pitfalls to watch out for when using closures. If an enclosed function defines a variable with the same name as the name of a variable in the outer scope, there is no way to refer to the variable in the outer scope again.

```
var createPet = function(name) {  // The outer function defines a variable called "name".
  return {
    setName: function(name) {    // The enclosed function also defines a variable called "name".
      name = name;               // How do we access the "name" defined by the outer function?
    }
  }
}
```

## Arguments & parameters

**Arguments**

The arguments of a function are maintained in an array-like object. Within a function, you can address the arguments passed to it as follows:

```
arguments[i]
```

where i is the ordinal number of the argument, starting at zero. So, the first argument passed to a function would be arguments[0]. The total number of arguments is indicated by arguments.length.

Using the arguments object, you can call a function with more arguments than it is formally declared to accept. This is often useful if you don't know in advance how many arguments will be passed to the function. You can use arguments.length to determine the number of arguments actually passed to the function, and then access each argument using the arguments object.

For example, consider a function that concatenates several strings. The only formal argument for the function is a string that specifies the characters that separate the items to concatenate. The function is defined as follows:

```
function myConcat(separator) {
   var result = ''; // initialize list
   var i;
   // iterate through arguments
   for (i = 1; i < arguments.length; i++) {
      result += arguments[i] + separator;
   }
   return result;
}
```

You can pass any number of arguments to this function, and it concatenates each argument into a string "list":

```
// returns "red, orange, blue, "
myConcat(', ', 'red', 'orange', 'blue');

// returns "elephant; giraffe; lion; cheetah; "
myConcat('; ', 'elephant', 'giraffe', 'lion', 'cheetah');

// returns "sage. basil. oregano. pepper. parsley. "
myConcat('. ', 'sage', 'basil', 'oregano', 'pepper', 'parsley');
```

Note: The arguments variable is "array-like", but not an array. It is array-like in that it has a numbered index and a length property. However, it does not possess all of the array-manipulation methods

**parameters**

**Default parameters**

In JavaScript, parameters of functions default to undefined. However, in some situations it might be useful to set a different default value. This is where default parameters can help.

In the past, the general strategy for setting defaults was to test parameter values in the body of the function and assign a value if they are undefined. If in the following example, no value is provided for b in the call, its value would be undefined  when evaluating a*b and the call to multiply would have returned NaN. However, this is caught with the second line in this example:

```
function multiply(a, b) {
  b = typeof b !== 'undefined' ?  b : 1;

  return a * b;
}

multiply(5); // 5
```
With default parameters, the check in the function body is no longer necessary. Now, you can simply put 1 as the default value for b in the function head:

```
function multiply(a, b = 1) {
  return a * b;
}

multiply(5); // 5
```

For more details, see default parameters in the reference.
Rest parameters

The rest parameter syntax allows us to represent an indefinite number of arguments as an array. In the example, we use the rest parameters to collect arguments from the second one to the end. We then multiply them by the first one. This example is using an arrow function, which is introduced in the next section.

```
function multiply(multiplier, ...theArgs) {
  return theArgs.map(x => multiplier * x);
}

var arr = multiply(2, 1, 2, 3);
console.log(arr); // [2, 4, 6]
```

## Arrow functions

An arrow function expression has a shorter syntax compared to function expressions and lexically binds the this value. Arrow functions are always anonymous. 

Two factors influenced the introduction of arrow functions: *shorter functions* and *lexical this*.
Shorter functions

In some functional patterns, shorter functions are welcome. Compare:

```
var a = [
  'Hydrogen',
  'Helium',
  'Lithium',
  'Beryllium'
];

var a2 = a.map(function(s) { return s.length; });

console.log(a2); // logs [8, 6, 7, 9]

var a3 = a.map(s => s.length);

console.log(a3); // logs [8, 6, 7, 9]
```

**Lexical this**

Until arrow functions, every new function defined its own this value (a new object in case of a constructor, undefined in strict mode function calls, the context object if the function is called as an "object method", etc.). This proved to be annoying with an object-oriented style of programming.

```
	function Person() {
	  // The Person() constructor defines `this` as itself.
	  this.age = 0;

	  setInterval(function growUp() {
		// In nonstrict mode, the growUp() function defines `this` 
		// as the global object, which is different from the `this`
		// defined by the Person() constructor.
		this.age++;
	  }, 1000);
	}

	var p = new Person();
```

In ECMAScript 3/5, this issue was fixed by assigning the value in this to a variable that could be closed over.

```
function Person() {
  var self = this; // Some choose `that` instead of `self`. 
                   // Choose one and be consistent.
  self.age = 0;

  setInterval(function growUp() {
    // The callback refers to the `self` variable of which
    // the value is the expected object.
    self.age++;
  }, 1000);
}
```

Alternatively, a bound function could be created so that the proper this value would be passed to the growUp() function.

Arrow functions capture the this value of the enclosing context, so the following code works as expected.

```
function Person() {
  this.age = 0;

  setInterval(() => {
    this.age++; // |this| properly refers to the person object
  }, 1000);
}

var p = new Person();
```

**JavaScript has several top-level, built-in functions:**

* eval() - evaluates JavaScript code represented as a string.

* uneval() - method creates a string representation of the source code of an Object.

* isFinite() - function determines whether the passed value is a finite number. If needed, the parameter is first converted to a number.

* isNaN() - determines whether a value is NaN or not. Note: coercion inside the isNaN function has interesting rules; you may alternatively want to use Number.isNaN(), as defined in ECMAScript 2015, or you can use typeof to determine if the value is Not-A-Number.

* parseFloat() - function parses a string argument and returns a floating point number.

* parseInt() -  function parses a string argument and returns an integer of the specified radix (the base in mathematical numeral systems).

* decodeURI() - function decodes a Uniform Resource Identifier (URI) previously created by encodeURI or by a similar routine.

* decodeURIComponent() - method decodes a Uniform Resource Identifier (URI) component previously created by encodeURIComponent or by a similar routine.

* encodeURI() - method encodes a Uniform Resource Identifier (URI) by replacing each instance of certain characters by one, two, three, or four escape sequences representing the UTF-8 encoding of the character (will only be four escape sequences for characters composed of two "surrogate" characters).

* encodeURIComponent() - method encodes a Uniform Resource Identifier (URI) component by replacing each instance of certain characters by one, two, three, or four escape sequences representing the UTF-8 encoding of the character (will only be four escape sequences for characters composed of two "surrogate" characters).


# Expressions and operators

## Assignment & Comparisons

**Assignment**

An assignment operator assigns a value to its left operand based on the value of its right operand. The simple assignment operator is equal (=), which assigns the value of its right operand to its left operand. That is, x = y assigns the value of y to x.

Name                              | Shorthand operator | Meaning
--------------------------------- | -------------------|--------
Assignment 	                      |  x = y 	           | x = y
Addition assignment 	          |  x += y 	       | x = x + y
Subtraction assignment 	          |  x -= y 	       | x = x - y
Multiplication assignment 	      |  x *= y 	       | x = x * y
Division assignment 	          |  x /= y 		   | x = x / y
Remainder assignment 	          |  x %= y 	       | x = x % y
Exponentiation assignment         |  x **= y 	       | x = x ** y
Left shift assignment 	          |  x <<= y 	       | x = x << y
Right shift assignment 	          |  x >>= y 	       | x = x >> y
Unsigned right shift assignment   |  x >>>= y 	       | x = x >>> y
Bitwise AND assignment 	          |  x &= y 	       | x = x & y
Bitwise XOR assignment            |  x ^= y 	       | x = x ^ y
Bitwise OR assignment 	          |  x |= y 	       | x = x | y

**Destructuring**

For more complex assignments, the destructuring assignment syntax is a JavaScript expression that makes it possible to extract data from arrays or objects using a syntax that mirrors the construction of array and object literals.

```
var foo = ['one', 'two', 'three'];

// without destructuring
var one   = foo[0];
var two   = foo[1];
var three = foo[2];

// with destructuring
var [one, two, three] = foo;
```

**Comparisons**

A comparison operator compares its operands and returns a logical value based on whether the comparison is true. The operands can be numerical, string, logical, or object values. Strings are compared based on standard lexicographical ordering, using Unicode values. In most cases, if the two operands are not of the same type, JavaScript attempts to convert them to an appropriate type for the comparison. This behavior generally results in comparing the operands numerically. The sole exceptions to type conversion within comparisons involve the === and !== operators, which perform strict equality and inequality comparisons. These operators do not attempt to convert the operands to compatible types before checking equality. 

 	 	

Operator            | Description                                | Examples returning true
--------------------| -------------------------------------------|-----------------------------------
Equal (==) 	        | Returns true if the operands are equal.    |	3 == var1 , "3" == var1 , 3 == '3'
Not equal (!=)      | Returns true if the operands are not equal.| 	var1 != 4, var2 != "3"     
Strict equal (===) 	| Returns true if the operands are equal and of the same type. |	3 === var1
Strict not equal (!==) | Returns true if the operands are of the same type but not equal, or are of different type. | var1 !== "3", 3 !== '3'
Greater than (>) |Returns true if the left operand is greater than the right operand.|	var2 > var1
"12" > 2
Greater than or equal (>=)|Returns true if the left operand is greater than or equal to the right operand.| 	var2 >= var1, var1 >= 3
Less than (<) |	Returns true if the left operand is less than the right operand.| var1 < var2, "2" < 12
Less than or equal (<=) | Returns true if the left operand is less than or equal to the right operand. |var1 <= var2, var2 <= 5

## Arithmetic operators

An arithmetic operator takes numerical values (either literals or variables) as their operands and returns a single numerical value. The standard arithmetic operators are addition (+), subtraction (-), multiplication (*), and division (/). These operators work as they do in most other programming languages when used with floating point numbers (in particular, note that division by zero produces Infinity). For example:

Operator      |	Description 													  |Example
--------------|-------------------------------------------------------------------|
Remainder (%) |	Binary operator. Returns the integer remainder of dividing the two operands. |	12 % 5 returns 2.
Increment (++)|	Unary operator. Adds one to its operand. If used as a prefix operator (++x), returns the value of its operand after adding one; if used as a postfix operator (x++), returns the value of its operand before adding one. |If x is 3, then ++x sets x to 4 and returns 4, whereas x++ returns 3 and, only then, sets x to 4.
Decrement (--)| Unary operator. Subtracts one from its operand. The return value is analogous to that for the increment operator. |	If x is 3, then --x sets x to 2 and returns 2, whereas x-- returns 3 and, only then, sets x to 2.
Unary negation (-)| 	Unary operator. Returns the negation of its operand. 	  |If x is 3, then -x returns -3.
Unary plus (+)| Unary operator. Attempts to convert the operand to a number, if it is not already. | 	+"3" returns 3. +true returns 1.
Exponentiation operator (**) | Calculates the base to the exponent power, that is, baseexponent |	2 ** 3 returns 8. 10 ** -1 returns 0.1.

## Bitwise & logical operators

**Logical**
Operator 	    |Usage 	       |Description
----------------|--------------|-----------------------------------------------------------------------------
Logical AND (&&)|expr1 && expr2| Returns expr1 if it can be converted to false; otherwise, returns expr2. Thus, when used with Boolean values, && returns true if both operands are true; otherwise, returns false.
Logical OR (||) |expr1 || expr2 |Returns expr1 if it can be converted to true; otherwise, returns expr2. Thus, when used with Boolean values, || returns true if either operand is true; if both are false, returns false.
Logical NOT (!) |!expr 	       |Returns false if its single operand that can be converted to true; otherwise, returns true.

The following code shows examples of the && (logical AND) operator.

```
var a1 =  true && true;     // t && t returns true
var a2 =  true && false;    // t && f returns false
var a3 = false && true;     // f && t returns false
var a4 = false && (3 == 4); // f && f returns false
var a5 = 'Cat' && 'Dog';    // t && t returns Dog
var a6 = false && 'Cat';    // f && t returns false
var a7 = 'Cat' && false;    // t && f returns false
```

The following code shows examples of the || (logical OR) operator.

```
var o1 =  true || true;     // t || t returns true
var o2 = false || true;     // f || t returns true
var o3 =  true || false;    // t || f returns true
var o4 = false || (3 == 4); // f || f returns false
var o5 = 'Cat' || 'Dog';    // t || t returns Cat
var o6 = false || 'Cat';    // f || t returns Cat
var o7 = 'Cat' || false;    // t || f returns Cat
```

The following code shows examples of the ! (logical NOT) operator.

```
var n1 = !true;  // !t returns false
var n2 = !false; // !f returns true
var n3 = !'Cat'; // !t returns false
```

**String operators**

The concatenation operator (+) concatenates two string values together, returning another string that is the union of the two operand strings.

For example,

```
console.log('my ' + 'string'); // console logs the string "my string".
```

The shorthand assignment operator += can also be used to concatenate strings.

For example,

```
var mystring = 'alpha';
mystring += 'bet'; // evaluates to "alphabet" and assigns this value to mystring.
```

## Conditional (ternary) operator

only JavaScript operator that takes three operands. The operator can have one of two values based on a condition. The syntax is:

```
condition ? val1 : val2
```

If condition is true, the operator has the value of val1. Otherwise it has the value of val2. You can use the conditional operator anywhere you would use a standard operator.

For example,

```
var status = (age >= 18) ? 'adult' : 'minor';
```
This statement assigns the value "adult" to the variable status if age is eighteen or more. Otherwise, it assigns the value "minor" to status.

## Unary operators

A unary operation is an operation with only one operand.

**delete**

The delete operator deletes an object, an object's property, or an element at a specified index in an array. The syntax is:

```
delete objectName;
delete objectName.property;
delete objectName[index];
delete property; // legal only within a with statement
```

where objectName is the name of an object, property is an existing property, and index is an integer representing the location of an element in an array.

The fourth form is legal only within a with statement, to delete a property from an object.

You can use the delete operator to delete variables declared implicitly but not those declared with the var statement.

If the delete operator succeeds, it sets the property or element to undefined. The delete operator returns true if the operation is possible; it returns false if the operation is not possible.

```
x = 42;
var y = 43;
myobj = new Number();
myobj.h = 4;    // create property h
delete x;       // returns true (can delete if declared implicitly)
delete y;       // returns false (cannot delete if declared with var)
delete Math.PI; // returns false (cannot delete predefined properties)
delete myobj.h; // returns true (can delete user-defined properties)
delete myobj;   // returns true (can delete if declared implicitly)
```

**Deleting array elements**

When you delete an array element, the array length is not affected. For example, if you delete a[3], a[4] is still a[4] and a[3] is undefined.

When the delete operator removes an array element, that element is no longer in the array. In the following example, trees[3] is removed with delete. However, trees[3] is still addressable and returns undefined.

```
var trees = ['redwood', 'bay', 'cedar', 'oak', 'maple'];
delete trees[3];
if (3 in trees) {
  // this does not get executed
}
```

If you want an array element to exist but have an undefined value, use the undefined keyword instead of the delete operator. In the following example, trees[3] is assigned the value undefined, but the array element still exists:

```
var trees = ['redwood', 'bay', 'cedar', 'oak', 'maple'];
trees[3] = undefined;
if (3 in trees) {
  // this gets executed
}
```

**typeof**

The typeof operator is used in either of the following ways:

```
typeof operand
typeof (operand)
```

The typeof operator returns a string indicating the type of the unevaluated operand. operand is the string, variable, keyword, or object for which the type is to be returned. The parentheses are optional.

Suppose you define the following variables:

```
var myFun = new Function('5 + 2');
var shape = 'round';
var size = 1;
var foo = ['Apple', 'Mango', 'Orange'];
var today = new Date();
```

The typeof operator returns the following results for these variables:

```
typeof myFun;       // returns "function"
typeof shape;       // returns "string"
typeof size;        // returns "number"
typeof foo;         // returns "object"
typeof today;       // returns "object"
typeof doesntExist; // returns "undefined"
```

For the keywords true and null, the typeof operator returns the following results:

```
typeof true; // returns "boolean"
typeof null; // returns "object"
```

For a number or string, the typeof operator returns the following results:

```
typeof 62;            // returns "number"
typeof 'Hello world'; // returns "string"
```

For property values, the typeof operator returns the type of value the property contains:

```
typeof document.lastModified; // returns "string"
typeof window.length;         // returns "number"
typeof Math.LN2;              // returns "number"
```

For methods and functions, the typeof operator returns results as follows:

```
typeof blur;        // returns "function"
typeof eval;        // returns "function"
typeof parseInt;    // returns "function"
typeof shape.split; // returns "function"
```

For predefined objects, the typeof operator returns results as follows:

```
typeof Date;     // returns "function"
typeof Function; // returns "function"
typeof Math;     // returns "object"
typeof Option;   // returns "function"
typeof String;   // returns "function"
```

**void**

The void operator is used in either of the following ways:

void (expression)
void expression

The void operator specifies an expression to be evaluated without returning a value. expression is a JavaScript expression to evaluate. The parentheses surrounding the expression are optional, but it is good style to use them.

You can use the void operator to specify an expression as a hypertext link. The expression is evaluated but is not loaded in place of the current document.

The following code creates a hypertext link that does nothing when the user clicks it. When the user clicks the link, void(0) evaluates to undefined, which has no effect in JavaScript.

```
<a href="javascript:void(0)">Click here to do nothing</a>
```

The following code creates a hypertext link that submits a form when the user clicks it.

```
<a href="javascript:void(document.form.submit())">
Click here to submit</a>
```

**in**

The in operator returns true if the specified property is in the specified object. The syntax is:

```
propNameOrNumber in objectName
```

where propNameOrNumber is a string or numeric expression representing a property name or array index, and objectName is the name of an object.

The following examples show some uses of the in operator.

```
// Arrays
var trees = ['redwood', 'bay', 'cedar', 'oak', 'maple'];
0 in trees;        // returns true
3 in trees;        // returns true
6 in trees;        // returns false
'bay' in trees;    // returns false (you must specify the index number,
                   // not the value at that index)
'length' in trees; // returns true (length is an Array property)

// built-in objects
'PI' in Math;          // returns true
var myString = new String('coral');
'length' in myString;  // returns true

// Custom objects
var mycar = { make: 'Honda', model: 'Accord', year: 1998 };
'make' in mycar;  // returns true
'model' in mycar; // returns true
```

**instanceof**

The instanceof operator returns true if the specified object is of the specified object type. The syntax is:

objectName instanceof objectType

where objectName is the name of the object to compare to objectType, and objectType is an object type, such as Date or Array.

Use instanceof when you need to confirm the type of an object at runtime. For example, when catching exceptions, you can branch to different exception-handling code depending on the type of exception thrown.

For example, the following code uses instanceof to determine whether theDay is a Date object. Because theDay is a Date object, the statements in the if statement execute.

```
var theDay = new Date(1995, 12, 17);
if (theDay instanceof Date) {
  // statements to execute
}
```
# Expressions

**Primary expressions**

Basic keywords and general expressions in JavaScript.

**this**

Use the this keyword to refer to the current object. In general, this refers to the calling object in a method. Use this either with the dot or the bracket notation:

```
this['propertyName']
this.propertyName
```

Suppose a function called validate validates an object's value property, given the object and the high and low values:

```
function validate(obj, lowval, hival) {
  if ((obj.value < lowval) || (obj.value > hival))
    console.log('Invalid Value!');
}
```

You could call validate in each form element's onChange event handler, using this to pass it the form element, as in the following example:

```
<p>Enter a number between 18 and 99:</p>
<input type="text" name="age" size=3 onChange="validate(this, 18, 99);">
```

**Grouping operator**

The grouping operator ( ) controls the precedence of evaluation in expressions. For example, you can override multiplication and division first, then addition and subtraction to evaluate addition first.

```
var a = 1;
var b = 2;
var c = 3;

// default precedence
a + b * c     // 7
// evaluated by default like this
a + (b * c)   // 7

// now overriding precedence 
// addition before multiplication   
(a + b) * c   // 9

// which is equivalent to
a * c + b * c // 9
```

**Comprehensions**

Comprehensions are an experimental JavaScript feature, targeted to be included in a future ECMAScript version. There are two versions of comprehensions:

```
[for (x of y) x] - Array comprehensions.
(for (x of y) y) - Generator comprehensions.
```
Comprehensions exist in many programming languages and allow you to quickly assemble a new array based on an existing one, for example.

```
[for (i of [1, 2, 3]) i * i]; 
// [1, 4, 9]

var abc = ['A', 'B', 'C'];
[for (letters of abc) letters.toLowerCase()];
// ["a", "b", "c"]
```

**Left-hand-side expressions**

Left values are the destination of an assignment.
new

You can use the new operator to create an instance of a user-defined object type or of one of the built-in object types. Use new as follows:

```
var objectName = new objectType([param1, param2, ..., paramN]);
```

**super**

The super keyword is used to call functions on an object's parent. It is useful with classes to call the parent constructor, for example.

```
super([arguments]); // calls the parent constructor.
super.functionOnParent([arguments]);
```

**Spread operator**

The spread operator allows an expression to be expanded in places where multiple arguments (for function calls) or multiple elements (for array literals) are expected.

Example: Today if you have an array and want to create a new array with the existing one being part of it, the array literal syntax is no longer sufficient and you have to fall back to imperative code, using a combination of push, splice, concat, etc. With spread syntax this becomes much more succinct:

```
var parts = ['shoulder', 'knees'];
var lyrics = ['head', ...parts, 'and', 'toes'];
```

Similarly, the spread operator works with function calls:

```
function f(x, y, z) { }
var args = [0, 1, 2];
f(...args);
```

# Numbers and dates Number literals

## Number object

In JavaScript, all numbers are implemented in double-precision 64-bit binary format IEEE 754 (i.e. a number between -(253 -1) and 253 -1). There is no specific type for integers. In addition to being able to represent floating-point numbers, the number type has three symbolic values: +Infinity, -Infinity, and NaN (not-a-number). 

You can use four types of number literals: 'decimal, binary, octal, and hexadecimal'.

**Decimal numbers**

```
1234567890
42

// Caution when using leading zeros:

0888 // 888 parsed as decimal
0777 // parsed as octal in non-strict mode (511 in decimal)
```

**Note** that decimal literals can start with a zero (0) followed by another decimal digit, but if every digit after the leading 0 is smaller than 8, the number gets parsed as an octal number.

**Binary numbers**

Binary number syntax uses a leading zero followed by a lowercase or uppercase Latin letter "B" (0b or 0B). If the digits after the 0b are not 0 or 1, the following SyntaxError is thrown: "Missing binary digits after 0b".

```
var FLT_SIGNBIT  = 0b10000000000000000000000000000000; // 2147483648
var FLT_EXPONENT = 0b01111111100000000000000000000000; // 2139095040
var FLT_MANTISSA = 0B00000000011111111111111111111111; // 8388607
```

**Octal numbers**

Octal number syntax uses a leading zero. If the digits after the 0 are outside the range 0 through 7, the number will be interpreted as a decimal number.

```
var n = 0755; // 493
var m = 0644; // 420
```

Strict mode in ECMAScript 5 forbids octal syntax. Octal syntax isn't part of ECMAScript 5, but it's supported in all browsers by prefixing the octal number with a zero: 0644 === 420 and"\045" === "%". In ECMAScript 2015, octal numbers are supported if they are prefixed with 0o, e.g.: 

```
var a = 0o10; // ES2015: 8
```
**Hexadecimal numbers**

Hexadecimal number syntax uses a leading zero followed by a lowercase or uppercase Latin letter "X" (0x or 0X). If the digits after 0x are outside the range (0123456789ABCDEF),  the following SyntaxError is thrown: "Identifier starts immediately after numeric literal".

```
0xFFFFFFFFFFFFFFFFF // 295147905179352830000
0x123456789ABCDEF   // 81985529216486900
0XA                 // 10
```

Exponentiation
```
1E3   // 1000
2e6   // 2000000
0.1e2 // 10
```
**Number object**

The built-in Number object has properties for numerical constants, such as maximum value, not-a-number, and infinity. You cannot change the values of these properties and you use them as follows:

```
var biggestNum = Number.MAX_VALUE;
var smallestNum = Number.MIN_VALUE;
var infiniteNum = Number.POSITIVE_INFINITY;
var negInfiniteNum = Number.NEGATIVE_INFINITY;
var notANum = Number.NaN;
```

You always refer to a property of the predefined Number object as shown above, and not as a property of a Number object you create yourself.

The following table summarizes the Number object's properties.

**Properties of Number**
Property 				 | Description
------------------------ | -------------
Number.MAX_VALUE 		 | The largest representable number
Number.MIN_VALUE 		 | The smallest representable number
Number.NaN 				 | Special "not a number" value
Number.NEGATIVE_INFINITY | Special negative infinite value; returned on overflow
Number.POSITIVE_INFINITY | Special positive infinite value; returned on overflow
Number.EPSILON 			 | Difference between one and the smallest value greater than one that can be represented as a Number.
Number.MIN_SAFE_INTEGER  | Minimum safe integer in JavaScript.
Number.MAX_SAFE_INTEGER  | Maximum safe integer in JavaScript.

**Methods of Number**
Method 					 |Description
------------------------ |------------------------ 
Number.parseFloat() 	| Parses a string argument and returns a floating point number.
Same as the global parseFloat() function.
Number.parseInt() 		| Parses a string argument and returns an integer of the specified radix or base.
Same as the global parseInt() function.
Number.isFinite() 		| Determines whether the passed value is a finite number.
Number.isInteger() 		| Determines whether the passed value is an integer.
Number.isNaN() 			| Determines whether the passed value is NaN. More robust version of the original global isNaN().
Number.isSafeInteger() 	| Determines whether the provided value is a number that is a safe integer.

The Number prototype provides methods for retrieving information from Number objects in various formats. The following table summarizes the methods of Number.prototype.
Methods of Number.prototype
Method 					 |Description
------------------------ |------------------------ 
toExponential()		   	 |Returns a string representing the number in exponential notation.
toFixed() 				 |Returns a string representing the number in fixed-point notation.
toPrecision() 			 |Returns a string representing the number to a specified precision in fixed-point notation.

## Math object

The built-in Math object has properties and methods for mathematical constants and functions. For example, the Math object's PI property has the value of pi (3.141...), which you would use in an application as

```
Math.PI
```

Similarly, standard mathematical functions are methods of Math. These include trigonometric, logarithmic, exponential, and other functions. For example, if you want to use the trigonometric function sine, you would write

```
Math.sin(1.56)
```

Note that all trigonometric methods of Math take arguments in radians.

The following table summarizes the Math object's methods.
**Methods of Math **
Method 	                 | Description
------------------------ |------------------------ 
abs() 					 | Absolute value
sin(), cos(), tan() 	 | Standard trigonometric functions; with the argument in radians.
asin(), acos(), atan(), atan2() |	Inverse trigonometric functions; return values in radians.
sinh(), cosh(), tanh() 	 | Hyperbolic functions; argument in hyperbolic angle.
asinh(), acosh(), atanh()| Inverse hyperbolic functions; return values in hyperbolic angle.
pow(), exp(), expm1(), log10(), log1p(), log2()| Exponential and logarithmic functions.
floor(), ceil() 		 | Returns the largest/smallest integer less/greater than or equal to an argument.
min(), max() 			 | Returns the minimum or maximum (respectively) value of a comma separated list of numbers as arguments.
random() 				 | Returns a random number between 0 and 1.
round(), fround(), trunc()| 	Rounding and truncation functions.
sqrt(), cbrt(), hypot() |	Square root, cube root, Square root of the sum of square arguments.
sign() 					|The sign of a number, indicating whether the number is positive, negative or zero.
clz32(), imul() 	     | Number of leading zero bits in the 32-bit binary representation.

The result of the C-like 32-bit multiplication of the two arguments.

Unlike many other objects, you never create a Math object of your own. You always use the built-in Math object.

## Date object

JavaScript does not have a date data type. However, you can use the Date object and its methods to work with dates and times in your applications. The Date object has a large number of methods for setting, getting, and manipulating dates. It does not have any properties.

JavaScript handles dates similarly to Java. The two languages have many of the same date methods, and both languages store dates as Unix Timestamp which is the number of milliseconds since January 1, 1970, 00:00:00.

The Date object range is -100,000,000 days to 100,000,000 days relative to 01 January, 1970 UTC.

To create a Date object:

```
var dateObjectName = new Date([parameters]);
```

where dateObjectName is the name of the Date object being created; it can be a new object or a property of an existing object.

Calling Date without the new keyword returns a string representing the current date and time.

The parameters in the preceding syntax can be any of the following:

    * Nothing: creates today's date and time. For example, today = new Date();.
    * A string representing a date in the following form: "Month day, year hours:minutes:seconds." For example, var Xmas95 = new Date("December 25, 1995 13:30:00"). If you omit hours, minutes, or seconds, the value will be set to zero.
    * A set of integer values for year, month, and day. For example, var Xmas95 = new Date(1995, 11, 25).
    * A set of integer values for year, month, day, hour, minute, and seconds. For example, var Xmas95 = new Date(1995, 11, 25, 9, 30, 0);.

**Methods of the Date object**

The Date object methods for handling dates and times fall into these broad categories:

    * "set" methods, for setting date and time values in Date objects.
    * "get" methods, for getting date and time values from Date objects.
    * "to" methods, for returning string values from Date objects.
    * parse and UTC methods, for parsing Date strings.

With the "get" and "set" methods you can get and set seconds, minutes, hours, day of the month, day of the week, months, and years separately. There is a getDay method that returns the day of the week, but no corresponding setDay method, because the day of the week is set automatically. These methods use integers to represent these values as follows:

    * Seconds and minutes: 0 to 59
    * Hours: 0 to 23
    * Day: 0 (Sunday) to 6 (Saturday)
    * Date: 1 to 31 (day of the month)
    * Months: 0 (January) to 11 (December)
    * Year: years since 1900

For example, suppose you define the following date:

```
var Xmas95 = new Date('December 25, 1995');

Then Xmas95.getMonth() returns 11, and Xmas95.getFullYear() returns 1995.
```

The getTime and setTime methods are useful for comparing dates. The getTime method returns the number of milliseconds since January 1, 1970, 00:00:00 for a Date object.

For example, the following code displays the number of days left in the current year:

```
var today = new Date();
var endYear = new Date(1995, 11, 31, 23, 59, 59, 999); // Set day and month
endYear.setFullYear(today.getFullYear()); // Set year to this year
var msPerDay = 24 * 60 * 60 * 1000; // Number of milliseconds per day
var daysLeft = (endYear.getTime() - today.getTime()) / msPerDay;
var daysLeft = Math.round(daysLeft); //returns days left in the year
```

This example creates a Date object named today that contains today's date. It then creates a Date object named endYear and sets the year to the current year. Then, using the number of milliseconds per day, it computes the number of days between today and endYear, using getTime and rounding to a whole number of days.

The parse method is useful for assigning values from date strings to existing Date objects. For example, the following code uses parse and setTime to assign a date value to the IPOdate object:

```
var IPOdate = new Date();
IPOdate.setTime(Date.parse('Aug 9, 1995'));
```
Example

In the following example, the function JSClock() returns the time in the format of a digital clock.

```
function JSClock() {
  var time = new Date();
  var hour = time.getHours();
  var minute = time.getMinutes();
  var second = time.getSeconds();
  var temp = '' + ((hour > 12) ? hour - 12 : hour);
  if (hour == 0)
    temp = '12';
  temp += ((minute < 10) ? ':0' : ':') + minute;
  temp += ((second < 10) ? ':0' : ':') + second;
  temp += (hour >= 12) ? ' P.M.' : ' A.M.';
  return temp;
}
```

The JSClock function first creates a new Date object called time; since no arguments are given, time is created with the current date and time. Then calls to the getHours, getMinutes, and getSeconds methods assign the value of the current hour, minute, and second to hour, minute, and second.

The next four statements build a string value based on the time. The first statement creates a variable temp, assigning it a value using a conditional expression; if hour is greater than 12, (hour - 12), otherwise simply hour, unless hour is 0, in which case it becomes 12.

The next statement appends a minute value to temp. If the value of minute is less than 10, the conditional expression adds a string with a preceding zero; otherwise it adds a string with a demarcating colon. Then a statement appends a seconds value to temp in the same way.

Finally, a conditional expression appends "P.M." to temp if hour is 12 or greater; otherwise, it appends "A.M." to temp.

# Text formatting

JavaScript's String type is used to represent textual data. It is a set of "elements" of 16-bit unsigned integer values  (UTF-16 code units). Each element in the String occupies a position in the String. The first element is at index 0, the next at index 1, and so on. The length of a String is the number of elements in it. You can create strings using string literals or string objects.


## String literals

You can create simple strings using either single or double quotes:

```
'foo'
"bar"
```

More advanced strings can be created using escape sequences:

**Hexadecimal escape sequences**

The number after \x is interpreted as a hexadecimal number.

```
'\xA9' // "©"
```

**Unicode escape sequences**

The Unicode escape sequences require at least four hexadecimal digits following \u.

```
'\u00A9' // "©"
```

**Unicode code point escapes**

New in ECMAScript 2015. With Unicode code point escapes, any character can be escaped using hexadecimal numbers so that it is possible to use Unicode code points up to 0x10FFFF. With simple Unicode escapes it is often necessary to write the surrogate halves separately to achieve the same.

See also String.fromCodePoint() or String.prototype.codePointAt().

```
'\u{2F804}'

// the same with simple Unicode escapes
'\uD87E\uDC04'
```

**String objects**

The String object is a wrapper around the string primitive data type.

```
var s = new String('foo'); // Creates a String object
console.log(s); // Displays: {'0': 'f', '1': 'o', '2': 'o'}
typeof s; // Returns 'object'
```

You can call any of the methods of the String object on a string literal value—JavaScript automatically converts the string literal to a temporary String object, calls the method, then discards the temporary String object. You can also use the String.length property with a string literal.

You should use string literals unless you specifically need to use a String object, because String objects can have counterintuitive behavior. For example:

```
var s1 = '2 + 2'; // Creates a string literal value
var s2 = new String('2 + 2'); // Creates a String object
eval(s1); // Returns the number 4
eval(s2); // Returns the string "2 + 2"
```

A String object has one property, length, that indicates the number of UTF-16 code units in the string. For example, the following code assigns x the value 13, because "Hello, World!" has 13 characters, each represented by one UTF-16 code unit. You can access each code unit using an array bracket style. You can't change individual characters because strings are immutable array-like objects:

```
var mystring = 'Hello, World!';
var x = mystring.length;
mystring[0] = 'L'; // This has no effect, because strings are immutable
mystring[0]; // This returns "H"
```

Characters whose Unicode scalar values are greater than U+FFFF (such as some rare Chinese/Japanese/Korean/Vietnamese characters and some emoji) are stored in UTF-16 with two surrogate code units each. For example, a string containing the single character U+1F600 "Emoji grinning face" will have length 2. Accessing the individual code units in such a string using brackets may have undesirable consequences such as the formation of strings with unmatched surrogate code units, in violation of the Unicode standard. (Examples should be added to this page after MDN bug 857438 is fixed.) See also String.fromCodePoint() or String.prototype.codePointAt().

A String object has a variety of methods: for example those that return a variation on the string itself, such as substring and toUpperCase.

The following table summarizes the methods of String objects.
Methods of String
Method 							|Description
--------------------------------|---------------------------------------------------------------
charAt, charCodeAt, codePointAt | Return the character or character code at the specified position in string.
indexOf, lastIndexOf 			| Return the position of specified substring in the string or last position of specified substring, respectively.
startsWith, endsWith, includes 	| Returns whether or not the string starts, ends or contains a specified string.
concat 							| Combines the text of two strings and returns a new string.
fromCharCode, fromCodePoint 	| Constructs a string from the specified sequence of Unicode values. This is a method of the String class, not a String instance.
split 							| Splits a String object into an array of strings by separating the string into substrings.
slice 							| Extracts a section of a string and returns a new string.
substring, substr 				| Return the specified subset of the string, either by specifying the start and end indexes or the start index and a length.
match, replace, search 			| Work with regular expressions.
toLowerCase, toUpperCase  		| Return the string in all lowercase or all uppercase, respectively.
normalize 						| Returns the Unicode Normalization Form of the calling string value.
repeat 							| Returns a string consisting of the elements of the object repeated the given times.
trim 							|Trims whitespace from the beginning and end of the string.

## Template literals

Template literals are string literals allowing embedded expressions. You can use multi-line strings and string interpolation features with them.

Template literals are enclosed by the back-tick (` `) (grave accent) character instead of double or single quotes. Template literals can contain place holders. These are indicated by the Dollar sign and curly braces (${expression}).
Multi-lines

Any new line characters inserted in the source are part of the template literal. Using normal strings, you would have to use the following syntax in order to get multi-line strings:

```
console.log('string text line 1\n\
string text line 2');
// "string text line 1
// string text line 2"
```

To get the same effect with multi-line strings, you can now write:

```
console.log(`string text line 1
string text line 2`);
// "string text line 1
// string text line 2"
```

*Embedded expressions*

In order to embed expressions within normal strings, you would use the following syntax:

```
var a = 5;
var b = 10;
console.log('Fifteen is ' + (a + b) + ' and\nnot ' + (2 * a + b) + '.');
// "Fifteen is 15 and
// not 20."
```

Now, with template literals, you are able to make use of the syntactic sugar making substitutions like this more readable:

```
var a = 5;
var b = 10;
console.log(`Fifteen is ${a + b} and\nnot ${2 * a + b}.`);
// "Fifteen is 15 and
// not 20."
```

## Internationalization

The Intl object is the namespace for the ECMAScript Internationalization API, which provides language sensitive string comparison, number formatting, and date and time formatting. The constructors for Collator, NumberFormat, and DateTimeFormat objects are properties of the Intl object.
Date and time formatting

The DateTimeFormat object is useful for formatting date and time. The following formats a date for English as used in the United States. (The result is different in another time zone.)

```
var msPerDay = 24 * 60 * 60 * 1000;
 
// July 17, 2014 00:00:00 UTC.
var july172014 = new Date(msPerDay * (44 * 365 + 11 + 197));

var options = { year: '2-digit', month: '2-digit', day: '2-digit',
                hour: '2-digit', minute: '2-digit', timeZoneName: 'short' };
var americanDateTime = new Intl.DateTimeFormat('en-US', options).format;
 
console.log(americanDateTime(july172014)); // 07/16/14, 5:00 PM PDT
```

**Number formatting**

The NumberFormat object is useful for formatting numbers, for example currencies.

```
var gasPrice = new Intl.NumberFormat('en-US',
                        { style: 'currency', currency: 'USD',
                          minimumFractionDigits: 3 });
 
console.log(gasPrice.format(5.259)); // $5.259

var hanDecimalRMBInChina = new Intl.NumberFormat('zh-CN-u-nu-hanidec',
                        { style: 'currency', currency: 'CNY' });
 
console.log(hanDecimalRMBInChina.format(1314.25)); // ￥ 一,三一四.二五
```

**Collation**

The Collator object is useful for comparing and sorting strings.

For example, there are actually two different sort orders in German, phonebook and dictionary. Phonebook sort emphasizes sound, and it’s as if “ä”, “ö”, and so on were expanded to “ae”, “oe”, and so on prior to sorting.

```
var names = ['Hochberg', 'Hönigswald', 'Holzman'];
 
var germanPhonebook = new Intl.Collator('de-DE-u-co-phonebk');
 
// as if sorting ["Hochberg", "Hoenigswald", "Holzman"]:
console.log(names.sort(germanPhonebook.compare).join(', '));
// logs "Hochberg, Hönigswald, Holzman"
```

Some German words conjugate with extra umlauts, so in dictionaries it’s sensible to order ignoring umlauts (except when ordering words differing only by umlauts: schon before schön).

```
var germanDictionary = new Intl.Collator('de-DE-u-co-dict');
 
// as if sorting ["Hochberg", "Honigswald", "Holzman"]:
console.log(names.sort(germanDictionary.compare).join(', '));
// logs "Hochberg, Holzman, Hönigswald"
```

## Regular Expressions

Regular expressions are patterns used to match character combinations in strings. In JavaScript, regular expressions are also objects. These patterns are used with the exec and test methods of RegExp, and with the match, replace, search, and split methods of String. 

**Creating a regular expression**

You construct a regular expression in one of two ways:

Using a regular expression literal, which consists of a pattern enclosed between slashes, as follows:

```
var re = /ab+c/;
```

Regular expression literals provide compilation of the regular expression when the script is loaded. If the regular expression remains constant, using this can improve performance.

Or calling the constructor function of the RegExp object, as follows:

```
var re = new RegExp('ab+c');
```
Using the constructor function provides runtime compilation of the regular expression. Use the constructor function when you know the regular expression pattern will be changing, or you don't know the pattern and are getting it from another source, such as user input.

**Writing a regular expression pattern**

A regular expression pattern is composed of simple characters, such as /abc/, or a combination of simple and special characters, such as /ab*c/ or /Chapter (\d+)\.\d*/. The last example includes parentheses which are used as a memory device. 

**Using simple patterns**

Simple patterns are constructed of characters for which you want to find a direct match. For example, the pattern /abc/ matches character combinations in strings only when exactly the characters 'abc' occur together and in that order. Such a match would succeed in the strings "Hi, do you know your abc's?" and "The latest airplane designs evolved from slabcraft." In both cases the match is with the substring 'abc'. There is no match in the string 'Grab crab' because while it contains the substring 'ab c', it does not contain the exact substring 'abc'.

**Using special characters**

When the search for a match requires something more than a direct match, such as finding one or more b's, or finding white space, the pattern includes special characters. For example, the pattern /ab*c/ matches any character combination in which a single 'a' is followed by zero or more 'b's (* means 0 or more occurrences of the preceding item) and then immediately followed by 'c'. In the string "cbbabbbbcdebc," the pattern matches the substring 'abbbbc'.

The following table provides a complete list and description of the special characters that can be used in regular expressions.

**Special characters in regular expressions.**

Character |	Meaning
----------|-----------------------------------------------------------
\ | Matches according to the following rules:

A backslash that precedes a non-special character indicates that the next character is special and is not to be interpreted literally. For example, a 'b' without a preceding '\' generally matches lowercase 'b's wherever they occur. But a '\b' by itself doesn't match any character; it forms the special word boundary character.

A backslash that precedes a special character indicates that the next character is not special and should be interpreted literally. For example, the pattern /a*/ relies on the special character '*' to match 0 or more a's. By contrast, the pattern /a\*/ removes the specialness of the '*' to enable matches with strings like 'a*'.

Do not forget to escape \ itself while using the RegExp("pattern") notation because \ is also an escape character in strings.

^ |	Matches beginning of input. If the multiline flag is set to true, also matches immediately after a line break character.

For example, /^A/ does not match the 'A' in "an A", but does match the 'A' in "An E".

The '^' has a different meaning when it appears as the first character in a character set pattern. See complemented character sets for details and an example.

$ | Matches end of input. If the multiline flag is set to true, also matches immediately before a line break character.

For example, /t$/ does not match the 't' in "eater", but does match it in "eat".

* | Matches the preceding expression 0 or more times. Equivalent to {0,}.

For example, /bo*/ matches 'boooo' in "A ghost booooed" and 'b' in "A bird warbled" but nothing in "A goat grunted".

+ | Matches the preceding expression 1 or more times. Equivalent to {1,}.

For example, /a+/ matches the 'a' in "candy" and all the a's in "caaaaaaandy", but nothing in "cndy".

? | Matches the preceding expression 0 or 1 time. Equivalent to {0,1}.

For example, /e?le?/ matches the 'el' in "angel" and the 'le' in "angle" and also the 'l' in "oslo".

If used immediately after any of the quantifiers *, +, ?, or {}, makes the quantifier non-greedy (matching the fewest possible characters), as opposed to the default, which is greedy (matching as many characters as possible). For example, applying /\d+/ to "123abc" matches "123". But applying /\d+?/ to that same string matches only the "1".

Also used in lookahead assertions, as described in the x(?=y) and x(?!y) entries of this table.
 
. | (The decimal point) matches any single character except the newline character.

For example, /.n/ matches 'an' and 'on' in "nay, an apple is on the tree", but not 'nay'.
(x) | Matches 'x' and remembers the match, as the following example shows. The parentheses are called capturing parentheses.

The '(foo)' and '(bar)' in the pattern /(foo) (bar) \1 \2/ match and remember the first two words in the string "foo bar foo bar". The \1 and \2 in the pattern match the string's last two words. Note that \1, \2, ..., \n are used in the matching part of the regex. In the replacement part of a regex the syntax $1, $2, ..., $n must be used, e.g.: 'bar foo'.replace(/(...) (...)/, '$2 $1').  $& means the whole matched string.

(?:x) |	Matches 'x' but does not remember the match. The parentheses are called non-capturing parentheses, and let you define subexpressions for regular expression operators to work with. Consider the sample expression /(?:foo){1,2}/. If the expression was /foo{1,2}/, the {1,2} characters would apply only to the last 'o' in 'foo'. With the non-capturing parentheses, the {1,2} applies to the entire word 'foo'. For more information, see Using parentheses below.

x(?=y) | Matches 'x' only if 'x' is followed by 'y'. This is called a lookahead.
For example, /Jack(?=Sprat)/ matches 'Jack' only if it is followed by 'Sprat'. /Jack(?=Sprat|Frost)/ matches 'Jack' only if it is followed by 'Sprat' or 'Frost'. However, neither 'Sprat' nor 'Frost' is part of the match results.

x(?!y) | Matches 'x' only if 'x' is not followed by 'y'. This is called a negated lookahead.
For example, /\d+(?!\.)/ matches a number only if it is not followed by a decimal point. The regular expression /\d+(?!\.)/.exec("3.141") matches '141' but not '3.141'.

x|y | Matches 'x', or 'y' (if there is no match for 'x').
For example, /green|red/ matches 'green' in "green apple" and 'red' in "red apple." The order of 'x' and 'y' matters. For example a*|b matches the empty string in "b", but b|a* matches "b" in the same string.

{n} | Matches exactly n occurrences of the preceding expression. N must be a positive integer.
For example, /a{2}/ doesn't match the 'a' in "candy," but it does match all of the a's in "caandy," and the first two a's in "caaandy."

{n,} | Matches at least n occurrences of the preceding expression. N must be a positive integer.
For example, /a{2,}/ will match "aa", "aaaa" and "aaaaa" but not "a"

{n,m} | Where n and m are positive integers and n <= m. Matches at least n and at most m occurrences of the preceding expression. When m is omitted, it's treated as ∞.
For example, /a{1,3}/ matches nothing in "cndy", the 'a' in "candy," the first two a's in "caandy," and the first three a's in "caaaaaaandy". Notice that when matching "caaaaaaandy", the match is "aaa", even though the original string had more a's in it.

[xyz] |	Character set. This pattern type matches any one of the characters in the brackets, including escape sequences. Special characters like the dot(.) and asterisk (*) are not special inside a character set, so they don't need to be escaped. You can specify a range of characters by using a hyphen, as the following examples illustrate.

The pattern [a-d], which performs the same match as [abcd], matches the 'b' in "brisket" and the 'c' in "city". The patterns /[a-z.]+/ and /[\w.]+/ match the entire string "test.i.ng".
[^xyz] 	

A negated or complemented character set. That is, it matches anything that is not enclosed in the brackets. You can specify a range of characters by using a hyphen. Everything that works in the normal character set also works here.

For example, [^abc] is the same as [^a-c]. They initially match 'r' in "brisket" and 'h' in "chop."

[\b] \Matches a backspace (U+0008). You need to use square brackets if you want to match a literal backspace character. (Not to be confused with \b.)

\b 	| Matches a word boundary. A word boundary matches the position where a word character is not followed or preceded by another word-character. Note that a matched word boundary is not included in the match. In other words, the length of a matched word boundary is zero. (Not to be confused with [\b].)

Examples:
/\bm/ matches the 'm' in "moon" ;
/oo\b/ does not match the 'oo' in "moon", because 'oo' is followed by 'n' which is a word character;
/oon\b/ matches the 'oon' in "moon", because 'oon' is the end of the string, thus not followed by a word character;
/\w\b\w/ will never match anything, because a word character can never be followed by both a non-word and a word character.

Note: JavaScript's regular expression engine defines a specific set of characters to be "word" characters. Any character not in that set is considered a word break. This set of characters is fairly limited: it consists solely of the Roman alphabet in both upper- and lower-case, decimal digits, and the underscore character. Accented characters, such as "é" or "ü" are, unfortunately, treated as word breaks.

\B | Matches a non-word boundary. This matches a position where the previous and next character are of the same type: Either both must be words, or both must be non-words. The beginning and end of a string are considered non-words.

For example, /\B../ matches 'oo' in "noonday", and /y\B./ matches 'ye' in "possibly yesterday."
\cX 	

Where X is a character ranging from A to Z. Matches a control character in a string.

For example, /\cM/ matches control-M (U+000D) in a string.
\d | Matches a digit character. Equivalent to [0-9].
For example, /\d/ or /[0-9]/ matches '2' in "B2 is the suite number."

\D | Matches a non-digit character. Equivalent to [^0-9].

For example, /\D/ or /[^0-9]/ matches 'B' in "B2 is the suite number."
\f 	Matches a form feed (U+000C).
\n 	Matches a line feed (U+000A).
\r 	Matches a carriage return (U+000D).
\s 	

Matches a single white space character, including space, tab, form feed, line feed. Equivalent to [ \f\n\r\t\v\u00a0\u1680\u180e\u2000-\u200a\u2028\u2029\u202f\u205f\u3000\ufeff].

For example, /\s\w*/ matches ' bar' in "foo bar."

\S | Matches a single character other than white space. Equivalent to [^ \f\n\r\t\v\u00a0\u1680\u180e\u2000-\u200a\u2028\u2029\u202f\u205f\u3000\ufeff].

For example, /\S*/ matches 'foo' in "foo bar."
\t | Matches a tab (U+0009).
\v | Matches a vertical tab (U+000B).
\w | Matches any alphanumeric character including the underscore. Equivalent to [A-Za-z0-9_].

For example, /\w/ matches 'a' in "apple," '5' in "$5.28," and '3' in "3D."

\W | Matches any non-word character. Equivalent to [^A-Za-z0-9_].

For example, /\W/ or /[^A-Za-z0-9_]/ matches '%' in "50%."

\n | Where n is a positive integer, a back reference to the last substring matching the n parenthetical in the regular expression (counting left parentheses).

For example, /apple(,)\sorange\1/ matches 'apple, orange,' in "apple, orange, cherry, peach."

\0 |	Matches a NULL (U+0000) character. Do not follow this with another digit, because \0<digits> is an octal escape sequence. Instead use \x00.

\xhh |	Matches the character with the code hh (two hexadecimal digits)

\uhhhh |	Matches the character with the code hhhh (four hexadecimal digits).

\u{hhhh} |	(only when u flag is set) Matches the character with the Unicode value hhhh (hexadecimal digits).

**Working with regular expressions**

Regular expressions are used with the RegExp methods test and exec and with the String methods match, replace, search, and split. 

 Methods that use regular expressions 
Method |	Description
--------|-----------------------------------------------
exec   |	A RegExp method that executes a search for a match in a string. It returns an array of information or null on a mismatch.

test   |	A RegExp method that tests for a match in a string. It returns true or false.

match  |	A String method that executes a search for a match in a string. It returns an array of information or null on a mismatch.

search | 	A String method that tests for a match in a string. It returns the index of the match, or -1 if the search fails.

replace| 	A String method that executes a search for a match in a string, and replaces the matched substring with a replacement substring.

split |	A String method that uses a regular expression or a fixed string to break a string into an array of substrings.

When you want to know whether a pattern is found in a string, use the test or search method; for more information (but slower execution) use the exec or match methods. If you use exec or match and if the match succeeds, these methods return an array and update properties of the associated regular expression object and also of the predefined regular expression object, RegExp. If the match fails, the exec method returns null (which coerces to false).

In the following example, the script uses the exec method to find a match in a string.

```
var myRe = /d(b+)d/g;
var myArray = myRe.exec('cdbbdbsbz');
```
If you do not need to access the properties of the regular expression, an alternative way of creating myArray is with this script:

```
var myArray = /d(b+)d/g.exec('cdbbdbsbz'); // similar to "cdbbdbsbz".match(/d(b+)d/g); however,
    // the latter outputs Array [ "dbbd" ], while 
    // /d(b+)d/g.exec('cdbbdbsbz') outputs Array [ "dbbd", "bb" ].
    // See below for further info (CTRL+F "The behavior associated with the".)
```

If you want to construct the regular expression from a string, yet another alternative is this script:

```
var myRe = new RegExp('d(b+)d', 'g');
var myArray = myRe.exec('cdbbdbsbz');
```

With these scripts, the match succeeds and returns the array and updates the properties shown in the following table.
Results of regular expression execution. 
Object 	| Property or index |	Description 						|	In this example
--------|-------------------|---------------------------------------|--------------------
myArray |                   |The matched string and all remembered substrings. 	['dbbd', 'bb', index: 1, input: 'cdbbdbsbz']
        | index 			| The 0-based index of the match in the input string. | 	1
		| input 			| The original string. 					|"cdbbdbsbz"
		| [0] 				| The last matched characters. 			|"dbbd"
myRe 	| lastIndex 		| The index at which to start the next match. (This property is set only if the regular expression uses the g option, described in Advanced Searching With Flags.) |	5
		|source 			|The text of the pattern. Updated at the time that the regular expression is created, not executed. 	|"d(b+)d"

		
**Using parenthesized substring matches**

Including parentheses in a regular expression pattern causes the corresponding submatch to be remembered. For example, /a(b)c/ matches the characters 'abc' and remembers 'b'. To recall these parenthesized substring matches, use the Array elements [1], ..., [n].

The number of possible parenthesized substrings is unlimited. The returned array holds all that were found. The following examples illustrate how to use parenthesized substring matches.

The following script uses the replace() method to switch the words in the string. For the replacement text, the script uses the $1 and $2 in the replacement to denote the first and second parenthesized substring matches.

```
var re = /(\w+)\s(\w+)/;
var str = 'John Smith';
var newstr = str.replace(re, '$2, $1');
console.log(newstr);

// "Smith, John"
```

**Advanced searching with flags**

Regular expressions have five optional flags that allow for global and case insensitive searching. These flags can be used separately or together in any order, and are included as part of the regular expression.
Regular expression flags 
Flag |	Description
-----|----------------
g 	 |Global search.
i 	 |Case-insensitive search.
m 	 |Multi-line search.
u 	 |unicode; treat a pattern as a sequence of unicode code points
y 	 |Perform a "sticky" search that matches starting at the current position in the target string. See sticky

To include a flag with the regular expression, use this syntax:
```
var re = /pattern/flags;

or

var re = new RegExp('pattern', 'flags');
```
Note that the flags are an integral part of a regular expression. They cannot be added or removed later.

For example, re = /\w+\s/g creates a regular expression that looks for one or more characters followed by a space, and it looks for this combination throughout the string.

```
var re = /\w+\s/g;
var str = 'fee fi fo fum';
var myArray = str.match(re);
console.log(myArray);

// ["fee ", "fi ", "fo "]

You could replace the line:

var re = /\w+\s/g;

with:

var re = new RegExp('\\w+\\s', 'g');
```

and get the same result.

The behavior associated with the 'g' flag is different when the .exec() method is used.  (The roles of "class" and "argument" get reversed: In the case of .match(), the string class (or data type) owns the method and the regular expression is just an argument, while in the case of .exec(), it is the regular expression that owns the method, with the string being the argument.  Contrast str.match(re) versus re.exec(str).)  The 'g' flag is used with the .exec() method to get iterative progression.
```
var xArray; while(xArray = re.exec(str)) console.log(xArray);
// produces: 
// ["fee ", index: 0, input: "fee fi fo fum"]
// ["fi ", index: 4, input: "fee fi fo fum"]
// ["fo ", index: 7, input: "fee fi fo fum"]
```

The m flag is used to specify that a multiline input string should be treated as multiple lines. If the m flag is used, ^ and $ match at the start or end of any line within the input string instead of the start or end of the entire string.

**Examples**

The following examples show some uses of regular expressions.
Changing the order in an input string

The following example illustrates the formation of regular expressions and the use of string.split() and string.replace(). It cleans a roughly formatted input string containing names (first name last) separated by blanks, tabs and exactly one semicolon. Finally, it reverses the name order (last name first) and sorts the list.

```
// The name string contains multiple spaces and tabs,
// and may have multiple spaces between first and last names.
var names = 'Orange Trump ;Fred Barney; Helen Rigby ; Bill Abel ; Chris Hand ';

var output = ['---------- Original String\n', names + '\n'];

// Prepare two regular expression patterns and array storage.
// Split the string into array elements.

// pattern: possible white space then semicolon then possible white space
var pattern = /\s*;\s*/;

// Break the string into pieces separated by the pattern above and
// store the pieces in an array called nameList
var nameList = names.split(pattern);

// new pattern: one or more characters then spaces then characters.
// Use parentheses to "memorize" portions of the pattern.
// The memorized portions are referred to later.
pattern = /(\w+)\s+(\w+)/;

// Below is the new array for holding names being processed.
var bySurnameList = [];

// Display the name array and populate the new array
// with comma-separated names, last first.
//
// The replace method removes anything matching the pattern
// and replaces it with the memorized string—the second memorized portion
// followed by a comma, a space and the first memorized portion.
//
// The variables $1 and $2 refer to the portions
// memorized while matching the pattern.

output.push('---------- After Split by Regular Expression');

var i, len;
for (i = 0, len = nameList.length; i < len; i++) {
  output.push(nameList[i]);
  bySurnameList[i] = nameList[i].replace(pattern, '$2, $1');
}

// Display the new array.
output.push('---------- Names Reversed');
for (i = 0, len = bySurnameList.length; i < len; i++) {
  output.push(bySurnameList[i]);
}

// Sort by last name, then display the sorted array.
bySurnameList.sort();
output.push('---------- Sorted');
for (i = 0, len = bySurnameList.length; i < len; i++) {
  output.push(bySurnameList[i]);
}

output.push('---------- End');

console.log(output.join('\n'));
```

**Using special characters to verify input**

In the following example, the user is expected to enter a phone number. When the user presses the "Check" button, the script checks the validity of the number. If the number is valid (matches the character sequence specified by the regular expression), the script shows a message thanking the user and confirming the number. If the number is invalid, the script informs the user that the phone number is not valid.

Within non-capturing parentheses (?: , the regular expression looks for three numeric characters \d{3} OR | a left parenthesis \( followed by three digits \d{3}, followed by a close parenthesis \), (end non-capturing parenthesis )), followed by one dash, forward slash, or decimal point and when found, remember the character ([-\/\.]), followed by three digits \d{3}, followed by the remembered match of a dash, forward slash, or decimal point \1, followed by four digits \d{4}.

The Change event activated when the user presses Enter sets the value of RegExp.input.

```
<!DOCTYPE html>
<html>  
  <head>  
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
    <meta http-equiv="Content-Script-Type" content="text/javascript">  
    <script type="text/javascript">  
      var re = /(?:\d{3}|\(\d{3}\))([-\/\.])\d{3}\1\d{4}/;  
      function testInfo(phoneInput) {  
        var OK = re.exec(phoneInput.value);  
        if (!OK)  
          window.alert(phoneInput.value + ' isn\'t a phone number with area code!');  
        else
          window.alert('Thanks, your phone number is ' + OK[0]);  
      }  
    </script>  
  </head>  
  <body>  
    <p>Enter your phone number (with area code) and then click "Check".
        <br>The expected format is like ###-###-####.</p>
    <form action="#">  
      <input id="phone"><button onclick="testInfo(document.getElementById('phone'));">Check</button>
    </form>  
  </body>  
</html>
```

# Indexed collections

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


# Keyed collections

## Map
ECMAScript 2015 introduces a new data structure to map values to values. A Map object is a simple key/value map and can iterate its elements in insertion order.

```
var sayings = new Map();
sayings.set('dog', 'woof');
sayings.set('cat', 'meow');
sayings.set('elephant', 'toot');
sayings.size; // 3
sayings.get('fox'); // undefined
sayings.has('bird'); // false
sayings.delete('dog');
sayings.has('dog'); // false

for (var [key, value] of sayings) {
  console.log(key + ' goes ' + value);
}
// "cat goes meow"
// "elephant goes toot"

sayings.clear();
sayings.size; // 0
```

**Object and Map compared**

Traditionally, objects have been used to map strings to values. Objects allow you to set keys to values, retrieve those values, delete keys, and detect whether something is stored at a key. Map objects, however, have a few more advantages that make them better maps.

    * The keys of an Object are Strings, where they can be of any value for a Map.
    * You can get the size of a Map easily while you have to manually keep track of size for an Object.
    * The iteration of maps is in insertion order of the elements.
    * An Object has a prototype, so there are default keys in the map. (this can be bypassed using map = Object.create(null)).

These three tips can help you to decide whether to use a Map or an Object:

    * Use maps over objects when keys are unknown until run time, and when all keys are the same type and all values are the same type.
    * Use maps in case if there is a need to store primitive values as keys because object treats each key as a string whether it's a number value, boolean value or any other primitive value.
    * Use objects when there is logic that operates on individual elements.


## WeakMap

The WeakMap object is a collection of key/value pairs in which the keys are objects only and the values can be arbitrary values. The object references in the keys are held weakly, meaning that they are a target of garbage collection (GC) if there is no other reference to the object anymore. The WeakMap API is the same as the Map API.

One difference to Map objects is that WeakMap keys are not enumerable (i.e., there is no method giving you a list of the keys). If they were, the list would depend on the state of garbage collection, introducing non-determinism.

For more information and example code, see also "Why WeakMap?" on the WeakMap reference page.

One use case of WeakMap objects is to store private data for an object or to hide implementation details. The private data and methods belong inside the object and are stored in the privates WeakMap object. Everything exposed on the instance and prototype is public; everything else is inaccessible from the outside world because privates is not exported from the module

```
const privates = new WeakMap();

function Public() {
  const me = {
    // Private data goes here
  };
  privates.set(this, me);
}

Public.prototype.method = function() {
  const me = privates.get(this);
  // Do stuff with private data in `me`...
};

module.exports = Public;
```

## Set

Set objects are collections of values. You can iterate its elements in insertion order. A value in a Set may only occur once; it is unique in the Set's collection.

The following code shows some basic operations with a Set. See also the Set reference page for more examples and the complete API.
```
var mySet = new Set();
mySet.add(1);
mySet.add('some text');
mySet.add('foo');

mySet.has(1); // true
mySet.delete('foo');
mySet.size; // 2

for (let item of mySet) console.log(item);
// 1
// "some text"
```
## WeakSet

WeakSet objects are collections of objects. An object in the WeakSet may only occur once; it is unique in the WeakSet's collection and objects are not enumerable.

The main differences to the Set object are:

    * In contrast to Sets, WeakSets are collections of objects only and not of arbitrary values of any type.
    * The WeakSet is weak: References to objects in the collection are held weakly. If there is no other reference to an object stored in the WeakSet, they can be garbage collected. That also means that there is no list of current objects stored in the collection. WeakSets are not enumerable.

The use cases of WeakSet objects are limited. They will not leak memory so it can be safe to use DOM elements as a key and mark them for tracking purposes, for example.

**Converting between Array and Set**

You can create an Array from a Set using Array.from or the spread operator. Also, the Set constructor accepts an Array to convert in the other direction. Note again that Set objects store unique values, so any duplicate elements from an Array are deleted when converting.

```
Array.from(mySet);
[...mySet2];

mySet2 = new Set([1, 2, 3, 4]);
```

**Array and Set compared**

Traditionally, a set of elements has been stored in arrays in JavaScript in a lot of situations. The new Set object, however, has some advantages:

    * Checking whether an element exists in a collection using indexOf for arrays is slow.
    * Set objects let you delete elements by their value. With an array you would have to splice based on an element's index.
    * The value NaN cannot be found with indexOf in an array.
    * Set objects store unique values; you don't have to keep track of duplicates by yourself.

**Key and value equality of Map and Set**

Both the key equality of Map objects and the value equality of Set objects, are based on the "same-value-zero algorithm":

    * Equality works like the identity comparison operator ===.
    * -0 and +0 are considered equal.
    * NaN is considered equal to itself (contrary to ===).

	
# Working with objects

Objects in JavaScript, just as in many other programming languages, can be compared to objects in real life. The concept of objects in JavaScript can be understood with real life, tangible objects.

In JavaScript, an object is a standalone entity, with properties and type. Compare it with a cup, for example. A cup is an object, with properties. A cup has a color, a design, weight, a material it is made of, etc. The same way, JavaScript objects can have properties, which define their characteristics.

## Objects and properties

A JavaScript object has properties associated with it. A property of an object can be explained as a variable that is attached to the object. Object properties are basically the same as ordinary JavaScript variables, except for the attachment to objects. The properties of an object define the characteristics of the object. You access the properties of an object with a simple dot-notation:

```
objectName.propertyName
```

Like all JavaScript variables, both the object name (which could be a normal variable) and property name are case sensitive. You can define a property by assigning it a value. For example, let's create an object named myCar and give it properties named make, model, and year as follows:

```
var myCar = new Object();
myCar.make = 'Ford';
myCar.model = 'Mustang';
myCar.year = 1969;
```

Unassigned properties of an object are undefined (and not null).
```
myCar.color; // undefined
```

Properties of JavaScript objects can also be accessed or set using a bracket notation (for more details see property accessors). Objects are sometimes called associative arrays, since each property is associated with a string value that can be used to access it. So, for example, you could access the properties of the myCar object as follows:

```
myCar['make'] = 'Ford';
myCar['model'] = 'Mustang';
myCar['year'] = 1969;
```

An object property name can be any valid JavaScript string, or anything that can be converted to a string, including the empty string. However, any property name that is not a valid JavaScript identifier (for example, a property name that has a space or a hyphen, or that starts with a number) can only be accessed using the square bracket notation. This notation is also very useful when property names are to be dynamically determined (when the property name is not determined until runtime). Examples are as follows:

```
// four variables are created and assigned in a single go, 
// separated by commas
var myObj = new Object(),
    str = 'myString',
    rand = Math.random(),
    obj = new Object();

myObj.type              = 'Dot syntax';
myObj['date created']   = 'String with space';
myObj[str]              = 'String value';
myObj[rand]             = 'Random Number';
myObj[obj]              = 'Object';
myObj['']               = 'Even an empty string';

console.log(myObj);
```

Please note that all keys in the square bracket notation are converted to String type, since objects in JavaScript can only have String type as key type. For example, in the above code, when the key obj is added to the myObj, JavaScript will call the obj.toString() method, and use this result string as the new key.

You can also access properties by using a string value that is stored in a variable:

```
var propertyName = 'make';
myCar[propertyName] = 'Ford';

propertyName = 'model';
myCar[propertyName] = 'Mustang';
```

You can use the bracket notation with for...in to iterate over all the enumerable properties of an object. To illustrate how this works, the following function displays the properties of the object when you pass the object and the object's name as arguments to the function:

```
function showProps(obj, objName) {
  var result = '';
  for (var i in obj) {
    // obj.hasOwnProperty() is used to filter out properties from the object's prototype chain
    if (obj.hasOwnProperty(i)) {
      result += objName + '.' + i + ' = ' + obj[i] + '\n';
    }
  }
  return result;
}
```
So, the function call showProps(myCar, "myCar") would return the following:

```
myCar.make = Ford
myCar.model = Mustang
myCar.year = 1969
```

**Enumerate the properties of an object**

Starting with ECMAScript 5, there are three native ways to list/traverse object properties:

    'for...in loops' - This method traverses all enumerable properties of an object and its prototype chain
    'Object.keys(o)' - This method returns an array with all the own (not in the prototype chain) enumerable properties' names ("keys") of an object o.
    'Object.getOwnPropertyNames(o)' - This method returns an array containing all own properties' names (enumerable or not) of an object o.

```
function listAllProperties(o) {
	var objectToInspect;     
	var result = [];
	
	for(objectToInspect = o; objectToInspect !== null; objectToInspect = Object.getPrototypeOf(objectToInspect)) {  
      result = result.concat(Object.getOwnPropertyNames(objectToInspect));  
	}
	
	return result; 
}
```

This can be useful to reveal "hidden" properties (properties in the prototype chain which are not accessible through the object, because another property has the same name earlier in the prototype chain). Listing accessible properties only can easily be done by removing duplicates in the array.

## Creating objects

JavaScript has a number of predefined objects. In addition, you can create your own objects. You can create an object using an object initializer. Alternatively, you can first create a constructor function and then instantiate an object invoking that function in conjunction with the new operator.

**Using object initializers**

In addition to creating objects using a constructor function, you can create objects using an object initializer. Using object initializers is sometimes referred to as creating objects with literal notation. "Object initializer" is consistent with the terminology used by C++.

The syntax for an object using an object initializer is:

```
var obj = { property_1:   value_1,   // property_# may be an identifier...
            2:            value_2,   // or a number...
            // ...,
            'property n': value_n }; // or a string
```

where obj is the name of the new object, each property_i is an identifier (either a name, a number, or a string literal), and each value_i is an expression whose value is assigned to the property_i. The obj and assignment is optional; if you do not need to refer to this object elsewhere, you do not need to assign it to a variable. (Note that you may need to wrap the object literal in parentheses if the object appears where a statement is expected, so as not to have the literal be confused with a block statement.)

Object initializers are expressions, and each object initializer results in a new object being created whenever the statement in which it appears is executed. Identical object initializers create distinct objects that will not compare to each other as equal. Objects are created as if a call to new Object() were made; that is, objects made from object literal expressions are instances of Object.

The following statement creates an object and assigns it to the variable x if and only if the expression cond is true:
``
if (cond) var x = {greeting: 'hi there'};
```
The following example creates myHonda with three properties. Note that the engine property is also an object with its own properties.
```
var myHonda = {color: 'red', wheels: 4, engine: {cylinders: 4, size: 2.2}};
```
You can also use object initializers to create arrays. 

**Using a constructor function**

Alternatively, you can create an object with these two steps:

    * Define the object type by writing a constructor function. There is a strong convention, with good reason, to use a capital initial letter.
    * Create an instance of the object with new.

To define an object type, create a function for the object type that specifies its name, properties, and methods. For example, suppose you want to create an object type for cars. You want this type of object to be called car, and you want it to have properties for make, model, and year. To do this, you would write the following function:

```
function Car(make, model, year) {
  this.make = make;
  this.model = model;
  this.year = year;
}
```

Notice the use of this to assign values to the object's properties based on the values passed to the function.

Now you can create an object called mycar as follows:

```
var mycar = new Car('Eagle', 'Talon TSi', 1993);
```

This statement creates mycar and assigns it the specified values for its properties. Then the value of mycar.make is the string "Eagle", mycar.year is the integer 1993, and so on.

You can create any number of car objects by calls to new. For example,

```
var kenscar = new Car('Nissan', '300ZX', 1992);
var vpgscar = new Car('Mazda', 'Miata', 1990);
```

An object can have a property that is itself another object. For example, suppose you define an object called person as follows:

```
function Person(name, age, sex) {
  this.name = name;
  this.age = age;
  this.sex = sex;
}
```

and then instantiate two new person objects as follows:

```
var rand = new Person('Rand McKinnon', 33, 'M');
var ken = new Person('Ken Jones', 39, 'M');
```

Then, you can rewrite the definition of car to include an owner property that takes a person object, as follows:

```
function Car(make, model, year, owner) {
  this.make = make;
  this.model = model;
  this.year = year;
  this.owner = owner;
}
```

To instantiate the new objects, you then use the following:

```
var car1 = new Car('Eagle', 'Talon TSi', 1993, rand);
var car2 = new Car('Nissan', '300ZX', 1992, ken);
```

Notice that instead of passing a literal string or integer value when creating the new objects, the above statements pass the objects rand and ken as the arguments for the owners. Then if you want to find out the name of the owner of car2, you can access the following property:

```
car2.owner.name
```
Note that you can always add a property to a previously defined object. For example, the statement

```
car1.color = 'black';
```
adds a property color to car1, and assigns it a value of "black." However, this does not affect any other objects. To add the new property to all objects of the same type, you have to add the property to the definition of the car object type.

**Using the Object.create method**

Objects can also be created using the Object.create() method. This method can be very useful, because it allows you to choose the prototype object for the object you want to create, without having to define a constructor function.

```
// Animal properties and method encapsulation
var Animal = {
  type: 'Invertebrates', // Default value of properties
  displayType: function() {  // Method which will display type of Animal
    console.log(this.type);
  }
};

// Create new animal type called animal1 
var animal1 = Object.create(Animal);
animal1.displayType(); // Output:Invertebrates

// Create new animal type called Fishes
var fish = Object.create(Animal);
fish.type = 'Fishes';
fish.displayType(); // Output:Fishes
```

**Inheritance**

All objects in JavaScript inherit from at least one other object. The object being inherited from is known as the prototype, and the inherited properties can be found in the prototype object of the constructor. 


**Indexing object properties**

You can refer to a property of an object either by its property name or by its ordinal index. If you initially define a property by its name, you must always refer to it by its name, and if you initially define a property by an index, you must always refer to it by its index.

This restriction applies when you create an object and its properties with a constructor function (as we did previously with the Car object type) and when you define individual properties explicitly (for example, myCar.color = "red"). If you initially define an object property with an index, such as myCar[5] = "25 mpg", you subsequently refer to the property only as myCar[5].

The exception to this rule is objects reflected from HTML, such as the forms array. You can always refer to objects in these arrays by either their ordinal number (based on where they appear in the document) or their name (if defined). For example, if the second <FORM> tag in a document has a NAME attribute of "myForm", you can refer to the form as document.forms[1] or document.forms["myForm"] or document.forms.myForm.

**Defining properties for an object type**

You can add a property to a previously defined object type by using the prototype property. This defines a property that is shared by all objects of the specified type, rather than by just one instance of the object. The following code adds a color property to all objects of type car, and then assigns a value to the color property of the object car1.

Car.prototype.color = null;
car1.color = 'black';

## Defining methods

A method is a function associated with an object, or, simply put, a method is a property of an object that is a function. Methods are defined the way normal functions are defined, except that they have to be assigned as the property of an object. See also method definitions for more details. An example is:

```
objectName.methodname = function_name;

var myObj = {
  myMethod: function(params) {
    // ...do something
  }

  // OR THIS WORKS TOO

  myOtherMethod(params) {
    // ...do something else
  }
};
```

where objectName is an existing object, methodname is the name you are assigning to the method, and function_name is the name of the function.

You can then call the method in the context of the object as follows:

```
object.methodname(params);
```

You can define methods for an object type by including a method definition in the object constructor function. You could define a function that would format and display the properties of the previously-defined car objects; for example,

```
function displayCar() {
  var result = 'A Beautiful ' + this.year + ' ' + this.make
    + ' ' + this.model;
  pretty_print(result);
}
```

where pretty_print is a function to display a horizontal rule and a string. Notice the use of this to refer to the object to which the method belongs.

You can make this function a method of car by adding the statement

```
this.displayCar = displayCar;
```

to the object definition. So, the full definition of car would now look like

```
function Car(make, model, year, owner) {
  this.make = make;
  this.model = model;
  this.year = year;
  this.owner = owner;
  this.displayCar = displayCar;
}
```

Then you can call the displayCar method for each of the objects as follows:

```
car1.displayCar();
car2.displayCar();
```

**Using this for object references**

JavaScript has a special keyword, this, that you can use within a method to refer to the current object. For example, suppose you have a function called validate that validates an object's value property, given the object and the high and low values:

```
function validate(obj, lowval, hival) {
  if ((obj.value < lowval) || (obj.value > hival)) {
    alert('Invalid Value!');
  }
}
```

Then, you could call validate in each form element's onchange event handler, using this to pass it the element, as in the following example:

```
<input type="text" name="age" size="3"
  onChange="validate(this, 18, 99)">
```

In general, this refers to the calling object in a method.

When combined with the form property, this can refer to the current object's parent form. In the following example, the form myForm contains a Text object and a button. When the user clicks the button, the value of the Text object is set to the form's name. The button's onclick event handler uses this.form to refer to the parent form, myForm.

```
<form name="myForm">
<p><label>Form name:<input type="text" name="text1" value="Beluga"></label>
<p><input name="button1" type="button" value="Show Form Name"
     onclick="this.form.text1.value = this.form.name">
</p>
</form>
```

## Getter and setter

A getter is a method that gets the value of a specific property. A setter is a method that sets the value of a specific property. You can define getters and setters on any predefined core object or user-defined object that supports the addition of new properties. 

The following illustrates how getters and setters could work for a user-defined object o.

```
var o = {
  a: 7,
  get b() { 
    return this.a + 1;
  },
  set c(x) {
    this.a = x / 2;
  }
};

console.log(o.a); // 7
console.log(o.b); // 8
o.c = 50;
console.log(o.a); // 25
```

Please note that function names of getters and setters defined in an object literal using "[gs]et property()" (as opposed to __define[GS]etter__ ) are not the names of the getters themselves, even though the [gs]et propertyName(){ } syntax may mislead you to think otherwise. To name a function in a getter or setter using the "[gs]et property()" syntax, define an explicitly named function programmatically using Object.defineProperty (or the Object.prototype.__defineGetter__ legacy fallback).

The following code illustrates how getters and setters can extend the Date prototype to add a year property to all instances of the predefined Date class. It uses the Date class's existing getFullYear and setFullYear methods to support the year property's getter and setter.

These statements define a getter and setter for the year property:

```
var d = Date.prototype;
Object.defineProperty(d, 'year', {
  get: function() { return this.getFullYear(); },
  set: function(y) { this.setFullYear(y); }
});
```

These statements use the getter and setter in a Date object:

```
var now = new Date();
console.log(now.year); // 2000
now.year = 2001; // 987617605170
console.log(now);
// Wed Apr 18 11:13:25 GMT-0700 (Pacific Daylight Time) 2001
```

In principle, getters and setters can be either

    * defined using object initializers, or
    * added later to any object at any time using a getter or setter adding method.

When defining getters and setters using object initializers all you need to do is to prefix a getter method with get and a setter method with set. Of course, the getter method must not expect a parameter, while the setter method expects exactly one parameter (the new value to set). For instance:

```
var o = {
  a: 7,
  get b() { return this.a + 1; },
  set c(x) { this.a = x / 2; }
};
```

Getters and setters can also be added to an object at any time after creation using the Object.defineProperties method. This method's first parameter is the object on which you want to define the getter or setter. The second parameter is an object whose property names are the getter or setter names, and whose property values are objects for defining the getter or setter functions. Here's an example that defines the same getter and setter used in the previous example:

```
var o = { a: 0 };

Object.defineProperties(o, {
    'b': { get: function() { return this.a + 1; } },
    'c': { set: function(x) { this.a = x / 2; } }
});

o.c = 10; // Runs the setter, which assigns 10 / 2 (5) to the 'a' property
console.log(o.b); // Runs the getter, which yields a + 1 or 6
```

Which of the two forms to choose depends on your programming style and task at hand. If you already go for the object initializer when defining a prototype you will probably most of the time choose the first form. This form is more compact and natural. However, if you need to add getters and setters later — because you did not write the prototype or particular object — then the second form is the only possible form. The second form probably best represents the dynamic nature of JavaScript — but it can make the code hard to read and understand.

**Deleting properties**

You can remove a non-inherited property by using the delete operator. The following code shows how to remove a property.

```
// Creates a new object, myobj, with two properties, a and b.
var myobj = new Object;
myobj.a = 5;
myobj.b = 12;

// Removes the a property, leaving myobj with only the b property.
delete myobj.a;
console.log ('a' in myobj); // yields "false"
```

You can also use delete to delete a global variable if the var keyword was not used to declare the variable:

```
g = 17;
delete g;
```

**Comparing Objects**

In JavaScript objects are a reference type. Two distinct objects are never equal, even if they have the same properties. Only comparing the same object reference with itself yields true.

```
// Two variables, two distinct objects with the same properties
var fruit = {name: 'apple'};
var fruitbear = {name: 'apple'};

fruit == fruitbear; // return false
fruit === fruitbear; // return false

// Two variables, a single object
var fruit = {name: 'apple'};
var fruitbear = fruit;  // assign fruit object reference to fruitbear

// here fruit and fruitbear are pointing to same object
fruit == fruitbear; // return true
fruit === fruitbear; // return true

fruit.name = 'grape';
console.log(fruitbear);    // yields { name: "grape" } instead of { name: "apple" }
```

# Details of the object model

JavaScript is an object-based language based on prototypes, rather than being class-based. Because of this different basis, it can be less apparent how JavaScript allows you to create hierarchies of objects and to have inheritance of properties and their values.

**Class-based vs. prototype-based languages**

Class-based object-oriented languages, such as Java and C++, are founded on the concept of two distinct entities: classes and instances.

    * A class defines all of the properties (considering methods and fields in Java, or members in C++, to be properties) that characterize a certain set of objects. A class is an abstract thing, rather than any particular member of the set of objects it describes. For example, the Employee class could represent the set of all employees.
    * An instance, on the other hand, is the instantiation of a class; that is, one of its members. For example, Victoria could be an instance of the Employee class, representing a particular individual as an employee. An instance has exactly the same properties of its parent class (no more, no less).

A prototype-based language, such as JavaScript, does not make this distinction: it simply has objects. A prototype-based language has the notion of a prototypical object, an object used as a template from which to get the initial properties for a new object. Any object can specify its own properties, either when you create it or at run time. In addition, any object can be associated as the prototype for another object, allowing the second object to share the first object's properties.

**Defining a class**

In class-based languages, you define a class in a separate class definition. In that definition you can specify special methods, called constructors, to create instances of the class. A constructor method can specify initial values for the instance's properties and perform other processing appropriate at creation time. You use the new operator in association with the constructor method to create class instances.

JavaScript follows a similar model, but does not have a class definition separate from the constructor. Instead, you define a constructor function to create objects with a particular initial set of properties and values. Any JavaScript function can be used as a constructor. You use the new operator with a constructor function to create a new object.

**Subclasses and inheritance**

In a class-based language, you create a hierarchy of classes through the class definitions. In a class definition, you can specify that the new class is a subclass of an already existing class. The subclass inherits all the properties of the superclass and additionally can add new properties or modify the inherited ones. For example, assume the Employee class includes only the name and dept properties, and Manager is a subclass of Employee that adds the reports property. In this case, an instance of the Manager class would have all three properties: name, dept, and reports.

JavaScript implements inheritance by allowing you to associate a prototypical object with any constructor function. So, you can create exactly the Employee — Manager example, but you use slightly different terminology. First you define the Employee constructor function, specifying the name and dept properties. Next, you define the Manager constructor function, calling the Employee constructor and specifying the reports property. Finally, you assign a new object derived from Employee.prototype as the prototype for the Manager constructor function. Then, when you create a new Manager, it inherits the name and dept properties from the Employee object.


**Adding and removing properties**

In class-based languages, you typically create a class at compile time and then you instantiate instances of the class either at compile time or at run time. You cannot change the number or the type of properties of a class after you define the class. In JavaScript, however, at run time you can add or remove properties of any object. If you add a property to an object that is used as the prototype for a set of objects, the objects for which it is the prototype also get the new property.


**Summary of differences**

The following table gives a short summary of some of these differences. The rest of this chapter describes the details of using JavaScript constructors and prototypes to create an object hierarchy and compares this to how you would do it in Java.

Comparison of class-based (Java) and prototype-based (JavaScript) object systems 
Class-based (Java) 						   |Prototype-based (JavaScript)
-------------------------------------------|--------------------------------------------------
Class and instance are distinct entities.  |All objects can inherit from another object.
Define a class with a class definition; instantiate a class with constructor methods. |	Define and create a set of objects with constructor functions.
Create a single object with the new operator.| 	Same.
Construct an object hierarchy by using class definitions to define subclasses of existing classes. |	Construct an object hierarchy by assigning an object as the prototype associated with a constructor function.
Inherit properties by following the class chain. | Inherit properties by following the prototype chain.
Class definition specifies all properties of all instances of a class. Cannot add properties dynamically at run time. |	Constructor function or prototype specifies an initial set of properties. Can add or remove properties dynamically to individual objects or to the entire set of objects.

## Prototype-based OOP
## Creating object hierarchies

The following Java and JavaScript Employee definitions are similar. The only difference is that you need to specify the type for each property in Java but not in JavaScript (this is due to Java being a strongly typed language while JavaScript is a weakly typed language).

**JavaScript**
```
function Employee() {
  this.name = '';
  this.dept = 'general';
}
```

**Java**
```
public class Employee {
   public String name = "";
   public String dept = "general";
}
```

The Manager and WorkerBee definitions show the difference in how to specify the next object higher in the inheritance chain. In JavaScript, you add a prototypical instance as the value of the prototype property of the constructor function. You can do so at any time after you define the constructor. In Java, you specify the superclass within the class definition. You cannot change the superclass outside the class definition.

**JavaScript**
```
function Manager() {
  Employee.call(this);
  this.reports = [];
}
Manager.prototype = 
    Object.create(Employee.prototype);

function WorkerBee() {
  Employee.call(this);
  this.projects = [];
}
WorkerBee.prototype = 
    Object.create(Employee.prototype);
```

**Java**
```
public class Manager extends Employee {
   public Employee[] reports = 
       new Employee[0];
}


public class WorkerBee extends Employee {
   public String[] projects = new String[0];
}
```

The Engineer and SalesPerson definitions create objects that descend from WorkerBee and hence from Employee. An object of these types has properties of all the objects above it in the chain. In addition, these definitions override the inherited value of the dept property with new values specific to these objects.

**JavaScript**
```
function SalesPerson() {
   WorkerBee.call(this);
   this.dept = 'sales';
   this.quota = 100;
}
SalesPerson.prototype = 
    Object.create(WorkerBee.prototype);

function Engineer() {
   WorkerBee.call(this);
   this.dept = 'engineering';
   this.machine = '';
}
Engineer.prototype = 
    Object.create(WorkerBee.prototype);
```
	
**Java**
```
public class SalesPerson extends WorkerBee {
   public String dept = "sales";
   public double quota = 100.0;
}


public class Engineer extends WorkerBee {
   public String dept = "engineering";
   public String machine = "";
}
```
**Creating objects with simple definitions**

var jim = new Employee; 
// Parentheses can be omitted if the
// constructor takes no arguments.
// jim.name is ''
// jim.dept is 'general'

var sally = new Manager;
// sally.name is ''
// sally.dept is 'general'
// sally.reports is []

var mark = new WorkerBee;
// mark.name is ''
// mark.dept is 'general'
// mark.projects is []

var fred = new SalesPerson;
// fred.name is ''
// fred.dept is 'sales'
// fred.projects is []
// fred.quota is 100

var jane = new Engineer;
// jane.name is ''
// jane.dept is 'engineering'
// jane.projects is []
// jane.machine is '

## Inheritance


# Iterators and generators

Processing each of the items in a collection is a very common operation. JavaScript provides a number of ways of iterating over a collection, from simple for loops to map() and filter(). Iterators and Generators bring the concept of iteration directly into the core language and provide a mechanism for customizing the behavior of for...of loops.

## Iterators
An object is an iterator when it knows how to access items from a collection one at a time, while keeping track of its current position within that sequence. In JavaScript an iterator is an object that provides a next() method which returns the next item in the sequence. This method returns an object with two properties: done and value.

Once created, an iterator object can be used explicitly by repeatedly calling next().

```
function makeIterator(array) {
    var nextIndex = 0;
    
    return {
       next: function() {
           return nextIndex < array.length ?
               {value: array[nextIndex++], done: false} :
               {done: true};
       }
    };
}
```

Once initialized, the next() method can be called to access key-value pairs from the object in turn:

```
var it = makeIterator(['yo', 'ya']);
console.log(it.next().value); // 'yo'
console.log(it.next().value); // 'ya'
console.log(it.next().done);  // true
```

## Iterables

An object is iterable if it defines its iteration behavior, such as what values are looped over in a for...of construct. Some built-in types, such as Array or Map, have a default iteration behavior, while other types (such as Object) do not.

In order to be iterable, an object must implement the @@iterator method, meaning that the object (or one of the objects up its prototype chain) must have a property with a Symbol.iterator key:

**User-defined iterables**

We can make our own iterables like this:

```
var myIterable = {};
myIterable[Symbol.iterator] = function* () {
    yield 1;
    yield 2;
    yield 3;
};

for (let value of myIterable) { 
    console.log(value); 
}
// 1
// 2
// 3

or

[...myIterable]; // [1, 2, 3]
```

**Built-in iterables**

String, Array, TypedArray, Map and Set are all built-in iterables, because their prototype objects all have a Symbol.iterator method.

**Syntaxes expecting iterables**

Some statements and expressions are expecting iterables, for example the for-of loops, spread syntax, yield*, and destructuring assignment.

```
for (let value of ['a', 'b', 'c']) {
    console.log(value);
}
// "a"
// "b"
// "c"

[...'abc']; // ["a", "b", "c"]

function* gen() {
  yield* ['a', 'b', 'c'];
}

gen().next(); // { value: "a", done: false }

[a, b, c] = new Set(['a', 'b', 'c']);
a; // "a"
```

## Generators

While custom iterators are a useful tool, their creation requires careful programming due to the need to explicitly maintain their internal state. Generators provide a powerful alternative: they allow you to define an iterative algorithm by writing a single function which can maintain its own state.

A GeneratorFunction is a special type of function that works as a factory for iterators. When it is executed it returns a new Generator object. A function becomes a GeneratorFunction if it uses the function* syntax.

```
function* idMaker() {
  var index = 0;
  while(true)
    yield index++;
}

var gen = idMaker();

console.log(gen.next().value); // 0
console.log(gen.next().value); // 1
console.log(gen.next().value); // 2
// ...
```

**Advanced generators**

Generators compute their yielded values on demand, which allows them to efficiently represent sequences that are expensive to compute, or even infinite sequences as demonstrated above.

The next() method also accepts a value which can be used to modify the internal state of the generator. A value passed to next() will be treated as the result of the last yield expression that paused the generator.

Here is the fibonacci generator using next(x) to restart the sequence:

```
function* fibonacci() {
  var fn1 = 0;
  var fn2 = 1;
  while (true) {  
    var current = fn1;
    fn1 = fn2;
    fn2 = current + fn1;
    var reset = yield current;
    if (reset) {
        fn1 = 0;
        fn2 = 1;
    }
  }
}

var sequence = fibonacci();
console.log(sequence.next().value);     // 0
console.log(sequence.next().value);     // 1
console.log(sequence.next().value);     // 1
console.log(sequence.next().value);     // 2
console.log(sequence.next().value);     // 3
console.log(sequence.next().value);     // 5
console.log(sequence.next().value);     // 8
console.log(sequence.next(true).value); // 0
console.log(sequence.next().value);     // 1
console.log(sequence.next().value);     // 1
console.log(sequence.next().value);     // 2
```

You can force a generator to throw an exception by calling its throw() method and passing the exception value it should throw. This exception will be thrown from the current suspended context of the generator, as if the yield that is currently suspended were instead a throw value statement.

If a yield is not encountered during the processing of the thrown exception, then the exception will propagate up through the call to throw(), and subsequent calls to next() will result in the done property being true.

Generators have a return(value) method that returns the given value and finishes the generator itself.

# Meta programming

## Proxy
## Handlers and traps
## Revocable Proxy
## Reflect

# Intermediate JavaScript

# Advance JavaScript
