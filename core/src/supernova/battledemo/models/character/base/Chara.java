package supernova.battledemo.models.character.base;

import supernova.battledemo.models.character.CharacterData;

public class Chara {

    // TODO: maybe use Strategy Pattern

    private CharacterData data;

    public Chara(int speed)
    {
        data = new CharacterData();
        data.baseFitness = speed;
    }

    public int getSpeed()
    {
        return data.baseFitness;
    }

}
