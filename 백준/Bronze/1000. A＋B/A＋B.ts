const fs = require("fs");
const filePath = process.platform === "linux" ? "dev/stdin" : "input.txt";
const input = fs.readFileSync(filePath, 'utf8').toString().trim().split(" ");

let a = parseInt(input[0]);
let b = parseInt(input[1]);
console.log(a+b);