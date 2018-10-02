function logDate() {
  console.log(new Date());
}

function logAnimals(animals) {
  console.log(animals);
}

function sayBookName() {
  console.log("Understanding Redux #2");
}

/**
 * 1. Uncomment the next 4 lines to invoke the raw boring functions
 **/

// logDate();
// const animals = ["cat", "dog", "elephant"];
// logAnimals(animals);
// sayBookName();

function addFancyLogs(fn) {
  return function(...yourFunctionArguments) {
    //include added functionality here:
    console.group("Logger💅");
    console.log("%c Fancy log added 👇👇👇 ", "background:yellow;color:black;");

    //invoke the function parameter
    fn(...yourFunctionArguments);
    console.groupEnd();
  };
}

/**
 * 2. Uncomment the lines below to invoke the lovely fancy logger
 **/

const fancyLogDate = addFancyLogs(logDate);
fancyLogDate();

const fancyLogAnimals = addFancyLogs(logAnimals);
const animals = ["cat", "dog", "elephant"];
fancyLogAnimals(animals);

const fancySayBookName = addFancyLogs(sayBookName);
fancySayBookName();
