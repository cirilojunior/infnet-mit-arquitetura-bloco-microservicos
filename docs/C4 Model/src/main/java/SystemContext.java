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
public class SystemContext {

    private final Deployer deployer;
    private final ViewDecorator viewDecorator;
    private final WorkspaceFactory workspaceFactory;

    public static void main(String[] args) throws Exception {
        new SystemContext().build();
    }

    public SystemContext() {
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
        final Person cliente = model.addPerson("Cliente", "Clientes da IT Job Hunters.");
        final Person analista = model.addPerson("Analista", "Analista que participa de processos seletivos.");
        final Person candidato = model.addPerson("´Candidato", "Candidato à vagas.");
        final Person gestor = model.addPerson("Gestor", "Acompanha relatórios e interage com módulos relacionados à contratuais.");

        /**************************************************************************************************************
         * Sistemas
         **************************************************************************************************************/
        final SoftwareSystem jobHunterSystem = model.addSoftwareSystem("Job Hunter System", "Sistema principal da área fim da empresa.");

        /**************************************************************************************************************
         * Relacionamentos
         **************************************************************************************************************/
        cliente.uses(jobHunterSystem, "Solicita, acompanha e aprova Processos Seletivos.");
        analista.uses(jobHunterSystem, "Conduz Processos Seletivos e Contratações.");
        candidato.uses(jobHunterSystem, "Confirma aceitação de vaga caso aprovado.");
        gestor.uses(jobHunterSystem, "Acompanha performance e resultados em relação à Oportunidades geradas e  Processos Seletivos finalizados.");

        jobHunterSystem.delivers(analista, "Informa sobre oportunidades nos clientes.");
        jobHunterSystem.delivers(analista, "Informa sobre possíveis candidatos para oportunidades.");


        /**************************************************************************************************************
         * Visualizações
         **************************************************************************************************************/
        final ViewSet views = workspace.getViews();
        final SystemContextView contextView = views.createSystemContextView(jobHunterSystem, "SystemContext", "Diagrama de Contexto do Sistema.");
        contextView.addAllSoftwareSystems();
        contextView.addAllPeople();
        viewDecorator.decorate(views);

        /**************************************************************************************************************
         * Deploy do modelo
         **************************************************************************************************************/
        deployer.deploy(workspace);
    }

}