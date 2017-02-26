package supernova.battledemo.models.battle;

import supernova.battledemo.models.party.Party;
import supernova.battledemo.models.party.PartyMember;
import supernova.battledemo.utils.CircularList;
import supernova.battledemo.utils.SortedList;

import java.util.Comparator;

public class Battle {

    private final Party allyParty;
    private final Party enemyParty;

    private final SortedList<PartyMember> sortedMembers;

    private int currentRound;
    private int currentTurn;
    private boolean doNextTurn;

    public Battle(final Party allyParty, final Party enemyParty)
    {
        this.allyParty = allyParty;
        this.enemyParty = enemyParty;

        sortedMembers = new SortedList<>(Comparator.comparingInt(PartyMember::getSpeed));
        sortedMembers.addAll(allyParty.getMembers());
        sortedMembers.addAll(enemyParty.getMembers());

        currentRound = 0;
        currentTurn = 0;
        doNextTurn = true;
    }

    public CircularList<PartyMember> getNextTurns()
    {
        return sortedMembers.getCircularList(currentTurn);
    }

    private void updateTurns(final float delta)
    {
        if (doNextTurn)
        {
            doNextTurn = false;
            currentTurn++;
        }
        else if (sortedMembers.get(currentTurn).updateTurn(delta, this))
        {
            doNextTurn = true;
        }

        if (currentTurn == sortedMembers.size())
        {
            currentTurn = 0;
            currentRound++;
        }
    }

    // this is called from BattleScreen#render
    public void update(final float delta)
    {
        updateTurns(delta);
    }

}
