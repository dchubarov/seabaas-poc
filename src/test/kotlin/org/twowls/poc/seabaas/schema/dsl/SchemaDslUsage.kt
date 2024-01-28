package org.twowls.poc.seabaas.schema.dsl

fun main() {
    val registry = createSchemaRegistry {
        schema("user") {
            docs = "[$name] User data"
            field("email")
        }

        schema("post") {
            docs = "[$name] Blog post"
            field("title")
            field("content")

            schema("post-ownership") {
                relationship("author", relatedSchemaName = "user")
                field("date-created")
                field("date-updated")
            }

            embedment("ownership", embeddedSchemaName = "post-ownership")
            relationship("comments", relatedSchemaName = "comment")
        }

        schema("comment") {
            relationship("reporter", relatedSchemaName = "user")
            field("date-posted")
        }
    }

    println(registry.toStringHierarchy(open = " {{", close = "}}"))
}