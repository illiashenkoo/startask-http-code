package net.codecision.startask.http.code

/**
 * Represents an HTTP status code.
 * @param value is a numeric code.
 */
@Suppress("unused")
data class HttpStatusCode(val value: Int) {

    override fun toString(): String = value.toString()

    override fun equals(other: Any?): Boolean = other is HttpStatusCode && other.value == value

    override fun hashCode(): Int = value.hashCode()

    /**
     * Checks if a given status code is a success code according to HTTP standards.
     *
     * Codes from 200 to 299 are considered to be successful.
     */
    fun isSuccess() = value in (200 until 300)

    fun isNotOk() = !isOk()

    fun isOk() = equals(OK)

    fun isCreated() = equals(Created)

    fun isNoContent() = equals(NoContent)

    fun isBadRequest() = equals(BadRequest)

    fun isUnauthorized() = equals(Unauthorized)

    fun isNotFound() = equals(NotFound)

    fun isInternalServerError() = equals(InternalServerError)

    companion object {

        /* Informational */

        val Continue = HttpStatusCode(100)
        val SwitchingProtocols = HttpStatusCode(101)
        val Processing = HttpStatusCode(102)

        /* Success */

        val OK = HttpStatusCode(200)
        val Created = HttpStatusCode(201)
        val Accepted = HttpStatusCode(202)
        val NonAuthoritativeInformation = HttpStatusCode(203)
        val NoContent = HttpStatusCode(204)
        val ResetContent = HttpStatusCode(205)
        val PartialContent = HttpStatusCode(206)
        val MultiStatus = HttpStatusCode(207)
        val AlreadyReported = HttpStatusCode(208)
        val IMUsed = HttpStatusCode(226)

        /* Redirection */

        val MultipleChoices = HttpStatusCode(300)
        val MovedPermanently = HttpStatusCode(301)
        val Found = HttpStatusCode(302)
        val SeeOther = HttpStatusCode(303)
        val NotModified = HttpStatusCode(304)
        val UseProxy = HttpStatusCode(305)
        val SwitchProxy = HttpStatusCode(306)
        val TemporaryRedirect = HttpStatusCode(307)
        val PermanentRedirect = HttpStatusCode(308)

        /* Client Error */

        val BadRequest = HttpStatusCode(400)
        val Unauthorized = HttpStatusCode(401)
        val PaymentRequired = HttpStatusCode(402)
        val Forbidden = HttpStatusCode(403)
        val NotFound = HttpStatusCode(404)
        val MethodNotAllowed = HttpStatusCode(405)
        val NotAcceptable = HttpStatusCode(406)
        val ProxyAuthenticationRequired = HttpStatusCode(407)
        val RequestTimeout = HttpStatusCode(408)
        val Conflict = HttpStatusCode(409)
        val Gone = HttpStatusCode(410)
        val LengthRequired = HttpStatusCode(411)
        val PreconditionFailed = HttpStatusCode(412)
        val PayloadTooLarge = HttpStatusCode(413)
        val RequestURITooLong = HttpStatusCode(414)

        val UnsupportedMediaType = HttpStatusCode(415)
        val RequestedRangeNotSatisfiable = HttpStatusCode(416)
        val ExpectationFailed = HttpStatusCode(417)
        val UnprocessableEntity = HttpStatusCode(422)
        val Locked = HttpStatusCode(423)
        val FailedDependency = HttpStatusCode(424)
        val UpgradeRequired = HttpStatusCode(426)
        val TooManyRequests = HttpStatusCode(429)
        val RequestHeaderFieldTooLarge = HttpStatusCode(431)

        val InternalServerError = HttpStatusCode(500)
        val NotImplemented = HttpStatusCode(501)
        val BadGateway = HttpStatusCode(502)
        val ServiceUnavailable = HttpStatusCode(503)
        val GatewayTimeout = HttpStatusCode(504)
        val VersionNotSupported = HttpStatusCode(505)
        val VariantAlsoNegotiates = HttpStatusCode(506)
        val InsufficientStorage = HttpStatusCode(507)

        /**
         * All known status codes
         */
        val allStatusCodes: List<HttpStatusCode> = allStatusCodes()

        private val byValue: Array<HttpStatusCode?> = Array(1000) { idx ->
            allStatusCodes.firstOrNull { it.value == idx }
        }

        /**
         * Creates an instance of [HttpStatusCode] with the given numeric value.
         */
        fun fromValue(value: Int): HttpStatusCode {
            val knownStatus = if (value in 1 until 1000) byValue[value] else null
            return knownStatus ?: HttpStatusCode(value)
        }
    }
}

internal fun allStatusCodes(): List<HttpStatusCode> = listOf(
    HttpStatusCode.Continue,
    HttpStatusCode.SwitchingProtocols,
    HttpStatusCode.Processing,
    HttpStatusCode.OK,
    HttpStatusCode.Created,
    HttpStatusCode.Accepted,
    HttpStatusCode.NonAuthoritativeInformation,
    HttpStatusCode.NoContent,
    HttpStatusCode.ResetContent,
    HttpStatusCode.PartialContent,
    HttpStatusCode.MultiStatus,
    HttpStatusCode.AlreadyReported,
    HttpStatusCode.IMUsed,
    HttpStatusCode.MultipleChoices,
    HttpStatusCode.MovedPermanently,
    HttpStatusCode.Found,
    HttpStatusCode.SeeOther,
    HttpStatusCode.NotModified,
    HttpStatusCode.UseProxy,
    HttpStatusCode.SwitchProxy,
    HttpStatusCode.TemporaryRedirect,
    HttpStatusCode.PermanentRedirect,
    HttpStatusCode.BadRequest,
    HttpStatusCode.Unauthorized,
    HttpStatusCode.PaymentRequired,
    HttpStatusCode.Forbidden,
    HttpStatusCode.NotFound,
    HttpStatusCode.MethodNotAllowed,
    HttpStatusCode.NotAcceptable,
    HttpStatusCode.ProxyAuthenticationRequired,
    HttpStatusCode.RequestTimeout,
    HttpStatusCode.Conflict,
    HttpStatusCode.Gone,
    HttpStatusCode.LengthRequired,
    HttpStatusCode.PreconditionFailed,
    HttpStatusCode.PayloadTooLarge,
    HttpStatusCode.RequestURITooLong,
    HttpStatusCode.UnsupportedMediaType,
    HttpStatusCode.RequestedRangeNotSatisfiable,
    HttpStatusCode.ExpectationFailed,
    HttpStatusCode.UnprocessableEntity,
    HttpStatusCode.Locked,
    HttpStatusCode.FailedDependency,
    HttpStatusCode.UpgradeRequired,
    HttpStatusCode.TooManyRequests,
    HttpStatusCode.RequestHeaderFieldTooLarge,
    HttpStatusCode.InternalServerError,
    HttpStatusCode.NotImplemented,
    HttpStatusCode.BadGateway,
    HttpStatusCode.ServiceUnavailable,
    HttpStatusCode.GatewayTimeout,
    HttpStatusCode.VersionNotSupported,
    HttpStatusCode.VariantAlsoNegotiates,
    HttpStatusCode.InsufficientStorage
)