function spreadOut() {
  let fragment = ['to', 'code'];
  fragment.unshift('learning');
  fragment.push("is");
  fragment.push("fun");
  let sentence = [...fragment]; // change this line
  return sentence;
}

// do not change code below this line
console.log(spreadOut());

