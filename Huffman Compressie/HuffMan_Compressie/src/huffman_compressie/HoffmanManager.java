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
    private HuffKnopp root;
    
    private ArrayList<String> encodedMessage;
    private String decodedMessage;
    
    public HoffmanManager()
    {
        System.out.println(input);
        
        charFrequency = frequency(input);
        root = generateHuffTree();
        lettercodes(root ,"");
                
        encodedMessage = encodeMessage(input);
        System.out.println(encodedMessage);
        
        String encodedMessageString = "";
        for(String code : encodedMessage)
        {
            encodedMessageString += code;
        }
        
        decodedMessage = decodeMessage(encodedMessageString);
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
            frequencies.add(new HuffKnopp(character, Collections.frequency(wordsCounted, character)));
        }
        
        //list.sort(null);
        //frequencies.addAll(list);
        return frequencies;
    }
    
    private HuffKnopp generateHuffTree()
    {
        for(int i = charFrequency.size(); i > 1; i--)
        {
            HuffKnopp leftChild = charFrequency.poll();
            HuffKnopp rightChild = charFrequency.poll();
            HuffKnopp parent = new HuffKnopp( leftChild , rightChild);
            
           
//            leftChild.parent = parent;
//            rightChild.parent = parent;
            
            charFrequency.add(parent);
            
            huffTree.add(leftChild);
            huffTree.add(rightChild);
            huffTree.add(parent);
        }
        
        return charFrequency.poll();
    }
    
    private void lettercodes(HuffKnopp huffKnopp, String code)
    {        
        if(huffKnopp.leftChild != null)
        {
            lettercodes(huffKnopp.leftChild, code += 0);
        }
        if(huffKnopp.rightChild != null)
        {
            lettercodes(huffKnopp.rightChild, code += 1);
        }
        
        codes.put(huffKnopp.character, code);
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
    
    private String decodeMessage(String encodedMessage, HuffKnopp huffKnopp)
    {
        
        String character = "";
        
        for(char bit : encodedMessage.toCharArray())
        {
            if(bit == 0)
            {
                decodeMessage(encodedMessage.substring(1), huffKnopp.leftChild);
            }
            if(bit == 1)
            {
                
            }
        }
//        String decodedMessage = "";
//        
//        for(String code : encodedMessage)
//        {
//            for(Entry<Character, String> entry : codes.entrySet())
//            {
//                if(entry.getValue() == code)
//                {
//                    decodedMessage += entry.getKey();
//                }
//            }
//        }
//        
//        return decodedMessage;
        
//        String decodedMessage = "";
//        for(String code : encodedMessage)
//        {
//            decodedMessage += decodeCode(code, root);
//        }
//        return decodedMessage;
    }
    
//    private String decodeCode(String code, HuffKnopp huffKnopp)
//    {
//        String character = "";
//        character = huffKnopp.character.toString();
//        
//        for(char bit : code.toCharArray())
//        {
//
//            if(bit == '0' && huffKnopp.leftChild != null)
//            {    
//                character = decodeCode(code.substring(1), huffKnopp.leftChild);
//            }
//            if(bit == '1' && huffKnopp.rightChild != null)
//            {
//                character = decodeCode(code.substring(1), huffKnopp.rightChild);
//            }
//        }
//        
//        return character;
//    }
}