package com.analyzer;

import java.util.Scanner;

public class TextAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Smart Text Analyzer ===");
        System.out.print("Enter a sentence or paragraph to analyze: ");
        String text = scanner.nextLine();
        
        if (text == null || text.trim().isEmpty()) {
            System.out.println("Error: No text provided.");
            scanner.close();
            return;
        }

        // Metrics calculation
        int charCount = text.length();
        int charWithoutSpaces = text.replace(" ", "").length();
        
        String[] words = text.trim().split("\\s+");
        int wordCount = words.length;
        
        int vowelCount = 0;
        String longestWord = "";
        
        for (String word : words) {
            // Clean punctuation from word for accurate length checking
            String cleanedWord = word.replaceAll("[^a-zA-Z]", "");
            if (cleanedWord.length() > longestWord.length()) {
                longestWord = cleanedWord;
            }
            
            // Count vowels
            for (char c : word.toLowerCase().toCharArray()) {
                if ("aeiou".indexOf(c) != -1) {
                    vowelCount++;
                }
            }
        }

        // Display Results
        System.out.println("\n--- Analysis Results ---");
        System.out.println("Total Characters (with spaces): " + charCount);
        System.out.println("Total Characters (without spaces): " + charWithoutSpaces);
        System.out.println("Total Words: " + wordCount);
        System.out.println("Total Vowels: " + vowelCount);
        System.out.println("Longest Word: " + (longestWord.isEmpty() ? "None" : longestWord));
        
        scanner.close();
    }
}