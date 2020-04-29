package ru.spsuace.homework2.objects.analyzer;

public class SpamAnalyzer implements TextAnalyzer {
    private final String[] Spam;

    public SpamAnalyzer(String[] Spam) {
        this.Spam = Spam;
    }

    public FilterType TextAnalyzer(String text) {
        for (String bad : Spam) {
            if (text.contains(bad)) {
                return FilterType.SPAM;
            }
        }
        return FilterType.GOOD;
    }
}
