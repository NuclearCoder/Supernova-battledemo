package supernova.battledemo.models.party;

import supernova.battledemo.models.battle.Battle;
import supernova.battledemo.models.character.allies.Ally;
import supernova.battledemo.models.character.base.Chara;

public class PartyMember {

    private final Chara character;

    private Party party;
    private float wait;

    public PartyMember(final Chara character)
    {
        this.character = character;
        party = null;
    }

    public int getSpeed()
    {
        // TODO: process additional effects here
        return character.getSpeed();
    }

    public void setParty(final Party party)
    {
        this.party = party;
    }

    /**
     * @return true if the turn is over
     */
    public boolean updateTurn(final float delta, final Battle battle)
    {
        wait += delta;
        if (wait >= 1)
        {
            wait = 0;
            return true;
        }
        // TODO: do turn
        return false;
    }

    public boolean isAlly()
    {
        // TODO: change
        return character instanceof Ally;
    }
}
