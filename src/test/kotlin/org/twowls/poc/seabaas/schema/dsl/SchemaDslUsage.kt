package org.twowls.poc.seabaas.schema.dsl

fun main() {
    createSchemaRegistry {
        schema("user") {
            docs = "User data"
        }

        schema("blog") {
            schema("metadata") {
                field("created")
                field("modified")
                relationship("author", relatedSchemaName = "user") {
                    docs = "Original post author"
                }
            }

            docs = "Blog post data"
            field("title")
            field("content")
            embedment("meta", embeddedSchemaName = "metadata")
        }
    }
}