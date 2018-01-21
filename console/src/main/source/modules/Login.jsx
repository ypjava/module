import React from 'react';
import ReactDOM from 'react-dom';
import './Login.css';

class Login extends React.Component {
    constructor(props) {
        super(props);
        this.state = {userName: '', password: ''};

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(e) {
        const name = e.target.name;
        this.setState({[name]: e.target.value});
    }

    handleSubmit(e) {
        // alert('A name was submitted: ' + this.state.userName + "  pwd: " + this.state.password);
        const params = {userName: this.state.userName, password: this.state.password};
        /*this.serverRequest = $.post(this.props.source, params, function(data) {
            alert(data);
        }.bind(this));*/
        // e.preventDefault();


        Utils.ajaxData({
            url: this.props.source,
            contentType: 'application/x-www-form-urlencoded',
            data: params,
            callback: function(result) {
                alert(result);
            }
        });
    }

    componentWillUnmount() {
        //this.serverRequest.abort();
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <label>
                    用户名123:
                    <input type="text" name="userName" value={this.state.userName} onChange={this.handleChange} />
                </label>
                <label>
                    密码:
                    <input type="password" name="password" value={this.state.password} onChange={this.handleChange} />
                </label>
                <input type="submit" value="Submit" />
            </form>
        );
    }
}

module.exports = Login;