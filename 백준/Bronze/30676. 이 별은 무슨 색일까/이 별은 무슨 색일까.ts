const fs = require("fs");
const filePath = process.platform === "linux" ? "dev/stdin" : "input.txt";
const input = fs.readFileSync(filePath, 'utf8').toString();

let num = parseInt(input);
let color: string;
if (num >= 620) {
    color = "Red";
} else if (num >= 590) {
    color = "Orange";
} else if (num >= 570) {
    color = "Yellow"
} else if (num >= 495) {
    color = "Green";
} else if (num >= 450) {
    color = "Blue";
} else if (num >= 425) {
    color = "Indigo";
} else {
    color = "Violet";
}

console.log(color);