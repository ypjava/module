import React from 'react';
import Reflux from 'reflux';

let Actions = Reflux.createActions([
    "statusUpdate",
    "statusEdited",
    "statusAdded"
]);

class StatusStore extends Reflux.Store {
    constructor() {
        super();
        this.state = {
            flag: 'OFFLINE'
        };
        // this.listenTo(Actions.statusUpdate, this.onStatusUpdate);
        this.listenables = Actions;
    }

    onStatusUpdate(status) {
        let newFlag = status ? 'ONLINE' : 'OFFLINE';
        this.setState({ flag: newFlag });
    }
}

class Test extends Reflux.Component {
    constructor(props) {
        super(props);
        this.state = {};
        this.store = StatusStore;
    }

    render() {
        let flag = this.state.flag;
        return <div>User is {flag}</div>
    }
}

module.exports = Test;