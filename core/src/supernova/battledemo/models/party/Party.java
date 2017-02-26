package supernova.battledemo.models.party;

import supernova.battledemo.models.character.base.Chara;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Party {

    private List<PartyMember> party;

    public Party(final List<PartyMember> list)
    {
        party = list;
        party.forEach(m -> m.setParty(this));
    }

    public Party(final PartyMember... party)
    {
        this(Arrays.asList(party));
    }

    public Party(final Chara... party)
    {
        this(Arrays.stream(party).map(PartyMember::new).collect(Collectors.toList()));
    }

    public List<PartyMember> getMembers()
    {
        return party;
    }

    public PartyMember getMember(int index)
    {
        return index < party.size() ? party.get(index) : null;
    }

    public int getSize()
    {
        return party.size();
    }

}
