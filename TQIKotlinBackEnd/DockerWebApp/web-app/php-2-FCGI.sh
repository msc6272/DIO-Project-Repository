#!/bin/sh
SCRIPT_NAME=testing.php \
SCRIPT_FILENAME=testing.php \
QUERY_STRING= \
REQUEST_METHOD=GET \
cgi-fcgi -bind -connect php-01:9000
