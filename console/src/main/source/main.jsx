import React from 'react';
import ReactDOM from 'react-dom';
import Login from './modules/Login.jsx';
import Clock from './modules/Clock.jsx';

import './utils/Utils.jsx';

ReactDOM.render(
    <Login source="/login" />,
    document.getElementById('root')
);