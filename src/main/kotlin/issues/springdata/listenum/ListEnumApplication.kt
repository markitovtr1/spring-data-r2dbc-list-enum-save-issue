package issues.springdata.listenum

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

enum class TestEnum {
  TEST_VALUE
}

@Table("sample")
data class ListEnum(
    @Id val sampleId: Int? = null,
    var stringColumn: String,
    val testColumn: List<TestEnum>?,
)

@Table("sample")
data class ListString(
    @Id val sampleId: Int? = null,
    var stringColumn: String,
    val testColumn: List<String>?,
)

interface ListEnumRepository : CoroutineCrudRepository<ListEnum, Int>

interface ListStringRepository : CoroutineCrudRepository<ListString, Int>

@SpringBootApplication class ListEnumApplication

fun main(args: Array<String>) {
  runApplication<ListEnumApplication>(*args)
}
