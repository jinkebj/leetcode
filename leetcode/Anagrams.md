# Anagrams

Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.

**Java:**
```java
public class Solution {
    public List<String> anagrams(String[] strs) {
        ArrayList<String> ret = new ArrayList<String>();
        HashMap<String, ArrayList<String>> group = new HashMap<String, ArrayList<String>>();

        for (String s : strs) {
            char[] cc = s.toCharArray();
            Arrays.sort(cc);
            String c = new String(cc);
            if (group.containsKey(c)) {
                ((ArrayList<String>)group.get(c)).add(s);
            } else {
                ArrayList<String> ar = new ArrayList<String>();
                ar.add(s);
                group.put(c, ar);
            }
        }

        Iterator it = group.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            if (((ArrayList<String>)entry.getValue()).size() > 1) {
                ret.addAll((ArrayList<String>)entry.getValue());
            }
        }
        return ret;
    }
}
```
