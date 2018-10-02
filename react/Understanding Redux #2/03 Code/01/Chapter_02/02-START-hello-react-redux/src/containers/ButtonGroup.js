import React from "react";
import { connect } from "react-redux";
import { setTechnology } from "../actions";

const ButtonGroup = ({ technologies, setTechnology }) => {
  function dispatchBtnAction(e) {
    const tech = e.target.dataset.tech;
    setTechnology(tech);
  }

  return (
    <div className="hello-btns">
      {technologies.map((tech, i) => (
        <button
          data-tech={tech}
          key={`btn-${i}`}
          className="hello-btn"
          onClick={dispatchBtnAction}
        >
          {tech}
        </button>
      ))}
    </div>
  );
};

export default connect(
  null,
  { setTechnology }
)(ButtonGroup);
