package com.hamzeh.kmp_networking_and_data_storage.data.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.network.sockets.ConnectTimeoutException
import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.http.headersOf
import io.ktor.serialization.kotlinx.json.json
import io.ktor.util.network.UnresolvedAddressException
import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.serialization.json.Json
import kotlin.coroutines.cancellation.CancellationException

fun apiClient(baseUrl: String, ) = HttpClient {
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
        })
    }
    install(Logging) {
        logger = Logger.SIMPLE
        level = LogLevel.ALL
    }

    defaultRequest {
        url(baseUrl)
        contentType(ContentType.Application.Json)
    }
}

suspend inline fun <T> safeApiCall(apiCall: suspend () -> T): Result<T> {
    return try {
        // Execute the API call
        val response = apiCall()
        Result.success(response)
    } catch (e: RedirectResponseException) {
        // 3xx errors
        Result.failure(Exception("Redirect error: ${e.response.status.description}"))
    } catch (e: ClientRequestException) {
        // 4xx errors
        Result.failure(Exception("Client request error: ${e.response.status.description}"))
    } catch (e: ServerResponseException) {
        // 5xx errors
        Result.failure(Exception("Server response error: ${e.response.status.description}"))
    } catch (e: TimeoutCancellationException) {
        // Request timeout
        Result.failure(Exception("Request timeout"))
    } catch (e: ConnectTimeoutException) {
        // Connection timeout
        Result.failure(Exception("Connection timeout"))
    } catch (e: SocketTimeoutException) {
        // Socket timeout
        Result.failure(Exception("Socket timeout"))
    } catch (e: UnresolvedAddressException) {
        // No internet connection or wrong URL
        Result.failure(Exception("No internet connection or invalid URL"))
    } catch (e: CancellationException) {
        // Coroutine was canceled
        Result.failure(Exception("Request was canceled"))
    } catch (e: IOException) {
        // Handle IO exceptions (e.g., network issues)
        Result.failure(Exception("Network I/O error: ${e.message}"))
    } catch (e: Exception) {
        // Generic error handling
        Result.failure(Exception("An unknown error occurred: ${e.message}"))
    }
}