package com.system.pattern;

public interface ComparisonStrategy{
    //ham nhan ca noi dung cu va moi xem co giong nhau khong
    boolean isIdentical(String oldContent, String newContent);
}