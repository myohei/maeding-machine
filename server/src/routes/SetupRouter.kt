package company.wed.routes

import company.wed.services.SetupService
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route
import org.koin.ktor.ext.inject

fun Route.setupRoutes() {
    val setupService by inject<SetupService>()
    route("/setup") {
        post {
            setupService.setup()
            call.respond("success")
        }
    }
}