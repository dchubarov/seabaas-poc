package org.twowls.poc.seabaas.schema

sealed class SchemaElementAttribute(private val key: Key<*>) {

    data object Required : SchemaElementAttribute(keyOf<Required>())

    sealed class Cardinality(private val range: IntRange) : SchemaElementAttribute(keyOf<Cardinality>()) {
        data object Once : Cardinality(1..1)
        data object OnceOrMore : Cardinality(1..Int.MAX_VALUE)
        data object ZeroOrOnce : Cardinality(0..1)
        data object ZeroOrMore : Cardinality(0..Int.MAX_VALUE)
        class Range(range: IntRange) : Cardinality(range)

        override fun toString(): String =
            super.toString() + "(${range.first}.." + (if (range.last == Int.MAX_VALUE) "*" else range.last) + ")"
    }

    final override fun equals(other: Any?): Boolean = other is SchemaElementAttribute && other.key == key

    final override fun hashCode(): Int = key.hashCode()

    override fun toString(): String = key.toString()

    interface Key<A : SchemaElementAttribute>
}

private inline fun <reified A : SchemaElementAttribute> keyOf(): SchemaElementAttribute.Key<A> =
    object : SchemaElementAttribute.Key<A> {
        override fun toString(): String = A::class.simpleName!!
    }