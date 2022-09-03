package my.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Leetcode {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        result.add(Objects.nonNull(root) ? (double) root.val : 0);

        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while(nodes.stream().anyMatch(x -> Objects.nonNull(x.left) || Objects.nonNull(x.right))) {
            Double avg = nodes.stream().flatMap(x -> Stream.of(x.left, x.right)).filter(Objects::nonNull).mapToDouble(x -> x.val).average().orElse(0);
            result.add(avg);
            nodes = new ArrayList<>(nodes.stream().flatMap(x -> Stream.of(x.left, x.right).filter(Objects::nonNull)).toList());
        }
        return result;
    }
}
