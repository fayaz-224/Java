package Strings.Basics;

import java.util.*;

//Pushes tag name to stack when <tag> is found.
//Pops and compares when </tag> is found.
//Ignores self-closing tags like <br/>.
public class HtmlTagValidator {

    public static boolean isValidHTML(String input) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < input.length()) {
            if (input.charAt(i) == '<') {
                int j = input.indexOf('>', i); //check for > from i
                if (j == -1) return false; // Invalid if there's no closing '>'

                String tag = input.substring(i+1, j);

                // Self-closing tag (e.g. <br/>)
                if (tag.endsWith("/")) {
                    i = j + 1;  //j is end of a tag, so check from j+1
                    continue;
                }

                // Closing tag
                if (tag.startsWith("/")) {
                    String tagName = tag.substring(1);
                    if (stack.isEmpty() || !stack.pop().equals(tagName))
                        return false;
                } else {  // Opening tag
                    stack.push(tag);
                }
                i = j + 1; //j is end of one tag, so check from j+1

            } else {
                i++; // Skip characters outside of tags
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] tests = {
                "<a><b>hahah</b><c></c></a>",   //Valid
                "<a><b></a></b>",          //Invalid
                "<tag1><tag2></tag2></tag1>", //Valid
                "<tag><inner></tag></inner>", //Invalid
                "<br/>",                   //Valid
        };

        for (String html : tests) {
            System.out.println(html + " → " + (isValidHTML(html) ? "Valid" : "Invalid"));
        }
    }
}

