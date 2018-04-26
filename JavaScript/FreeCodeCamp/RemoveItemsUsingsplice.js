
function sumOfTen(arr) {
  // change code below this line
   let newArray = arr.splice(1,2);
   console.log(newArray);
   console.log(arr);
   
   
  //arr = newArray;
  // change code above this line
  return arr.reduce((a, b) => a + b);
}

// do not change code below this line
console.log(sumOfTen([2, 5, 1, 5, 2, 1]));