package store3D.models;

import java.util.ArrayList;
import java.util.List;

public class Scene {
    private static int counter = 0;
    private int id;
    private List<PoligonalModel> models = new ArrayList<>();
    private List<Flash> flashes = new ArrayList<>();
    private List<Camera> cameras = new ArrayList<>();

    {
        id = ++counter;
    }

    public Scene(List<PoligonalModel> models, List<Camera> cameras) {
        this.models = models;
        this.cameras = cameras;
        if (models == null || models.size() == 0) {
            throw new RuntimeException("Модель должна содержать минимум одну позицию.");
        }
        if (cameras == null || cameras.size() == 0) {
            throw new RuntimeException("Камера должна быть минимум одну позицию.");
        }
    }

    public Scene(List<PoligonalModel> models, List<Flash> flashes, List<Camera> cameras) {
        this.models = models;
        this.flashes = flashes;
        this.cameras = cameras;
        if (models == null || models.size() == 0) {
            throw new RuntimeException("Модель должна содержать минимум одну позицию.");
        }
        if (cameras == null || cameras.size() == 0) {
            throw new RuntimeException("Камера должна быть минимум одну позицию.");
        }
    }
}
