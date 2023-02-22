<?php

$servername = "3.89.24.236";
$username = "root";
$password = "Senha123";
$database = "meubanco";

// Criar conexão

$link = new msqli($servername, $username, $password, $database);

/* check connection */
if (mysqli_connect_errno()) {
    printf("Connect failed: %s\n", mysqli_connect_errno());
    exit();
}

?>