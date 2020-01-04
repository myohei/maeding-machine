package company.wed.graphql

import graphql.ExecutionInput
import graphql.GraphQL
import graphql.language.OperationDefinition
import io.ktor.application.Application
import io.ktor.application.ApplicationCall
import io.ktor.application.call
import io.ktor.http.content.defaultResource
import io.ktor.http.content.static
import io.ktor.request.receive
import io.ktor.request.receiveText
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing
import org.koin.ktor.ext.inject
import org.slf4j.Logger
import org.slf4j.LoggerFactory

data class GraphQLRequest(
    val query: String? = "",
    val operationName: String? = "",
    val variables: Map<String, Any>? = emptyMap()
)


fun Application.installGql() {
    val schema: Schema by inject()
    val a = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME)
    val gql = schema.create()
    a.info(gql.toString())
    val graphql = GraphQL.newGraphQL(gql).build()
    suspend fun ApplicationCall.executeQuery() {
//        a.info(
//            receiveText().replace("\\s+".toRegex(), " ")
//        )
        val request = receive<GraphQLRequest>()
        a.info(request.toString())
        val executionInput = ExecutionInput.newExecutionInput()
            .context(ApplicationCallContext(this))
            .query(request.query ?: "")
            .operationName(request.operationName ?: "")
            .variables(request.variables ?: emptyMap())
            .build()
//        graphql.execute(executionInput)
        respond(graphql.execute(executionInput))
//        respond(graphql.executeAsync(executionInput))
    }

    routing {
        get("/graphql") {
            call.executeQuery()
        }
        post("/graphql") {
            call.executeQuery()
        }
        static("/graphiql") {
            defaultResource("static/graphiql/index.html")
        }
    }
}