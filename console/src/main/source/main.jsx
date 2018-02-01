import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import Login from './modules/Login.jsx';
import Index from './modules/Index.jsx';
import UserList from './modules/UserList.jsx';
import UserAdd from './modules/UserAdd.jsx';
import Clock from './modules/Clock.jsx';

import './utils/Utils.jsx';

let login = <Login source="/login" />;
ReactDOM.render((
    <Router>
        <div className="console">
            <Route exact path="/" component={Index}/>
            <Route exact path="/login" component={Login}/>
            <Route exact path="/user/list" component={UserList}/>
            <Route exact path="/user/add" component={UserAdd}/>
        </div>
    </Router>
), document.getElementById('root'));