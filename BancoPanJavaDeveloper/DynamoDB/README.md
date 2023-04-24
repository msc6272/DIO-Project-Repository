# DynamoDB Good Practices - Lab Project

Repository for the referenced project

## Requirements

* Amazon DynamoDB
* Amazon CloudShell (for command line execution)

## First Steps

1. Upload all the files from the json folder to your Amazon CloudShell session
2. Upload "carrega_json.sh" script to your Amazon CloudShell session (don't forget to give it execution permission)

## Commands used on Amazon CloudShell

* Creating the table

```sh
aws dynamodb create-table \
     --table-name Northwind \
     --attribute-definitions \
         AttributeName=pk,AttributeType=S \
         AttributeName=sk,AttributeType=S \
         AttributeName=data,AttributeType=S \
     --key-schema \
         AttributeName=pk,KeyType=HASH \
         AttributeName=sk,KeyType=RANGE \
     --global-secondary-indexes \
         '[{"IndexName":"gsi_1",
           "KeySchema":[{"AttributeName":"sk","KeyType":"HASH"},{"AttributeName":"data","KeyType":"RANGE"}],
           "Projection":{"ProjectionType":"ALL"}}]' \
     --billing-mode PAY_PER_REQUEST
```

* Inserting the first item for the Categories dataset

```sh
aws dynamodb put-item \
    --table-name Northwind \
    --item '{"pk": {"S": "categories#1"}, "sk": {"S": "Beverages"},
             "data": {"S": "Soft drinks coffees teas beers and ales"},
             "picture": {"S": "0x151C2F00020000000D000E0014002100FFFFFFFF4269746D617020496D616765005061696E742E5069637475726500010500000200000007000000504272757368000000000000000000A0290000424D98290000000000005600000028000000AC00000078000000010004000000000000000000880B0000880B0000080000"}}'
```

* Inserting another item for the Categories dataset

```sh
aws dynamodb put-item \
    --table-name Northwind \
    --item '{"pk": {"S": "categories#2"}, "sk": {"S": "Condiments"},
             "data": {"S": "Sweet and savory sauces relishes spreads and seasonings"},
             "picture": {"S": "0x151C2F00020000000D000E0014002100FFFFFFFF4269746D617020496D616765005061696E742E5069637475726500010500000200000007000000504272757368000000000000000000A0290000424D98290000000000005600000028000000AC00000078000000010004000000000000000000880B0000880B0000080000"}}'
```

* Inserting multiple item for the Categories dataset (remaining items)

```sh
aws dynamodb batch-write-item --request-items file://categories_3-8.json
```

* Inserting items for the remaining datasets

```sh
./carrega_json.sh customers.json
./carrega_json.sh employees.json
./carrega_json.sh order_details.json
./carrega_json.sh orders.json
./carrega_json.sh products.json
./carrega_json.sh shippers.json
./carrega_json.sh suppliers.json
```

* Query employee by employee ID

```sh
aws dynamodb query --table-name Northwind --key-condition-expression "pk=:partitionkey" --expression-attribute-values '{":partitionkey":{"S": "employees#2"}}'
```

* Query subordinates for an employee

```sh
aws dynamodb query --table-name Northwind --index-name gsi_1 --key-condition-expression "sk=:partitionkey" --expression-attribute-values '{":partitionkey":{"S": "employees#2"}}'
```

* Query discontinued products

```sh
aws dynamodb query --table-name Northwind --index-name gsi_1 --key-condition-expression "sk=:partitionkey and #data=:sortkey" --expression-attribute-values '{":partitionkey":{"S": "PRODUCT"}, ":sortkey":{"S": "1"}}' --expression-attribute-names '{"#data": "data"}'
```

* Query all orders of a given product

```sh
aws dynamodb query --table-name Northwind --index-name gsi_1 --key-condition-expression "sk=:partitionkey" --expression-attribute-values '{":partitionkey":{"S": "products#1"}}'
```

* Query the most recent 25 orders

```sh
aws dynamodb query --table-name Northwind --index-name gsi_1 --key-condition-expression "sk=:partitionkey" --expression-attribute-values '{":partitionkey":{"S": "ORDER"}}' --limit=25
```

* Query shippers by name

```sh
aws dynamodb query --table-name Northwind --index-name gsi_1 --key-condition-expression "sk=:partitionkey" --expression-attribute-values '{":partitionkey":{"S": "United Package"}}'
```

* Query customers by contact name

```sh
aws dynamodb query --table-name Northwind --index-name gsi_1 --key-condition-expression "sk=:partitionkey" --expression-attribute-values '{":partitionkey":{"S": "Maria Anders"}}'
```

* Query all products included in an order

```sh
aws dynamodb query --table-name Northwind --key-condition-expression "pk=:partitionkey and begins_with(sk, :sortkey)" --expression-attribute-values '{":partitionkey":{"S": "10260"}, ":sortkey":{"S": "product"}}'
```

* Query suppliers by country and region

```sh
aws dynamodb query --table-name Northwind --index-name gsi_1 --key-condition-expression "sk=:partitionkey and begins_with(#data, :sortkey)" --expression-attribute-values '{":partitionkey":{"S": "SUPPLIER"}, ":sortkey":{"S": "Germany#NULL"}}' --expression-attribute-names '{"#data": "data"}'
```

## Notes

The idea for this project was borrowed from the article [From relational DB to single DynamoDB table: a step-by-step exploration](https://www.trek10.com/blog/dynamodb-single-table-relational-modeling/) and adapted for the same environment addressed in class.

The whole idea of this project is much more advanced than that of the challenge description and sample project. Many problems had arisen: some because there are many limitations for DynamoDB and others because the whole implementation is not intuitive. For example: there is a limitation of 25 put item operations when using the 'batch-write-item' command and; the idea of a single-table implementation is very confusing for developers using relational databases.

## Useful Links

[Example of modeling relational data in DynamoDB](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/bp-modeling-nosql-B.html)

[Data Modeling Overview](https://www.dynamodbguide.com/data-modeling-overview/)

[The What, Why, and When of Single-Table Design with DynamoDB](https://www.alexdebrie.com/posts/dynamodb-single-table/)

[DynamoDB Deep Dive: Advanced Design Patterns](https://aws.amazon.com/dynamodb/resources/reinvent-2019-advanced-design-patterns/)

[Tool to format/fix JSON](https://jsonformatter.curiousconcept.com/#)

[Amazon DynamoDB - single table design](https://getindata.com/blog/amazon-aws-dynamodb-single-table-design/)

[Modelling a product catalog in DynamoDB](https://www.tecracer.com/blog/2021/03/modelling-a-product-catalog-in-dynamodb.html)

[Part 1: Refactoring to single-table design in Amazon DynamoDB](https://emshea.com/post/part-1-dynamodb-single-table-design)

[Fundamentals of Amazon DynamoDB Single Table Design with Rick Houlihan](https://www.youtube.com/watch?v=KYy8X8t4MB8)

[Using the Single Table design on AWS DynamoDB](https://awstip.com/using-the-single-table-design-on-aws-dynamodb-65a9480bd0c5)

[WORKSHOP: ADVANCED DESIGN PATTERNS FOR AMAZON DYNAMODB](https://amazon-dynamodb-labs.com/design-patterns.html)
