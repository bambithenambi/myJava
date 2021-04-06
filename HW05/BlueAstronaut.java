public class BlueAstronaut extends Player implements Crewmate {
    private static final int DEFAULT_SUSLEVEL = 15;
    private static final int DEFAULT_NUMTASKS = 6;
    private static final int DEFAULT_TASKSPEED = 10;
    private int numTasks;
    private int taskSpeed;

    public BlueAstronaut(String name) {
        this(name, DEFAULT_SUSLEVEL, DEFAULT_NUMTASKS, DEFAULT_TASKSPEED);
    }
    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }

    public void emergencyMeeting() {
        Arrays.sort(getPlayers());
        Player[] players = getPlayers();
        for (int i = players.length-1; i>0; i--) {
            if (players[i].isFrozen()==false) {
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
    public void completeTask() {
        if (this.isFrozen() || numTasks==0) {
            return;
        }
        if (taskSpeed>20) {
            numTasks-=2;
        }
        else {
            numTasks-=1;
        }
        if (numTasks<=0) {
            numTasks=0;
            System.out.println("I have completed all my tasks");
            this.setSusLevel((int) (this.getSusLevel()*0.5));
        }
    }
    public boolean equals(Object o) {
        if (o instanceof Crewmate && super.equals(o)) {
            BlueAstronaut p = (BlueAstronaut) o;
            if (numTasks==p.getNumTasks() && taskSpeed==p.getTaskSpeed()) {
                return true;
            }
        }
        return false;
    }
    public String toString() {
        String s = super.toString()+" I have "+numtasks+" left over.";
        if (this.getSusLevel()>15) {
            return s.toUpperCase();
        }
        return s;
    }

    public int getNumTasks() {
        return numTasks;
    }
    public void setNumTasks(int numTasks) {
        if (numTasks<0){
            this.numTasks=0;
        }
        else {
            this.numTasks=numTasks;
        }
    }
    public int getTaskSpeed() {
        return taskSpeed;
    }



}
