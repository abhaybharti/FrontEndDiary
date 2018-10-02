import React, { Component } from "react";
import formatNumber from "format-number";
import { connect } from "react-redux";
import { withdrawMoney } from "./actions";
import photographer from "./images/girl.png";
import "./App.css";

class App extends Component {
  render() {
    const handleWithdrawMoney = e => {
      const amount = e.target.dataset.amount;
      this.props.withdrawMoney(amount);
    };

    return (
      <div className="App">
        <img className="App__userpic" src={photographer} alt="user" />
        <p className="App__username">Hello, {this.props.username}! </p>
        <div className="App__amount">
          {formatNumber({ prefix: "$" })(this.props.totalAmount)}
          <p className="App__amount--info">Total Amount</p>
        </div>

        <section className="App__buttons">
          <button data-amount="10000" onClick={handleWithdrawMoney}>
            WITHDRAW $10,000
          </button>
          <button data-amount="5000" onClick={handleWithdrawMoney}>
            WITHDRAW $5,000
          </button>
        </section>

        <p className="App__giveaway">Give away all your cash to charity</p>
      </div>
    );
  }
}

const mapStateToProps = state => ({
  totalAmount: state.totalAmount,
  username: state.username
});

export default connect(
  mapStateToProps,
  {
    withdrawMoney
  }
)(App);
