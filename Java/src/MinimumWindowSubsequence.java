
public class MinimumWindowSubsequence {
    
    public String minWindow(String S, String T) {
        int [] tar = new int[26];
        int [] src = new int[26];
        String res = "";
        for(int i = 0; i < T.length(); i++) {
            tar[T.charAt(i)-'a']++;
        }
        
        int i = 0;
        int j = 0;
        src[S.charAt(i)-'a']++;
        int min = Integer.MAX_VALUE;
        while(i <= j && j < S.length()) {
            if(j-i+1 >= T.length()) {
                if(candidate(src, tar)) {
                    if(isSubsequence(T, S.substring(i, j+1))) {
                        if(j-i+1 < min) {
                            res = S.substring(i, j+1);
                            min = j-i+1;
                        }
                        src[S.charAt(i)-'a']--;
                        i++;
                    }else {
                        j++;
                        if(j < S.length()) src[S.charAt(j)-'a']++;
                    }
                }else {
                    j++;
                    if(j < S.length()) src[S.charAt(j)-'a']++;
                    
                }
            }else {
                j++;
                if(j < S.length()) src[S.charAt(j)-'a']++;
                
            }
        }
        
        return res;
    }
    
    private boolean candidate(int[] src, int[] tar) {
        for(int i = 0; i < 26; i++) {
            if(src[i] < tar[i]) return false;
        }
        return true;
    }
    
    private boolean isSubsequence(String s, String t) {
        int i = 0;
        for(char c : t.toCharArray()) {
            if(i < s.length() && s.charAt(i) == c) i++;
        }
        if(i == s.length()) return true;
        else return false;
    }
    
