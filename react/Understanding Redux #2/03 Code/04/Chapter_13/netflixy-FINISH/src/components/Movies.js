import React, { Component, Fragment } from "react";
import PropTypes from "prop-types";
import FontAwesomeIcon from "./FontAwesomeIcon";
import StyledHeader from "./StyledHeader";
import StyledHeaderTitle from "./StyledHeaderTitle";
import StyledHorizontalScroll from "./StyledHorizontalScroll";
import Movie from "./Movie";
import StyledFooter from "./StyledFooter";
import StyledLargeBtn from "./StyledLargeBtn";
import HelpMenuContainer from "../containers/HelpMenuContainer";
import StyledLoader from "./StyledLoader";
import StyledMovieLink from "./StyledMovieLink";

class Movies extends Component {
  state = {};
  static defaultProps = {
    movies: [],
    loading: true
  };
  static propTypes = {
    movies: PropTypes.arrayOf(PropTypes.object)
  };

  componentDidMount() {
    this.props.getMovies();
  }

  render() {
    return (
      <Fragment>
        <StyledHeader>
          {/* Help icon extracted to a separate component */}
          <HelpMenuContainer />
          <StyledHeaderTitle>The Movie Recommender</StyledHeaderTitle>
          <FontAwesomeIcon icon="search" />
        </StyledHeader>
        {/* the list of movies */}
        <StyledHorizontalScroll>
          {this.props.loading ? (
            <StyledLoader />
          ) : (
            this.props.movies.map(movie => (
              <StyledMovieLink href={`/movies/${movie.id}`} key={movie.id}>
                <Movie
                  name={movie.name}
                  poster={movie.poster}
                  duration={movie.duration}
                  year={movie.year}
                />
              </StyledMovieLink>
            ))
          )}
        </StyledHorizontalScroll>
        <StyledFooter>
          <StyledLargeBtn>Get Recommended Movies</StyledLargeBtn>
        </StyledFooter>
      </Fragment>
    );
  }
}

export default Movies;
