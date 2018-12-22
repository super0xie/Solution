import java.util.HashMap;
import java.util.HashSet;

public class UniqueEmailAddresses {
	
	public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for(String email : emails) {
        	int idx = email.indexOf('@');
        	String local = email.substring(0, idx);
        	String domain = email.substring(idx+1);
        	local = local.replace(".", "");
        	int plusIdx = local.indexOf('+');
        	if(plusIdx >= 0) {
        		local = local.substring(0, plusIdx);
        	}
        	
        	String aux = local + "@" + domain;
        	set.add(aux);
        }
        return set.size();
        
    }
	
	public static void main(String[] args) {
		UniqueEmailAddresses test = new UniqueEmailAddresses();
		String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		System.out.println(test.numUniqueEmails(emails));
	}
	
}
