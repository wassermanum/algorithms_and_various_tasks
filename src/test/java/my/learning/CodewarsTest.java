package my.learning;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CodewarsTest {

    @Test
    public void det() {
        int[][] matrix = {{2,5,3}, {1,-2,-1}, {1, 3, 4}};
//        System.out.println(Arrays.deepToString(Codewars.getMinor(matrix, 0)));
//        System.out.println(Arrays.deepToString(Codewars.getMinor(matrix, 1)));
        int[][] matrix2 ={{1, 3}, {2,5}};
        assertEquals(-20, Codewars.determinant(matrix));
        assertEquals(-1, Codewars.determinant(matrix2));
    }

}