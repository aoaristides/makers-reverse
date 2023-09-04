#!/bin/bash

##echo ### Criando Segredos no AWS Secret Manager do LocalStack...
##aws --endpoint http://localhost:4566 --profile localstack secretsmanager create-secret --name /secret/makersweb-reverse_consumer_localstack --description "Segredos para acesso a API da Marvel" --secret-string "{\"ts\":\"1685926279\",\"apiKey\":\"df755aa50238c2ba693230ceb631bfd5\",\"hash\":\"a887722811b5800a34eb8c40e10d48bd\"}"

echo ### Criando Chaves no AWS Parameter Store do LocalStack...
aws --endpoint http://localhost:4566 --profile localstack ssm put-parameter --name "/config/makersweb-reverse_consumer_localstack/receive.reverse.order.queue.name" --value "recebeReversaDoPedidoQueue" --type String
aws --endpoint http://localhost:4566 --profile localstack ssm put-parameter --name "/config/makersweb-reverse_consumer_localstack/reverse.by.billet.queue.name" --value "reversaPorBoletoQueue" --type String
aws --endpoint http://localhost:4566 --profile localstack ssm put-parameter --name "/config/makersweb-reverse_consumer_localstack/reverse.by.credit-card.queue.name" --value "reversaPorCartaoCreditoQueue" --type String
aws --endpoint http://localhost:4566 --profile localstack ssm put-parameter --name "/config/makersweb-reverse_consumer_localstack/reverse.by.debit-card.queue.name" --value "reversaPorCartaoDebitoQueue" --type String
aws --endpoint http://localhost:4566 --profile localstack ssm put-parameter --name "/config/makersweb-reverse_consumer_localstack/reverse.by.pix.queue.name" --value "reversaPorPixQueue" --type String

echo ### Criando Queue(Standard) no SQS do LocalStack...
aws --endpoint http://localhost:4566 --profile localstack sqs create-queue --queue-name recebeReversaDoPedidoQueue
aws --endpoint http://localhost:4566 --profile localstack sqs create-queue --queue-name reversaPorBoletoQueue
aws --endpoint http://localhost:4566 --profile localstack sqs create-queue --queue-name reversaPorCartaoCreditoQueue
aws --endpoint http://localhost:4566 --profile localstack sqs create-queue --queue-name reversaPorCartaoDebitoQueue
aws --endpoint http://localhost:4566 --profile localstack sqs create-queue --queue-name reversaPorPixQueue

echo ### Criando Queue(Standard) no SNS do LocalStack...
aws --endpoint http://localhost:4566 --profile localstack sns create-topic --name reversaRecebidaNotification
aws --endpoint http://localhost:4566 --profile localstack sns subscribe --topic-arn arn:aws:sns:us-east-1:000000000000:reversaRecebidaNotification --protocol sqs --notification-endpoint arn:aws:sqs:us-east-1:000000000000:recebeReversaDoPedidoQueue
aws --endpoint http://localhost:4566 --profile localstack sns subscribe --topic-arn arn:aws:sns:us-east-1:000000000000:reversaRecebidaNotification --protocol sqs --notification-endpoint arn:aws:sqs:us-east-1:000000000000:reversaPorBoletoQueue
aws --endpoint http://localhost:4566 --profile localstack sns subscribe --topic-arn arn:aws:sns:us-east-1:000000000000:reversaRecebidaNotification --protocol sqs --notification-endpoint arn:aws:sqs:us-east-1:000000000000:reversaPorCartaoCreditoQueue
aws --endpoint http://localhost:4566 --profile localstack sns subscribe --topic-arn arn:aws:sns:us-east-1:000000000000:reversaRecebidaNotification --protocol sqs --notification-endpoint arn:aws:sqs:us-east-1:000000000000:reversaPorCartaoDebitoQueue
aws --endpoint http://localhost:4566 --profile localstack sns subscribe --topic-arn arn:aws:sns:us-east-1:000000000000:reversaRecebidaNotification --protocol sqs --notification-endpoint arn:aws:sqs:us-east-1:000000000000:reversaPorPixQueue
