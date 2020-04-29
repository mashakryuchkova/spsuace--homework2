package ru.spsuace.homework2.objects.analyzer;

public class LongAnalyzer {
    private final long length;

    public LongAnalyzer(long length) {
        this.length = length;
    }

    private FilterType TextAnalyze(String text) {
        if (text.length() > length) {
            return FilterType.TOO_LONG;
        } else {
            return FilterType.GOOD;
        }

    }
}
