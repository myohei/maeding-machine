package company.wed.routes

import company.wed.services.VendingMachineService
import io.ktor.routing.Route
import io.ktor.routing.route
import org.koin.ktor.ext.inject


fun Route.graphqlController() {
    route("/graphql") {

    }
}