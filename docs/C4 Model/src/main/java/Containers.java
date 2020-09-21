import com.structurizr.Workspace;
import com.structurizr.api.StructurizrClientException;
import com.structurizr.model.Enterprise;
import com.structurizr.model.Model;
import com.structurizr.model.Person;
import com.structurizr.model.SoftwareSystem;
import com.structurizr.view.SystemContextView;
import com.structurizr.view.ViewSet;

/**
 * Modelagem Arquitetural dos serviços do Job Hunter System.
 */
public class Containers {

    private final Deployer deployer;
    private final ViewDecorator viewDecorator;
    private final WorkspaceFactory workspaceFactory;

    public static void main(String[] args) throws Exception {
        new Containers().build();
    }

    public Containers() {
        workspaceFactory = new WorkspaceFactory();
        viewDecorator = new ViewDecorator();
        deployer = new Deployer();
    }

    void build() throws StructurizrClientException {

        final Workspace workspace = workspaceFactory.create();

        final Model model = workspace.getModel();
        model.setEnterprise(new Enterprise("IT Job Hunters"));

        /**************************************************************************************************************
         * Pessoas
         **************************************************************************************************************/
        // Pessoas
        final Person analista = model.addPerson("Analista", "Analista que participa de processos seletivos.");

        /**************************************************************************************************************
         * Sistemas
         **************************************************************************************************************/
        final SoftwareSystem jobHunterSystem = model.addSoftwareSystem("Job Hunter System", "Sistema principal da área fim da empresa.");

        /**************************************************************************************************************
         * Relacionamentos
         **************************************************************************************************************/
        analista.uses(jobHunterSystem, "Cadastra um novo Perfil de Vaga.");

        jobHunterSystem.delivers(analista, "Lista Perfis desejados por Clientes.");
        jobHunterSystem.addContainer("Teste", "teste1", "openshift");
        jobHunterSystem.getContainers()

        /**************************************************************************************************************
         * Visualizações
         **************************************************************************************************************/
        final ViewSet views = workspace.getViews();
        final SystemContextView contextView = views.createSystemContextView(jobHunterSystem, "Container", "Diagrama de Contexto do Sistema.");
        contextView.addAllSoftwareSystems();
        contextView.addAllPeople();
        viewDecorator.decorate(views);

        /**************************************************************************************************************
         * Deploy do modelo
         **************************************************************************************************************/
        deployer.deploy(workspace);
    }

}