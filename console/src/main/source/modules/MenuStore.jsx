import Reflux from 'reflux';
import UserList from './UserList.jsx';

const Actions = Reflux.createActions([
    "statusUpdate",
    "statusEdited",
    "statusAdded"
]);

class MenuStore extends Reflux.Store {
    constructor() {
        super();
        this.state = {
            flag: 'OFFLINE',
            content: ''
        };
        // this.listenTo(Actions.statusUpdate, this.onStatusUpdate);
        this.listenables = Actions;
    }

    onStatusUpdate(status) {
        // let newFlag = status ? 'ONLINE' : 'OFFLINE';
        this.setState({ content: UserList });
    }
}

class Nav extends Reflux.Component {
    constructor(props) {
        super(props);
        this.state = {};
        this.store = MenuStore;
    }

    render() {
        let flag = this.state.flag;
        return <div>User is {flag}</div>
    }
}

module.exports = { Actions, MenuStore };