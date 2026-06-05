package com.system.model;
import com.system.pattern.ComparisonStrategy;
public class CompareHtmlContent implements ComparisonStrategy {
    @Override
    public boolean isIdentical(String oldContent, String newContent){
        return oldContent.equals(newContent);
    }
}