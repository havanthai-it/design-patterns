package creational.abstract_factory;


public class AbstractFactory {

}

abstract class FurnitureFactory {
    private static final PlasticFactory PLASTIC_FACTORY = new PlasticFactory();
    private static final WoodFactory WOOD_FACTORY = new WoodFactory();

    public static FurnitureFactory getFactory (Material material) {
        FurnitureFactory factory = null;
        switch (material) {
            case WOOD:
                factory = WOOD_FACTORY;
                break;
            case PLASTIC:
                factory = PLASTIC_FACTORY;
                break;
        }
        return factory;
    }

    abstract Chair produceChair();

    abstract Table produceTable();
}

enum Material {
    PLASTIC,
    WOOD
}

class PlasticFactory extends FurnitureFactory {

    @Override
    public Chair produceChair() {
        return new PlasticChair();
    }

    @Override
    public Table produceTable() {
        return new PlasticTable();
    }
}

class WoodFactory extends FurnitureFactory {

    @Override
    public Chair produceChair() {
        return new WoodChair();
    }

    @Override
    public Table produceTable() {
        return new WoodTable();
    }
}

abstract class Table {}

class PlasticTable extends  Table {}

class WoodTable extends  Table {}

abstract  class Chair {}

class PlasticChair extends  Chair {}

class WoodChair extends  Chair {}
