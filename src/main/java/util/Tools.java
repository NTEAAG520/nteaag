package util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tools {

    //返回所有匹配项的分组1
    public static List getLstVal(String txt, String regx) {
        Pattern p = Pattern.compile(regx);
        Matcher m = p.matcher(txt);
        List listFind = new ArrayList();
        while (m.find()) {
            listFind.add(m.group(1));
        }
        return listFind;
    }
}
