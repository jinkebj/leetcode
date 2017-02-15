# Simplify Path

Given an absolute path for a file (Unix-style), simplify it.

    For example,
    path = "/home/", => "/home"
    path = "/a/./b/../../c/", => "/c"

**Java:**
```java
public class Solution {
    public String simplifyPath(String path) {
        if (path == null) return null;

        LinkedList<String> finalPath = new LinkedList<>();
        String[] pathArray = path.split("/");

        for (int i = 0; i < pathArray.length; i++) {
            if (pathArray[i].isEmpty() || pathArray[i].equals(".")) {
                continue;
            } else if (pathArray[i].equals("..")) {
                if (!finalPath.isEmpty()) finalPath.removeLast();
            } else {
                finalPath.addLast(pathArray[i]);
            }
        }

        if (finalPath.isEmpty()) return "/";

        StringBuilder ret = new StringBuilder();
        for (String str : finalPath) {
            ret.append("/");
            ret.append(str);
        }

        return ret.toString();
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
