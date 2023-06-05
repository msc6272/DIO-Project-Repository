#!/bin/sh
SCRIPT_NAME=test.php \
SCRIPT_FILENAME=test.php \
QUERY_STRING= \
REQUEST_METHOD=GET \
cgi-fcgi -bind -connect 127.0.0.1:9000
