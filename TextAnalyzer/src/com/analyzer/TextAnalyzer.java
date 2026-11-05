package com.analyzer;

public class TextAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Smart Text Analyzer & Comparator ===");
        System.out.println("1. Analyze Single Text");
        System.out.println("2. Compare Two Texts");
        System.out.print("Choose an option (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            analyzeSingle(scanner);
        } else if (choice == 2) {
            compareTexts(scanner);
        } else {
            System.out.println("Invalid choice!");
        }
        
        scanner.close();
    }

    public static void analyzeSingle(Scanner scanner) {
        System.out.print("\nEnter a sentence or paragraph to analyze: ");
        String text = scanner.nextLine();
        
        if (text == null || text.trim().isEmpty()) {
            System.out.println("Error: No text provided.");
            return;
        }

        int charCount = text.length();
        int charWithoutSpaces = text.replace(" ", "").length();
        String[] words = text.trim().split("\\s+");
        int wordCount = words.length;
        
        int vowelCount = 0;
        String longestWord = "";
        
        for (String word : words) {
            String cleanedWord = word.replaceAll("[^a-zA-Z]", "");
            if (cleanedWord.length() > longestWord.length()) {
                longestWord = cleanedWord;
            }
            for (char c : word.toLowerCase().toCharArray()) {
                if ("aeiou".indexOf(c) != -1) {
                    vowelCount++;
                }
            }
        }

        System.out.println("\n--- Analysis Results ---");
        System.out.println("Total Characters (with spaces): " + charCount);
        System.out.println("Total Characters (without spaces): " + charWithoutSpaces);
        System.out.println("Total Words: " + wordCount);
        System.out.println("Total Vowels: " + vowelCount);
        System.out.println("Longest Word: " + (longestWord.isEmpty() ? "None" : longestWord));
    }

    public static void compareTexts(Scanner scanner) {
        System.out.print("\nEnter First Text: ");
        String text1 = scanner.nextLine();
        
        System.out.print("Enter Second Text: ");
        String text2 = scanner.nextLine();

        int words1 = text1.trim().isEmpty() ? 0 : text1.trim().split("\\s+").length;
        int words2 = text2.trim().isEmpty() ? 0 : text2.trim().split("\\s+").length;

        System.out.println("\n--- Comparison Results ---");
        System.out.println("Text 1 Word Count: " + words1 + " | Character Count: " + text1.length());
        System.out.println("Text 2 Word Count: " + words2 + " | Character Count: " + text2.length());

        if (text1.length() > text2.length()) {
            System.out.println("Result: Text 1 is longer than Text 2.");
        } else if (text2.length() > text1.length()) {
            System.out.println("Result: Text 2 is longer than Text 1.");
        } else {
            System.out.println("Result: Both texts have the exact same length.");
        }
    }
}
