var webpack = require('webpack');

module.exports = {
    devtool: 'eval-source-map',
    devServer: {
        historyApiFallback: true,
        hot: true,
        inline: true,
        contentBase: './webapp',
        progress: true,
        port: 8888
    },
    entry: __dirname + '/source/main.jsx',
    output: {
        path: __dirname + '/webapp/build',
        filename: './bundle.js',
        chunkFilename: '[name].[chunkhash:5].chunk.js'
    },
    module: {
        loaders: [{
            test: /\.css$/,
            loader: 'style-loader!css-loader'
        }, {
            test: /(\.jsx|\.js)$/,
            use: {
                loader: "babel-loader"
            },
            exclude: /node_modules/
        }]
    },
    plugins: []
};