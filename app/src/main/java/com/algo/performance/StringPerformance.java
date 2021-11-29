package com.algo.performance;

import com.algo.common.time.TimeUtil;

public class StringPerformance {
    public static void test_서브스트링_vs_split(String[] testCases) {
        System.out.println("========================= when substring =========================");
        TimeUtil.start();
        for (int i = 0; i < 10000; i++) {
            for (String testCase : testCases) {
                String subbedText = testCase.substring(testCase.indexOf(' ') + 1);
            }
        }
        TimeUtil.elapsedTime(false);

        System.out.println("========================= when split =========================");
        TimeUtil.start();
        for (int i = 0; i < 10000; i++) {
            for (String testCase : testCases) {
                String splitText = testCase.split("\\s+", 1)[0];
            }
        }
        TimeUtil.elapsedTime(false);
    }

    public static void test() {
        String[] testCases = new String[]{
                "가gare g 나 re gaer 다 라 마" +
                        "바rae gaerg사 아자차카 타파하",
                "바사 dsf g asdf 아자차카 타파하",
                "바r a사 gaerg아g er 자차카 타파하",
                "바사 아자sdraer  fasdg s aga fe차카 타파하",
                "바사 아자차카 r g타파하",
                "바a사  aer ga아자차카 타파하",
                "바 gr사 아자차are aegrag카aeg  타파하",
                "바사 아er gare자차카 타파하",
                "Stack Overflow\n" +
                        "Products\n" +
                        "Search…\n" +
                        " \n" +
                        "Join Stack Overflow to learn, share knowledge, and build your career.\n" +
                        "\n" +
                        "Home\n" +
                        "PUBLIC\n" +
                        "Questions\n" +
                        "Tags\n" +
                        "Users\n" +
                        "COLLECTIVES\n" +
                        "Explore Collectives\n" +
                        "FIND A JOB\n" +
                        "Jobs\n" +
                        "Companies\n" +
                        "TEAMS\n" +
                        "Stack Overflow for Teams – Collaborate and share knowledge with a private group. \n" +
                        "How to split a String by space\n" +
                        "Asked 9 years, 9 months ago\n" +
                        "Active 1 year, 1 month ago\n" +
                        "Viewed 887k times\n" +
                        "\n" +
                        "382\n" +
                        "\n" +
                        "\n" +
                        "94\n" +
                        "I need to split my String by spaces. For this I tried:\n" +
                        "\n" +
                        "str = \"Hello I'm your String\";\n" +
                        "String[] splited = str.split(\" \");\n" +
                        "But it doesn't seem to work.\n" +
                        "\n" +
                        "java\n" +
                        "string\n" +
                        "split\n" +
                        "arrays\n" +
                        "Share\n" +
                        "Improve this question\n" +
                        "Follow\n" +
                        "edited Sep 17 '18 at 9:58\n" +
                        "\n" +
                        "rghome\n" +
                        "7,35088 gold badges3737 silver badges5353 bronze badges\n" +
                        "asked Oct 26 '11 at 6:54\n" +
                        "\n" +
                        "safari\n" +
                        "6,8971717 gold badges5151 silver badges8181 bronze badges\n" +
                        "5\n" +
                        "Looks good... what are the values in the 'splited' array? – npinti Oct 26 '11 at 6:56\n" +
                        "2\n" +
                        "Your code does indeed work as-is. See code run live at IdeOne.com. – Basil Bourque Oct 12 '18 at 18:46\n" +
                        "@BasilBourque - I couldn't find any run button on that link – nanosoft Jan 9 '20 at 8:27\n" +
                        "2\n" +
                        "@nanosoft The page at IdeOne.com runs automatically upon loading. See output below the code, in stdout section. To alter the code, click the fork link near top left corner. – Basil Bourque Jan 9 '20 at 8:48 \n" +
                        "Does this answer your question? How do I split a string with any whitespace chars as delimiters? – scai Feb 13 '20 at 15:06\n" +
                        "Add a comment\n" +
                        "15 Answers\n" +
                        "\n" +
                        "726\n" +
                        "\n" +
                        "What you have should work. If, however, the spaces provided are defaulting to... something else? You can use the whitespace regex:\n" +
                        "\n" +
                        "str = \"Hello I'm your String\";\n" +
                        "String[] splited = str.split(\"\\\\s+\");\n" +
                        "This will cause any number of consecutive spaces to split your string into tokens.\n" +
                        "\n" +
                        "As a side note, I'm not sure \"splited\" is a word :) I believe the state of being the victim of a split is also \"split\". It's one of those tricky grammar things :-) Not trying to be picky, just figured I'd pass it on!\n" +
                        "\n" +
                        "Share\n" +
                        "Improve this answer\n" +
                        "Follow\n" +
                        "edited Jun 19 '18 at 16:07\n" +
                        "answered Oct 26 '11 at 6:58\n" +
                        "\n" +
                        "corsiKa\n" +
                        "77.4k2222 gold badges148148 silver badges194194 bronze badges\n" +
                        "31\n" +
                        ":-) Hey it's no big. I've used some ridiculous variable names (in code I probably shouldn't have let go live!) I wasn't trying to be a grammar nazi or anything, just passing on a little trivia, that's all. – corsiKa Oct 26 '11 at 7:04\n" +
                        "what regular expression to use if we have to split on these space , + - / ; – user2603796 Dec 30 '15 at 13:48\n" +
                        "I'm not sure off the top of my head. If it's only space, you can form your own class by bracketing it, so in your case probably (note, this is untested) [ +\\\\-/;]+ - notice the \\` around the -` to escape it. Now, this will probably match This is+a+ - + - + - test into 4 tokens, which may or may not be desired. The real problem is you can't use \\\\s to match \"any whitespace\". You might be better off not using split, and just using Matcher m = Pattern.compile(\"([A-Za-z0-9]+)\").matcher(text); while(m.find()) list.add(m.group(1)); to fetch words instead of splitting a big text. – corsiKa Dec 30 '15 at 16:27\n" +
                        "@FarazAhmad Note that those are just off the top of my head, there could be little bugs, so don't copy/paste the code in that comment :) – corsiKa Dec 30 '15 at 16:28\n" +
                        "1\n" +
                        "I find it useful as my use case was to split the string and remove multiple spaces. One line of code does both for me. – Niharika Upadhyay Jul 10 '18 at 9:06\n" +
                        "Show 6 more comments\n" +
                        "\n" +
                        "110\n" +
                        "\n" +
                        "While the accepted answer is good, be aware that you will end up with a leading empty string if your input string starts with a white space. For example, with:\n" +
                        "\n" +
                        "String str = \" Hello I'm your String\";\n" +
                        "String[] splitStr = str.split(\"\\\\s+\");\n" +
                        "The result will be:\n" +
                        "\n" +
                        "splitStr[0] == \"\";\n" +
                        "splitStr[1] == \"Hello\";\n" +
                        "splitStr[2] == \"I'm\";\n" +
                        "splitStr[3] == \"Your\";\n" +
                        "splitStr[4] == \"String\";\n" +
                        "So you might want to trim your string before splitting it:\n" +
                        "\n" +
                        "String str = \" Hello I'm your String\";\n" +
                        "String[] splitStr = str.trim().split(\"\\\\s+\");\n" +
                        "[edit]\n" +
                        "\n" +
                        "In addition to the trim caveat, you might want to consider the unicode non-breaking space character (U+00A0). This character prints just like a regular space in string, and often lurks in copy-pasted text from rich text editors or web pages. They are not handled by .trim() which tests for characters to remove using c <= ' '; \\s will not catch them either.\n" +
                        "\n" +
                        "Instead, you can use \\p{Blank} but you need to enable unicode character support as well which the regular split won't do. For example, this will work: Pattern.compile(\"\\\\p{Blank}\", UNICODE_CHARACTER_CLASS).split(words) but it won't do the trim part.\n" +
                        "\n" +
                        "The following demonstrates the problem and provides a solution. It is far from optimal to rely on regex for this, but now that Java has 8bit / 16bit byte representation, an efficient solution for this becomes quite long.\n" +
                        "\n" +
                        "public class SplitStringTest\n" +
                        "{\n" +
                        "    static final Pattern TRIM_UNICODE_PATTERN = Pattern.compile(\"^\\\\p{Blank}*(.*)\\\\p{Blank}$\", UNICODE_CHARACTER_CLASS);\n" +
                        "    static final Pattern SPLIT_SPACE_UNICODE_PATTERN = Pattern.compile(\"\\\\p{Blank}\", UNICODE_CHARACTER_CLASS);\n" +
                        "\n" +
                        "    public static String[] trimSplitUnicodeBySpace(String str)\n" +
                        "    {\n" +
                        "        Matcher trimMatcher = TRIM_UNICODE_PATTERN.matcher(str);\n" +
                        "        boolean ignore = trimMatcher.matches(); // always true but must be called since it does the actual matching/grouping\n" +
                        "        return SPLIT_SPACE_UNICODE_PATTERN.split(trimMatcher.group(1));\n" +
                        "    }\n" +
                        "\n" +
                        "    @Test\n" +
                        "    void test()\n" +
                        "    {\n" +
                        "        String words = \" Hello I'm\\u00A0your String\\u00A0\";\n" +
                        "        // non-breaking space here --^ and there -----^\n" +
                        "\n" +
                        "        String[] split = words.split(\" \");\n" +
                        "        String[] trimAndSplit = words.trim().split(\" \");\n" +
                        "        String[] splitUnicode = SPLIT_SPACE_UNICODE_PATTERN.split(words);\n" +
                        "        String[] trimAndSplitUnicode = trimSplitUnicodeBySpace(words);\n" +
                        "\n" +
                        "        System.out.println(\"words: [\" + words + \"]\");\n" +
                        "        System.out.println(\"split: [\" + Arrays.stream(split).collect(Collectors.joining(\"][\")) + \"]\");\n" +
                        "        System.out.println(\"trimAndSplit: [\" + Arrays.stream(trimAndSplit).collect(Collectors.joining(\"][\")) + \"]\");\n" +
                        "        System.out.println(\"splitUnicode: [\" + Arrays.stream(splitUnicode).collect(Collectors.joining(\"][\")) + \"]\");\n" +
                        "        System.out.println(\"trimAndSplitUnicode: [\" + Arrays.stream(trimAndSplitUnicode).collect(Collectors.joining(\"][\")) + \"]\");\n" +
                        "    }\n" +
                        "}\n" +
                        "Results in:\n" +
                        "\n" +
                        "words: [ Hello I'm your String ]\n" +
                        "split: [][Hello][I'm your][String ]\n" +
                        "trimAndSplit: [Hello][I'm your][String ]\n" +
                        "splitUnicode: [][Hello][I'm][your][String]\n" +
                        "trimAndSplitUnicode: [Hello][I'm][your][String]\n" +
                        "Share\n" +
                        "Improve this answer\n" +
                        "Follow\n" +
                        "edited Jun 21 '20 at 16:43\n" +
                        "answered May 13 '15 at 16:31\n" +
                        "\n" +
                        "GaspardP\n" +
                        "3,34911 gold badge1818 silver badges2929 bronze badges\n" +
                        "Thanks for this detailed answer. I was running into an exception because of leading and trailing spaces. – ninja Jul 11 '20 at 8:56\n" +
                        "Add a comment\n" +
                        "\n" +
                        "30\n" +
                        "\n" +
                        "I do believe that putting a regular expression in the str.split parentheses should solve the issue. The Java String.split() method is based upon regular expressions so what you need is:\n" +
                        "\n" +
                        "str = \"Hello I'm your String\";\n" +
                        "String[] splitStr = str.split(\"\\\\s+\");\n" +
                        "Share\n" +
                        "Improve this answer\n" +
                        "Follow\n" +
                        "edited Apr 12 '18 at 14:02\n" +
                        "\n" +
                        "mskfisher\n" +
                        "3,02833 gold badges3131 silver badges4747 bronze badges\n" +
                        "answered Oct 26 '11 at 7:04\n" +
                        "\n" +
                        "rbrtl\n" +
                        "74911 gold badge66 silver badges2222 bronze badges\n" +
                        "Add a comment\n" +
                        "\n" +
                        "14\n" +
                        "\n" +
                        "Use Stringutils.split() to split the string by whites paces. For example StringUtils.split(\"Hello World\") returns \"Hello\" and \"World\";\n" +
                        "\n" +
                        "In order to solve the mentioned case we use split method like this\n" +
                        "\n" +
                        "String split[]= StringUtils.split(\"Hello I'm your String\");\n" +
                        "when we print the split array the output will be :\n" +
                        "\n" +
                        "Hello\n" +
                        "\n" +
                        "I'm\n" +
                        "\n" +
                        "your\n" +
                        "\n" +
                        "String\n" +
                        "\n" +
                        "For complete example demo check here\n" +
                        "\n" +
                        "Share\n" +
                        "Improve this answer\n" +
                        "Follow\n" +
                        "edited May 21 '14 at 14:14\n" +
                        "\n" +
                        "Kh.Taheri\n" +
                        "88611 gold badge1010 silver badges2525 bronze badges\n" +
                        "answered Apr 7 '14 at 5:59\n" +
                        "\n" +
                        "sandeep vanama\n" +
                        "61988 silver badges88 bronze badges\n" +
                        "Add a comment\n" +
                        "\n" +
                        "10\n" +
                        "\n" +
                        "Try\n" +
                        "\n" +
                        "String[] splited = str.split(\"\\\\s\");\n" +
                        "http://download.oracle.com/javase/tutorial/essential/regex/pre_char_classes.html\n" +
                        "\n" +
                        "Share\n" +
                        "Improve this answer\n" +
                        "Follow\n" +
                        "answered Oct 26 '11 at 6:57\n" +
                        "\n" +
                        "Vladimir\n" +
                        "9,25566 gold badges3232 silver badges5656 bronze badges\n" +
                        "Add a comment\n" +
                        "\n" +
                        "8\n" +
                        "\n" +
                        "if somehow you don't wanna use String split method then you can use StringTokenizer class in Java as..\n" +
                        "\n" +
                        "    StringTokenizer tokens = new StringTokenizer(\"Hello I'm your String\", \" \");\n" +
                        "    String[] splited = new String[tokens.countTokens()];\n" +
                        "    int index = 0;\n" +
                        "    while(tokens.hasMoreTokens()){\n" +
                        "        splited[index] = tokens.nextToken();\n" +
                        "        ++index;\n" +
                        "    }\n" +
                        "Share\n" +
                        "Improve this answer\n" +
                        "Follow\n" +
                        "answered Jul 3 '14 at 8:21\n" +
                        "\n" +
                        "Muhammad Suleman\n" +
                        "2,75622 gold badges2323 silver badges3333 bronze badges\n" +
                        "There is a possibility of throwing ArrayIndexOutofBounds Exception. – Ajay Takur Aug 12 '14 at 12:54\n" +
                        "3\n" +
                        "No, this won't throw \"ArrayIndexOutofBounds\" because i have declare array size according to number of tokens found in String. this will make sure that arrays size won't be more than received tokens in a string. – Muhammad Suleman Aug 13 '14 at 7:08\n" +
                        "Add a comment\n" +
                        "\n" +
                        "7\n" +
                        "\n" +
                        "Try this one\n" +
                        "\n" +
                        "    String str = \"This is String\";\n" +
                        "    String[] splited = str.split(\"\\\\s+\");\n" +
                        "\n" +
                        "    String split_one=splited[0];\n" +
                        "    String split_second=splited[1];\n" +
                        "    String split_three=splited[2];\n" +
                        "\n" +
                        "   Log.d(\"Splited String \", \"Splited String\" + split_one+split_second+split_three);\n" +
                        "Share\n" +
                        "Improve this answer\n" +
                        "Follow\n" +
                        "answered Aug 20 '15 at 10:24\n" +
                        "\n" +
                        "sachin pangare\n" +
                        "1,3971414 silver badges1111 bronze badges\n" +
                        "Add a comment\n" +
                        "\n" +
                        "6\n" +
                        "\n" +
                        "OK, so we have to do splitting as you already got the answer I would generalize it.\n" +
                        "\n" +
                        "If you want to split any string by spaces, delimiter(special chars).\n" +
                        "\n" +
                        "First, remove the leading space as they create most of the issues.\n" +
                        "\n" +
                        "str1 = \"    Hello I'm your       String    \";\n" +
                        "str2 = \"    Are you serious about this question_  boy, aren't you?   \";\n" +
                        "First remove the leading space which can be space, tab etc.\n" +
                        "\n" +
                        "String s = str1.replaceAll(\"^\\\\s+\",\"\");//starting with whitespace one or more\n" +
                        "Now if you want to split by space or any special char.\n" +
                        "\n" +
                        "String[] sa = s.split(\"[^\\\\w]+\");//split by any non word char\n" +
                        "But as w contains [a-zA-Z_0-9] ,so if you want to split by underscore(_) also use\n" +
                        "\n" +
                        " String[] sa = s.split(\"[!,? ._'@]+\");//for str2 after removing leading space\n" +
                        "Share\n" +
                        "Improve this answer\n" +
                        "Follow\n" +
                        "answered Oct 2 '17 at 6:38\n" +
                        "\n" +
                        "Anuj Kumar Soni\n" +
                        "17222 silver badges77 bronze badges\n" +
                        "1\n" +
                        "That replaceAll(\"^\\\\s+\",\"\") saved my day. That worked for my case. Thank you – Kostas Asargiotakis May 21 '20 at 13:37\n" +
                        "Add a comment\n" +
                        "\n" +
                        "5\n" +
                        "\n" +
                        "An alternative way would be:\n" +
                        "\n" +
                        "import java.util.regex.Pattern;\n" +
                        "\n" +
                        "...\n" +
                        "\n" +
                        "private static final Pattern SPACE = Pattern.compile(\" \");\n" +
                        "String[] arr = SPACE.split(str); // str is the string to be split\n" +
                        "Saw it here\n" +
                        "\n" +
                        "Share\n" +
                        "Improve this answer\n" +
                        "Follow\n" +
                        "answered Jun 20 '14 at 11:10\n" +
                        "\n" +
                        "gjain\n" +
                        "4,05644 gold badges3131 silver badges4242 bronze badges\n" +
                        "Add a comment\n" +
                        "\n" +
                        "3\n" +
                        "\n" +
                        "Very Simple Example below:\n" +
                        "\n" +
                        "Hope it helps.\n" +
                        "\n" +
                        "String str = \"Hello I'm your String\";\n" +
                        "String[] splited = str.split(\" \");\n" +
                        "var splited = str.split(\" \");\n" +
                        "var splited1=splited[0]; //Hello\n" +
                        "var splited2=splited[1]; //I'm\n" +
                        "var splited3=splited[2]; //your\n" +
                        "var splited4=splited[3]; //String\n" +
                        "Share\n" +
                        "Improve this answer\n" +
                        "Follow\n" +
                        "answered Nov 19 '18 at 10:29\n" +
                        "\n" +
                        "BaxD\n" +
                        "3144 bronze badges\n" +
                        "Add a comment\n" +
                        "\n" +
                        "2\n" +
                        "\n" +
                        "you can saperate string using the below code\n" +
                        "\n" +
                        "   String thisString=\"Hello world\";\n" +
                        "\n" +
                        "   String[] parts = theString.split(\" \");\n" +
                        "\n" +
                        "   String first = parts[0];//\"hello\"\n" +
                        "\n" +
                        "    String second = parts[1];//\"World\"\n" +
                        "Share\n" +
                        "Improve this answer\n" +
                        "Follow\n" +
                        "answered May 31 '18 at 11:10\n" +
                        "\n" +
                        "Syed Danish Haider\n" +
                        "1,1361010 silver badges1414 bronze badges\n" +
                        "Add a comment\n" +
                        "\n" +
                        "2\n" +
                        "\n" +
                        "Since it's been a while since these answers were posted, here's another more current way to do what's asked:\n" +
                        "\n" +
                        "List<String> output = new ArrayList<>();\n" +
                        "try (Scanner sc = new Scanner(inputString)) {\n" +
                        "    while (sc.hasNext()) output.add(sc.next());\n" +
                        "}\n" +
                        "Now you have a list of strings (which is arguably better than an array); if you do need an array, you can do output.toArray(new String[0]);\n" +
                        "\n" +
                        "Share\n" +
                        "Improve this answer\n" +
                        "Follow\n" +
                        "answered Jun 19 '18 at 6:42\n" +
                        "\n" +
                        "daniu\n" +
                        "12.3k33 gold badges2424 silver badges4646 bronze badges\n" +
                        "Add a comment\n" +
                        "\n" +
                        "1\n" +
                        "\n" +
                        "Here is a method to trim a String that has a \",\" or white space\n" +
                        "\n" +
                        "private String shorterName(String s){\n" +
                        "        String[] sArr = s.split(\"\\\\,|\\\\s+\");\n" +
                        "        String output = sArr[0];\n" +
                        "\n" +
                        "        return output;\n" +
                        "    }\n" +
                        "Share\n" +
                        "Improve this answer\n" +
                        "Follow\n" +
                        "answered Mar 16 '18 at 8:56\n" +
                        "\n" +
                        "Mr T\n" +
                        "1,0861414 silver badges2121 bronze badges\n" +
                        "Add a comment\n" +
                        "\n" +
                        "1\n" +
                        "\n" +
                        "Not only white space, but my solution also solves the invisible characters as well.\n" +
                        "\n" +
                        "str = \"Hello I'm your String\";\n" +
                        "String[] splited = str.split(\"\\p{Z}\");\n" +
                        "Share\n" +
                        "Improve this answer\n" +
                        "Follow\n" +
                        "answered Feb 24 '20 at 4:44\n" +
                        "\n" +
                        "logbasex\n" +
                        "67411 gold badge66 silver badges1313 bronze badges\n" +
                        "Add a comment\n" +
                        "\n" +
                        "0\n" +
                        "\n" +
                        "Simple to Spit String by Space\n" +
                        "\n" +
                        "    String CurrentString = \"First Second Last\";\n" +
                        "    String[] separated = CurrentString.split(\" \");\n" +
                        "\n" +
                        "    for (int i = 0; i < separated.length; i++) {\n" +
                        "\n" +
                        "         if (i == 0) {\n" +
                        "             Log.d(\"FName ** \", \"\" + separated[0].trim() + \"\\n \");\n" +
                        "         } else if (i == 1) {\n" +
                        "             Log.d(\"MName ** \", \"\" + separated[1].trim() + \"\\n \");\n" +
                        "         } else if (i == 2) {\n" +
                        "             Log.d(\"LName ** \", \"\" + separated[2].trim());\n" +
                        "         }\n" +
                        "     }\n" +
                        "Share\n" +
                        "Improve this answer\n" +
                        "Follow\n" +
                        "answered Apr 21 '17 at 5:46\n" +
                        "\n" +
                        "Jaydeep Dobariya\n" +
                        "44577 silver badges1111 bronze badges\n" +
                        "Add a comment\n" +
                        "Your Answer\n" +
                        "Sign up or log in\n" +
                        "Post as a guest\n" +
                        "Name\n" +
                        "Email\n" +
                        "Required, but never shown\n" +
                        "\n" +
                        "By clicking “Post Your Answer”, you agree to our terms of service, privacy policy and cookie policy\n" +
                        "\n" +
                        "Not the answer you're looking for? Browse other questions tagged java string split arrays or ask your own question.\n" +
                        "The Overflow Blog\n" +
                        "Podcast 364: What’s the blast radius when your database goes down?\n" +
                        "The Overflow #84 and 85: How Dwarf Fortress is built\n" +
                        "Featured on Meta\n" +
                        "Join me in Welcoming Valued Associates: #945 - Slate - and #948 - Vanny\n" +
                        "Linked\n" +
                        "35\n" +
                        "Splitting string on multiple spaces in java\n" +
                        "-6\n" +
                        "How can I split a string by a delimiter in Java?\n" +
                        "-1\n" +
                        "Split a string into different parts with dynamic length\n" +
                        "0\n" +
                        "How do I account for whitespaces when counting words in a String?\n" +
                        "-2\n" +
                        "Android java string division when has whitespaces (space)\n" +
                        "0\n" +
                        "How to take in a String and return an array after modifying the String?\n" +
                        "-2\n" +
                        "Swap adjacent element of an array in JAVA\n" +
                        "-4\n" +
                        "How can I pick a string apart and outprint it?\n" +
                        "571\n" +
                        "How to split a string with any whitespace chars as delimiters\n" +
                        "58\n" +
                        "String.split() *not* on regular expression?\n" +
                        "See more linked questions\n" +
                        "Related\n" +
                        "6961\n" +
                        "What is the difference between String and string in C#?\n" +
                        "3159\n" +
                        "How do I iterate over the words of a string?\n" +
                        "2617\n" +
                        "How do you split a list into evenly sized chunks?\n" +
                        "3137\n" +
                        "Case insensitive 'Contains(string)'\n" +
                        "2980\n" +
                        "Convert bytes to a string\n" +
                        "2352\n" +
                        "How do I split a string on a delimiter in Bash?\n" +
                        "4894\n" +
                        "How to replace all occurrences of a string in JavaScript\n" +
                        "7418\n" +
                        "How to check whether a string contains a substring in JavaScript?\n" +
                        "1781\n" +
                        "How to split a string in Java\n" +
                        "9680\n" +
                        "How can I remove a specific item from an array?\n" +
                        "Hot Network Questions\n" +
                        "Energy weapons or Bullets? What would make more sense?\n" +
                        "Where does Scrum or Agile Manifesto say that we should avoid stages (development, then testing)?\n" +
                        "Is there any reason not to immediately use cash back balance to pay credit card?\n" +
                        "When do we add NE when asking a question?\n" +
                        "Centering text with dotfill\n" +
                        "Sieve of Eratosthenes in Vyxal\n" +
                        "Is there an idiom that says not to change a perfectly good thing?\n" +
                        "How to deal with a colleague who edits previous email details to paint colleagues in a negative light?\n" +
                        "What tried and tested possibilities are there to create a poster without using LaTeX?\n" +
                        "Why does pair production only occur in an electric but not a magnetic field?\n" +
                        "Overcoming the issues of caseless ammunition\n" +
                        "Common Classical Ciphers\n" +
                        "What is the difference between \"Zu\" and \"Auf\" in these sentences?\n" +
                        "How do I add a different prefix to each line?\n" +
                        "What's the meaning of the word \"расходилась\" in Tolstoy's story ''Прыжок''?\n" +
                        "Is there any law that states how far you can dig underground in the United States?\n" +
                        "Can you identify this helicopter?\n" +
                        "What hair color did Évariste Galois have?\n" +
                        "Mean and Variance for Math Library\n" +
                        "Are calculus and differential geometry required for building neural networks?\n" +
                        "Nurikabe: An Inconvenient Twelve\n" +
                        "What could justify large amounts of troops that can move entirely by helicopter & organically have the means to do so?\n" +
                        "Is Hogwarts the only magical school in the UK?\n" +
                        "What rules apply when Saving Throw proficiencies overlap?\n" +
                        " Question feed\n" +
                        "\n" +
                        "STACK OVERFLOW\n" +
                        "Questions\n" +
                        "Jobs\n" +
                        "Developer Jobs Directory\n" +
                        "Salary Calculator\n" +
                        "Help\n" +
                        "Mobile\n" +
                        "Disable Responsiveness\n" +
                        "PRODUCTS\n" +
                        "Teams\n" +
                        "Talent\n" +
                        "Advertising\n" +
                        "Enterprise\n" +
                        "COMPANY\n" +
                        "About\n" +
                        "Press\n" +
                        "Work Here\n" +
                        "Legal\n" +
                        "Privacy Policy\n" +
                        "Terms of Service\n" +
                        "Contact Us\n" +
                        "Cookie Settings\n" +
                        "Cookie Policy\n" +
                        "STACK EXCHANGE\n" +
                        "NETWORK\n" +
                        "Technology\n" +
                        "Life / Arts\n" +
                        "Culture / Recreation\n" +
                        "Science\n" +
                        "Other\n" +
                        "Blog\n" +
                        "Facebook\n" +
                        "Twitter\n" +
                        "LinkedIn\n" +
                        "Instagram\n" +
                        "site design / logo © 2021 Stack Exchange Inc; user contributions licensed under cc by-sa. rev 2021.8.5.39930",
                "2134239um dsaf9783178r dasf sd" +
                        "f-0sdif-  e89fw0e9fjiojddm932r90",
                "주요 콘텐츠로 이동접근성 도움말\n" +
                        "접근성 관련 의견 보내기\n" +
                        "Google\n" +
                        "java split whitespace\n" +
                        "\n" +
                        "전체\n" +
                        "이미지지도뉴스동영상더보기\n" +
                        "도구\n" +
                        "검색결과 약 10,700,000개 (0.45초) \n" +
                        "You can split a String by whitespaces or tabs in Java by using the split() method of java. lang. String class. This method accepts a regular expression and you can pass a regex matching with whitespace to split the String where words are separated by spaces.2016. 10. 9.\n" +
                        "\n" +
                        "How to split String in Java by WhiteSpace or ... - Javarevisitedhttps://javarevisited.blogspot.com › 2016/10 › how-to-spli...\n" +
                        "추천 스니펫 정보\n" +
                        "•\n" +
                        "사용자 의견\n" +
                        "\n" +
                        "How to split a string with any whitespace chars as delimiters ...https://stackoverflow.com › questions\n" +
                        "이 페이지 번역하기\n" +
                        "2008. 10. 22. · 답변 13개\n" +
                        "Something in the lines of myString.split(\"\\\\s+\");. This groups all white spaces as a delimiter. So if I have the string:\n" +
                        "How to split a String by space - Stack Overflow\n" +
                        "답변 15개\n" +
                        "2015년 5월 13일\n" +
                        "How to split string in Java on whitespace? - Stack Overflow\n" +
                        "답변 2개\n" +
                        "2012년 11월 21일\n" +
                        "Splitting string on multiple spaces in java - Stack Overflow\n" +
                        "답변 7개\n" +
                        "2012년 10월 26일\n" +
                        "How to split() a String while maintaining whitespace - Stack ...\n" +
                        "답변 4개\n" +
                        "2015년 7월 7일\n" +
                        "stackoverflow.com 검색결과 더보기\n" +
                        "관련 질문\n" +
                        "What does split \\\\ s+ do?\n" +
                        "split(\"\\\\s+\"); This combines all-white spaces as a delimiter. This will yield the strings \"Hello\" and \"World\" and eliminate the space among the [space] and the [tab].2019. 7. 21.\n" +
                        "\n" +
                        "How do I split a string with any whitespace chars as delimiters ...https://intellipaat.com › community › Java\n" +
                        "관련 검색: What does split \\\\ s+ do?\n" +
                        "Is space a delimiter in Java?\n" +
                        "\n" +
                        "How do you separate words in Java?\n" +
                        "\n" +
                        "How do I fix whitespace in Java?\n" +
                        "\n" +
                        "Why %s is used in Java?\n" +
                        "\n" +
                        "What does + S+ mean?\n" +
                        "\n" +
                        "사용자 의견\n" +
                        "\n" +
                        "Split a String in Java | Baeldunghttps://www.baeldung.com › java-s...\n" +
                        "이 페이지 번역하기\n" +
                        "2019. 10. 30. — Let's split by a whitespace: String[] splitted = \"car jeep scooter\".split(\" \");. Let's also split by a dot ...\n" +
                        "\n" +
                        "Split a String by Space in Java | Delft Stackhttps://www.delftstack.com › howto\n" +
                        "이 페이지 번역하기\n" +
                        "2021. 3. 12. — Split a String Using the split() and trim() Methods in Java. If the string contains whitespace at the start of the string, it will return an ...\n" +
                        "\n" +
                        "How do I split a string with any whitespace chars as delimiters ...https://intellipaat.com › ... › Java\n" +
                        "이 페이지 번역하기\n" +
                        "2019. 7. 21. · 답변 1개\n" +
                        "1 Answer ... Try this syntax: myString.split(\"\\\\s+\");. This combines all-white spaces as a delimiter. ... This will yield the strings \"Hello\" and \" ...\n" +
                        "\n" +
                        "How do we split a string with any whitespace chars as ...https://www.tutorialspoint.com › ho...\n" +
                        "이 페이지 번역하기\n" +
                        "2019. 10. 10. — Splitting the string with white space as delimiter · Read the source string. · Invoke split() method by passing “ ” as a delimiter. · Print the ...\n" +
                        "\n" +
                        "How do I split a string with multiple spaces? | Kode Javahttps://kodejava.org › how-do-i-spl...\n" +
                        "이 페이지 번역하기\n" +
                        "2019. 7. 8. — To split the string this way we use the \"\\s+\" regular expression. The white-space characters include space, tab, line-feed, carriage-return, new ...\n" +
                        "\n" +
                        "Java String Split Space Or Whitespace Examples ...https://javadevnotes.com › java-stri...\n" +
                        "이 페이지 번역하기\n" +
                        "2015. 3. 16. — comments. A common programming scenario in Java is to Split Strings using space or whitespaces as separators. This is useful, for example, ...\n" +
                        "\n" +
                        "Java - split string by space character - Diraskhttps://dirask.com › posts › Java-spl...\n" +
                        "이 페이지 번역하기\n" +
                        "1. Overview In Java there is a couple of ways to split string by space. 2. Java simple split by space char Code example: Output: 3. Java split by whitespace ...\n" +
                        "\n" +
                        "Split a string on whitespace in Python – Techie Delighthttps://www.techiedelight.com › spl...\n" +
                        "이 페이지 번역하기\n" +
                        "The Pythonic way of splitting on a string in Python uses the str.split(sep) function. It splits the string based on the specified delimiter sep . When the ...\n" +
                        "관련 검색어\n" +
                        "Java split s\n" +
                        "Java split limit\n" +
                        "Java split comma and space\n" +
                        "Java split word\n" +
                        "Regex split whitespace\n" +
                        "Java split space\n" +
                        "Java split delimiter multiple characters\n" +
                        "Java string split max\n" +
                        "1\t\n" +
                        "2\n" +
                        "3\n" +
                        "4\n" +
                        "5\n" +
                        "6\n" +
                        "7\n" +
                        "8\n" +
                        "9\n" +
                        "10\n" +
                        "다음\n" +
                        "가나\n" +
                        "알 수 없음 - 위치 업데이트\n" +
                        "도움말의견 보내기개인정보처리방침약관"
        };
        StringPerformance.test_서브스트링_vs_split(testCases);
    }
}
