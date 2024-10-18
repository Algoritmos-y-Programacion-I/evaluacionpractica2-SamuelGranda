package model;

public class Controller {

    private Pillar[] pillars;

    public Controller() {

        pillars = new Pillar[4];
        pillars[0] = new Pillar("Biodiversidad");
        pillars[1] = new Pillar("Agua");
        pillars[2] = new Pillar("Tratamiento de Basuras");
        pillars[3] = new Pillar("Energía");

    }
    

    /**
     * Descripcion: Permite crear y añadir un Project en un Pillar en el sistema
     * 
     * @return boolean true si se logra añadir el Prject en el Pillar, false en caso
     *         contrario
     */
    public boolean registerProjectInPillar(int pillarType, String id, String name, String description,boolean status) {

        if (pillarType < 0 || pillarType >= pillars.length || pillars[pillarType] == null) {
            return false; 
        }
    
        Project newProject = new Project(id, name, description, status);
        return pillars[pillarType].registerProject(newProject);

    }

    /**
     * Descripcion: Calcula el valor en dinero correspondiente al arrendamiento
     * mensual de todos los Edificios
     * pre: El arreglo edificios debe estar inicializado
     * 
     * @return String cadena en formato lista con la información de los
     * Project registrados en el Pillar
     */
    public String queryProjectsByPillar(String name) {

        int pillarType = getPillarIndex(name);
        if (pillarType == -1) {
            return ""; 
        }

        return pillars[pillarType].getProjectList();
    }

    private int getPillarIndex(String name) {
        for (int i = 0; i < pillars.length; i++) {
            if (pillars[i].getName().equalsIgnoreCase(name)) {
                return i; 
            }
        }
        return 0; 
    }

    public String getPillarList() {
        StringBuilder list = new StringBuilder();
        for (Pillar pillar : pillars) {
            list.append(pillar.getName()).append("\n");
        }
        return list.toString();
    }
}

