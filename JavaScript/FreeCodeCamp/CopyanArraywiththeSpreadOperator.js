
function copyMachine(arr, num) {
  let newArr = [];
  while (num >= 1) {
    // change code below this line
	  //console.log(newArr.length);
      newArr[newArr.length] =[...arr];
    // change code above this line
    num--;
  }
  return newArr;
}

// change code here to test different cases:
//console.log(copyMachine([true, false, true], 1));
//console.log(copyMachine([true, false, true], 2));
//console.log(copyMachine([1, 2, 3], 5));
//console.log(copyMachine([true, true, null], 1));
console.log(copyMachine(["it works"], 3));
