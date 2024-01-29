package org.twowls.poc.seabaas.schema.dsl

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldMatchInOrder
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.shouldBe

class SchemaDslTests : FunSpec({
    test("should build a registry with simple object consisting of two fields") {
        val res = createSchemaRegistry {
            schema("test") {
                field("a")
                field("b")
            }
        }
        res["test"].shouldNotBeEmpty().shouldMatchInOrder({ it.name shouldBe "a" }, { it.name shouldBe "b" })
    }

    xcontext("usage examples") {
        test("prints out test schemas") {
            println(TestSchemas.blog.toStringHierarchy(open = " {{", close = "}}"))
            println(TestSchemas.ticket.toStringHierarchy(open = " {{", close = "}}"))
        }
    }

    beforeTest { }
})