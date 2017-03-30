# Simplify Path

Given an absolute path for a file (Unix-style), simplify it.

    For example,
    path = "/home/", => "/home"
    path = "/a/./b/../../c/", => "/c"

**Java:**
```java
public class Solution {
    public String simplifyPath(String path) {
        String ret = "";
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));

        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!skip.contains(dir)) stack.push(dir);
        }
        for (String dir : stack) ret = "/" + dir + ret;

        return ret.isEmpty() ? "/" : ret;
    }
}
```

**Java: (use java.nio.file.Paths)**
```java
public class Solution {
    public String simplifyPath(String path) {
        return java.nio.file.Paths.get(path).normalize().toString();
    }
}
```

**C++:**
```c++
class Solution {
public:
    string simplifyPath(string path) {
        vector<string> dirs;

        for (auto i = path.begin(); i!= path.end(); ) {
            i++;
            auto j = find(i, path.end(), '/');
            auto dir = string(i, j);

            if (dir.empty() || dir == ".") {
                continue;
            } else if (dir == "..") {
                if (!dirs.empty()) dirs.pop_back();
            } else {
                dirs.push_back(dir);
            }

            i = j;
        }

        if (dirs.empty()) return "/";

        stringstream out;
        for (string str : dirs)
            out << "/" << str;

        return out.str();
    }
};
```
