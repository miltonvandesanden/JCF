/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woordenapplicatie.gui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author Milton
 */
public class WoordenManager
{
    public String amount(String input)
    {
        int differentWords;
        int totalWords = 0;
        
        String[] words = input.split(" |,|\\.|\n");
        HashSet<String> uniqueWords = new HashSet<>();
        
        for(String word : words)
        {
            if(word.length() != 0)
            {
                totalWords++;
                uniqueWords.add(word.trim().toLowerCase());
            }
        }
        
        return "Totaal aantal woorden:  " + totalWords + "\n" + "Aantal verschillende woorden: " + uniqueWords.size();
    }
    
    public String sort(String input)
    {
        String output = "";
        
        String[] words = input.split(" |,|\\.|\n");
        TreeSet<String> uniqueWords = new TreeSet<>(Collections.reverseOrder());
        
        for(String word : words)
        {
            if(word.length() != 0)
            {
                uniqueWords.add(word.trim().toLowerCase());
            }
        }
        
        String result = "";
        
        for(String word : uniqueWords)
        {
            result += word + "\n";
        }
        
        return result;
    }
    
    public String frequency(String input)
    {
        ArrayList<String> wordsCounted = new ArrayList<>();
        HashSet<String> uniqueWords = new HashSet<>();
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        
        String[] words = input.split(" |,|\\.|\n");
        String output = "";
               
        for(String word : words)
        {
            if(word.length() != 0)
            {
                wordsCounted.add(word.trim().toLowerCase()); 
            }
        }

        uniqueWords.addAll(wordsCounted);
        
        for(String word : uniqueWords)
        {
            treeMap.put(word, Collections.frequency(wordsCounted, word));
        }
        
        SortedSet result = entriesSortedByValues(treeMap);
        
        for(Object entry : result)
        {
            output += entry.toString() + "\n";
        }
                
        return output;
    }
    
    public String concordation(String input)
    {
        ArrayList<String> wordsCounted = new ArrayList<>();
        HashSet<String> uniqueWords = new HashSet<>();
        TreeMap<String, String> treeMap = new TreeMap<>();

        String[] lines = input.split("\n");
        String[] words = input.split(" |,|\\.|\n");
        
        for(String word : words)
        {
            if(word.length() != 0)
            {
                wordsCounted.add(word.trim()); 
            }
        }
        
        uniqueWords.addAll(wordsCounted);
        
        for(String uniqueWord : uniqueWords)
        {
            String occurences = "";
            int i = 0;
            
            for (String line : lines)
            {
                i++;
                
                if(line.contains(uniqueWord))
                {
                    occurences += i + ", ";
                }
            }
            treeMap.put(uniqueWord, occurences);
        }
        
        String output = "";
        
        for(Entry<String, String> entry : treeMap.entrySet())
        {
            output += entry.toString() + System.getProperty("line.separator");
        }
        
        return output;
    }
    
    static <K, V extends Comparable<? super V>>
    SortedSet<Map.Entry<K, V>> entriesSortedByValues(Map<K, V> map)
    {
        SortedSet<Map.Entry<K, V>> sortedEntries = new TreeSet<>(
        (Map.Entry<K, V> e1, Map.Entry<K, V> e2) ->
        {
            int res = e1.getValue().compareTo(e2.getValue());
            return res != 0 ? res : 1;
        });
        
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }    
}
