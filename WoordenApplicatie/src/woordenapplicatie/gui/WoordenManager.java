/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woordenapplicatie.gui;

import java.util.HashSet;

/**
 *
 * @author Milton
 */
public class WoordenManager
{
    public String aantal(String input)
    {
        int differentWords;
        int totalWords = 0;
        
        String[] words = input.split(" |,|\\.|\n");
        HashSet<String> differentWordsSet = new HashSet<>();
        
        for(String word : words)
        {
            if(word.length() != 0)
            {
            totalWords ++;
            differentWordsSet.add(word.trim().toLowerCase());
            }
        }
        
        differentWords = differentWordsSet.size();
        
        return "Totaal aantal woorden:  " + totalWords + "\n" + "Aantal verschillende woorden: " + differentWords;
    }
}
