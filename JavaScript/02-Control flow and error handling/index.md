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

        Error: Permission denied to access property "x"
        InternalError: too much recursion
        RangeError: argument is not a valid code point
        RangeError: invalid array length
        RangeError: invalid date
        RangeError: precision is out of range
        RangeError: radix must be an integer
        RangeError: repeat count must be less than infinity
        RangeError: repeat count must be non-negative
        ReferenceError: "x" is not defined
        ReferenceError: assignment to undeclared variable "x"
        ReferenceError: can't access lexical declaration`X' before initialization
        ReferenceError: deprecated caller or arguments usage
        ReferenceError: invalid assignment left-hand side
        ReferenceError: reference to undefined property "x"
        SyntaxError: "0"-prefixed octal literals and octal escape seq. are deprecated
        SyntaxError: "use strict" not allowed in function with non-simple parameters
        SyntaxError: "x" is a reserved identifier
        SyntaxError: JSON.parse: bad parsing
        SyntaxError: Malformed formal parameter
        SyntaxError: Unexpected token
        SyntaxError: Using //@ to indicate sourceURL pragmas is deprecated. Use //# instead
        SyntaxError: a declaration in the head of a for-of loop can't have an initializer
        SyntaxError: applying the 'delete' operator to an unqualified name is deprecated
        SyntaxError: for-in loop head declarations may not have initializers
        SyntaxError: function statement requires a name
        SyntaxError: identifier starts immediately after numeric literal
        SyntaxError: illegal character
        SyntaxError: invalid regular expression flag "x"
        SyntaxError: missing ) after argument list
        SyntaxError: missing ) after condition
        SyntaxError: missing : after property id
        SyntaxError: missing ; before statement
        SyntaxError: missing = in const declaration
        SyntaxError: missing ] after element list
        SyntaxError: missing formal parameter
        SyntaxError: missing name after . operator
        SyntaxError: missing variable name
        SyntaxError: missing } after function body
        SyntaxError: missing } after property list
        SyntaxError: redeclaration of formal parameter "x"
        SyntaxError: return not in function
        SyntaxError: test for equality (==) mistyped as assignment (=)?
        SyntaxError: unterminated string literal
        TypeError: "x" has no properties
        TypeError: "x" is (not) "y"
        TypeError: "x" is not a constructor
        TypeError: "x" is not a function
        TypeError: "x" is not a non-null object
        TypeError: "x" is read-only
        TypeError: More arguments needed
        TypeError: can't access dead object
        TypeError: can't define property "x": "obj" is not extensible
        TypeError: can't delete non-configurable array element
        TypeError: can't redefine non-configurable property "x"
        TypeError: cannot use 'in' operator to search for 'x' in 'y'
        TypeError: cyclic object value
        TypeError: invalid 'instanceof' operand 'x'
        TypeError: invalid Array.prototype.sort argument
        TypeError: invalid arguments
        TypeError: invalid assignment to const "x"
        TypeError: property "x" is non-configurable and can't be deleted
        TypeError: setting getter-only property "x"
        TypeError: variable "x" redeclares argument
        URIError: malformed URI sequence
        Warning: -file- is being assigned a //# sourceMappingURL, but already has one
        Warning: 08/09 is not a legal ECMA-262 octal constant
        Warning: Date.prototype.toLocaleFormat is deprecated
        Warning: JavaScript 1.6's for-each-in loops are deprecated
        Warning: String.x is deprecated; use String.prototype.x instead
        Warning: expression closures are deprecated
        Warning: unreachable code after return statement
        X.prototype.y called on incompatible type
    

