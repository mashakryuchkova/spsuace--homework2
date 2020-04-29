package ru.spsuace.homework2.objects.analyzer;

public class NegativeAnalyzer {
    private final static String[] negative = {"=(", ":(", ":|"};

    private FilterType TextAnalyze(String text) {
        for (String bad : negative) {
            if (text.contains(bad)) {
                return FilterType.NEGATIVE_TEXT;
            }
        }
        return FilterType.GOOD;
    }
}

