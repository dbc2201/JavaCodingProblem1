package io.github.dbc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DuplicateCharactersCounterTest {
    private DuplicateCharactersCounter counter;

    @BeforeEach
    void setUp() {
        counter = new DuplicateCharactersCounter();
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
}