# Rectangle Area

Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
Rectangle Area

![](RectangleArea.png)

Assume that the total area is never beyond the maximum possible value of int.


**Java:**
```java
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = A > E ? A : E;
        int right = C < G ? C : G;
        int bottom = B > F ? B : F;
        int top = D < H ? D : H;

        // need check if there is no overlap
        int overlap = 0;
        if (right > left && top > bottom) overlap = (right - left) * (top - bottom);

        return (C - A) * (D - B) + (G - E) * (H - F) - overlap;
    }
}
```
