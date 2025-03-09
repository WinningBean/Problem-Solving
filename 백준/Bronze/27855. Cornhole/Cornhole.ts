const fs = require("fs");
const filePath = process.platform === "linux" ? "dev/stdin" : "input.txt";
const input = fs.readFileSync(filePath, 'utf8').toString().split("\n");

let P1 = input[0].split(" ").map(Number);
let P2 = input[1].split(" ").map(Number);
let score1 = P1[0] * 3 + P1[1];
let score2 = P2[0] * 3 + P2[1];

let result: string = "NO SCORE";
if (score1 > score2) {
    result = "1 " + (score1 - score2)
} else if (score2 > score1) {
    result = "2 " + (score2 - score1);
}

console.log(result);