package com.system.model;
import com.system.pattern.ComparisonStrategy;

public class CompareContentSize implements ComparisonStrategy {
    @Override
    public boolean isIdentical(String oldContent, String newContent) {
        // Chỉ cần so sánh độ dài của 2 chuỗi và trả về kết quả trực tiếp
        return oldContent.length() == newContent.length();
    }
}

