package company.wed.graphql.scalars

import com.expediagroup.graphql.hooks.SchemaGeneratorHooks
import graphql.language.StringValue
import graphql.schema.Coercing
import graphql.schema.GraphQLScalarType
import graphql.schema.GraphQLType
import org.joda.time.DateTime
import java.util.*
import kotlin.reflect.KClass
import kotlin.reflect.KType

class DateTimeScalarGeneratorHooks : SchemaGeneratorHooks {
    override fun willGenerateGraphQLType(type: KType): GraphQLType? = when (type.classifier as? KClass<*>) {
        DateTime::class -> graphqlDateTimeType
        else -> null
    }

    private val graphqlDateTimeType = GraphQLScalarType.newScalar()
        .name("DateTime")
        .description("datetime")
        .coercing(DateTimeCoercing)
        .build()


    private object DateTimeCoercing : Coercing<DateTime, String> {
        override fun parseValue(input: Any?): DateTime = DateTime.parse(serialize(input))

        override fun parseLiteral(input: Any?): DateTime {
            val dateTimeString = (input as? StringValue)?.value
            return DateTime.parse(dateTimeString)
        }

        override fun serialize(dataFetcherResult: Any?): String = dataFetcherResult.toString()
    }

}