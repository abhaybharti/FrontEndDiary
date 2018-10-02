import styled from "styled-components";
import { devices } from "../utils/styledUtils";

const StyledMovieContainer = styled.section`
  background: ${props => props.theme.secondaryBg};
  width: 100%;
  height: 100vh;
  padding: 1rem;
  display: flex;
  flex-direction: column;

  ${devices.md`
    width: 640px;
    height: 390px;
    border-radius: 15px;
  `};
`;

export default StyledMovieContainer;
