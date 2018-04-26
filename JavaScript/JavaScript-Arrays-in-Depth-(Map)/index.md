## JavaScript Arrays in Depth (Map)
    Map is another HOC function which transforms an array. Map is a function on array object.

    ```   example -
       var animals = [
           {name: 'Fluffykins', species:'rabbit'},
           {name: 'Caro', species:'dog'},
           {name: 'Hamilton', species:'dog'},
           {name: 'Harold', species:'fish'},
           {name: 'Ursula', species:'cat'},
           {name: 'Jimmy', species:'fish'}
       ]

       //Problem Description - get name of all animal species
       var names = []
       for (var i =0; i < animals.length; i++){
           names.push(animals[i].name)
       }
       console.log(names);
       
       var names = animals.map(functin(animal){
           return animal.name + ' is a ' + animal.species
       })

       using array function
       var names = animals.map(animal => animals.name)
	```
       transform multi value array into single value array
       * filter, reject, map, find are list transformation method, turn list into something