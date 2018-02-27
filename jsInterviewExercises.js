//https://dev.to/maxpou/typical-javascript-interview-exercises-explained
//interview exercises

//1
//why does this print "hey arnold" ?
function greet (person) {
  if (person == { name: 'amy' }) {
    return 'hey amy'
  } else {
    return 'hey arnold'
  }
}
console.log(greet({ name: 'amy'}))

//ANSWER
//because when comparing 2 javascript objects, it depends on reference not on the content
//we have to reference the name attribute!
/*function greet_fixed(person){
	if(person.name=='amy'){
		return 'hey amy'
	} else {
		return 'hey arnold'
	}
}
console.log(greet_fixed({ name: 'amy' }))*/


/*//2
//Why does this print '4444'?
for (var i = 0; i < 4; i++) {
  setTimeout(() => console.log(i), 0)
}
//w/o short-hand
for (var i = 0; i < 4; i++) {
  setTimeout(function cb(){
  	console.log(i);
  }, 0)
}*/

//ANSWER
//it has to do with the Javascript Event Loop!
//var = i is scoped within the function block
//it will log 4 since i=4 when the callback is pushed from the event queue to the call stack
//if we use let instead of var we will print 0,1,2,3 since
//let = i is scoped within the enclosing block...the callback function?
/*for (let i = 0; i < 4; i++) {
  setTimeout(function cb(){
  	console.log(i);
  },0)
}*/

//3
//we want this to print 'doggo'...but it logs undefined! why?
let dog = {
  name: 'doggo',
  sayName () {
    console.log(this.name)
  }
}
let sayName = dog.sayName //copy sayName() into another let
sayName()
//use var instead of let? nope
//let does not have a .this feature? nope

//ANSWER
//function sayName() is called out of the dog context
//it returns window.name =="undefined"
//therefore, we should call the sayName directly on the dog context
/*let dog = {
  name: 'doggo',
  sayName () {
    console.log(this.name)
  }
}
dog.sayName()*/

//4
//I want to bark(), but I get an error. why?
/*function Dog (name) {
  this.name = name
}
Dog.bark = function () {
  console.log(this.name + ' says woof')
}
let fido = new Dog('fido')
fido.bark()*/

//bark function is not defined when Dog is constructed
//so we need to link the bark function to Dog!
//ANSWER
/*function Dog (name) {
  this.name = name
}
Dog.prototype.bark = function () {
  console.log(this.name + ' says woof')
}
let fido = new Dog('fido')
fido.bark()*/

//5
//Explain isBig...
function isBig (thing) {
  if (thing == 0 || thing == 1 || thing == 2) {
    return false
  }
  return true
}
console.log("1: " +isBig(1))    // false
console.log("[2]: " +isBig([2]))  //false
console.log("[2]: " +isBig([2,1]))  //true
console.log("[3]: " +isBig(3)) // true

//I have no idea what the difference between 2 and [2] is in JS
//it's a number vs an array with the value of 2...silly!

//ANSWER
//equality operator == vs strict comparison === question
//equality operators do not compare type
//when comparing an array to a number, the array will be converted to a number
//^what if the array has multiple numbers??


//6
//preserve immutability of heroes list
const heroes = [
  { name: 'Wolverine',      family: 'Marvel',    isEvil: false },
  { name: 'Deadpool',       family: 'Marvel',    isEvil: false },
  { name: 'Magneto',        family: 'Marvel',    isEvil: true  },
  { name: 'Charles Xavier', family: 'Marvel',    isEvil: false },
  { name: 'Batman',         family: 'DC Comics', isEvil: false },
  { name: 'Harley Quinn',   family: 'DC Comics', isEvil: true  },
  { name: 'Legolas',        family: 'Tolkien',   isEvil: false },
  { name: 'Gandalf',        family: 'Tolkien',   isEvil: false },
  { name: 'Saruman',        family: 'Tolkien',   isEvil: true  }
]

const newHeroes = heroes.map(h => {
  h.name = h.name.toUpperCase()
  return h
})
