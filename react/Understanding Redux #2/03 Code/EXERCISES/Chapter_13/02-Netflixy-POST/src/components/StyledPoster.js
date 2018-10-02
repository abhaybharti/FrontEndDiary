import styled from "styled-components";
import { devices } from "../utils/styledUtils";

const StyledPoster = styled.img`
  ${"" /* width and height now check if the "isExpanded" prop exists */}
  width: ${props =>
    props.isExpanded
      ? props.theme.posterWidthExpanded
      : props.theme.posterWidth};
  height: ${props =>
    props.isExpanded
      ? props.theme.posterHeightExpanded
      : props.theme.posterHeight};
  border-radius: 4px;
  ${"" /* extra styling if the movie has prop, isExpanded */}
  ${devices.md`
    position: ${props => (props.isExpanded ? "absolute" : "initial")};
    top: ${props => (props.isExpanded ? "-10%" : "initial")};
    left: ${props => (props.isExpanded ? "-6%" : "initial")};
  `}
`;

export default StyledPoster;
