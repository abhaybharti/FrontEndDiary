# High level overview

- In `Movies.js`, attach a click handler to the "Get Recommended Movies" Button.

```js
...
<StyledLargeBtn onClick={this._handleMovieRecommendations}>
  Get Recommended Movies
</StyledLargeBtn>
...
```

- The overview of what should be done in the handler looks likr this:

```js
...
_handleMovieRecommendations = () => {
    //get rated movies
    //if no rated movies so far, display toast asking user to rate at least one movie
    //else, dispatch getRecommendations action creator - pass ratedMovies parameter
    //make post request. data sent to the server is the list of rated movies
    //server then returns a list of recommended movies - in this case, the same as the rated movies :)
    //display the result from the api !
  };
...
```

Have a look at the complete code in `Movies.js`.

```js
...
 _handleMovieRecommendations = () => {
    //get rated movies
    const ratedMoviesList = this.props.movies.filter(movies => movies.rating);

    //if no rated movies so far, display toast asking user to rate at least one movie
    if (ratedMoviesList.length === 0) {
      this.props.showToast("error", rateAMovie); // rateAMovie = "Please rate at least one movie to view your personalized movie recommendations";
      return;
    }
    //else, dispatch getRecommendations action creator - pass ratedMovies parameter
    this.props.recommendMovies(ratedMoviesList); //recommendMovies action creator added via container. See movieactions.js
  };
...
```

Also, to handle loading states, the reducer `isLoading.js` has been edited.

**before:**

```js
...
export default handleActions(
  {
    [API_START]: produce((state, action) => {
      if (action.payload === GET_MOVIES) state[GET_MOVIES] = true;
    }),
    [API_END]: produce((state, action) => {
      if (action.payload === GET_MOVIES) state[GET_MOVIES] = false;
    })
  },
  {}
);
...
```

**now:**

```js
...
export default handleActions(
  {
    [API_START]: produce((state, action) => {
      if (action.payload === GET_MOVIES || GET_RECOMMENDED_MOVIES)
        state[GET_MOVIES] = true;
    }),
    [API_END]: produce((state, action) => {
      if (action.payload === GET_MOVIES || GET_RECOMMENDED_MOVIES)
        state[GET_MOVIES] = false;
    })
  },
  {}
);
...
```

Finally, in `apiPayloadCreator` in `appUtils.js`, the payload has been edited to include `data` to be sent to the server. in the event of a POST request. Please have a look.

**before:**

```js
const noOp = () => ({ type: "NO_OP" });

export const apiPayloadCreator = ({
  url = "/",
  method = "GET",
  onSuccess = noOp,
  onFailure = noOp,
  label = ""
}) => ({
  url,
  method,
  onSuccess,
  onFailure,
  label
});
```

**now:**

```js
const noOp = () => ({ type: "NO_OP" });

export const apiPayloadCreator = ({
  url = "/",
  method = "GET",
  onSuccess = noOp,
  onFailure = noOp,
  label = "",
  data = null
}) => ({
  url,
  method,
  onSuccess,
  onFailure,
  label,
  data
});
```

View result: https://i.imgur.com/KSJWBCU.jpg
