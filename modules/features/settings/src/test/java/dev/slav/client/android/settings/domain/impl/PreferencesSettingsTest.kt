package dev.slav.client.android.settings.domain.impl

import android.content.Context
import android.content.SharedPreferences
import app.cash.turbine.test
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.doAnswer
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.eq
import org.mockito.kotlin.inOrder
import org.mockito.kotlin.whenever
import javax.inject.Provider

@DisplayName("Unit tests for PreferencesSettings")
@ExtendWith(MockitoExtension::class)
class PreferencesSettingsTest {

    @Mock
    lateinit var contextProvider: Provider<Context>

    @Mock
    lateinit var context: Context

    @Mock
    lateinit var sharedPreferences: SharedPreferences

    @Mock
    lateinit var sharedPreferencesEditor: SharedPreferences.Editor

    @BeforeEach
    fun initDefaultMocks() {
        whenever(contextProvider.get()) doReturn context
        whenever(context.getSharedPreferences(any(), any())) doReturn sharedPreferences
    }

    private fun initEmptyPreferences() {
        whenever(sharedPreferences.contains(any())) doReturn false
        whenever(sharedPreferences.getBoolean(any(), any())) doAnswer { invocation ->
            invocation.arguments.last() as Boolean
        }
    }

    private fun initPreferences(systemTheme: Boolean, darkMode: Boolean) {
        whenever(sharedPreferences.contains(any())) doReturn true
        whenever(sharedPreferences.getBoolean(eq("system_theme"), any())) doReturn systemTheme
        whenever(sharedPreferences.getBoolean(eq("dark_mode"), any())) doReturn darkMode
    }

    @Test
    @DisplayName(
        "GIVEN no value is stored in shared preferences, " +
            "WHEN I check if system theme should be used, " +
            "THEN the return value is false"
    )
    fun systemThemeShouldReturnDefaultValue() = runTest {
        initEmptyPreferences()
        val classUnderTest = PreferencesSettings(contextProvider)

        classUnderTest.systemTheme.test {
            val result = awaitItem()

            assertThat(result).isFalse()
        }
    }

    @Test
    @DisplayName(
        "GIVEN a value is stored in shared preferences, " +
            "WHEN I check if system theme should be used, " +
            "THEN value from shared preferences is returned"
    )
    fun systemThemeShouldReturnPreferencesValue() = runTest {
        initPreferences(systemTheme = true, darkMode = false)
        val classUnderTest = PreferencesSettings(contextProvider)

        classUnderTest.systemTheme.test {
            val result = awaitItem()

            assertThat(result).isTrue()
        }
    }

    @Test
    @DisplayName(
        "GIVEN no value is stored in shared preferences, " +
            "WHEN I check if dark mode should be used, " +
            "THEN the return value is null"
    )
    fun darkModeShouldReturnDefaultValue() = runTest {
        initEmptyPreferences()
        val classUnderTest = PreferencesSettings(contextProvider)

        classUnderTest.darkMode.test {
            val result = awaitItem()

            assertThat(result).isNull()
        }
    }

    @Test
    @DisplayName(
        "GIVEN a value is stored in shared preferences, " +
            "WHEN I check if dark mode should be used, " +
            "THEN value from shared preferences is returned"
    )
    fun darkModeShouldReturnPreferencesValue() = runTest {
        initPreferences(systemTheme = true, darkMode = false)
        val classUnderTest = PreferencesSettings(contextProvider)

        classUnderTest.darkMode.test {
            val result = awaitItem()

            assertThat(result).isFalse()
        }
    }

    @Test
    @DisplayName(
        "GIVEN no value is stored in shared preferences, " +
            "WHEN I set system theme setting, " +
            "THEN the new value should be saved into shared preferences"
    )
    fun setSystemThemeShouldUpdateSharedPreferences() = runTest {
        initEmptyPreferences()
        val classUnderTest = PreferencesSettings(contextProvider)
        whenever(sharedPreferences.edit()) doReturn sharedPreferencesEditor

        classUnderTest.setSystemTheme(true)

        inOrder(sharedPreferencesEditor) {
            verify(sharedPreferencesEditor).putBoolean("system_theme", true)
            verify(sharedPreferencesEditor).commit()
        }
    }

    @Test
    @DisplayName(
        "GIVEN no value is stored in shared preferences, " +
            "WHEN I set system theme setting, " +
            "THEN the new value should be emitted"
    )
    fun setSystemThemeShouldUpdateEmittedValue() = runTest {
        initEmptyPreferences()
        val classUnderTest = PreferencesSettings(contextProvider)
        whenever(sharedPreferences.edit()) doReturn sharedPreferencesEditor

        classUnderTest.setSystemTheme(true)

        classUnderTest.systemTheme.test {
            val result = awaitItem()

            assertThat(result).isTrue()
        }
    }

    @Test
    @DisplayName(
        "GIVEN no value is stored in shared preferences, " +
            "WHEN I set dark mode setting, " +
            "THEN the new value should be saved into shared preferences"
    )
    fun setDarkModeShouldUpdateSharedPreferences() = runTest {
        initEmptyPreferences()
        val classUnderTest = PreferencesSettings(contextProvider)
        whenever(sharedPreferences.edit()) doReturn sharedPreferencesEditor

        classUnderTest.setDarkMode(false)

        inOrder(sharedPreferencesEditor) {
            verify(sharedPreferencesEditor).putBoolean("dark_mode", false)
            verify(sharedPreferencesEditor).commit()
        }
    }

    @Test
    @DisplayName(
        "GIVEN no value is stored in shared preferences, " +
            "WHEN I set dark mode setting, " +
            "THEN the new value should be emitted"
    )
    fun setDarkModeShouldUpdateEmittedValue() = runTest {
        initEmptyPreferences()
        val classUnderTest = PreferencesSettings(contextProvider)
        whenever(sharedPreferences.edit()) doReturn sharedPreferencesEditor

        classUnderTest.setDarkMode(true)

        classUnderTest.darkMode.test {
            val result = awaitItem()

            assertThat(result).isTrue()
        }
    }

    @Test
    @DisplayName(
        "GIVEN a value is stored in shared preferences, " +
            "WHEN I set dark mode setting to null, " +
            "THEN the value should be removed from shared preferences"
    )
    fun setDarkModeNullShouldRemoveSharedPreferences() = runTest {
        initPreferences(systemTheme = false, darkMode = true)
        val classUnderTest = PreferencesSettings(contextProvider)
        whenever(sharedPreferences.edit()) doReturn sharedPreferencesEditor

        classUnderTest.setDarkMode(null)

        inOrder(sharedPreferencesEditor) {
            verify(sharedPreferencesEditor).remove("dark_mode")
            verify(sharedPreferencesEditor).commit()
        }
    }

    @Test
    @DisplayName(
        "GIVEN a value is stored in shared preferences, " +
            "WHEN I set dark mode setting to null, " +
            "THEN the null value should be emitted"
    )
    fun setDarkModeNullShouldUpdateEmittedValue() = runTest {
        initEmptyPreferences()
        val classUnderTest = PreferencesSettings(contextProvider)
        whenever(sharedPreferences.edit()) doReturn sharedPreferencesEditor

        classUnderTest.setDarkMode(null)

        classUnderTest.darkMode.test {
            val result = awaitItem()

            assertThat(result).isNull()
        }
    }
}
