Arithmetic operators
        Array comprehensions
        Assignment operators
        Bitwise operators
        Comma operator
        Comparison operators
        Conditional (ternary) Operator
        Destructuring assignment
        Expression closures
        Generator comprehensions
        Grouping operator
        Legacy generator function expression
        Logical Operators
        Object initializer
        Operator precedence
        Pipeline operator
        Property accessors
        Spread syntax
        async function expression
        await
        class expression
        delete operator
        function expression
        function* expression
        in operator
        instanceof
        new operator
        new.target
        super
        this
        typeof
        void operator
        yield
        yield*
		
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
