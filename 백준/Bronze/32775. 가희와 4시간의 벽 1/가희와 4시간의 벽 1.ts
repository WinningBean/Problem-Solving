const fs = require("fs");
const filePath = process.platform === "linux" ? "dev/stdin" : "input.txt";
const input = fs.readFileSync(filePath, 'utf8').toString().split("\n");

let S = parseInt(input[0]);
let F = parseInt(input[1]);

let result: string = S > F ? "flight" : "high speed rail";

console.log(result);