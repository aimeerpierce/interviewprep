
//returns -1 if the value is not found
var binarySearch = function(arr,val){
  let front = 0;
  let mid = Math.floor(arr.length/2);
  let end = arr.length - 1;

  while(arr[mid] !== val){
    if(front==end){
      mid = -1;
      break;
    }
    if (arr[mid] > val){
      end = mid-1;
    }
    if( arr[mid] < val){
      front = mid+1;
    }
    mid = Math.floor((end+front)/2);
  }
  return mid;

}
arr = [1,3,5,7,9,11];
val = 5;
//binarySearch(arr,val);


/*var binarySearch_recursive = function(arr,val){
  let front = 0;
  let mid = Math.floor(arr.length/2);
  let end = arr.length - 1;

  if(arr.length == 1){
    return mid;
  }

  while(arr.length > 1){
    if (arr[mid] > val){
      var new_arr = arr.slice(0,mid);
     // return binarySearch_recursive(new_arr,val)
    }
    if( arr[mid] < val){
      var new_arr = arr.slice(mid+1,arr.length);
     // return bina
    }
    return
  }
}*/

function binarySearch_recursive(array, element) {
  var start = 0;
  var end = array.length - 1;
  var mid = Math.floor((end - start) / 2);

  if (array.length === 0) {
    return null;
  }

  if (array[mid] === element) {
    return mid;
  }

  if (element > array[mid]) {
    if(element === array[end]) {
      return end;
    } else {
      var right = array.slice(mid);
      return binarySearch(right, element);
    }
  } else {
    if(element === array[start]) {
      return start;
    } else {
      var left = array.slice(0, mid);
      return binarySearch(left, element);
    }
  }
  return null;
}

console.log(binarySearch_recursive(arr,val));

function binarySearch_recursive2(array,val,buffer){
  var start = 0;
  var end = array.length - 1;
  var mid = Math.floor((end - start) / 2);
  var new_arr = [];

  if(arr.length == 1){
    return arr + buffer;
  }

  if(arr[mid] > val){
    new_arr = arr.slice(0,mid);
    buffer = 0;
  }
  if(arr[mid] < val){
    new_arr = arr.slice(mid+1,arr.length);
    buffer =
  }
}
