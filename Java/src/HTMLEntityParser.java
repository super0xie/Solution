
public class HTMLEntityParser {
	
	public String entityParser(String text) {
		text = text.replace("&quot;", "\"");
        text = text.replace("&apos;", "\'");
        text = text.replace("&gt;", ">");
        text = text.replace("&lt;", "<");
        text = text.replace("&frasl;", "/");
        text = text.replace("&amp;", "&");
        
        return text;
    }
	
	public static void main(String[] args) {
		HTMLEntityParser test = new HTMLEntityParser();
		System.out.println(test.entityParser("&amp; is an HTML entity but &ambassador; is not."));
		System.out.println(test.entityParser("and I quote: &quot;...&quot;"));
		System.out.println(test.entityParser("Stay home! Practice on Leetcode :)"));
		System.out.println(test.entityParser("x &gt; y &amp;&amp; x &lt; y is always false"));
		System.out.println(test.entityParser("leetcode.com&frasl;problemset&frasl;all"));
	}
	
}
