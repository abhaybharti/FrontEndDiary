import React, { Fragment } from "react";
import FontAwesomeIcon from "./FontAwesomeIcon";
import StyledHeader from "./StyledHeader";
import StyledHeaderTitle from "./StyledHeaderTitle";
import { movies } from "../staticData";
import StyledHorizontalScroll from "./StyledHorizontalScroll";
import Movie from "./Movie";
import StyledFooter from "./StyledFooter";
import StyledLargeBtn from "./StyledLargeBtn";

const Movies = () => (
  <Fragment>
    <StyledHeader>
      <FontAwesomeIcon icon="bars" text="help" />
      <StyledHeaderTitle>The Movie Recommender</StyledHeaderTitle>
      <FontAwesomeIcon icon="search" />
    </StyledHeader>
    {/* the list of movies */}
    <StyledHorizontalScroll>
      {movies.map(movie => (
        <Movie
          key={movie.id}
          name={movie.name}
          poster={movie.poster}
          duration={movie.duration}
          year={movie.year}
        />
      ))}
    </StyledHorizontalScroll>
    <StyledFooter>
      <StyledLargeBtn>Get Recommended Movies</StyledLargeBtn>
    </StyledFooter>
  </Fragment>
);

export default Movies;
