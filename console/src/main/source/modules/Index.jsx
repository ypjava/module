import React from 'react';
import { Link } from 'react-router-dom';
import { Layout, Menu, Icon } from 'antd';

import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';

import Login from './Login.jsx';
import Workbench from './Workbench.jsx';
import UserList from './UserList.jsx';

import './Index.css';

const { Header, Sider, Content, Footer } = Layout;
const SubMenu = Menu.SubMenu;

class ConsoleFrame extends React.Component {
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
        console.log(e.key);
    }

    render() {
        return (
            <Layout className="console_index">
                <Sider trigger={ null } collapsible collapsed={ this.state.collapsed }>
                    <div className="logo" />
                    <Menu theme="dark" mode="inline" defaultSelectedKeys={['sub1']} onClick={this.handleClick}>
                        <Menu.Item key="sub1">
                            <Link to="/workbench">
                                <Icon type="home" />
                                <span>首页</span>
                            </Link>
                        </Menu.Item>
                        <SubMenu key="sub2" title={<span><Icon type="laptop" /><span>系统管理</span></span>}>
                            <SubMenu key="sub21" title={<span><Icon type="safety" /><span>权限管理</span></span>}>
                                <Menu.Item key="211"><Link to="/user/list">用户管理</Link></Menu.Item>
                                <Menu.Item key="212">角色管理</Menu.Item>
                                <Menu.Item key="213">菜单管理</Menu.Item>
                                <Menu.Item key="214">权限管理</Menu.Item>
                            </SubMenu>
                        </SubMenu>
                        <SubMenu key="sub3" title={<span><Icon type="notification" /><span>导航1</span></span>}>
                            <Menu.Item key="9">选项1</Menu.Item>
                            <Menu.Item key="10">选项2</Menu.Item>
                            <Menu.Item key="11">选项3</Menu.Item>
                            <Menu.Item key="12">选项4</Menu.Item>
                        </SubMenu>
                    </Menu>
                </Sider>
                <Layout style={{flexDirection: 'column'}}>
                    <Header style={{ background: '#fff', padding: 0 }}>
                        <Icon className="trigger" type={this.state.collapsed ? 'menu-unfold' : 'menu-fold'} onClick={ this.toggle } />
                    </Header>
                    <Content style={{ margin: '24px 16px', padding: 24, background: '#fff', height: 'auto' }}>
                        { this.props.children }
                        <Route path="/workbench" component={Workbench} />
                        <Route path="/user/list" component={UserList} />
                    </Content>
                    <Footer style={{ textAlign: 'center' }}>
                        React-Admin ©2018 Created by 414218798@qq.com
                    </Footer>
                </Layout>
            </Layout>
        );
    }
}

class Index extends React.Component {
    render() {
        return (
            <Router>
                <Switch>
                    <Route path="/login" component={Login} />
                    <Route path="/" component={ConsoleFrame} />
                </Switch>
            </Router>
        );
    }
}

module.exports = Index;