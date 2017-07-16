import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.Console;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexTestHarness
{
    public static void main(String[] args)
    {
        
    }

    public static void regExChecker(String theRegEx, String string2Check)
    {
        Pattern checkRegEx = Pattern.compile(theRegEx);
        Matcher regExMatcher = checkRegEx.matcher(string2Check);

        while(regExMatcher.find())
        {
            if(regExMatcher.group().length() != 0)
            {
                System.out.println(regExMatcher.group().trim());
            }

            System.out.println("Start Index: " + regExMatcher.start());
            System.out.println("End Index: " + regExMatcher.end());
        }
    }

    public static void consoleRegExChecker()
    {
        Console console = System.console();
        if(console == null)
        {
            System.err.println("No console");
            System.exit(1);
        }

        while(true)
        {
            Pattern pattern = Pattern.compile(console.readLine("%nEnter your regex: "));

            Matcher matcher = pattern.matcher(console.readLine("Enter input string to search: "));

            boolean found = false;

            while (matcher.find())
            {
                console.format("I found the text" + " \"%s\" starting at " + "index %d and ending at index %d.%n",
                        matcher.group(),
                        matcher.start(),
                        matcher.end());
                found = true;
            }
            if(!found)
            {
                console.format("No match found.%n");
            }
        }
    }
}
