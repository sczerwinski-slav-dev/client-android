package dev.slav.client.android.common.network.serializers

import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.capture
import org.mockito.kotlin.doNothing
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import java.time.LocalDate

@DisplayName("Unit tests for LocalDateSerializer")
@ExtendWith(MockitoExtension::class)
class LocalDateSerializerTest {

    @Mock
    lateinit var decoder: Decoder

    @Mock
    lateinit var encoder: Encoder

    @Captor
    lateinit var stringCaptor: ArgumentCaptor<String>

    private val classUnderTest = LocalDateSerializer

    @Test
    @DisplayName(
        "GIVEN a date encoded as yyyy-MM-dd, " +
            "WHEN I deserialize the date, " +
            "THEN correct local date is returned"
    )
    fun deserializeLocalDate() {
        whenever(decoder.decodeString()) doReturn "2025-01-15"

        val result = classUnderTest.deserialize(decoder)

        assertThat(result).isEqualTo(LocalDate.of(2025, 1, 15))
    }

    @Test
    @DisplayName(
        "GIVEN a local date, " +
            "WHEN I serialize the date, " +
            "THEN correct date is encoded as yyyy-MM-dd"
    )
    fun serializeLocalDate() {
        doNothing().whenever(encoder).encodeString(capture(stringCaptor))

        classUnderTest.serialize(encoder, LocalDate.of(2025, 1, 15))

        verify(encoder, times(1)).encodeString(any())
        assertThat(stringCaptor.value).isEqualTo("2025-01-15")
    }
}
