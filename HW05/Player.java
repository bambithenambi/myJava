public abstract class Player implements Comparable<Player> {
    private String name;
    private int susLevel;
    private boolean frozen;
    private static Player[] players;

    /**
     * Constructor for Player Objects. Be sure to use this constructor, as it properly populates the players array.
     * The logic in this constructor ensures that players is always full, although frozen players will still be in it.
     * NOTE: Use getPlayers() each time you need it, since the reference will change with every new instance.
     * @param name Name of the player
     * @param susLevel Integer that represents the suspicion level, with higher being more suspicious.
     *                 Negative values will be set to a minimum of 0.
     */
    public Player(String name, int susLevel) {
        this.name = name;
        if (susLevel >= 0) {
            this.susLevel = susLevel;
        } else {
            this.susLevel = 0;
        }
        if (players == null) {
            players = new Player[1];
            players[0] = this;
        } else {
            int length = players.length + 1;
            Player[] temp = players;
            players = new Player[length];
            for (int i = 0; i < temp.length; i++) {
                players[i] = temp[i];
            }
            players[players.length - 1] = this;
        }
    }

    /**
     * This method is an abstract method called emergencyMeeting.
     * This method will be overridden by any child class and will be used to
     * have an emergency meeting.
     */
    public abstract void emergencyMeeting();

    @Override
    public int compareTo(Player p) {
        return (this.getSusLevel()-p.getSusLevel());
    }

    /**
     * This is the equals method which tells you if two Players are equal
     * @param o the other Player that you are comparing
     * @return boolean based on whether or not the two objects are equal
     */
    public boolean equals(Object o) {
        if (o instanceof Player) {
            Player player = (Player) o;
            return this.name.equals(player.name) && this.frozen == player.frozen
                    && this.susLevel == player.susLevel;
        }
        return false;
    }

    /**
     * This method overrides the toString method to specify what will be returned
     * if a specific instance of a Player object is printed out.
     * @return String of the values that we want to print out
     */
    public String toString() {
        String frozenString = frozen ? "frozen" : "not frozen";
        return "My name is " + this.name + ", and I have a susLevel of "
                + this.susLevel + ". I am currently " + frozenString + ".";
    }

    /**
     * This method tells you whether the game is over or not.
     * You will call this method in your frozen and emergencyMeeting methods.
     * @return boolean whether or not the game is over
     */
    public boolean gameOver() {
        int impostorCount = 0;
        int crewmateCount = 0;
        for (Player p : players) {
            if (p instanceof Impostor && !p.frozen) {
                impostorCount++;
            } else if (p instanceof Crewmate && !p.frozen) {
                crewmateCount++;
            }
        }
        if (impostorCount == 0) {
            System.out.println("Crewmates Win!");
            return true;
        } else if (impostorCount >= crewmateCount) {
            System.out.println("Impostors Win!");
            return true;
        }
        return false;
    }
    public String getName() {
        return name;
    }
    public int getSusLevel() {
        return susLevel;
    }
    public void setSusLevel(int susLevel) {
        if (susLevel >= 0) {
            this.susLevel = susLevel;
        } else {
            this.susLevel = 0;
        }
    }
    public boolean isFrozen() {
        return frozen;
    }
    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }
    public static Player[] getPlayers() {
        return players;
    }

}
