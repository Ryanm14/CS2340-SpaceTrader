package neighbors.com.spacetrader.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;


public class Repository {

    volatile private static Repository repo;

    private PlayerDao playerDao;
    private Player player;
    private Universe universe;

    private PlanetDao planetDao;
    private SpaceshipDao spaceshipDao;
    private InventoryDao inventoryDao;

    //TODO one big huge database with lots of strings for json and stuff - Ryan type Adapters with gson

    private Repository(Context context) {
        PlayerDatabase db = PlayerDatabase.getInstance(context);
        playerDao = db.playerDao();
        PlanetDatabase db2 = PlanetDatabase.getInstance(context);
        planetDao = db2.planetDao();
        InventoryDatabase db4 = InventoryDatabase.getInstance(context);
        inventoryDao = db4.inventoryDao();
        player = playerDao.getPlayer();
        if (player != null) {
            List<SolarSystem> solarSystems = new ArrayList<>();
            for (Planet allPlanet : planetDao.getAllPlanets()) {
                solarSystems.add(new SolarSystem(allPlanet));
            }
            universe = new Universe(solarSystems);
            player.setCurrentPlanet(planetDao.getPlanetByName(player.getCurrentPlanetName()));
//            player.setInventory(inventoryDao.getInventory());
        } else {
            universe = new Universe();
            savePlanets(universe.getPlanents());
        }

    }

    public static Repository getInstance(Context context) {
        if (repo == null) {
            repo = new Repository(context);
        }
        return repo;
    }

//    public void insert(Planet planet) {
//        planetDao.insert(planet);
//    }

    public void insert(Player player) {
        playerDao.insert(player);
    }

//    public void insert(SolarSystem system) {
//        solarSystemDao.insert(system);
//    }

    public void insert(Planet planet) {
        planetDao.insert(planet);
    }

    //    public void insert(Spaceship spaceship) { spaceshipDao.insert(spaceship);}
    public void insert(Inventory inventory) {
        inventoryDao.insert(inventory);
    }

//    public void update(Planet planet) {
//        planetDao.update(planet);
//    }

    public void update(Player player) {
        playerDao.update(player);
    }

//    public void update(SolarSystem system) {
//        solarSystemDao.update(system);
//    }

    //    public void update(Spaceship spaceship) { spaceshipDao.update(spaceship);}
    public void update(Inventory inventory) {
        inventoryDao.update(inventory);
    }

//    public void delete(Planet planet) {
//        planetDao.delete(planet);
//    }

    public void delete(Player player) {
        playerDao.delete(player);
    }

//    public void delete(SolarSystem system) {
//        solarSystemDao.delete(system);
//    }

    //    public void delete(Spaceship spaceship) { spaceshipDao.delete(spaceship);}
    public void delete(Inventory inventory) {
        inventoryDao.delete(inventory);
    }

    public Player getPlayer() {
        return this.player;
    }

    public Planet getPlanet() {
        return player.getCurrentPlanet();
    }

    public SolarSystem getCurrentSolarSystem() {
        return player.getCurrentSystem();
    }

    public Spaceship getSpaceship() {
        return player.getSpaceship();
    }

    public Inventory getInventory() {
        return player.getInventory();
    }

    public Universe getUniverse() {
        return universe;
    }

    public List<SolarSystem> getSolarSystems() {
        return universe.getSolarSystems();
    }

    public SolarSystem getSolarSystem(String name) {
        if (name == null) {
            return getSolarSystems().get(0);
        }
        for (SolarSystem solarSystem : getSolarSystems()) {
            if (solarSystem.getName().equals(name)) {
                return solarSystem;
            }
        }
        return null;
    }

    public Market getMarket(String name) {
        return getSolarSystem(name).getMarket();
    }

    public void save() {
        insert(player);
        for (SolarSystem solarSystem : getSolarSystems()) {
//            insert(solarSystem);
        }
//        insert(player.getInventory());

    }

    public boolean isFirstTime() {
        return player == null;
    }

    public void savePlayer(Player player) {
        this.player = player;
        insert(player);
    }

    public void savePlanets(List<Planet> planets) {
        for (Planet planet : planets) {
            insert(planet);
        }
    }
}
