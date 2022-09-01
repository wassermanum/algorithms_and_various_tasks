package my.learning;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodewarsTest {

    @Test
    public void det() {
        int[][] matrix = {{2,5,3}, {1,-2,-1}, {1, 3, 4}};
        assertEquals(-20, Codewars.determinant(matrix));
    }

}