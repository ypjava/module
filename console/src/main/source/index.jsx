import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter, Route } from 'react-router-dom';
import Login from './modules/Login.jsx';
import Main from './modules/Main.jsx';
import Clock from './modules/Clock.jsx';

import './utils/Utils.jsx';

let login = <Login source="/login" />;
ReactDOM.render((
    <BrowserRouter>
        <div id="wrapper">
            {/*<ul className="nav navbar-nav">
                <li><Link to="/">首页</Link></li>
                <li><Link to="/login">登录</Link></li>
            </ul>*/}
            <Route exact path="/" component={Main}/>
            <Route exact path="/login" component={Login}/>
        </div>
    </BrowserRouter>
), document.getElementById('root'));