#!/bin/sh
SCRIPT_NAME=status \
SCRIPT_FILENAME=status \
QUERY_STRING= \
REQUEST_METHOD=GET \
cgi-fcgi -bind -connect 127.0.0.1:9000
