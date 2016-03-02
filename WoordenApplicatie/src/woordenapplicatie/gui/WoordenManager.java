/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woordenapplicatie.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.SortedMap;
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
        String result = "";
               
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
        
        treeMap = sortByValue(treeMap);
        
        for(Entry<String, Integer> entry : treeMap.entrySet())
        {
            result += entry.getKey() + "    " + entry.getValue() + "\n";
        }
        return result;
    }
    
    public TreeMap sortByValue(TreeMap treemap)
    {
        TreeMap sortedMap = new TreeMap(new ValueComparator(treemap));
        sortedMap.putAll(treemap);

        return sortedMap;
    }
    
    public class ValueComparator implements Comparator 
    {
        TreeMap map;
        public ValueComparator(TreeMap map)
        {
            this.map = map;
        }
        
        /**
         *
         * @param keyA
         * @param keyB
         * @return
         */
        @Override
        public int compare(Object keyA, Object keyB)
        {
            Comparable valueA = (Comparable) map.get(keyA);
            Comparable valueB = (Comparable) map.get(keyB);
            System.out.println(valueA +" - "+valueB);
            return valueA.compareTo(valueB);
        }
    }
}
