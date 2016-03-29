/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman_compressie;

/**
 *
 * @author Milton
 */
class HuffKnopp implements Comparable<HuffKnopp>
{
    public Character character;
    public Integer frequency;
    public HuffKnopp leftChild;
    public HuffKnopp rightChild;
    
    public HuffKnopp(Character character, int frequency)
    {
        this.character = character;
        this.frequency = frequency;
    }
    
    public HuffKnopp(HuffKnopp leftChild, HuffKnopp rightChild)
    {
        character = '*';
        frequency = leftChild.frequency + rightChild.frequency;
        
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
    
    @Override
    public String toString()
    {
        String output = character + " - " + frequency;
        
//        if(leftChild != null)
//        {
//            output += " | " + leftChild.toString();
//        }
//        
//        if(rightChild != null)
//        {
//            output += " | " + rightChild.toString();
//        }
            
        return output;
    }

    @Override
    public int compareTo(HuffKnopp o2)
    {
        return this.frequency - o2.frequency;
    }
}
