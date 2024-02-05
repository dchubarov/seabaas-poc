package org.twowls.poc.seabaas.schema.dsl

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldMatchInOrder
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.shouldBe
import org.twowls.poc.seabaas.logger

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

    context("test schema build tests") {
        test("should build the test schemas without throwing an exception") {
            logger.info {
                "Built test schema '${TestSchemas::blog.name}':\n" +
                        TestSchemas.blog.toStringHierarchy(open = " {{", close = "}}")
            }
            logger.info {
                "Built test schema '${TestSchemas::ticket.name}':\n" +
                        TestSchemas.ticket.toStringHierarchy(open = " {{", close = "}}")
            }
        }
    }

    beforeTest { }
})