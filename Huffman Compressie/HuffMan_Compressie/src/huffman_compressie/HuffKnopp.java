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
class HuffKnopp implements Comparable
{
    public Character character;
    public Integer frequency;
    public HuffKnopp leftChild;
    public HuffKnopp rightChild;
    public HuffKnopp parent;
    
    public HuffKnopp(Character character, int frequency)
    {
        this.character = character;
        this.frequency = frequency;
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
            
        if(parent != null)
        {
            output += " | " + parent.toString();
        }
        
        return output;
    }

    @Override
    public int compareTo(Object o2)
    {
        if (((HuffKnopp)o2).frequency < this.frequency)
        {
            return 1;
        }
        else if (((HuffKnopp)o2).frequency > this.frequency)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
}
