import React from 'react';
import { Redirect } from 'react-router-dom';
//import Index from './Index.jsx';
import './Login.css';

class Login extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            userName: '',
            password: '',
            redirectToReferrer: false
        };

        this.handleChange = this.handleChange.bind(this);
        this.login = this.login.bind(this);
    }

    handleChange(e) {
        const name = e.target.name;
        this.setState({[name]: e.target.value});
    }

    login() {
        // alert('A name was submitted: ' + this.state.userName + "  pwd: " + this.state.password);
        const params = {userName: this.state.userName, password: this.state.password};
        /*this.serverRequest = $.post(this.props.source, params, function(data) {
            alert(data);
        }.bind(this));*/
        // e.preventDefault();


        /*Utils.ajaxData({
            url: this.props.source,
            // contentType: 'application/x-www-form-urlencoded',
            data: params,
            callback: function(result) {
                alert(result.code);
            }
        });
        return false;*/

        auth.authenticate(() => {
            this.setState({ redirectToReferrer: true});
        });

    }

    componentWillUnmount() {
        //this.serverRequest.abort();
    }

    render() {
        const { redirectToReferrer } = this.state;

        if (redirectToReferrer) {
            return (
                <Redirect to="/"/>
            );
        }

        return (
            <form>
                <label>
                    用户名:
                    <input type="text" name="userName" value={this.state.userName} onChange={this.handleChange} />
                </label>
                <label>
                    密码:
                    <input type="password" name="password" value={this.state.password} onChange={this.handleChange} />
                </label>
                <button onClick={this.login}>登录</button>
            </form>
        );
    }
}

const auth = {
    isAuthenticated: false,
    authenticate(callback) {
        this.isAuthenticated = true;
        // setTimeout(callback, 100);
        callback();
    },
    logout(callback) {
        this.isAuthenticated = false;
        setTimeout(callback, 100);
    }
};

module.exports = Login;