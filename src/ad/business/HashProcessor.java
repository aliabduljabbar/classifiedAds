package ad.business;

import java.util.ArrayList;

public class HashProcessor {

    public HashProcessor(){
    }

    public ArrayList<String> process(String description){
        ArrayList<String> hashList = new ArrayList<String>();
        String[] words = description.split(" ");
        for(String word : words){
            if(word.charAt(0) == '#')
                hashList.add(word);
        }

        return hashList;
    }
}
