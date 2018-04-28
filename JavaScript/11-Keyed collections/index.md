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