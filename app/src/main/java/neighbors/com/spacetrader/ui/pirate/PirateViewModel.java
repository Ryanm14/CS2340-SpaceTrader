package neighbors.com.spacetrader.ui.pirate;

import android.app.Application;

import java.util.Random;

import neighbors.com.spacetrader.model.SkillType;
import neighbors.com.spacetrader.ui.base.BaseViewModel;

class PirateViewModel extends BaseViewModel {

    /**
     * The view model to be instantiated
     * @param application the application that is running the view model
     */
    public PirateViewModel(Application application) {
        super(application);
    }


    /**
     * Decides the result of running from the pirate
     *
     * @return true if escape false if caught
     */
    public boolean run() {
        int difficulty = repository.getPlayerDifficultyMultiplier();
        int flight = repository.getPlayerSkill(SkillType.PILOT);
        int chance = new Random().nextInt(20);
        if (((flight * chance) / difficulty) > 1) {
            return true;
        }
        int credits = repository.getPlayerCredits();
        int removeCredits = credits / 10;
        repository.removePlayerCredits(removeCredits);
        return false;
    }

    /**
     * Decides the result of fighting the pirate
     *
     * @return true if successful false if fail
     */
    public boolean fight() {
        int difficulty = repository.getPlayerDifficultyMultiplier();
        int fight = repository.getPlayerSkill(SkillType.FIGHTER);
        int chance = new Random().nextInt(20);
        int credits = repository.getPlayerCredits();
        if (((fight * chance) / difficulty) > 1) {
            int addCredits = credits / 10;
            repository.addPlayerCredits(addCredits);
            return true;
        }
        int removeCredits = credits / 10;
        repository.removePlayerCredits(removeCredits);
        return false;
    }

}
