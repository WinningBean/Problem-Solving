const fs = require("fs");
const filePath = process.platform === "linux" ? "dev/stdin" : "input.txt";
const input = fs.readFileSync(filePath, 'utf8').toString();

let P = parseInt(input);
let left = 100 - P;

let cent25 = Math.floor(left / 25);
left %= 25;
let cent10 = Math.floor(left / 10);
left %= 10
let cent5 = Math.floor(left / 5);
left %= 5;
let cent1 = Math.floor(left / 1);

let result = `${cent25} ${cent10} ${cent5} ${cent1}`;
console.log(result);