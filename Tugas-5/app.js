const math = require('./math');
const string = require('./string');
const array = require('./array');
const object = require('./object');

console.log(math.add(2, 3));
console.log(string.capitalize('hello'));
console.log(array.findMax([1, 2, 3, 4, 5]));
console.log(object.getKeys({ a: 1, b: 2, c: 3 }));