package company.wed

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.sessions.*
import io.ktor.features.*
import org.slf4j.event.*
import com.fasterxml.jackson.databind.*
import company.wed.data.db.MysqlDbConnector
import company.wed.routes.setupRoutes
import company.wed.services.SetupService
import company.wed.services.impl.SetupServiceImpl
import company.wed.services.serviceModule
import io.ktor.jackson.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.name
import org.koin.Logger.slf4jLogger
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.koin.ktor.ext.Koin


fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

val a = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME)
@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    val graphQLSchemaString = requireNotNull(this::class.java.classLoader.getResource("schema.graphql")).readText()
//    a.info(graphQLSchemaString)

    val dbConnector = MysqlDbConnector(
        dbUrl,
        dbUseName,
        dbPassword
    )
    val db = dbConnector.connect()
    install(Koin) {
        slf4jLogger()
        modules(serviceModule)
        modules(org.koin.dsl.module(createdAtStart = true) {
            single { db }
        })
    }

    install(Sessions) {
        cookie<MySession>("MY_SESSION") {
            cookie.extensions["SameSite"] = "lax"
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
        get("/session/increment") {
            val session = call.sessions.get<MySession>() ?: MySession()
            call.sessions.set(session.copy(count = session.count + 1))
            call.respondText("Counter is ${session.count}. Refresh to increment.")
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


