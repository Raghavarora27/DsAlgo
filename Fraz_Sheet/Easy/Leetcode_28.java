public class Leetcode_28 {
    class Solution1 {
        public int strStr(String haystack, String needle) {
            int hLen = haystack.length();
            int nLen = needle.length();
            if (nLen == 0) {
                return 0;
            }
            if (hLen < nLen) {
                return -1;
            }

            for (int i = 0; i <= hLen - nLen; i++) {
                int j = 0;
                while (j < nLen && haystack.charAt(i + j) == needle.charAt(j)) {
                    j++;
                }
                if (j == nLen) {
                    return i;
                }
            }

            return -1;
        }
    }

    class Solution2 {
        public int strStr(String haystack, String needle) {
            if (needle.length() == 0)
                return 0;
            if (haystack.length() == 0)
                return -1;

            for (int i = 0; i < haystack.length(); i++) {
                // no enough places for needle after i
                if (i + needle.length() > haystack.length())
                    break;

                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j))
                        break;
                    if (j == needle.length() - 1)
                        return i;
                }
            }

            return -1;
        }
    }
}