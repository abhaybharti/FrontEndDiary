## Reduce Data with Javascript Array
   it takes two paramter, 
   first a function
   second starting object
    ```  var orders =[
          {amount: 250},
          {amount: 150},
          {amount: 200},
          {amount: 400}
      ]

      var totalAmount = 0;
      for(var i =0; i<orders.length; i++){
          totalAmount += orders[i].amount
      }

      console.log(totalAmount);

      var totalAmount = orders.Reduce(functin(sum, order){
          console.log("hello", sum, order)
          return sum+order.amount
      },0)
	```
	
## Advance Reduce Data with Javascript Array
{
}