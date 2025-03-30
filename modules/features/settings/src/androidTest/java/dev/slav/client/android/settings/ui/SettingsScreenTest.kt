package dev.slav.client.android.settings.ui

import androidx.compose.ui.test.DeviceConfigurationOverride
import androidx.compose.ui.test.Locales
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.text.intl.LocaleList
import de.mannodermaus.junit5.compose.AndroidComposeExtension
import de.mannodermaus.junit5.compose.ComposeExtension
import dev.slav.client.android.common.ui.theme.SlavDevTheme
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoInteractions
import org.mockito.kotlin.verifyNoMoreInteractions

@DisplayName("Instrumented tests for SettingsScreen")
@ExtendWith(AndroidComposeExtension::class, MockitoExtension::class)
class SettingsScreenTest {

    @Mock
    lateinit var onSystemThemeChange: (Boolean) -> Unit

    @Mock
    lateinit var onDarkModeChange: (Boolean?) -> Unit

    @Test
    @DisplayName(
        "GIVEN default settings, " +
            "WHEN I open the settings screen, " +
            "THEN I should see system theme switch"
    )
    fun shouldDisplaySystemThemeSwitch(extension: ComposeExtension) = extension.use {
        setContent {
            DeviceConfigurationOverride(
                DeviceConfigurationOverride.Locales(LocaleList("en-rUK"))
            ) {
                SlavDevTheme {
                    SettingsScreen(
                        systemTheme = false,
                        onSystemThemeChange = {},
                        darkMode = null,
                        onDarkModeChange = {}
                    )
                }
            }
        }

        onNodeWithText("Use system colours")
            .assertIsDisplayed()
    }

    @Test
    @DisplayName(
        "GIVEN default settings, " +
            "WHEN I open the settings screen, " +
            "THEN I should see override dark mode switch"
    )
    fun shouldDisplayOverrideDarkModeSwitch(extension: ComposeExtension) = extension.use {
        setContent {
            DeviceConfigurationOverride(
                DeviceConfigurationOverride.Locales(LocaleList("en-rUK"))
            ) {
                SlavDevTheme {
                    SettingsScreen(
                        systemTheme = false,
                        onSystemThemeChange = {},
                        darkMode = null,
                        onDarkModeChange = {}
                    )
                }
            }
        }

        onNodeWithText("Override system dark mode")
            .assertIsDisplayed()
    }

    @Test
    @DisplayName(
        "GIVEN default settings, " +
            "WHEN I open the settings screen, " +
            "THEN I should see dark mode switch"
    )
    fun shouldDisplayDarkModeSwitch(extension: ComposeExtension) = extension.use {
        setContent {
            DeviceConfigurationOverride(
                DeviceConfigurationOverride.Locales(LocaleList("en-rUK"))
            ) {
                SlavDevTheme {
                    SettingsScreen(
                        systemTheme = false,
                        onSystemThemeChange = {},
                        darkMode = null,
                        onDarkModeChange = {}
                    )
                }
            }
        }

        onNodeWithText("Dark mode")
            .assertIsDisplayed()
    }

    @Test
    @DisplayName(
        "GIVEN dark mode setting is null, " +
            "WHEN I open the settings screen, " +
            "THEN dark mode switch should be disabled"
    )
    fun shouldDisableDarkModeSwitch(extension: ComposeExtension) = extension.use {
        setContent {
            DeviceConfigurationOverride(
                DeviceConfigurationOverride.Locales(LocaleList("en-rUK"))
            ) {
                SlavDevTheme {
                    SettingsScreen(
                        systemTheme = false,
                        onSystemThemeChange = {},
                        darkMode = null,
                        onDarkModeChange = {}
                    )
                }
            }
        }

        onNodeWithTag("settings:Dark mode:switch")
            .assertIsNotEnabled()
    }

    @Test
    @DisplayName(
        "GIVEN dark mode setting is not null, " +
            "WHEN I open the settings screen, " +
            "THEN dark mode switch should be enabled"
    )
    fun shouldEnableDarkModeSwitch(extension: ComposeExtension) = extension.use {
        setContent {
            DeviceConfigurationOverride(
                DeviceConfigurationOverride.Locales(LocaleList("en-rUK"))
            ) {
                SlavDevTheme {
                    SettingsScreen(
                        systemTheme = false,
                        onSystemThemeChange = {},
                        darkMode = false,
                        onDarkModeChange = {}
                    )
                }
            }
        }

        onNodeWithTag("settings:Dark mode:switch")
            .assertIsEnabled()
    }

    @Test
    @DisplayName(
        "GIVEN system theme setting is false, " +
            "WHEN I click on system theme switch, " +
            "THEN system theme should change to true"
    )
    fun shouldChangeSystemThemeSettingToTrue(extension: ComposeExtension) = extension.use {
        setContent {
            DeviceConfigurationOverride(
                DeviceConfigurationOverride.Locales(LocaleList("en-rUK"))
            ) {
                SlavDevTheme {
                    SettingsScreen(
                        systemTheme = false,
                        onSystemThemeChange = onSystemThemeChange,
                        darkMode = null,
                        onDarkModeChange = onDarkModeChange
                    )
                }
            }
        }

        onNodeWithTag("settings:Use system colours:switch")
            .performClick()

        verify(onSystemThemeChange).invoke(true)
        verifyNoMoreInteractions(onSystemThemeChange)
        verifyNoInteractions(onDarkModeChange)
    }

