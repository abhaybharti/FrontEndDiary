/*var count = 0;
for (var i = 0; i < 5; i++) {
console.log("count before + " + count);
count = count + i;
console.log("count is after + " + count + " " +i);
}
console.log("count is " + count);

//==============================
var tops = 5;
while (tops > 0) {
for (var spins = 0; spins < 3; spins++) {
console.log("Top is spinning!");
}
tops = tops - 1;
}*/


var word1 = "a";
var word2 = "nam";
var word3 = "nal p";
var word4 = "lan a c";
var word5 = "a man a p";
var phrase = "";

for (var i = 0; i < 4; i++) {
	if (i == 0) {
		phrase = word1;
	}
	else if (i == 1) {
		phrase = phrase + word4;
	}
	else if (i == 2) {
		phrase = phrase + word1 + word3;
	}
	else if (i == 3) {
		phrase = phrase + "________" + word2 + word1;
	}
}
console.log(phrase);