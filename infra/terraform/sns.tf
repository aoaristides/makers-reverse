# resource "aws_sns_topic" "reversaRecebidaNotification" {
#   name = "reversaRecebidaNotification-topic"
# }

# resource "aws_sns_topic_subscription" "reversaPorBoletoQueue_subscription" {
#   protocol             = "sqs"
#   raw_message_delivery = true
#   topic_arn            = aws_sns_topic.reversaRecebidaNotification.arn
#   endpoint             = aws_sqs_queue.reversaPorBoletoQueue.arn
# }

# resource "aws_sns_topic_subscription" "reversaPorCartaoCreditoQueue_subscription" {
#   protocol             = "sqs"
#   raw_message_delivery = true
#   topic_arn            = aws_sns_topic.reversaRecebidaNotification.arn
#   endpoint             = aws_sqs_queue.reversaPorCartaoCreditoQueue.arn
# }

# resource "aws_sns_topic_subscription" "reversaPorCartaoDebitoQueue_subscription" {
#   protocol             = "sqs"
#   raw_message_delivery = true
#   topic_arn            = aws_sns_topic.reversaRecebidaNotification.arn
#   endpoint             = aws_sqs_queue.reversaPorCartaoDebitoQueue.arn
# }

# resource "aws_sns_topic_subscription" "reversaPorPixQueue_subscription" {
#   protocol             = "sqs"
#   raw_message_delivery = true
#   topic_arn            = aws_sns_topic.reversaRecebidaNotification.arn
#   endpoint             = aws_sqs_queue.reversaPorPixQueue.arn
# }

# resource "aws_sqs_queue_policy" "reversaPorBoletoQueue_subscription" {
#   queue_url = aws_sqs_queue.reversaPorBoletoQueue.id
#   policy    = <<EOF
# {
#   "Version": "2012-10-17",
#   "Statement": [
#     {
#       "Effect": "Allow",
#       "Principal": {
#         "Service": "sns.amazonaws.com"
#       },
#       "Action": [
#         "sqs:SendMessage"
#       ],
#       "Resource": [
#         "${aws_sqs_queue.reversaPorBoletoQueue.arn}"
#       ],
#       "Condition": {
#         "ArnEquals": {
#           "aws:SourceArn": "${aws_sns_topic.reversaRecebidaNotification.arn}"
#         }
#       }
#     }
#   ]
# }
# EOF
# }

# resource "aws_sqs_queue_policy" "reversaPorCartaoCreditoQueue_subscription" {
#   queue_url = aws_sqs_queue.reversaPorCartaoCreditoQueue.id
#   policy    = <<EOF
# {
#   "Version": "2012-10-17",
#   "Statement": [
#     {
#       "Effect": "Allow",
#       "Principal": {
#         "Service": "sns.amazonaws.com"
#       },
#       "Action": [
#         "sqs:SendMessage"
#       ],
#       "Resource": [
#         "${aws_sqs_queue.reversaPorCartaoCreditoQueue.arn}"
#       ],
#       "Condition": {
#         "ArnEquals": {
#           "aws:SourceArn": "${aws_sns_topic.reversaRecebidaNotification.arn}"
#         }
#       }
#     }
#   ]
# }
# EOF
# }

# resource "aws_sqs_queue_policy" "reversaPorCartaoDebitoQueue_subscription" {
#   queue_url = aws_sqs_queue.reversaPorCartaoDebitoQueue.id
#   policy    = <<EOF
# {
#   "Version": "2012-10-17",
#   "Statement": [
#     {
#       "Effect": "Allow",
#       "Principal": {
#         "Service": "sns.amazonaws.com"
#       },
#       "Action": [
#         "sqs:SendMessage"
#       ],
#       "Resource": [
#         "${aws_sqs_queue.reversaPorCartaoDebitoQueue.arn}"
#       ],
#       "Condition": {
#         "ArnEquals": {
#           "aws:SourceArn": "${aws_sns_topic.reversaRecebidaNotification.arn}"
#         }
#       }
#     }
#   ]
# }
# EOF
# }

# resource "aws_sqs_queue_policy" "reversaPorPixQueue_subscription" {
#   queue_url = aws_sqs_queue.reversaPorPixQueue.id
#   policy    = <<EOF
# {
#   "Version": "2012-10-17",
#   "Statement": [
#     {
#       "Effect": "Allow",
#       "Principal": {
#         "Service": "sns.amazonaws.com"
#       },
#       "Action": [
#         "sqs:SendMessage"
#       ],
#       "Resource": [
#         "${aws_sqs_queue.reversaPorPixQueue.arn}"
#       ],
#       "Condition": {
#         "ArnEquals": {
#           "aws:SourceArn": "${aws_sns_topic.reversaRecebidaNotification.arn}"
#         }
#       }
#     }
#   ]
# }
# EOF
# }