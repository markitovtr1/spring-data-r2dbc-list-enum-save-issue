package issues.springdata.listenum

import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ListEnumApplicationTests
@Autowired
constructor(
    private val listEnumRepository: ListEnumRepository,
    private val listStringRepository: ListStringRepository,
) {

  @Test
  fun listEnumRepository() {
    val saved =
        ListEnum(stringColumn = "test", testColumn = null).let {
          val savedValue = runBlocking { listEnumRepository.save(it) }
          savedValue.stringColumn = "otherValue"
          runBlocking { listEnumRepository.save(savedValue) }
        }

    assertThat(saved).isNotNull
  }

  @Test
  fun listStringRepository() {
    val saved =
        ListString(stringColumn = "test", testColumn = null).let {
          val savedValue = runBlocking { listStringRepository.save(it) }
          savedValue.stringColumn = "otherValue"
          runBlocking { listStringRepository.save(savedValue) }
        }

    assertThat(saved).isNotNull
  }
}