    public static void main(String[] args) {
        MinimumWindowSubsequence test = new MinimumWindowSubsequence();
        System.out.println(test.minWindow("faalafealefelfafaleflflaeelleaelefafelflfeefaafaalleeeaflfaaeeleeallaaeeffffllalfafalfaelffffeeallaafeelfeelefelafaefafleeflfefeellllfffellleealflaaaellaeaefeaeeeealeflfafefafeeefellaalelllaefelefaeaallleealllealaleealfeeaaeaefeaefllaeefeaflaeeflaelllffeleleeeefeaaeflefllleefelfaeafeaaaaeeffaalflefleelaeeffleelffaeaeeaaleeaelaeaeeflafafelfaelflfllaealffealeeefafleaaflfelelalaealaaaalfelaaelflallefeaellelleeellaeaeaflaflllelaaeelfeaeeeelalffelefllaeeaaflaaeafeflflaeelaalaaaefefaaalfflaaeflfalefaefeffllaffaflffefeaellfalallfeelefeellellllaaaffalflaeleleeefellfaelfleealaaeafeafeaalflaafaaaeffellfflfafealafealeallfelaeafffeefaffafllleeeflaalafallaeaaaffefallallellaflflaalflaaelellelflaaaeeelffaalalealaeaeeleaafafflfaflefeaffalllfaelaaaaelffeealffffllaaafffeffaaaaaaaaaefllefeellaealalfallaffeffaafleeleelfeaallaleeealfeeflfflefeaalfeaaaaaallllaelfleefffealflaafffllllaaellfafefeelfalalaafllfaelffflleeafalflaealfefaelleeffelaaaaflelffaleaaeafallaaaaellfaaalfaalflefeaaflfalfaelllelealaefefeellaaeelefaelefefefllalaeaaafaaealfaaeeeleaalflelfalffffeaaefeefleeaeeelelflffaeleffaaffeealallaaaeelealeeeleaaaflflfllafelafeelfaaaefaaeffeefalfafffaeelleeleafeeeeaeeefalffaalfelaalealelafffalfelfallaaaeaafaflalealfeflafffeeelfalaaelaefeelefaleefaelfaaalfaleffellfefaaelafeeaaafaeffeleeaflafafeeaelfffeeaaaeeflafafelelaeeleeleffallleeleleelaeflffaelaaeelaafeleefaelleaeffflfflffeaeffllefleellaaallalaellelaefaellallllefffaefefefaefaaalefellaefeeealealeefafaeaaalaefeafllaffflalflfaaffffaleellefaffaefeelfllllaaeefallaafefeaalfeaelfaeleaflalaafafflflffffaflalefllfefleaefalelflffalfllaallellellllffaeefeffaallfeafafeelaeaeefffaellffffafaflefafllaeflflaaalalalealleflaeeeeleaaleffllaalaffefeflalalafleeleallaeeaaeaaaflleeaalaelleeflaelllaaaeflffefeealeeeefaaeeelalaealffaaeealfefeafeaafeaafleeaffleellaaellfalfeaeafaleelafallaeeflaafflfffaleelffllaffelleellefeeefllaealfllflfaeafaellaeaalalellaefaafeelflelllaaffalfeaaealflaaaaefllealllellllfefflalflffallfaafafafllaealllaellffalefafaeflelellffeefafefleelaeeeleeefeeleffflefalalaaaflfellflafeaelalaeflleallefalaffffafealllllleaeffaalleelaffeaffeafalafelfafaeefllfffellafallfefffalalflaeaallaffefllalflealeeelaallffflaefefafeaellleeflafaleaaefaelaaeafleeaafafflfaalelelfeaeffaellefelfeaeleeleeleeefalffaeeaaeeafelafleeeleaflefalfallffelafeleaalalllelaeeaaefaafflaffelefafflellaefeffleaelleffeafaefaffaeflfeelffaaffeffafaeealeeeeeflefeffealaaleleaallaelfafflfefaleaelefafffaeaalfelaeeffaelfeffaefflaaflaaaafelffefeeffeffeaflaeefllalelefffeflafeealaeelealaaaaeeallllaefelalaeffeeaaleeeefaaffaeeaffleeeelflaaellafaelfalellalfeaeeeelaefflaaallfefeeeellafefllflllfafeelfffefeaaffflafeleeefflalalfeeefaelaaleaallfffeflfealelaefaaealeafaffaffefffaafalaleefaafalelelleaeelflaefffaffeefelflaflefllfaafeeleleleffalalfelfafaeafeaaaaeelfllllafffeeelfelafealaflflflafafaaeeefaafeffefaleeelfeaefffaflllaealefaalaefaalaafaaelflefllafefaaaflfaeafleffaflfleaafaelaafleallfffalafaaleeeaeflaaefaelafefalfafalaefeffllalllleeaallaaffeeafaaaffllfaleaflaelllllffaeeaeaaaalfffaffelfaaaefeefaflfaflaaeealaleaaafeeelaeffeelaefaffaffaafaaffleflfalalalefalellaaaaeaffflfafaalelffeeaeaafalalafllaafeffefalfeffelfaflaafellffafeeaflalaaaaafeflllefefllaleeeeefeleaafelfefafffeffllllafaaafeefleaeaefflelfaffaefleefeelfalaflelaalfleeaeaafalaaeellfaelflfaeaeelffallllleeaeaeaffaaleeellaaelefleaalllaaflfeeafalfefllaafllfalaeeeefeffeeafleaflaalafalaleaaeefflalfleffalafeelfaaleeaeeefaaalefallleefffaaaaeealafeaeeleaeeelafflafelaafffaafeaffeefefeaaaeelffalleeefefefalfllafelalleefllaaleffflaelflfeaflfeeefafaelalllaaeelalleaafleflfeeaefelflelfeflllalleefafeelelealaaaaealfflfaeafleaeffllaleeaeeaaleaeaflafffelllaaleefeaflffllaaaflaleeflafaffealeelaeaeeaelfafeaffelelflaaallllelfeleeaaleaaffaeafeefellfaeleelfflalaaaffaeefallfeaaleaeflffflellelffeaefellaeflffellelflflalfefeaafllelaealaafaafafeffeleaaflfafefelefeaeefeefefafeaaaeaeeaealelaeflfaleeefllflflellealalaefeafaffelfealaeleeealflfafleafefffffaleaeaaelaeeaeffflllleeffelfaleefaalfealfflefalallaleelefeeflaafalffaflfelffafllelflafllfllafpopxorpproppprooxoxxoxrxoxrppppxroroorxrrxorporxoprrxxprporopxoxrpxpxoxroxrxrproooppooppprppxrorrxxooxrooxoppoprorprxpxrxoxpxorppppopxrxroooprxooxxxpxoropoxoxxxropprrpxoprrrooopppxppxrxpprpxoppprxorxorxoroxxrprrpppxrrxrrroxorpxrpooppoxrrpopoppxrrxoxorppxoxxrpxxxrprxrxooprxxprxrrproxrrrrpprpooorrxrxpprpropppooprrpxxroooproooxxoxxoxopoorpoxxrpoxprpporpxooxxxrxopoxpxpxorxorprxoxrxxorxprpooxrppxoxorppxxorpxxrxrrrpopxxoropprrproroxxrppporrrxoxrxroroorrppprpxropppxprororoppxprpxopprpprpppoxooxpopprrrpxpoxppppxxoorxporoxoxxppooxooroxxoxporxxxrprpppoxrpoprxxroprxxppporxrxrrrpopxxppxxxoxxopoxrrporpxpoopxxxxxopxpprprpxpproxxoroxppppxppoxpoxoprxpxrrpprxpxxrxxpoxpxxxxrorxpxxrorprrrorroxxoxxprorpprrpoorroxpxoxpxoopooxpppxrrorprropxorproxrxpprrrpxxoroporxxropxxxxooopxrrxproppprxxoooopxrrxppoxoxrrxooopoxpooxxooxppoxpooorpxxxpooxooxoopxxxporxoxxrprxppopxrrororxrxrxoxxorrxrorrxopxxprxxroxxropopxxorrxrrxpopxopporrxroopprpxoxororrpxororxxxxpopoxrrxrxxopoppooxpoxorxrrrorporxooppxoxoxoxxopxxoxrpxppppxrrprxoxrxxprxxxxpproopoooorrprpopoorprpoxporxpooxorproooppoxropoxorprrprxroropxrxrorpoorxxxprxooxoorrpxporxoooxxrxxoxpxrrxpproppprorroorxxrprxrorxrpoorprroooroxxrrorooxxoopxoopororopooxpoxxxpproporpopoxrppxxxpoxrrpoxxrrxororopprorooroxopoorxxpxrpxrxrxrxprxrrxxoxrrpoxxrrpxxoroxxrppxpxpxrpppoopprrxrrxororopxpoxxorrroprorooooorxxoxrxxoporropopxrrorpopoooxrrrpporpprpxoxxrppxrrorppxprpooxoxxpxrrproporrxxppxprxrrrroorrrxproxopxrorrropxrxoprporropoppprrrxpxopoorpooxprooooxroxooprrropxpxxxrrppxpororoorprroxrrrxppxppprropprroxrorroprxxpxxoxroopxrproprrpoxporprrrprpropxprrrrrpppoxpxoroxpxorprprxrprorrxpxrrorpxoxoxxorrroprroxrxpxrrppxporoxpooxxxxpxopooroopprxpoorprrpoopppxorrprxpprorxxorooppxrroxoxoopoxxppoporrxrrrxpxrprppopxrooppppoxoppxorxoxrxxoproxxpprrorpoppxrxpxrroxxorrrppproorroxrxroxxrroprxrpoprooppprxrpproprpxrrprrrpxpxpxrxrxrpxpoprxoroxoroorrprxxrpxpoppxoporxxrxxxopxpoxxppoxooroxprxrrppxpropprpxpppororrxorooxrororrrpprppopxoorprpxrorrxxppoopxopoooropoxrrpprpxxppxprproorpporpooxoxrorxropppxoxoorpxrrrrpxropoxxxpoxoooxppxrxxroooppxrrpppooproxprororrxrorpprpxrprxropppoorxrprorprrorxxooxoprorpporppoopxxrxxpprrppxpprroporprroroorpprooooxoxpprrrpoxpppprxoorooooprpoororoxprxrpxxxrropprooprrxrorrorrororxxprproxrxxxoxpppoppxpoprporxxpoprrxopprxrxxopxooopporpxrooxxrpoppxrppxoxrroprxppxrxrxrppxopooprooooorpoxopppooprxoxrpxorxxproorporroxoxxxrprxppooorprxxxrpooxopporxrpororprpppxprxorxxororpoorpporxrpopxropxxxxoorppxroooxpoorrppporxpxxrrrpoxpxoxprpxrorroxxxxxxoxpoxpxprrrxooppoprrxrropooprxxxrprxrxoxoroxrpppopxxrxxxxoorrppporxooopopprxrporpprpprrppppoxoxrororpoopxxrorpppoxxrrxooorxrroxxoxoxooxorprooroxrppproxxpxrorpxxprroxxoxprooxpoprrproprrxrpxxoppoxprrroxxpooxrprproxoxrppoxpprxrxxrrorpxopxroroooxroorxxoooxxxprrorxorooroxoprpprrxxroxopoorpxpopopooxpopoopoppoxxoooxxrporprxxxrpxxoxppporxpxorppoprxrppoxpoxopopxpxorxxxooorxprproppooppoooxxppxrpprxpprxpporoooxrrxopoorprppxopxpxxpppproxoppxorrrropoxpooroxpxroorrpoxrxrxpxpoppoxrppxrrpxoporopppxpxoxxppprrorxrrxopxrorooorrrxrrppropprpxpxropoxporrroppxorrxprpxpppoorxoprrproxrooropxoprprprpxppppporrxpoxxrrppxxxoppxxpxxrrproxpoporororrrroxoprpxooxprorropxxrroxrxooxrxxxorxrprprxrxxpxororxxpoxoxopoproppxpxrprxoooxooxrprorxoopprxoooxrrxopprxrxxoppxxoxopoprxxrxoxxxorpooorrxropxoxprpxpopxxpxoxoprxxporopropxorrorpporropopxpxxrrooooprorororrroooprooxorxppoxppxoopoxxoppooxopxrxpxxpoooopppooxooppxrppxxxxpoopoxxoprpoxpprproxpxopprpxxrxxxorrrxxpooorrrprrprxorrxoppopprxxoxxprxrxroooxrorpropxxpxrxorxrpxxropxxoppprrxpoxxxrxxxporpprrrporprpxpxroprrpopxxorpxxpprxooxxorxopxpxppopxxopxoroorxrpoxxrxpooorppopoorxxrppppoorxoxrprxrxopprpxxpxpoxxroorxoppppooxoppoxrrpoxoxxxopooproroprppxproxoxpoxpxpopxoorrpoxrooppxrpxooxxxxrrprooopoxrpxxxxprrpppoppprrporopoxrrprprrpporopproroprooooproxrrxpprpxoxopxxrxprppxxoxxooxpppxorrrpoooopopxxrxoooxoxxrrrprooooopoororrprooxorrxooxopoprrxxrooxrrpproxpxooporxprxxpxpprxproxrxropxpxppxprxrorxroxrpxpopppoxxroropxoxopporpxoxorrppppxxrrorprrorrprorpxpxpppoooorroxrxrporrrxpxpoxxppxroprxpprorrxoroxrrrroppxxopxoropoxxpoxopxssllmmslsmssmallssmsalalmmmslmlalmsssllmasmlmssammaaamlalaalmsammlmasamsmammsssamalalmasssmlasaalsalsllasaammmmsslsllllaamlllllamlslmlllamlsmlallllallalaalsmmlaaasamssmamlamslammsmssalaasmaaaamsllsmllmlasmmmlslmlmsalsllsmlmsaallsaaaaslslsmasalmssaasaamslllmlasmallssslalsaaaasllslamlslmmlassmlaammmmslssmlalamaaalmalssmlsllmsamaaslaslmmlmlllmamlsslmmlmaalalsssmmsssammaalmmaammmllllasasamsmlalallsamllsalsllmssmalmsmlamsalslmmslassalmlaasamamsamsalsllammmmsalsmlsalmlllslsasmalmslsslslslslssmmaasassmssmmlsasmsmllaamlmamsassmaslmsmalaaalsmaamssssamsmmsmasslmsmmmlsaaamlmsasssmllssslalamlasmlasssmsmmsalsmssmsmllslalmmammsslaalllsmllmmmlsllmammmlamlaslsmmasamsamlsamssmalmsmslmlassmmmmmlmmslsalsllaaamalaslamsmamsssmasmammmllamlmaallssmmsassallmlsalamlalsmmlsaasllmlalmmmslammamsalsallslamlmsmallmmaaasmasalmlslmlsmmmasaamalsalaalalmsaammasmmaalssmmaasssllmamlmsssallssslmlmamlllsalammsmamaammmlasmmamllmllmammammlamlslammmllllssllassmmsmaslasssaassslmllmlalmllalmaaaamalmlsaalsssaamamllmamsammssssaaalsmaaamlmlsaassalaassslsalalsmasamaslalslalmasllssllaallsssalasamssmsalallaammlalmmmaammalaslmmlsamlllmsmasamlmaammmamalamlsllamlmsmmlllasmasmalaaasslmsllmlmmllsasmllssmllsmlssmamslssmmamsmssslsmlsmllllmaalsmmalalslsasmmamsmssalaasmallmsllssmlaslalallmassssamsmmalmasslssaaalslmsllsmmmssalmlsslaasmllmmlaalmsmlaassaslsmsmlmsslmslaasalmasslaslamasmmsmmlllsalsmmmaslalmmlaamalalslsalslmaslsslasalllmmlamamalmasssllasmlassalllmsmmlsamsammslallmssssamamamaamlmssmassmslammmlmalssllmmslmassllsmmaaslsaalmlaamaalsmlmaammmlsmlassmmlmmmasmasallmlalassasamslsaalsmsammalmlamsmllsmmmmasasllssslassallmmsmasaaalasllmlmsllsammmlasmlsammamaaaslsmlsalssllalsaamalmlsmaasaasmlaamallamlammsslalaslalsallamlmamsalmmaslsmaalsmllaasaassassllaasmsslamlllmmssslasllmsamallassamsmmsamlmamaslsaalsmmlsaaamllallaslsamlsalaasalassmlalsllmlmaslammallasaammsamssmlaslsmslalmlmlsaallaamalalslmmssallmlmsslasssmllslalaaalaasasmmlmamaasmsmsmamslaasalaslmaalsassaaalmlmmssmlslalslmlmlaasalsmssmmlmmamllaamllamlsmsslamalamlmsmmmamasmamllslllsallasalslmsssasaaasaaalmasllmamssllslsmasallalalasmlsmmsalslalllmlssallaammlmlllaasasslalllsslmmsmlslammlamlmamasmmammsalmaallssallslmsmlamlaallalmaalllmalmamlllmlasslslmmmamllsmaaasmsssaasasssmaamsslmssmlmlamlmsamlaalllsmlsmaasamllsaasmmslamsmsaalalmlaasmsaaamalssmammsasllsalslalasmsssmamasllsasmamalaamasmslsmmlmlmlalamlmalmssmmammmasamlllmaalmasllslalalmlaaamlamsmmaslaslmlsamlalmmsmmlsmllllsmlmmsmssmsllssmsamsaaamsmlasslmmmaslallaaamammmallmmaamlalmllllmmmmmlmmassalsalalasammammlllmlmmsalmmlsaasmsallaamalaaamsmmamsasmmsslasmmmaaasslmlmllmmslllalslllalsaaaasslasmsassmmasmlalmmlsllmmlslslaalsassssalmssaasmsaamssslslmslmmsmssssasmaaslasslsmmsamslsasamsaaalsmallmsmsalllssammalalmaalsmlllslmssmllaamalslaasmssamlaalassmssmsmaamsaalsmllmsssalmaaammmslsalmlsaslslsmaamammmasssssamsamllamasmlsaslmaallsallmlsaammassamslsmlsamaamalsalaslaaslslsllmsalssllasasalllmaaammalassmlllamlsaammslmasamaslmaalassaammlmmlalmmalsmmlmsllsslmlsmmslllslsmlaassmsallmaaamsmaamaammmlallsssmlsmsssmlsasmlmlmssaalammalalaammsmssslsamsmmslalslmssmmsammmaalmslllsalslasallallalalsaalmmasamllllllmaslmasmllssssaamaaamllalmlllaslamslsmmsammmlmsllamslasllamsllamsasmlllalmmlmmslsallsslaalassamssllasmslamssmmmalsmmalalalmmslmslaamassmmslmsamlalmmamlmmllammamasamllllmlaasslamlammalamalasslsaamlammssllllsllsmaasaasalsmsmamaslalasasmmamssamsllslsmamsmsslmmsllalammaamlmmlslsmmsaaallmsslslamsmlamlalasasassssamaamaamaammalmsmssalmssmmmaslssmaamlllsslmaamalmlsmsmsslasalmaaamsllmmamsamllmssmslaaaamasmlsssssamaammlsmlsassaalsalmlmalallmmllsalmlmmlsmmmssmaalassllmamasammlamassmsslamalmssammmsmssallmmallllsasssamsaaaamsaalsalaammsmaamlssaslaslllamllmmlmsammlmaaalmsmsamaasalsaaamalalsaaalalslalmaamasmmmlslsamlsamalalmmmmsmamsaaalsammmslsmsmmsmamsmsmmsmmlmssmslasmmmaamslsmmsllmsamasammmsamslaalaaammmsllmmaslmmlaslsssslmlmmssaslsssmalasaslmsasslmaalamsallasmllsslsalmsmaslamaassslsssmslalssmalaaasammasmlslammmmsllmlmsmsammamslmsslsmsasmsslasssmmmaslsmmlslsllssslassmmmsmlsmsalmasmasllallllalasslmmaaaammllamamlmllfftfffhkhkkffhfkkffkffttkkkhktktkktktkfkttftkkhkhthfthkhktttkfhfhffktkfhtfktthfhhthfkhkkffkhttkftfkhkthhhthkftkffthktkkhkftkhfkfktkfhkftkttkfttttkfkhthhftthfkkfkhkthkfhtffktttttttfkkkkfhtkthtfthhfhtkhhhthffhhhfhhhfkttkkhtkfhfkfhfhhhkhkfkfhkhfkfhhkkhfkthhfftfffthkfthkhhhtfhkhttfktfhhkhhhfhhfhfftfhhhfhttthfkfkftttkhffhhfktkhkthtkttkkhthkfffhfhkthhthkhkhkfkttfhfthktktftkkhfkkfkttfhttfttkkkkhhfktttkkfhkfkhktftktttktkhthktththkthfhhfthfkkhhhkffkhhtkfkkfhhkhkfhtfkfthkkfkfftkfhftkhkhffhhfttkhtkthttkfttthtfhfkfkkhfhhhkttffkhtfffhkfkkhfkhkktkhftfffkkthtfkfhtthfhhfthkfhfttffhfkffthttftftkfkhfkkkkfkktfhkffhfhkffhhhhfhktkkkkkhtkhhhffhhktfkkthttffffhkfthhfttkfthkhhttttfttfhttttkffthttfthfttttthtfkftttffthfkkfhffftftkkfktthfhffkthkftttkhkhthtfhhfkhtffhttkkkhkfthfkktthfhttthkhtthkfhtfhhhfhktffkthttthkhhhtfffkhthhkhhhkfhthfhfhkhhkhhtkfththhkffhfffkkfkfhfhffftttftffhththfthhthfhffkfkkkfffkhkhttfkkthffththffkhttfthkhkkthkftkkfhthhttttffhfhttkhtkhtffffhfkfkhfhkthhtfkhhttfhtkkftfffffhhffkhkhhtfftfhhtfhttfhktftfthhhttkkhhkfftththfttkfhhkhkhtkkthkfhhhhfhtttktfkfhkthtthhhkkhfftthtthtfffhhhftkkhfkhhkkhhkthkkhhkhktkkfttkhhhftthffffhhtktktftkhtkhkthkftfkffktfhtkfhhfhtktttttffhkfhkhtthtftkhtthkkkhhtkthhfffkfhhfkttfftktffhthftfthktkkhfthhfhhtkhkfhkhhthhfkfftffkkktkfhthkhkhkhhkfhhhfhffffhfhffttfftfhkthkfhthffhhthhfhtftkkkhhtttkkftkhhtfhtkhtktfttkttkfhkkhkthkthkfhhkthkhfthkhtftthhkfhhktfkkfkktthkhfhthkthtkhkfhktktkhthfkkkkttthtkfthfhffkhfftftftkkkkkthhkftfftftkthkhhfkftfhkfttkkkkfhththtttkftkfhttfhffhhhkhkhhhtthkkffkktkktkftfkfkfffkfhhkfhffkhtfkffkththfffkfffttkfkhtttkhhkttkhfhffkhktthkththkfftkfhkhhttfhtkfhhttkktfttfhhtffkthtkhthhffhthfkftfkfktftkhfftthktkthkthhtkhkttfthtffhftthtkkthkktthhtfkffkkkhhfffthhhfkhtttffhhhtfhtfffttkttthfftfthtthhkthfhtfhhttthhtkkkhkkhkthhffhkhtkkffhffhhtkffthhhhkkktfkhtffkthffkhhkhtkhhhfhfhkkkkhkhkkfthktfktfhhhthttfhfhhkkhfhffhttktththfhkhfkhhkhfkfftkkhttkkhfhfkftffffkkkfkffthfkhhttthkkfktktfktktfftthfftkfkhtkthkfkfftkkhftthkttfhfhtttfhhtftkththkkththfhfhfkfkhhfkhhtfhhkffkftttfhktkkffhfhhhhkthkkhhktkhtthfkfhkkffhffhhhfkkhfkthkktffhkfthhftttkkthhftffktfhhhhttttfthttfhtfftkkkhhtthftkkttfhftthfhffthkkkftkhkfftfkfhktttkfkhftfhtththkttfkhhkhkkhhfhtttkkkfkktkfkkhhtffkhffkhttttffkttkhfhftffhtthhtkffhhfkftkhtthkhtkfhffttkhkhkthktffkftkfttthfhfttkhhkhkkhkhhhfkkkkkthkfftkkhhhkttthfhtffhftfthfhkfffftffhkffhhtffktfhtkfkffffkktftkkfhtktkththftkhfhkkthfhffftkftffkhtfkkkkkfkkfftftttkftkhththkffhtkkttktttkhkfkfkthhtkfkkftfhkkkfkhhfhhtfkhkkfkfhhhfttfhhfkthfkhhhttttfkhhtfhftffhthkkffthfththththffhffthhthtkhfkhthhktkkkhkhhkhfffkfktkttfhkkkthfhfhhfthhkthhhhtfttkhkffhtthftktftttktkfhthhhkftfhhhftkfhhkhkhtfffhftkfhttthktffhhhhttfftthhhhhhtffhttthkkkfhkhhkhhkfftthhtkhhfkttktkffkhhfktttfhhhhthkkhfkfktkhhkhkttkkhhthffkfkfhkfhhftkhtfftktkfkfftfttthhttftfhthtfhfthhfthffhtttkkkhkftfkthftfkhtthkhfhhfkfkkhfkkkftfkkkhhkkkktkhhttkftthhfftthtkfhthfktfffkttkfffkthfkfkhtffhhhfhhhftkhhtfthkhktkththkfhkhtkhfktkftkkhffhhhkfkktthftfttfkhkkkfhkthhhffhktttffhfkfhtkkfttktkfkfhkhftkkthtfhfkkftftkffhkftfhhhkkfhftftkftkhkhhftkffktktftfhhkkfhffthtkhffffthtftthfkhffkkhkkftfkkfhhkhftfkkhffkhktkkfkfkthttkkffkthttfftkfthffhkttkkhtfthfkfthftfkffkfkkhhkhffkfkfhtktkfkkffhkkkhtfttkfhkkhtktffhkfhhkhkhhtkkhhhhktkhhhthkfkfkftftttttthkhkkkftthhthhfthhfttfthtftkkkfhffkffttkffkhtkffhffkfkhfthkhkfhkthkhhkttffftfftttkhthftktfhhtkhtkhtfffhkhhkfttfftkfhhttthftfthkkhtkkthtfkktkkfhhfhffhkftkffkfhkthfftkffkhtffkhkkfkkkkhfhfthktktktkhtfftkfhkfkhfhfkktktkthfftkhkfffhhhhhfhhtfhfthffkhkffkhhthhhttkhhkkthhfkkfkhkfftkttfkhkkfffkktfhfftktthhffffhthhtkfffthtftkthfkfktktktttkhkkkfhhtktktfthffhktkttktfkttkhkhkffthfkfttththhfhhhtkttkfkthfktkhftthkkkkthkthtftfhkhhhfthkthftkkkthftfkkkhffhkktffkfkhtfhftffhhhtfthftfkkfhhhkffktkffhtkhkhhkfttkktkfkftkhfhhhtfhtttkkhtttfhkkffhffttkffhtkffffhfthftffktkkttfhttkthffkkthkffhkffftthktfhfhftktftffkfkhtftkfhhkhkhffhhftkfktftkfkthkkhhtfkkkhhhkfkhkhhkkthhkfhtffftkhkttfktthhhhffthkkkhkftthttfhfkfktfktfkttttkhfhkftftftktfthhfttttkffftkfthhfttfhthkkkhtfhhhktkkkhffthkfhtktffxccdzxczczzzxddxxxxxczdzdddccxdzzzzxxcddcdzccxxzxzccdxcdczxdcxxczzdxzddxxdzczxczcxxcxcxxccdcxcxxdxxxzdzzcxdxxzzdcxzcxcccxcczcxdzdcxcxxxzxdzcdzcdxxxdxcccxxxcdczzdzxxcxxxzzxxczczzdxzzxcxzzczdcdzcdcxxcxcxxdcdzxcccdxzzzcddxzcdxxcxddcxcccxzzcccddcdzzzxzcddcdxcdxzdxzcdcccddxzdxxczzcczcczccczczdzdxdxzzddxcxxdxzczdcxzdcxdxzddxzzxzdzddzxzcddzdxcdcdzxcdcddcccxxxdxczdxcccdzzdxdxdxczzzdzdcxzzxcdzcdzzzdzzcczdczczxxcxzzzxzccczzxzdzczzxczcxzxczxdccczddxxxccxdccdxdcdxzdzcdczdxddxdcxcdcxdxxxzcxdzzczcdxdxzdxdddxxxzzccdczxxxzcdcddzzzczczxxcxdcdcxzdzdxdzdzzzxcxdczzcddxcdxxczzcddccccxzdzzxcdczcxcxxxxdccxcdxzccdccxzzxxcxzzzdzccxzcddcxcxccdxcdcdddzddxzzxczxxdccdxxxccczdzxxddxxdczcxzzxzdcxdzxzxcxzdczdzxzzzxzccccczzzcdczzzzxxcxzxczcxzxzxzddxcxdzdcddxzdcczxdzcdczzzccxcccdzzddxxzdccxxzxcxxcxzczxdzxxcxxxxcxdcxdzdzzzzdxzdcccxzcccxxccxczxcxxzdcddxdczdxxxczzcddxxxxcdczdcdxcdccdczcczdzdxxczzdczcxzczzczzxczdzzzxzzxcdzxxdxdzccdzdzcddzxcccxcddxzzzzzzzzcxzcdzdxzdccxcccxcxdczzcxxxxcxxcdxdzxczdxzdccxcxzzdzcxzxczxzxccdzcxdddcdcdzxzxxzdcczzdcxcddxxcdxdcdczdxcxzxxzzdxzdzzdzxcddxdcddxcdzzzzxzdcxzxzxdcdcdzdcdxzccczxzzzddxzzdxxcxdzxcczcdcdzczxzdxczxcdzdzddcxxxzddccczxcccxddczczdzcxdcddzzxddzzxdzxzdccxdxcxczczccxzdcddcddzzdxzxczddzzcxczxxxddczxczdzxdxzzddzzxzzccxcdxzdzcxzxdcxdzdzzxdzdzdzxxcczcxxxzccdcxcddczxdddzzzcxdzzcdcdxzczdddxdxdxzczddzdxczcxccddcxxcdzcczcxczcxzdxccxzzxdxcdzczzcdxxdcdzdzzccczddccdczdczcdxdxxzdzzccdzcdczxzcxxxcdzzzcxcxczczzdxxdcdzxxcdxcxxzxccdddccxxdccddzczzzdxxddcccdzdzxxzzxdzzzxxdccxcdcddzdxxzdccxdzddccccdzxzdxcxdxczczcdxxczxzcddxcxxcxdxxzxdzcxdxzxcddcdcxdzzxzcccccxzzxdzzdczdczxxddzzzdzdzcddxczcdcxxxdzccdxxxxzcxdxdcdxcxxzxcdxxxdxzdzxczzxxxdcdcczxxzdzxdccdcdddddczxzxxczcxxcxcczddcccxcddcczzczddxccccxcxccxdccccccddczzdzzxxxddzddzcxxdzczdxddzzxzxzxzdcxddzzzxcxcddddcxczczdxddxczcdzdxzczdzxxcxxzcdxdxzczzccdcxzdxzzzdczzxdxzzxczdcxczdcxzzzcxdcddddxxxdccdzdcxzzcxzczcxzzdcddczczcccdcdcxxcxdddccczcdcczdczxddzxdddxccddxzcdxxxdxccdzdxcxdxddxdzzdxdcdcccddxzdczccddccdczczxzzdzxzccczzxcdddzdddcdzxdzccxzzcxdzcxccxcddcxdzdzccxdxxzxcxcdcxdzdxzccxxdxdcdzxxdxdddzcccdzzcdzdcdxczxdczczdcdczdcxxdxcxxzxzczxzzdzdxzzcxcxczddxczzxczzcdxczzddcdxcxxxxcdzczxczdzcxdxddcddxzdxdzcxzccxxdcxzxcdzddxxxdxxzdcxdcxcccdzxxzzxdxczdddxxxczdxzxzzcdxzcczxxccdxcdddxxdzczddxdcczzdzcdzzzcczcxcdccxzzcdxcxzxxzdzcczzzczddccdzdxczzcczcxxzczxzxdxzxczcdzdzxdcxzczzczcczxdxdzdcxcczzzcddczzxxzdcxxxzzczxxccczxdczdxcxxxdcxzdxcccdxzcczdxczxddxzddxdzxxdddcxxdxdzdxczcxzdcdzzddzdcddcczcxzcdxdcxcdczczcxzcxdzczcdxzdcxccxxzccdxzxxcdczdxzxczzxzxxcdzczzzcxzxdxzxxzdzczdzcczxcxzczdzddcxdcxddxxdxdzxxccxxxzcdddxddczzddzzddzxdxzzzxzxzxcccxxczdxcdzccddzczzdczdcccxczddddczzcdzdddxzccczcxxddczxzcczczddddcdzxdcdcxxdzzzzccxccdxdcxdxdxzzccxdczzdxczccdcczxzxdxcdxdzxzxxcccczxxdzzdzccddcxdzzzzxcxxxddzzzdzdccxdzxczzxdzxxddddcxzddzzxcdccxxzccxzcxzxddccxxddcxdxczxxzdzzxcddzcdcdzczzzdzzdxccxcczzczccxcczzczzcczzczdzzdczdxdxxdccxcxxxdzddxdxxzzxzxcdxxdxdcxxcxcxzdxczdcdzdddxdxczzdzdzzccxzzddcdzddxcdczcdxccczxxxxczxdxxxcxzdczxzdczczxdxxzzxddzcxdccdcczdzxdzzxddcdzczzddczcxxczccczxxczczzzxdxzdxdzdcxxzdxccddzdxczdccxxxdcczdzzzdxdxzdxddxdddxxcdxzdxzcddcxzdcdcdzcxzxdcxcdcxxzdczcxdcxdczcczxdxczczdzzcxzdcdxccxczdxcxxdzzdxczzdxzdzxddcccdccxxxcxzdxccccddzzdcdxccccddxcccxdzzxxczxcdxddcdxczdzxzxcczxzzzzcxcdcczxddczzxxzxczdxzccxxcccxccddcdxcczcxczczxcxcdcdcdzzxzxdxzxcdddxdzzxzxxxzzxzzccdxxdddxxdcdczzdccdcxxcczxzxxczczzxxcxcczzdddzdcdxzxddcdxcccdzdxdccxxcxxdxxxdczzzcxxcdcxxdzxxzzcxzzcdxcxdxczdcdzzdcczcxdczdzxzzxccxxdzdzdzxdxzcdzzxcxdzccdcddzddzxcdczdccxdczxzxxxczdxxcxdzdddczczzxzdxcxzxzczzdxzdzxccccddxzxxxzzdccdzzcddcxxdcxxxcdxxzdcdzzzzddzdcxxxzzdzdxcxzzzzzxcdczzdzxdxxdcdcxxzzdxccczcdccdcxzzzccddcccxzxcdzccccxzzcddcdcdcxzxdzcxddczxcdzdddzcdxcxzxxccczzddccczccdddxdzccxcddzcdzzzxxzcczxcddcdzczddzdxxxxxccczczxxxxxccdcxczzdzczxcxdxzdxxzzcccxcddzczzzdxdcxxxzdxccxzcccdzcxxxcdxcxzzzcdxdzzxxdzdzcczczzzzcdzczzcxxcdcccdxzdzzzzzzcxczxcczdzxdzcdxzdcdcxdxczzzzddddzcdxzzzccdzzxxcdxzxcczzxzzccdxcccxxcdzdzzzzxxxddxxdcxxzxcdxzxxdzdczxxxdcdxxxxdzdxxcddczdxzxcxzxzcxzcz", "aallorposamamtfkkthcdx"));
    }
}
