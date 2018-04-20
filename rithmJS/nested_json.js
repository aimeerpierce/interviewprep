var nestedData = {
  innerData: {
    order: ["first", "second", "third"],
    snacks: ["chips", "fruit", "crackers"],
    numberData: {
        primeNumbers: [2,3,5,7,11],
        fibonnaci: [1,1,2,3,5,8,13]
    },
    addSnack: function(snack){
        this.snacks.push(snack);
        return this;
    }
  }
};
/*
Using a for loop, console.log all of the numbers in the primeNumbers array.
Using a for loop, console.log all of the even Fibonnaci numbers.
Console.log the value "second" inside the order array.
Invoke the addSnack function and add the snack "chocolate".
Inside of the addSnack function there is a special keyword called this.
What does the word this refer to inside the addSnack function?

*/
var logPrime = function(){
    var arr = nestedData.innerData.numberData.primeNumbers;
    for(var i = 0; i < arr.length; i++){
        console.log(arr[i]);
    }
}

var logFib = function(){
    var arr = nestedData.innerData.numberData.fibonnaci;
    for(var i = 0; i < arr.length; i++){
        if(arr[i] % 2 == 0){
            console.log(arr[i]);
        }
    }
}

var logOrder = function(){
    var arr = nestedData.innerData;
    console.log(arr.order[1]);
}

//logPrime();
//logFib();
//logOrder();
var addedSnack = nestedData.innerData.addSnack('goldfish');
//console.log(addedSnack);//nestedData.addSnack("goldfish"));

var nestedObject = {
  speakers: [{name:"Elie"},{name:"Tim"},{name:"Matt"}],
  data: {
    continents: {
      europe: {
        countries: {
          switzerland: {
            capital: "Bern",
            population: 8000000
          }
        }
      }
    },
    languages: {
      spanish: {
          hello: "Hola"
      },
      french: {
          hello: "Bonjour"
      }
    }
  }
}

/*

Write a function addSpeaker to add a speaker to the array of speakers.
The speaker you add must be an object with a key of name and a value of whatever you'd like. */
var addSpeaker = function(){
    var arr = nestedObject.speakers;
    var obj = {name:"Dan"};
    arr.push(obj);
    return nestedObject;
};
var j = addSpeaker();
//console.log(j);

/*
Write a function addLanguage that adds a language to the languages object.
The language object you add should have a key with the name of the language and the value of another object with a key of "hello"
and a value of however you spell "hello" in the language you add.*/
var addLang = function(){
    var arr = nestedObject.data.languages;
    arr['hindi'] = {'hello':'namaste'};
    return arr;
}

//console.log(addLang());

/*
Write a function addCountry that adds a European country to the countries object (inside of the continents object, inside of the countries object).
The country you add should be an object with the key as name of the country and the value as an object with the keys of "capital" and "population" and their respective values.
*/

var newCountry = {
    name: 'Spain',
    capital: 'Madrid',
    population: 5000
}

var addCountry = function(country){
    var arr = nestedObject.data.continents.europe.countries;
    arr[country.name] = {
        'capital': country.capital,
        'population': country.population
    };
    return arr;
}

console.log(addCountry(newCountry));
