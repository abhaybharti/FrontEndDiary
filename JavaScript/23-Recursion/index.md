## Higher-order functions
    functions are values & can be assigned to variable or passed into other functions. Higher order function provies composition. When a function takes another function as argument, called as higher order function. Transforms an array into smaller array.
      example -
	  
      ``` var animals = [
           {name: 'Fluffykins', species:'rabbit'},
           {name: 'Caro', species:'dog'},
           {name: 'Hamilton', species:'dog'},
           {name: 'Harold', species:'fish'},
           {name: 'Ursula', species:'cat'},
           {name: 'Jimmy', species:'fish'}
       ]

      //using for loop approach
       var dogs =[]
       for (var i =0; i<animals.length; i++) {
           if (animals[i].species === 'dog')
             dog.push(animals[i]);
       }
     
     //Ex 1 using filter function
      var dogs = animals.filter(function(animal){
          return animal.species === 'dog'
      })```

      filter will go through each element of array, based on true/false returned by callback function, it will  add that  
      element in new array. filter function & callback function are composed together, in this example function(animal) is a callback function filter is a function on array object.
     
	 ```//Ex 2 
      var isDog = functin(animal){
          return animal.species === 'dogs'
      }  

      var dogs = animals.filter(isDog); //create array of dogs
      var otherAnimals = animals.reject(isDog); // create array of other species
	 ```

      function that you send to other function are called as callback function