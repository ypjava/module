import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import Login from './modules/Login.jsx';
//import Index from './modules/Index.jsx';
import UserList from './modules/UserList.jsx';
import UserAdd from './modules/UserAdd.jsx';
import Clock from './modules/Clock.jsx';
//import Test from './modules/Test.jsx';
import RoleList from './modules/RoleList.jsx';

import './utils/Utils.jsx';
import data from './data.json';

let login = <Login source="/login" />;

const rootRoute = {
    path: '/',
    indexRoute: {
        getComponent() {
            require.ensure([], (require) => {
                let Component = require('./modules/UserList.jsx');
            }, 'HomePage');
        }
    }
};

ReactDOM.render((
    <Router>
        <div className="console">
            {/*<Route exact path="/" component={Index}/>*/}
            {
                React.Children.map(data, function (route) {
                    return <Route exact path={ route.path } component={ route.code }/>;
                })
            }
            {/*<Route exact path="/login" component={Login}/>
            <Route exact path="/user/list" component={UserList}/>
            <Route exact path="/role/list" component={RoleList}/>
            <Route exact path="/user/add" component={UserAdd}/>*/}
            {/*<Route exact path="/test" component={Test}/>*/}
        </div>
    </Router>
), document.getElementById('root'));