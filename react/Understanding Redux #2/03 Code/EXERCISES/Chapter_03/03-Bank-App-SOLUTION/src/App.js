import React, { Component } from "react";
import formatNumber from "format-number";
import { connect } from "react-redux";
import { withdrawMoney, fetchUserDetails } from "./actions";
import "./App.css";

class App extends Component {
  static defaultProps = {
    username: "",
    totalAmount: 0,
    userPic: "",
    withdrawMoney: () => {},
    isLoading: true
  };

  componentDidMount() {
    this.props.fetchUserDetails();
  }

  render() {
    const handleWithdrawMoney = e => {
      const amount = e.target.dataset.amount;
      this.props.withdrawMoney(amount);
    };
    return (
      <div className={`${!this.props.isLoading ? "App" : "App App--loading"}`}>
        <img
          className="App__userpic"
          src={this.props.userPic}
          alt="user profile pic"
        />
        <p className="App__username">Hello, {this.props.username}! </p>
        <div className="App__amount">
          {formatNumber({ prefix: "$" })(this.props.totalAmount)}
          <p className="App__amount--info">Total Amount</p>
        </div>

        <section className="App__buttons">
          <button
            data-amount="10000"
            onClick={handleWithdrawMoney}
            disabled={this.props.isLoading}
          >
            WITHDRAW $10,000
          </button>
          <button
            data-amount="5000"
            onClick={handleWithdrawMoney}
            disabled={this.props.isLoading}
          >
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
  username: state.username,
  userPic: state.userPic,
  isLoading: state.isLoading
});

export default connect(
  mapStateToProps,
  {
    withdrawMoney,
    fetchUserDetails
  }
)(App);
