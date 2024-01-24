package org.twowls.poc.seabaas.schema.base

import org.twowls.poc.seabaas.schema.dsl.schema

fun main() {
    val registry = SchemaRegistry.of(
        schema("blogpost") {
            docs = "Contains blog post data"

            schema("ownership") {
                docs = "Blog post ownership and metadata information"

                relationship("author") {
                    docs = "Post author (owner)"
                }

                field("created") {
                    docs = "Date created"
                }

                field("modified") {
                    docs = "Date modified"
                }
            }

            field("title") {
                docs = "Blog post title"
            }

            field("content") {
                docs = "Blog post content (markdown or other rich text format)"
            }

            embedment("meta") {

            }
        }
    )

    println(registry)
}