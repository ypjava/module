import React from 'react';
import { Link } from 'react-router-dom';
import { Layout, Header, Footer, Sider, Content } from 'antd';

class Index extends React.Component {
    constructor(props) {
        super(props);
    }

    handleChange(e) {

    }

    handleSubmit(e) {

    }

    componentWillUnmount() {

    }

    render() {
        return (
            <div>
                <Layout>
                    <Header>header</Header>
                    <Layout>
                        <Sider>left sidebar</Sider>
                        <Content>main content</Content>
                        <Sider>right sidebar</Sider>
                    </Layout>
                    <Footer>footer</Footer>
                </Layout>
            </div>
        );
    }
}

module.exports = Index;