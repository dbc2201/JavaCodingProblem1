package io.github.dbc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DuplicateCharactersCounterTest {
    private DuplicateCharactersCounter counter;

    @BeforeEach
    void setUp() {
        counter = new DuplicateCharactersCounter();
    }

    @ParameterizedTest(name = "countDuplicateCharacters(\"{arguments}\")")
    @ValueSource(strings = {"abcdefghijklmnopqrstuvwxyz", "dbc", "A", "1234567890", " "})
    @DisplayName("should return map of correct size")
    void shouldReturnMapOfCorrectSize(String input) {
        // Act
        var characterIntegerMap = counter.countDuplicateCharacters(input);
        // Assert
        assertEquals(input.length(), characterIntegerMap.size(),
                "the map should have the same size as the input string");
    }

    @Test
    @DisplayName("should return count as 1 for all non duplicate characters")
    void shouldReturnCount1ForNonDuplicateCharacters() {
        // Arrange
        String input = "abcdefghijklmnopqrstuvwxyz";
        // Act
        var characterIntegerMap = counter.countDuplicateCharacters(input);
        // get the value for key 'a'
        var count = characterIntegerMap.get('a');
        // Assert
        assertEquals(1, count, "the count value for all non duplicate characters should be 1");
    }

    @Test
    @DisplayName("should throw an IllegalArgumentException for null input")
    void shouldThrowAnIllegalArgumentExceptionForNullInput() {
        assertThrows(IllegalArgumentException.class, () -> counter.countDuplicateCharacters(null));
    }

    @Test
    @DisplayName("should return empty map for empty input")
    void shouldReturnEmptyMapForEmptyInput() {
        // Arrange
        String input = "";
        // Act
        var characterIntegerMap = counter.countDuplicateCharacters(input);
        // Assert
        assertEquals(0, characterIntegerMap.size(), "the map should be empty");
    }
}