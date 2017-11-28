# Judge Route Circle

Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

Example 1:

    Input: "UD"
    Output: true

Example 2:

    Input: "LL"
    Output: false

**Java:**
```java
class Solution {
    public boolean judgeCircle(String moves) {
        int xCount = 0;
        int yCount = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'R') xCount++;
            else if (c == 'L') xCount--;
            else if (c == 'U') yCount++;
            else if (c == 'D') yCount--;
        }

        return (xCount == 0 && yCount == 0);
    }
}
```

**Java:**
```java
class Solution {
    public boolean judgeCircle(String moves) {
        moves = " " + moves + " ";
        return moves.split("L").length == moves.split("R").length && moves.split("U").length == moves.split("D").length;
    }
}
```
