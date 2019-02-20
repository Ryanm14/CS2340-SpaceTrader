package neighbors.com.spacetrader.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Player Model to hold data throughout the game
 */
public class Player {
    public static List<String> legalDifficulty = Arrays.asList
            ("Beginner", "Easy", "Medium", "Hard", "Impossible");
    private String characterName;
    private HashMap<SkillCategory, Integer> skills;
    private Difficulty difficulty;
    private int credits;
    private String spaceship;
    private int availableSkillPoints;

    public Player() {
        skills = new HashMap<>();
        credits = 1000;
        spaceship = "Gnat";
    }


    /**
    All the getter methods for the private fields of the Player class
     */
    public String getCharacterName() {
        return this.characterName;
    }

    public HashMap<SkillCategory, Integer> getSkills() {
        return this.skills;
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    public int getCredits() {
        return this.credits;
    }

    public String getSpaceship() {
        return this.spaceship;
    }

    public int getAvailableSkillPoints() {
        return this.availableSkillPoints;
    }

    /**
    All the setter methods for the private fields of the Player class
     */
    public void setCharacterName(String name) {
        this.characterName = name;
    }

    public void assignSkillPoints(SkillCategory category, int numberOfPoints) {
        skills.put(category, numberOfPoints);
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setSpaceship(String spaceship) {
        this.spaceship = spaceship;
    }

    @Override
    public String toString() {
        return "Player{" +
                "characterName='" + characterName + '\'' +
                ", skills=" + skills +
                ", difficulty=" + difficulty +
                ", credits=" + credits +
                ", spaceship='" + spaceship + '\'' +
                ", availableSkillPoints=" + availableSkillPoints +
                '}';
    }
}
