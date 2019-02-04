URL - https://developer.mozilla.org/en-US/docs/Web/HTML/Element


# HTML Form

## HTML Forms
*<form>* - The HTML <form> element defines a form that is used to collect user input:

```
<form>
.
form elements
.
</form>
```

An HTML form contains form elements. Form elements are different types of input elements, like text fields, checkboxes, radio buttons, submit buttons, and more.

*<input>* - Defines an input control, The <input> element can be displayed in several ways, depending on the type attribute.

Input Type Text - <input type="text"> defines a one-line text input field:
```
<form>
  First name:<br>
  <input type="text" name="firstname"><br>
  Last name:<br>
  <input type="text" name="lastname">
</form> 
```

Input Type Password - <input type="password"> defines a password field:
```
<form>
  User name:<br>
  <input type="text" name="username"><br>
  User password:<br>
  <input type="password" name="psw">
</form> 
```

Input Type Submit - <input type="submit"> defines a button for submitting form data to a form-handler. The form-handler is typically a server page with a script for processing input data. The form-handler is specified in the form's action attribute:
```
 <form action="/action_page.php">
  First name:<br>
  <input type="text" name="firstname" value="Mickey"><br>
  Last name:<br>
  <input type="text" name="lastname" value="Mouse"><br><br>
  <input type="submit" value="Submit">
 </form> 
```

Input Type Reset - <input type="reset"> defines a reset button that will reset all form values to their default values:
```
<form action="/action_page.php">
  First name:<br>
  <input type="text" name="firstname" value="Mickey"><br>
  Last name:<br>
  <input type="text" name="lastname" value="Mouse"><br><br>
  <input type="submit" value="Submit">
  <input type="reset">
</form> 
```

Input Type Radio - <input type="radio"> defines a radio button. Radio buttons let a user select ONLY ONE of a limited number of choices:
```
<form>
  <input type="radio" name="gender" value="male" checked> Male<br>
  <input type="radio" name="gender" value="female"> Female<br>
  <input type="radio" name="gender" value="other"> Other
</form> 
```

Input Type Checkbox - <input type="checkbox"> defines a checkbox. Checkboxes let a user select ZERO or MORE options of a limited number of choices.
```
 <form>
  <input type="checkbox" name="vehicle1" value="Bike"> I have a bike<br>
  <input type="checkbox" name="vehicle2" value="Car"> I have a car
</form> 
```

Input Type Button - <input type="button"> defines a button:
```
 <input type="button" onclick="alert('Hello World!')" value="Click Me!"> 
```

Input Type Color - The <input type="color"> is used for input fields that should contain a color.
Depending on browser support, a color picker can show up in the input field.

```
<form>
  Select your favorite color:
  <input type="color" name="favcolor">
</form> 
```

Input Type Date - The <input type="date"> is used for input fields that should contain a date.
Depending on browser support, a date picker can show up in the input field.

```
<form>
  Birthday:
  <input type="date" name="bday">
</form> 
```

You can also add restrictions to dates:

```
<form>
  Enter a date before 1980-01-01:
  <input type="date" name="bday" max="1979-12-31"><br>
  Enter a date after 2000-01-01:
  <input type="date" name="bday" min="2000-01-02"><br>
</form> 
```

Input Type Datetime-local - The <input type="datetime-local"> specifies a date and time input field, with no time zone. 
```
<form>
  Birthday (date and time):
  <input type="datetime-local" name="bdaytime">
</form> 
```

Input Type Email - The <input type="email"> is used for input fields that should contain an e-mail address.
Some smartphones recognize the email type, and adds ".com" to the keyboard to match email input.

```
<form>
  E-mail:
  <input type="email" name="email">
</form> 
```

*<select>* - The <select> element defines a drop-down list:
```
 <select name="cars">
  <option value="volvo">Volvo</option>
  <option value="saab">Saab</option>
  <option value="fiat">Fiat</option>
  <option value="audi">Audi</option>
 </select> 
```

*<option>* - The <option> elements defines an option that can be selected. By default, the first item in the drop-down list is selected. To define a pre-selected option, add the selected attribute to the option:

```
<option value="fiat" selected>Fiat</option>
Visible Values:
```

Use the size attribute to specify the number of visible values:
```
<select name="cars" size="3">
  <option value="volvo">Volvo</option>
  <option value="saab">Saab</option>
  <option value="fiat">Fiat</option>
  <option value="audi">Audi</option>
</select>
```

