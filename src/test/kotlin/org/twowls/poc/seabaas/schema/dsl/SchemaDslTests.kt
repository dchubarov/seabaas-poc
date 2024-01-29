package org.twowls.poc.seabaas.schema.dsl

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldMatchInOrder
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.shouldBe

class SchemaDslTests : StringSpec({
    "should build a registry with simple object consisting of two fields" {
        val res = createSchemaRegistry {
            schema("test") {
                field("a")
                field("b")
            }
        }
        res["test"].shouldNotBeEmpty()
        res["test"]?.shouldMatchInOrder({ it.name shouldBe "a" }, { it.name shouldBe "b" })
    }

    "!prints out test schemas" {
        println(TestSchemas.blog.toStringHierarchy(open = " {{", close = "}}"))
        println(TestSchemas.ticket.toStringHierarchy(open = " {{", close = "}}"))
    }
})