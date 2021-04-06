import java.util.*;
public class RedAstronaut extends Player implements Impostor {
    private static final int DEFAULT_SUSLEVEL = 15;
    private static final String DEFAULT_SKILL = "experienced";
    private String skill;

    public RedAstronaut(String name) {
        this(name, DEFAULT_SUSLEVEL, DEFAULT_SKILL);
    }
    public RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);
        this.skill = skill;
    }

    public void emergencyMeeting() {
        Arrays.sort(getPlayers());
        Player[] players = getPlayers();
        for (int i = players.length-1; i>0; i--) {
            if (players[i].isFrozen()==false && this.equals(players[i])==false) {
                for (int j = i-1; j>=0; j--) {
                    if (players[j].isFrozen()==false && players[j].getSusLevel()==players[i].getSusLevel()) {
                        return;
                    }
                }
                players[i].setFrozen(true);
                players[i].gameOver();
                return;
            }
        }
    }
    public void freeze(Player p) {
        if (p instanceof Impostor || p.isFrozen()) {
            return;
        }
        if (this.getSusLevel()<p.getSusLevel()){
            p.setFrozen(true);
        }
        else {
            this.setSusLevel(this.getSusLevel()*2);
        }
        p.gameOver();
        return;
    }
    public void sabotage(Player p) {
        if (p instanceof Impostor || this.isFrozen() || p.isFrozen()) {
            return;
        }
        if (this.getSusLevel()<20) {
            p.setSusLevel((int) (p.getSusLevel()*1.5));
        }
        else {
            p.setSusLevel((int) (p.getSusLevel()*1.25));
        }
    }
    public boolean equals(Object o) {
        if (o instanceof Impostor && super.equals(o)) {
            RedAstronaut p = (RedAstronaut) o;
            if (skill==p.getSkill()) {
                return true;
            }
        }
        return false;
    }
    public String toString() {
        String s = super.toString()+" I am an "+skill+" player!";
        if (this.getSusLevel()>15) {
            return s.toUpperCase();
        }
        return s;
    }
}
