'use strict';

var webpack = require('webpack');
var path = require('path');
var CommonsChunkPlugin = webpack.optimize.CommonsChunkPlugin;
var HasteResolverPlugin = require('haste-resolver-webpack-plugin');

module.exports = {

    entry: {
        mainpage: './index.js'
    },
    output: {
        path: __dirname + '/assets',
        publicPath: "/assets/",
        filename: '[name]-bundle.js'
    },
    plugins: [
        new webpack.NoErrorsPlugin(),
        new HasteResolverPlugin({
            platform: 'web',
            nodeModules: ['react-web']
        }),
        new webpack.DefinePlugin({
            'process.env': {
                'NODE_ENV': JSON.stringify('development'),
            }
        })
        //new CommonsChunkPlugin({
        //    name: "mainpage"
        //})
    ],
    //resolve: {
    //    alias: {
    //        react: path.resolve(__dirname + '/node_modules/react')
    //    }
    //},
    module: {
        loaders: [

            {
                test: /\.css$/,
                loader: 'style-loader!css-loader'
            },

            {
                test: /\.(png|jpg|svg)$/,
                loaders: [
                    'url-loader?limit=8192',
                    'image-webpack?optimizationLevel=7&progressive=true']
            } // inline base64 URLs for <=8k images, direct URLs for the rest
        ]
    }


};