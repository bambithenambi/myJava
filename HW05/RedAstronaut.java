public class RedAstronaut extends Player implements Impostor {
    private static final int DEFAULT_SUSLEVEL = 15;
    private static final String DEFAULT_SKILL = "experienced"
    private String skill;

    public RedAstronaut(String name) {
        this(name, DEFAULT_SUSLEVEL, DEFAULT_SKILL)
    }
    public RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);
        this.skill = skill;
    }
    
}