    @Test
    @DisplayName(
        "GIVEN system theme setting is true, " +
            "WHEN I click on system theme switch, " +
            "THEN system theme should change to false"
    )
    fun shouldChangeSystemThemeSettingToFalse(extension: ComposeExtension) = extension.use {
        setContent {
            DeviceConfigurationOverride(
                DeviceConfigurationOverride.Locales(LocaleList("en-rUK"))
            ) {
                SlavDevTheme {
                    SettingsScreen(
                        systemTheme = true,
                        onSystemThemeChange = onSystemThemeChange,
                        darkMode = null,
                        onDarkModeChange = onDarkModeChange
                    )
                }
            }
        }

        onNodeWithTag("settings:Use system colours:switch")
            .performClick()

        verify(onSystemThemeChange).invoke(false)
        verifyNoMoreInteractions(onSystemThemeChange)
        verifyNoInteractions(onDarkModeChange)
    }

    @Test
    @DisplayName(
        "GIVEN dark mode setting is null, " +
            "WHEN I click on override dark mode switch, " +
            "THEN dark mode should change to false"
    )
    fun shouldChangeOverrideDarkModeSettingToTrue(extension: ComposeExtension) = extension.use {
        setContent {
            DeviceConfigurationOverride(
                DeviceConfigurationOverride.Locales(LocaleList("en-rUK"))
            ) {
                SlavDevTheme {
                    SettingsScreen(
                        systemTheme = false,
                        onSystemThemeChange = onSystemThemeChange,
                        darkMode = null,
                        onDarkModeChange = onDarkModeChange
                    )
                }
            }
        }

        onNodeWithTag("settings:Override system dark mode:switch")
            .performClick()

        verify(onDarkModeChange).invoke(false)
        verifyNoMoreInteractions(onDarkModeChange)
        verifyNoInteractions(onSystemThemeChange)
    }

    @Test
    @DisplayName(
        "GIVEN dark mode setting is true, " +
            "WHEN I click on override dark mode switch, " +
            "THEN dark mode should change to null"
    )
    fun shouldChangeOverrideDarkModeSettingToFalse(extension: ComposeExtension) = extension.use {
        setContent {
            DeviceConfigurationOverride(
                DeviceConfigurationOverride.Locales(LocaleList("en-rUK"))
            ) {
                SlavDevTheme {
                    SettingsScreen(
                        systemTheme = false,
                        onSystemThemeChange = onSystemThemeChange,
                        darkMode = true,
                        onDarkModeChange = onDarkModeChange
                    )
                }
            }
        }

        onNodeWithTag("settings:Override system dark mode:switch")
            .performClick()

        verify(onDarkModeChange).invoke(null)
        verifyNoMoreInteractions(onDarkModeChange)
        verifyNoInteractions(onSystemThemeChange)
    }

    @Test
    @DisplayName(
        "GIVEN dark mode setting is null, " +
            "WHEN I click on dark mode switch, " +
            "THEN nothing should happen"
    )
    fun shouldNotChangeDarkModeSetting(extension: ComposeExtension) = extension.use {
        setContent {
            DeviceConfigurationOverride(
                DeviceConfigurationOverride.Locales(LocaleList("en-rUK"))
            ) {
                SlavDevTheme {
                    SettingsScreen(
                        systemTheme = false,
                        onSystemThemeChange = onSystemThemeChange,
                        darkMode = null,
                        onDarkModeChange = onDarkModeChange
                    )
                }
            }
        }

        onNodeWithTag("settings:Dark mode:switch")
            .performClick()

        verifyNoInteractions(onDarkModeChange)
        verifyNoInteractions(onSystemThemeChange)
    }

    @Test
    @DisplayName(
        "GIVEN dark mode setting is false, " +
            "WHEN I click on dark mode switch, " +
            "THEN dark mode should change to true"
    )
    fun shouldChangeDarkModeSettingToTrue(extension: ComposeExtension) = extension.use {
        setContent {
            DeviceConfigurationOverride(
                DeviceConfigurationOverride.Locales(LocaleList("en-rUK"))
            ) {
                SlavDevTheme {
                    SettingsScreen(
                        systemTheme = false,
                        onSystemThemeChange = onSystemThemeChange,
                        darkMode = false,
                        onDarkModeChange = onDarkModeChange
                    )
                }
            }
        }

        onNodeWithTag("settings:Dark mode:switch")
            .performClick()

        verify(onDarkModeChange).invoke(true)
        verifyNoMoreInteractions(onDarkModeChange)
        verifyNoInteractions(onSystemThemeChange)
    }

    @Test
    @DisplayName(
        "GIVEN dark mode setting is true, " +
            "WHEN I click on dark mode switch, " +
            "THEN dark mode should change to false"
    )
    fun shouldChangeDarkModeSettingToFalse(extension: ComposeExtension) = extension.use {
        setContent {
            DeviceConfigurationOverride(
                DeviceConfigurationOverride.Locales(LocaleList("en-rUK"))
            ) {
                SlavDevTheme {
                    SettingsScreen(
                        systemTheme = false,
                        onSystemThemeChange = onSystemThemeChange,
                        darkMode = true,
                        onDarkModeChange = onDarkModeChange
                    )
                }
            }
        }

        onNodeWithTag("settings:Dark mode:switch")
            .performClick()

        verify(onDarkModeChange).invoke(false)
        verifyNoMoreInteractions(onDarkModeChange)
        verifyNoInteractions(onSystemThemeChange)
    }
}
