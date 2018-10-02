# Steps to take

1. Create a `rateMovie` action creator in `actions/movieActions.js`

```js
export const rateMovie = createAction(RATE_MOVIE, (rating, movieId) => ({
  rating,
  movieId
}));
```

2. Expose this action creator in `MovieDetailsContainer`. This will make sure we can dispatch the action creator in the ``Movies` component.

```js
...
import { selectMovie, rateMovie } from "../actions/movieActions";

export default connect(
  mapStateToProps,
  {
    selectMovie,
    rateMovie
  }
)(MovieDetailsContainer);
```

3. In `MovieDetails.js`, add an `onChange` callback to the `ReactStars` component. This will be fired when a rating has been made. It will be called with the value of the rating - a number value between 1 to 5.

This onChange callback will dispatch the `rateMovie` action creator - with rating and movieId parameters.

```js
_handleRating = rating => {
    const movieId = +this.props.match.params.id;
    this.props.rateMovie(rating, movieId);
 };
...
<ReactStars
    count={5}
    size={24}
    color2={"#ffd700"}
    onChange={this._handleRating}
/>
...
```

View result: https://i.imgur.com/AFVH7zT.jpg

4. Handle the action in the reducers i.e add a "rating" field to the just rated movie.

In `reducers/movies.js`:

```js
  ...
  [RATE_MOVIE]: produce((state, action) => {
      const { movieId, rating } = action.payload;
      state[movieId].rating = rating;
  })
```

View result: https://i.imgur.com/aGauKBX.jpg

5. If a movie already has a rating, we want to show it. i.e if it is rated 4 out of 5, upon checking the movie details, we want the star to show the rating.

To do this, we must read the rating property from the movie state object - if it exists, then assign `ReactStars` a value prop.

In MovieDetails.js:

```js
...
const {
      poster,
      name,
      duration,
      details,
      year,
      rating //NOTE rating deconstructed here
    } = this.props.selectedMovie;
...

<ReactStars
    count={5}
    size={24}
    color2={"#ffd700"}
    value={rating} //SET the value here
    onChange={this._handleRating}
  />
```

View result: https://i.imgur.com/CATPTk4.png

You can go on to rate as many movies as you like now :)

NB:
Check the `componentDidMount` of the `Movies` component - there's something i did there you may wanna have a look at.
