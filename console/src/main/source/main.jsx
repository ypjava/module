import React from 'react';
import ReactDOM from 'react-dom';
import Login from './modules/Login.jsx';
import Index from './modules/Index.jsx';

import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';

/*import './utils/Utils.jsx';
import data from './data.json';

let login = <Login source="/login" />;

const routes = {
    path: '/',
    //component: Index,
    /!*indexRoute: {
        getComponent() {
            require.ensure([], (require) => {
                let Component = require('./modules/UserList.jsx');
            }, 'HomePage');
        }
    },*!/
    childRoutes: [
        { path: 'workbench', component: Workbench },
        { path: 'user/list', component: UserList }
    ]
};*/

class App extends React.Component {
    render() {
        return (
            <Switch>
                <Route path="/login" component={Login} />
                <Route path="/index" component={Index} />
            </Switch>
        );
    }
}

ReactDOM.render((
    <Router>
        <Route path="/" component={App} />
    </Router>
), document.getElementById('root'));