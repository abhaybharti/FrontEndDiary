import React from "react";
import StyledHeader from "./StyledHeader";
import StyledHeaderLink from "./StyledHeaderLink";
import FontAwesomeIcon from "./FontAwesomeIcon";

const MovieDetails = () => {
  return (
    <StyledHeader>
      <StyledHeaderLink href="/">
        <FontAwesomeIcon icon="chevron-left" text="Go back" />
      </StyledHeaderLink>
    </StyledHeader>
  );
};

export default MovieDetails;
