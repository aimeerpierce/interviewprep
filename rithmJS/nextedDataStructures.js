
//Given the following array, write a function called printEvens that console.logs all of the even numbers
var nestedArr = [[1,2,3],[4,5,6],[7,8],[9,10,11,12]];

var printEvens = function(arr){
	for(var i = 0; i < arr.length; i++){
		for(var j = 0; j < arr[i].length; j++){
			if(arr[i][j]%2==0){
				console.log(arr[i][j]);
			}
		}
	}
}

//printEvens(nestedArr);


//Given the following array, write a function called sumTotal returns the sum of all numbers in the array
var nestedArr2 = [
	[
		[1,2],
		[3,4]
	],
	[
		[5,6]
	]
];

var sumTotal = function(arr){
	var sum = 0;
	for(var i = 0; i < arr.length; i++){
		for(var j = 0; j < arr[i].length; j++){
			for(var k = 0; k < arr[i][j].length; k++){
				//sum = Math.floor(arr[i][j]);
				sum += arr[i][j][k]*1;
				//console.log(arr[i][j][k]);
			}
		}
	}
	return sum;
}

//sumTotal(nestedArr2);
//console.log(sumTotal(nestedArr2)); // 21


/*
Given the following array, write a function called countVowels, which returns the count of all of the vowels in each string regardless of case.
To see if a value is an array, you can not use typeof since that will return 'object', so one way to do this is by using the Array.isArray function.
*/
var arr = []
Array.isArray(arr) // true
Array.isArray('Hello') // false

var nestedArr3 = ['Elie', ['Matt',['Tim']], ['Colt',['Whisky',['Janey'], 'Tom']], 'Lorien'];

var countVowels = function(arr){
	var sum = 0;
	for(var i = 0; i < arr.length; i++){ //4
		if(!Array.isArray(arr[i])){
			//console.log(arr[i]);
			sum += getVowels(arr[i])*1;
		} else {
			for(var j = 0; j < arr[i].length; j++){
				if(!Array.isArray(arr[i][j])){
					sum += getVowels(arr[i][j])*1;
				} else {
					for(var k = 0; k < arr[i][j].length; k++){
						sum += getVowels(arr[i][j][k])*1;
					}
				}
			}
		}
	}
	return sum;
}

function getVowels(str) {
  var m = String(str).match(/[aeiou]/gi);
  return m === null ? 0 : m.length;
}

//console.log(countVowels(nestedArr3)); // 13


/*
Write a function called rotate which takes an array and a number, and moves each element however many spaces the number is to the right.
For the value at the end of the array, rotate should move it back to the beginning.
rotate([1,2,3], 1) // [3,1,2]
rotate([1,2,3], 2) // [2,3,1]
rotate([1,2,3], 3) // [1,2,3]
*/
var rotate = function(arr, rot){
	var mod = rot % arr.length; //number of times we shift over
	var back, front;
	if(mod == 0){
		return arr;
	} else {
		back = arr.slice(0,arr.length-mod);
		front = arr.slice(arr.length-mod);
	}
	return front.concat(back);
}

//console.log(rotate([1,2,3,4],8));

/*
Write a function called makeXOGrid which takes in two parameters, rows and columns, and returns an array of arrays with the number
of values in each subarray equal to the columns parameter and the number of subarrays equal to the rows parameter.
The values in the sub-arrays should switch between "X" and "O".

makeXOGrid(1,4)
[["X","O","X","O"]]

makeXOGrid(3,2)
[["X","O"],["X","O"],["X","O"]]

makeXOGrid(3,3)
[["X","O","X"],["O","X","O"],["X","O","X"]]
*/

var makeXOGrid = function(rows,columns){
	if(!rows || !columns){
		console.log("zero parameter");
	}
	var grid = [];
	var x = true;
	var o = false;
	for(var i = 0; i < rows; i++){
		grid[i] = [];
		for(var j = 0; j < columns; j++){
			if(x){
				grid[i][j] = "X";
				x = false;
				o = true;
				continue;
			}
			if(o){
				grid[i][j] = "O";
				o = false;
				x = true;
				continue;
			}
		}
	}
	return grid;
}

//console.log(makeXOGrid(5,3));
