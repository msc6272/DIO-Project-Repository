# Docker LAB

## Testing FastCGI PHP Container

In order to test the connection to the PHP Container some steps are necessary:

1. Access the bash console for the 'php-01' container
2. Install the FCGI package executing the command: apk add fcgi
3. Add the line 'pm.status_path = /status' to the end of the file '/usr/local/etc/php-fpm.conf'
4. Execute the command 'kill -HUP 1' to restart 'php-fpm'
5. Copy the file 'testFCGI.sh' to the container and execute it

If everything is right, you will receive some statistics about FastCGI PHP.

### Sources

[Directly connecting to PHP-FPM](https://www.thatsgeeky.com/2012/02/directly-connecting-to-php-fpm/)

[An alternative: How to use curl and telnet instead of cgi-fcgi?](https://serverfault.com/questions/1059428/how-to-use-curl-and-telnet-instead-of-cgi-fcgi)

## Integrating FastCGI with Apache

In order to integrate Apache and FastCGI the file 'httpd.conf' must be configured:

1. Uncomment the following lines: "LoadModule proxy_module modules/mod_proxy.so" e "LoadModule proxy_fcgi_module modules/mod_proxy_fcgi.so"
2. Include the following lines inside the your website information [Exemplo](https://www.otaviomiranda.com.br/2018/apache2-php-fpm-ubuntu-debian/)

```sh
<FilesMatch "\.php$">
        <If "-f %{SCRIPT_FILENAME}">
            SetHandler "proxy:fcgi://php-01:9000"
        </If>
</FilesMatch>
```

## More Info

[Alpine Linux Packages](https://pkgs.alpinelinux.org/packages?name=fcgi&branch=edge&repo=&arch=&maintainer=)

[Install 7.4 via Docker](https://prototype.php.net/versions/7.4/install/docker)

## Issues

It seems to have a problem with the PHP-FPM configuration that prevents the identification of a leading slash in the name of the PHP file. For example, if we use /test.php it is not found by the module. But, if we use test.php this is found. The problem is that the Apache sends the file name with the leading slash, so it is never found by the PHP-FPM. It needs to be fixed, but it haven't found any solution until now.
