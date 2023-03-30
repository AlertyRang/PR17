package com.example.pr17;

import android.content.Context;
import android.widget.Toast;
import java.util.ArrayList;
import io.paperdb.Paper;

public class PaperBDC {

    public ArrayList<Character> getCharacters() {
        return Paper.book("characters").read("characters", new ArrayList<Character>());
    }

    public void saveCharacterList(ArrayList<Character> characters) {
        Paper.book("characters").write("characters", characters);
    }

    public void addCharacter(Character character, Context context) {
        ArrayList<Character> characters = getCharacters();

        for(int i = 0; i < characters.size(); i++) {
            if(characters.get(i).getName_Char().equals(character.getName_Char())) {
                Toast.makeText(context, "Такая персонаж уже существует", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        characters.add(character);
        saveCharacterList(characters);
    }

    public void deleteCharacter(int id) {
        ArrayList<Character> characters = getCharacters();
        characters.remove(id);
        Paper.book("characters").write("characters", characters);
        saveCharacterList(characters);
    }

    public void updateCharacter(Character character , int id) {
        ArrayList<Character> characters = getCharacters();
        characters.set(id, character);
        Paper.book("characters").write("characters", characters);
        saveCharacterList(characters);
    }
}
