/**
 * http://usejsdoc.org/
 */
function multiplyAll(arr) {
  var product = 1;
  // Only change code below this line
  for (var i =0; i <arr.length;i++){
    for (var j =0; j<arr[i].length; j++){
      console.log(i+""+ j +"i : "+arr[i][j]);
      console.log(arr[i][j]*product);
      console.log(i+""+ j +"product : "+product);
    }
  }
  console.log("final - "+product);
  // Only change code above this line
  return product;
}

// Modify values below to test your code
multiplyAll([[1],[2],[3]]);