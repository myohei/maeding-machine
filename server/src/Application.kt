package company.wed

import com.fasterxml.jackson.databind.SerializationFeature
import company.wed.data.db.MysqlDbConnector
import company.wed.data.repositories.repositoryModule
import company.wed.features.lucky.luckyModule
import company.wed.graphql.gqlModule
import company.wed.graphql.installGql
import company.wed.routes.setupRoutes
import company.wed.services.serviceModule
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.*
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.jackson.jackson
import io.ktor.request.path
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.sessions.Sessions
import io.ktor.sessions.cookie
import org.koin.Logger.slf4jLogger
import org.koin.ktor.ext.Koin
import org.slf4j.event.Level
import java.time.Duration
import kotlin.collections.set


fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)


@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    val dbConnector = MysqlDbConnector(
        dbUrl,
        dbUseName,
        dbPassword
    )
    val db = dbConnector.connect()
    install(Koin) {
        slf4jLogger(org.koin.core.logger.Level.INFO)
        modules(repositoryModule)
        modules(serviceModule)
        modules(gqlModule)
        modules(luckyModule)
        modules(org.koin.dsl.module(createdAtStart = true) {
            single { db }
        })
    }
    installGql()
    install(Sessions) {
        cookie<MySession>("MY_SESSION") {
            cookie.extensions["SameSite"] = "lax"
            cookie.path = "/"
            cookie.duration = Duration.ofMinutes(10)
        }
    }

    install(Compression) {
        gzip {
            priority = 1.0
        }
        deflate {
            priority = 10.0
            minimumSize(1024) // condition
        }
    }

    install(CallLogging) {
        level = Level.INFO
        filter { call -> call.request.path().startsWith("/") }
    }
    install(ConditionalHeaders)
    install(DataConversion)
    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }

    routing {
        setupRoutes()
        get("/") {
            call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
        }
        install(StatusPages) {
            exception<AuthenticationException> { cause ->
                call.respond(HttpStatusCode.Unauthorized)
            }
            exception<AuthorizationException> { cause ->
                call.respond(HttpStatusCode.Forbidden)
            }
        }

        get("/json/jackson") {
            call.respond(mapOf("hello" to "world"))
        }
    }
}

data class MySession(val count: Int = 0)

class AuthenticationException : RuntimeException()
class AuthorizationException : RuntimeException()

fun Application.getEnv(key: String): String = environment.config.property(key).getString()
val Application.dbUrl get() = getEnv("database.url")
val Application.dbUseName get() = getEnv("database.username")
val Application.dbPassword get() = getEnv("database.password")


