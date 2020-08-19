import $ from 'jquery';
import 'materialize-css';
import Dropzone from 'dropzone';
import React from 'react';
import ReactDom from 'react-dom';

// Dropzoneのドラッグ＆ドロップエリアエリアの設定
Dropzone.options.filedropzone = {
    paramName: 'file', // The name that will be used to transfer the file
    maxFilesize: 2, // MB
    dictDefaultMessage: '',
    thumbnaiHeight: 200,
    thumbnaiWidth: 200,
    init: function () {
        this.on('addedfile', function (file) {
            $('#overlaytext').val($('#overlaytext-shown').val());
            $('#overlaytextsize').val($('#overlaytextsize-shown').val());
        });
    },
    accept: function (file, done) {
        done();
        $('.dz-details').remove();
        $('.dz-progress').remove();
        $('.dz-error-message').remove();
        $('.dz-success-mark').remove();
        $('.dz-error-mark').remove();
    }
};

// Materializedの設定
$(function () {
    //Materialized Menu
    $('.button-collapse').sideNav();
}); // end of document ready