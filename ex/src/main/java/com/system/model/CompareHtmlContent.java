package com.system.model;
import com.system.pattern.ComparisonStrategy;

public class CompareHtmlContent implements ComparisonStrategy {
    @Override
    public boolean isIdentical(String oldContent, String newContent){
        //Loc sach the HTML
        String cleanOld = oldContent.replaceAll("\\<.*?\\>", "");
        String cleanNew = newContent.replaceAll("\\<.*?\\>", "");

        //tra ve ket qua so sanh 2 chuoi da sach
        return cleanOld.equals(cleanNew);
    }
}