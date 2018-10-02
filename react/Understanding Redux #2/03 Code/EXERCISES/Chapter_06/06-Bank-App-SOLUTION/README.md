So, there are 2 exercises in here.

1.  Refactor the App’s state to be managed solely by Redux.
2.  Handle the withdrawal actions to actually deplete the user’s balance i.e on clicking the buttons, the balance reduces.

Let's walk through the solution - beginning with the easiest :)

# 1. Refactor the App's state to be managed solely by Redux.

You should be a pro at doing this now.

1.  Remove the state object from `App`
    i.e remove this:

```js
state = {
  username: "Janny",
  totalAmount: 2500701
};
```

2.  In App.js, replace the following line

```js
const { totalAmount, username } = this.state;
```

with this:

```js
const { totalAmount, username } = store.getState();
```

3.  Create the store. `store/index.js`

Firstly install redux: `yarn add redux`

Then here is the content for `store/index.js`

```js
import { createStore } from "redux";

const initialState = {
  username: "Janny",
  totalAmount: 2500701
};

const store = createStore(reducer, initialState);
export default store;
```

4.  Create the reducer. `reducers/index.js`

```js
const reducer = (state, action) => {
  return state;
};
export default reducer;
```

For now, the reducer doesn't really do much. THe `action` isn't even handled at this point.

5.  Import the just created `reducer` into `store/index.js`

```js
import reducer from ".../reducers";
```

6.  Import `store` in `App.js`

```js
import store from "./store";
```

That is it! The first exercise is done :)

# 2. Handle the withdrawal actions to actually deplete the user’s balance i.e on clicking the buttons, the balance reduces

Firstly define the shape of the action object. This looks good:

```js
{
  type: "WITHDRAWAL",
  payload: 10000
}
```

type is "WITHDRAWAL" and payload holds the amount to be withdrawn.

1.  Create an `actions` folder. In index.js, define the following action creator.

**actions/index.js**

```js
export const withdrawMoney = amount => ({
  type: "WITHDRAW",
  payload: amount
});
```

This will handle return the withdraw action with the right type and payload set!

2.  Import this action creator in App.js

```js
import { withdrawMoney } from "./actions";
```

3.  Add `onCLick` handlers to the buttons

e.g.

```html
<button data-amount="10000" onClick={handleWithdrawMoney}>
    WITHDRAW $10,000
</button>
```

4.  Now write the handler, `handleWithdrawMoney`

```js
const handleWithdrawMoney = e => {
  const amount = e.target.dataset.amount;
  store.dispatch(withdrawMoney(amount));
};
```

5.  Right now, actions are dispatched but they aren't handled in the reducer. Let's fix that.

**Refactor reducers/index.js**

**before:**

```js
const reducer = (state, action) => {
  return state;
};
export default reducer;
```

```js
const reducer = (state, action) => {
  switch (action.type) {
    case "WITHDRAW":
      return {
        ...state,
        totalAmount: state.totalAmount - action.payload
      };

    default:
      return state;
  }
};
export default reducer;
```

Note how we are returning a new object that has all the previous state keys (...state) and we only change `totalAmount` to equal the former value minus the amount in the action payload.

For example, if initial state was this:

```js
{
  username: "Janny",
  totalAmount: 2500701
};
```

upon dispatching a withdraw action with payload, `10000`

We should now have this:

```js
{
  username: "Janny",
  totalAmount: 2500701 - 10000
};
```

which results in:

```js
{
  username: "Janny",
  totalAmount: 2490701
};
```

6.  Finally, we need to re-render the app upon state upadtes.

**refactor the entry point of the app, index.js**

**before:**

```js
import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import App from "./App";
import registerServiceWorker from "./registerServiceWorker";

ReactDOM.render(<App />, document.getElementById("root"));
registerServiceWorker();
```

**now:**

```js
import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import App from "./App";
import registerServiceWorker from "./registerServiceWorker";
import store from "./store";

const render = () => ReactDOM.render(<App />, document.getElementById("root"));

render();
store.subscribe(render);

registerServiceWorker();
```

7.  Yeah! Now, if you click any of the buttons, the total amount will be depleted accordingly.

8.  Extra exercise.

(a)If you look below the buttons, you'll find a button that reads, _"Give away all your cash to charity"_

Upon clicking this button, deplete the user's total amount to 0 (zero)
They gave it all to charity :)

(b) Currently, if you click any of the "withdraw $10,000" or "withdraw $5000" buttons long enough, the user's balance will be depleted until it gets to zero.
Click even more and you'll get -ve values. That may or may not be acceptable.

How would you prevent -ve values in the state's total amount?

**Hint: use Math.max()**
That is, do this in the reducer:

```js
{
  ...state,
  totalAmount: Math.max(0, state.totalAmount - action.payload)
}
```
