//use flip() to return a sorted array
function pancakeSort(arr) {

  if(arr.length ==1){
    return arr;
  }

  var max = arr[0];
  var maxi = 0;
  var modified_length = arr.length - 1;
  for(var i = 1; i < arr.length; i++){
    if(arr[i]>max){
      max = arr[i];
      maxi = i;
    }
  }
  arr = flip(arr,maxi);
  arr = flip(arr,arr.length-1);

  return pancakeSort(arr.slice(0,arr.length-1)).concat(max);

}


//flip the elements at a given array index
function flip(arr,k){
  var farr = [];

  for(var i = k; i>-1; i--){
    farr.push(arr[i]);
  }
  for(var j = k+1; j < arr.length; j++){
    farr.push(arr[j]);
  }
  return farr;
}


console.log(pancakeSort([7, 1, 5, 5, 4, 3, 2, 7]));
