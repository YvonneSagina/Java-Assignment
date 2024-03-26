public class Inventory {
    private MenuItem[] Seeds;
    private MenuItem[] Fertilizers;
    private MenuItem[] Tools;

    public Inventory() {
        initialize_Inventory();
    }

    private void initialize_Inventory() {
        Seeds = new MenuItem[] {
                // Category 1: Seeds
                new MenuItem("Carrot Seeds", 5.99, 50),
                new MenuItem("Tomato Seeds", 4.49, 30),
                new MenuItem("Lemon Seeds", 3.99, 40),
                new MenuItem("Corn Seeds", 6.49, 20),
                new MenuItem("Bean Seeds", 4.99, 25)
        };
        Fertilizers = new MenuItem[] {
                // Category 2: Fertilizers
                new MenuItem("Organic Fertilizer", 8.99, 20),
                new MenuItem("Synthetic Fertilizer", 7.49, 15),
                new MenuItem("Liquid Fertilizer", 9.99, 25),
                new MenuItem("Granular Fertilizer", 6.99, 30),
                new MenuItem("Slow-Release Fertilizer", 10.49, 10)
        };
        Tools = new MenuItem[] {
                // Category 3: Tools
                new MenuItem("Shovel", 12.99, 15),
                new MenuItem("Hoe", 10.49, 12),
                new MenuItem("Rake", 8.99, 18),
                new MenuItem("Pruning Shears", 9.49, 20),
                new MenuItem("Watering Can", 7.99, 22)
        };
    }

    public MenuItem[] getSeeds() {
        return this.Seeds;
    }

    public MenuItem[] getFertilizers() {
        return this.Fertilizers;
    }

    public MenuItem[] getTools() {
        return this.Tools;
    }
}
