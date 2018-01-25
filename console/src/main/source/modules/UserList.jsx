import React from 'react';
import { Link } from 'react-router-dom';

class UserList extends React.Component {
    constructor(props) {
        super(props);
    }

    handleChange(e) {

    }

    handleSubmit(e) {

    }

    componentWillUnmount() {

    }

    render() {
        return (
            <div>
                <ul className="nav navbar-nav">
                    <li><Link to="/user/add">添加用户</Link></li>
                </ul>
                <div>用户列表</div>
            </div>
        );
    }
}

module.exports = UserList;