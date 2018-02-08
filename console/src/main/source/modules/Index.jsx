import React from 'react';
import { Link } from 'react-router-dom';
import { Layout, Menu, Icon } from 'antd';
import Reflux from 'reflux';
import Actions from './Actions.jsx';

import data from '../data.json';
import Workbench from './Workbench.jsx';

import './Index.css';

const { Header, Sider, Content, Footer } = Layout;
const SubMenu = Menu.SubMenu;

/*const Actions = Reflux.createActions([
    "updateComponent"
]);*/

class StatusStore extends Reflux.Store {
    constructor() {
        super();
        this.state = {};
        // this.listenTo(Actions.statusUpdate, this.onStatusUpdate);
        this.listenables = Actions;
    }

    onUpdateComponent(code) {
        require.ensure([], (require) => {
            let ConsoleComponent = require('./' + code + '.jsx');
            this.setState({ content: <ConsoleComponent /> });
        }, 'modules');
    }
}

class CustomContent extends Reflux.Component {
    constructor(props) {
        super(props);
        this.state = { content: <Workbench /> };
        this.store = StatusStore;
    }

    render() {
        let content = this.state.content;
        return <div>{content}</div>;
    }
}

class Index extends React.Component {
    constructor(props) {
        super(props);
        this.state = { collapsed: false };
        this.toggle = this.toggle.bind(this);
        this.handleClick = this.handleClick.bind(this);
    }

    toggle() {
        this.setState({
            collapsed: ! this.state.collapsed,
        });
    }

    handleClick(e) {
        if (e.item.props.code) {
            Actions.updateComponent(e.item.props.code);
        }
    }

    initSubMenu(menuList) {
        let menuNodes = menuList.map((menu) => {
            if (menu.children.length > 0) {
                return (
                    <SubMenu key={menu.id} title={<span><Icon type={menu.icon} /><span>{menu.name}</span></span>}>
                        {this.initSubMenu(menu.children)}
                    </SubMenu>
                );
            }

            if (menu.icon) {
                return (
                    <Menu.Item key={menu.id} code={menu.code}>
                        <Icon type={menu.icon} />
                        <span>{menu.name}</span>
                    </Menu.Item>
                );
            }
            return (<Menu.Item key={menu.id} code={menu.code}>{menu.name}</Menu.Item>);
        });
        return menuNodes;
    }

    componentDidMount() {

    }

    render() {
        return (
            <Layout className="console_index">
                <Sider trigger={ null } collapsible collapsed={ this.state.collapsed }>
                    <div className="logo" />
                    <Menu theme="dark" mode="inline" defaultSelectedKeys={['1']} onClick={this.handleClick}>
                        {
                            this.initSubMenu(data)
                        }
                    </Menu>
                </Sider>
                <Layout style={{flexDirection: 'column'}}>
                    <Header style={{ background: '#fff', padding: 0 }}>
                        <Icon className="trigger" type={this.state.collapsed ? 'menu-unfold' : 'menu-fold'} onClick={ this.toggle } />
                    </Header>
                    <Content style={{ margin: '24px 16px', padding: 24, background: '#fff', height: 'auto' }}>
                        <CustomContent />
                    </Content>
                    <Footer style={{ textAlign: 'center' }}>
                        React-Admin ©2018 Created by 414218798@qq.com
                    </Footer>
                </Layout>
            </Layout>
        );
    }
}

module.exports = Index;