#!/bin/sh

pass=`openssl passwd -crypt pass123`

# Creating folders
echo "Criando diretórios..."
mkdir /publico
mkdir /adm
mkdir /ven
mkdir /sec
echo "Diretórios criados!"

# Creating groups
echo "Criando grupos..."
groupadd GRP_ADM
groupadd GRP_VEN
groupadd GRP_SEC
echo "Grupos criados!"

# Creating users
echo "Criando usuários nos respectivos grupos..."
useradd carlos -m -s /bin/bash -G GRP_ADM -p $pass
useradd maria -m -s /bin/bash -G GRP_ADM -p $pass
useradd joao -m -s /bin/bash -G GRP_ADM -p $pass

useradd debora -m -s /bin/bash -G GRP_VEN -p $pass
useradd sebastiana -m -s /bin/bash -G GRP_VEN -p $pass
useradd roberto -m -s /bin/bash -G GRP_VEN -p $pass

useradd josefina -m -s /bin/bash -G GRP_SEC -p $pass
useradd amanda -m -s /bin/bash -G GRP_SEC -p $pass
useradd rogerio -m -s /bin/bash -G GRP_SEC -p $pass

echo "Usuários criados!"

# Defining folder permissions
echo "Definindo permissões nos diretórios..."
chown root:GRP_ADM /adm
chown root:GRP_VEN /ven
chown root:GRP_SEC /sec
chown root:root /publico

chmod 770 /adm
chmod 770 /ven
chmod 770 /sec
chmod 777 /publico

echo "Permissões definidas!"
