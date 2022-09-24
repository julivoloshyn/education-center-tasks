package com.knubisoft.tasks.algorithm.search;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SearchImplTest {
    private final SearchImpl search = new SearchImpl();

    @Test
    void binarySearchSuccess() {
        long[] arrayTest = {1, 2, 3, 4, 5, 6};

        assertEquals(3, search.binarySearch(arrayTest, 4));
        assertEquals(5, search.binarySearch(arrayTest, 6));
    }

    @Test
    void binarySearchFail() {
        long[] arrayTest = {};

        assertThrows(NullPointerException.class, () -> search.binarySearch(null, 0));
        assertThrows(NullPointerException.class, () -> search.binarySearch(arrayTest, 0));
    }

}
