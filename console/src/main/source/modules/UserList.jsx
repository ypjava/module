import React from 'react';
import { Link } from 'react-router-dom';
import { Table, Icon, Divider, Button, Breadcrumb } from 'antd';
import Actions from './Actions.jsx';

const columns = [{
    title: 'Name',
    dataIndex: 'name',
    key: 'name',
    render: text => <a href="#">{text}</a>,
}, {
    title: 'Age',
    dataIndex: 'age',
    key: 'age',
}, {
    title: 'Address',
    dataIndex: 'address',
    key: 'address',
}, {
    title: 'Action',
    key: 'action',
    render: (text, record) => (
        <span>
            <a href="#">Action 一 {record.name}</a>
            <Divider type="vertical" />
            <a href="#">Delete</a>
            <Divider type="vertical" />
            <a href="#" className="ant-dropdown-link">
                More actions <Icon type="down" />
            </a>
        </span>
    ),
}];

const data = [{
    key: '1',
    name: 'John Brown',
    age: 32,
    address: 'New York No. 1 Lake Park',
}, {
    key: '2',
    name: 'Jim Green',
    age: 42,
    address: 'London No. 1 Lake Park',
}, {
    key: '3',
    name: 'Joe Black',
    age: 32,
    address: 'Sidney No. 1 Lake Park',
}];


class UserList extends React.Component {
    constructor(props) {
        super(props);
        this.add = this.add.bind(this);
    }

    componentWillMount() {

    }

    componentWillUnmount() {

    }

    add() {
        console.log("添加用户");
        Actions.updateComponent("UserAdd");
    }

    render() {
        return (
            <div>
                <Breadcrumb>
                    <Breadcrumb.Item>系统管理</Breadcrumb.Item>
                    <Breadcrumb.Item>权限管理</Breadcrumb.Item>
                    <Breadcrumb.Item>用户管理</Breadcrumb.Item>
                </Breadcrumb>
                <div className="table-operations">
                    <Button onClick={this.add}>添加</Button>
                    <Button onClick={this.clearFilters}>删除</Button>
                </div>
                <Table columns={columns} dataSource={data} bordered />
            </div>
        );
    }
}

module.exports = UserList;