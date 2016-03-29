/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman_compressie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 *
 * @author Milton
 */
public class HoffmanManager
{
    private String input = "superaardappelbananensplit";
    private PriorityQueue<HuffKnopp> charFrequency;
    private PriorityQueue<HuffKnopp> huffTree = new PriorityQueue<>();
    private HashMap<Character, String> codes = new HashMap<>();
    
    private ArrayList<String> encodedMessage;
    private String decodedMessage;
    
    public HoffmanManager()
    {   
        System.out.println("Calculating frequencies");
        charFrequency = frequency(input);
        for(HuffKnopp huffKnopp : charFrequency)
        {
            System.out.println(huffKnopp.toString());
        }
        
        System.out.println("______________");
        
        System.out.println("generate HuffTree");
        generateHuffTree();
        
        for(HuffKnopp huffKnopp : huffTree)
        {
            System.out.println(huffKnopp.toString());
        }
        
        System.out.println("encoding characters");
        lettercodes();
        
        for(Entry<Character, String> entry : codes.entrySet())
        {
            System.out.println(entry.toString());
        }
        
        encodedMessage = encodeMessage(input);
        
        System.out.println(encodedMessage);
        
        decodedMessage = decodeMessage(encodedMessage);
        
        System.out.println(decodedMessage);
    }
    
    private PriorityQueue<HuffKnopp> frequency(String input)
    {
        ArrayList<Character> wordsCounted = new ArrayList<>();
        HashSet<Character> wordsUnique = new HashSet<>();
        
        List<HuffKnopp> list = new ArrayList<>();
        PriorityQueue<HuffKnopp> frequencies = new PriorityQueue<>();
        
        for (Character character : input.toCharArray())
        {
            wordsCounted.add(character);
        }
        wordsUnique.addAll(wordsCounted);
        
        for (Character character : wordsUnique)
        {
            list.add(new HuffKnopp(character, Collections.frequency(wordsCounted, character)));
        }
        
        list.sort(null);
        frequencies.addAll(list);
        return frequencies;
    }
    
    private void generateHuffTree()
    {
        for(int i = charFrequency.size(); i > 1; i--)
        {
            HuffKnopp leftChild = charFrequency.poll();
            HuffKnopp rightChild = charFrequency.poll();
            HuffKnopp parent = new HuffKnopp('*', leftChild.frequency + leftChild.frequency);
            
            parent.leftChild = leftChild;
            parent.rightChild = rightChild;
            leftChild.parent = parent;
            rightChild.parent = parent;
            
            charFrequency.add(parent);
            
            huffTree.add(leftChild);
            huffTree.add(rightChild);
            huffTree.add(parent);
        }
    }
    
    private void lettercodes()
    {
        for(char character : input.toCharArray())
        {
            String code = "";
            
            for(HuffKnopp huffKnopp : huffTree)
            {
                if(huffKnopp.character == character)
                {
                    code = parentCode(huffKnopp);
                }
            }
            
            codes.put(character, code);
        }
    }
    
    private String parentCode(HuffKnopp huffKnopp)
    {
        String code = "";
        
        if(huffKnopp.parent.leftChild == huffKnopp)
        {
            code += 0;
        }
        else
        {
            code += 1;
        }
        
        if(huffKnopp.parent.parent != null)
        {
            code += parentCode(huffKnopp.parent);
        }
        
        return new StringBuilder(code).reverse().toString();
    }
    
    private ArrayList<String> encodeMessage(String input)
    {
        ArrayList<String> encodedMessage = new ArrayList<>();
        for(char character : input.toCharArray())
        {
            encodedMessage.add(codes.get(character));
        }
        
        return encodedMessage;
    }
    
    private String decodeMessage(ArrayList<String> encodedMessage)
    {
        String decodedMessage = "";
        
        for(String code : encodedMessage)
        {
            for(Entry<Character, String> entry : codes.entrySet())
            {
                if(entry.getValue() == code)
                {
                    decodedMessage += entry.getKey();
                }
            }
        }
        
        return decodedMessage;
    }
}