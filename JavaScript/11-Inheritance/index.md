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

http://davidshariff.com/blog/javascript-inheritance-patterns/