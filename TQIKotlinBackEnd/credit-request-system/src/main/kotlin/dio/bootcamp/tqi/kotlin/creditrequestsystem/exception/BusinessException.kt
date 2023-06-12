package dio.bootcamp.tqi.kotlin.creditrequestsystem.exception

data class BusinessException(override val message: String?): RuntimeException(message)