*Allow Multiple Selections*: Use the multiple attribute to allow the user to select more than one value:
```
<select name="cars" size="4" multiple>
  <option value="volvo">Volvo</option>
  <option value="saab">Saab</option>
  <option value="fiat">Fiat</option>
  <option value="audi">Audi</option>
</select> 
```

*<optgroup>* - Defines a group of related options in a drop-down list
*<textarea>* - Defines a multiline input control (text area)
```
<textarea name="message" rows="10" cols="30">
The cat was playing in the garden.
</textarea> 
```
The rows attribute specifies the visible number of lines in a text area.

The cols attribute specifies the visible width of a text area.

<label> 	Defines a label for an <input> element
<fieldset> 	Groups related elements in a form
<legend> 	Defines a caption for a <fieldset> element
*<button>* - Defines a clickable button
```
 <button type="button" onclick="alert('Hello World!')">Click Me!</button> 
```

<datalist> 	Specifies a list of pre-defined options for input controls
<output> 	Defines the result of a calculation


## Geolocation API

The methods that are part of the Geolocation API - 
**getCurrentPosition**
getCurrentPosition(successHandler, errorHandler, positionOptions)

successHandler - the success handler (or callback) is called when a location is determined, and it is passed a position object.

errorHandler - The error handler is called when the browser can’t determine its location. 

positionOptions - this allows us to fine-tune the behavior of geolocation

**Coordinates** - coordinates object has following properties - 
* latitude
* longitude
* accuracy
* altitude
* altitudeAccuracy
* heading
* speed

Property latitude, longitude, accuracyThree are guaranteed to be there: lat, long and accuracy. The rest may or may not be supported, depending on your device.

**Position**
* coords
* timestamp

Position object has coords & timestamp property. timestamp contains the time the position object was created. This can be useful for knowing how old the location is. coords give latitude & longtitude. 

**watchPosition**
**clearWatch**

## JSON

**JSON Conversion Example**
Let’s create an object

```
var plan9Movie = new Movie("Plan 9 from Outer Space","Cult Classic", 2,["3:00pm", "7:00pm", "11:00pm"]);
```

Once you’ve got an object, you can convert it into the JSON string format with the JSON.stringify method.

```
var jsonString = JSON.stringify(plan9Movie);
alert(jsonString);
```
We got a JSON string that represents our movie object. We could take this string and do any number of things with it, 
*like send it over HTTP to a server. 
*can also receive a JSON string from another server. 
*Server gave us this string, use method: JSON.parse to turn it back into an object
```
var jsonMovieObject = JSON.parse(jsonString);
alert("JSON Movie is " + jsonMovieObject.title);
```

## Making a AJAX call

var url = "http://wickedlysmart.com/ifeelluckytoday";

var request = new XMLHttpRequest();

request.open("GET", url);

//Handler will check if response is received & let us know
request.onload = function() {
	if (request.status == 200) {
		alert(request.responseText);
		displayLuck(request.responseText);
	}
};

request.send(null);

function displayLuck(luck){
	var p = document.getElementById("luck");
	p.innerHTML = "Today you are " + luck;
}

*To get HTML files or data from a server, the browser sends an HTTP request.
*An HTTP response includes a response code that indicates if there was an error with the request.
*The HTTP response code 200 means the request had no errors. 
*To send an HTTP request from JavaScript, use the XMLHttpRequest object.
*The XMLHttpRequest object's onload handler handles getting the response from the server.
*The JSON response to an XMLHttpRequest is placed in the request's responseText property.
*To convert the responseText string to JSON, use the JSON.parse method.

**Cross Browser Origin Issue**
JSONP stands for "JSON with Padding."
Steps to get data using JSONP

# Remove our XMLHttpRequest code.
# Make sure the updateSales function is ready to receive an object, not a string (as it was with the XMLHttpRequest).
# Add the <script> element to do the actual data retrieval.

When we use the <script> element, we’re telling the browser that it needs to retrieve JavaScript, and so the browser retrieves it, parses it and evaluates it. That means by the time it gets to your updateSales function, the JSON is no longer in string form, but is a first-class JavaScript object. When we used XMLHttpRequest, the data came back in the form of a string. Right now, updateSales assumes it is getting a string, so let’s change
that so that it handles an object, not a string: