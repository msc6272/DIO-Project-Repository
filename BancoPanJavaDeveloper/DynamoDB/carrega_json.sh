#!/bin/bash
if [ $# -eq 0 ]; then
	echo -e "\nErro: Argumento não fornecido!!!";
	echo -e "Sintaxe: ./carrega_json.sh <arquivo_JSON>\n";
	exit 1;
fi
registros=`grep -c 'PutRequest' $1`
# echo $registros
atual=0
while [ $atual -lt $registros ]; do
	# echo $atual;
	item=`jq .Northwind[$atual].PutRequest.Item $1`;
	echo $item > item.json;
	# echo $item;
	# echo "--------";
	aws dynamodb put-item --table-name Northwind --item file://item.json;
	# aws dynamodb put-item --table-name Northwind --item `echo -e $item | tr -d [:space:]`;
	# cat item.json;
	# rm -f item.json;
	atual=$((atual+1));
done
