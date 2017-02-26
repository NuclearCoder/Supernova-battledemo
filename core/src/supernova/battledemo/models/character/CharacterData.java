package supernova.battledemo.models.character;

public class CharacterData {

    public int baseMaxHealth;
    public int baseAttack;
    public int baseDefence;
    public int baseStrength;
    public int baseIntelligence;
    public int baseFitness;
    public int baseDexterity;
    public int equipMaxHealth;
    public int equipAttack;
    public int equipDefence;
    public int equipStrength;
    public int equipIntelligence;
    public int equipFitness;
    public int equipDexterity;

    public int updateAttack(double attackModifier)
    {
        return (int) (attackModifier * (double) (this.baseAttack + this.equipAttack));
    }

    public int updateDefence(double defenceModifier)
    {
        return (int) (defenceModifier * (double) (this.baseDefence + this.equipDefence));
    }

    public int updateStrength(double strengthModifier)
    {
        return (int) (strengthModifier * (double) (this.baseStrength + this.equipStrength));
    }

    public int updateIntelligence(double intelligenceModifier)
    {
        return (int) (intelligenceModifier * (double) (this.baseIntelligence
                + this.equipIntelligence));
    }

    public int updateFitness(double fitnessModifier)
    {
        return (int) (fitnessModifier * (double) (this.baseFitness + this.equipFitness));
    }

    public int updateDexterity(double dexterityModifier)
    {
        return (int) (dexterityModifier * (double) (this.baseDexterity + this.equipDexterity));
    }

    public int updateMaxHealth(double maxHealthModifier)
    {
        return (int) (maxHealthModifier * (double) (this.baseMaxHealth + this.equipMaxHealth));
    }

}
