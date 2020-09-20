import com.structurizr.Workspace;
import com.structurizr.api.StructurizrClientException;
import com.structurizr.model.*;
import com.structurizr.view.SystemContextView;
import com.structurizr.view.ViewSet;

import java.io.IOException;

/**
 * Modelagem Arquitetural dos serviços do Job Hunter System.
 */
public class Modelo02 {

    private final Deployer deployer;
    private final ViewDecorator viewDecorator;
    private final WorkspaceFactory workspaceFactory;

    public static void main(String[] args) throws Exception {
        new Modelo02().build();
    }

    public Modelo02() {
        workspaceFactory = new WorkspaceFactory();
        viewDecorator = new ViewDecorator();
        deployer = new Deployer();
    }

    void build() throws IOException, StructurizrClientException {

        final Workspace workspace = workspaceFactory.create();

        final Model model = workspace.getModel();
        model.setEnterprise(new Enterprise("IT Job Hunters"));

        final SoftwareSystem jobHunterSystem = createSystem(model);

        final ViewSet views = workspace.getViews();

        createContextView(jobHunterSystem, views);

        viewDecorator.decorate(views);

        deployer.deploy(workspace);
    }

    private void createContextView(SoftwareSystem jobHunterSystem, ViewSet views) {
        final SystemContextView contextView = views.createSystemContextView(jobHunterSystem, "SystemContext", "Diagrama de Contexto.");

        contextView.addAllSoftwareSystems();
        contextView.addAllPeople();
    }

    private SoftwareSystem createSystem(Model model) {

        /**************************************************************************************************************
         * Atores do sistema
         **************************************************************************************************************/
        // Pessoas
        final Person cliente = model.addPerson("Cliente", "Clientes da IT Job Hunters.");
        final Person analista = model.addPerson("Analista", "Analista que participa de processos seletivos.");
        final Person candidato = model.addPerson("´Candidato", "Candidato à vagas.");
        final Person gestor = model.addPerson("Gestor", "Acompanha relatórios e interage com módulos relacionados à contratuais.");
        // Sistemas integrados
        final SoftwareSystem sitePerfil = model.addSoftwareSystem(Location.Internal, "Site de Perfil", "Site de Perfil.");
        final SoftwareSystem siteVaga = model.addSoftwareSystem(Location.Internal, "Site de Vaga", "Site de Vaga.");
        final SoftwareSystem sistemaLegado = model.addSoftwareSystem(Location.Internal, "Legado", "Sistemas Legados.");
        final SoftwareSystem sistemaParceiro = model.addSoftwareSystem(Location.Internal, "Parceiro", "Sistemas Parceiros.");
        final SoftwareSystem iAm = model.addSoftwareSystem(Location.Internal, "I Am", "Sistema de Autenticação e Autorização.");


        /**************************************************************************************************************
         * Sistema
         **************************************************************************************************************/
        final SoftwareSystem jobHunterSystem = model.addSoftwareSystem(Location.Internal, "Job Hunter System", "Sistema principal da área fim da empresa.");

        /**************************************************************************************************************
         * Relacionamentos entre Atores e Sistema
         **************************************************************************************************************/
        // Pessoas
        cliente.uses(jobHunterSystem, "Solicita Vagas, acompanha e aprova Processos Seletivos.");
        analista.uses(jobHunterSystem, "Trabalha Oportunidades que possam gerar Processos Seletivos e Contratações.");
        candidato.uses(jobHunterSystem, "Confirma aceitação de vaga caso aprovado.");
        gestor.uses(jobHunterSystem, "Acompanha performance e resultados em relação à Oportunidades geradas e  Processos Seletivos finalizados.");

        // Sistemas
        jobHunterSystem.delivers(analista, "Possíveis candidatos para que os Analistas conduzam seus Processos Seletivos.");
        jobHunterSystem.delivers(analista, "Oportunidades para que os Analistas possam iniciar ou dar andamento a Processos Seletivos.");
        jobHunterSystem.delivers(analista, "Informações corporativas ainda não migradas para o novo sistema.");
        jobHunterSystem.delivers(analista, "Informações sobre Vagas em aberto.");

        iAm.delivers(cliente, "Autorização");
        iAm.delivers(analista, "Autorização");
        iAm.delivers(candidato, "Autorização");
        iAm.delivers(gestor, "Autorização");

        return jobHunterSystem;
    }

}