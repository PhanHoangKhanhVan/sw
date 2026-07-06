package com.system.model;
import com.system.pattern.ComparisonStrategy;

public class CompareTextContent implements ComparisonStrategy{
    @Override
    public boolean isIdentical(String oldContent, String newContent){
        return oldContent.equals(newContent);
    }
}