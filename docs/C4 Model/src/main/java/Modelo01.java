import com.structurizr.Workspace;
import com.structurizr.api.StructurizrClient;
import com.structurizr.api.StructurizrClientException;
import com.structurizr.model.Model;
import com.structurizr.model.Person;
import com.structurizr.model.SoftwareSystem;
import com.structurizr.model.Tags;
import com.structurizr.view.Shape;
import com.structurizr.view.Styles;
import com.structurizr.view.SystemContextView;
import com.structurizr.view.ViewSet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Modelagem Arquitetural dos serviços do Job Hunter System.
 */
public class Modelo01 {

    private Integer workspaceID;
    private String apiKey;
    private String apiSecret;

    public static void main(String[] args) throws Exception {
        new Modelo01().build();
    }

    void build() throws IOException, StructurizrClientException {

        autentica();

        final Workspace workspace = createWorkspace();

        final Model model = workspace.getModel();

        final SoftwareSystem jobHunterSystem = createSystem(model);

        final ViewSet views = workspace.getViews();

        createContextView(jobHunterSystem, views);

        defineVisualizationStyles(views);

        deploy(workspace);
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
        final SoftwareSystem sitePerfil = model.addSoftwareSystem("Site de Perfil", "Site de Perfil.");
        final SoftwareSystem siteVaga = model.addSoftwareSystem("Site de Vaga", "Site de Vaga.");
        final SoftwareSystem iAm = model.addSoftwareSystem("I Am", "Sistema de Autenticação e Autorização.");
        final SoftwareSystem sistemaLegado = model.addSoftwareSystem("Legado", "Sistemas Legados.");
        final SoftwareSystem sistemaParceiro = model.addSoftwareSystem("Parceiro", "Sistemas Parceiros.");

        /**************************************************************************************************************
         * Sistema
         **************************************************************************************************************/
        final SoftwareSystem jobHunterSystem = model.addSoftwareSystem("Job Hunter System", "Sistema principal da área fim da empresa.");

        /**************************************************************************************************************
         * Relacionamentos entre Atores e Sistema
         **************************************************************************************************************/
        // Pessoas
        cliente.uses(jobHunterSystem, "Solicita Vagas");
        cliente.uses(jobHunterSystem, "Aprova Candidato");

        analista.uses(jobHunterSystem, "Usa");
        candidato.uses(jobHunterSystem, "Usa");
        gestor.uses(jobHunterSystem, "Usa");

        analista.interactsWith(cliente, "Consulta");
        analista.interactsWith(candidato, "Entrevista");
        candidato.interactsWith(analista, "Aceita Vaga");

        gestor.interactsWith(cliente, "Negocia");

        // Sistemas integrados
        sitePerfil.delivers(analista, "Notifica Candidatos");
        siteVaga.delivers(analista, "Notifica Vagas");
        sistemaLegado.delivers(analista, "Informa");
        sistemaParceiro.delivers(analista, "Informa");

        iAm.delivers(cliente, "Autorização");
        iAm.delivers(cliente, "Autorização");
        iAm.delivers(cliente, "Autorização");
        iAm.delivers(cliente, "Autorização");
        iAm.delivers(cliente, "Autorização");
        iAm.delivers(cliente, "Autorização");

        return jobHunterSystem;
    }

    private Workspace createWorkspace() {
        final Workspace workspace = new Workspace("Infnet", "Modelagem do Trabalho sobre Microsserviços.");
        return workspace;
    }

    private void defineVisualizationStyles(ViewSet views) {
        final Styles styles = views.getConfiguration().getStyles();
        styles.addElementStyle(Tags.SOFTWARE_SYSTEM).background("#1168bd").color("#ffffff");
        styles.addElementStyle(Tags.PERSON).background("#08427b").color("#ffffff").shape(Shape.Person);
    }

    private void deploy(Workspace workspace) throws StructurizrClientException {
        final StructurizrClient structurizrClient = new StructurizrClient(apiKey, apiSecret);
        structurizrClient.putWorkspace(workspaceID, workspace);
    }

    private void autentica() throws IOException {
        final Properties credenciais = new Properties();
        try (final InputStream stream = this.getClass().getResourceAsStream("acesso.properties")) {
            credenciais.load(stream);
        }
        workspaceID = Integer.valueOf(credenciais.getProperty("structurizr.workspace.id"));
        apiKey = credenciais.getProperty("structurizr.api.key");
        apiSecret = credenciais.getProperty("structurizr.api.secret");
    }

}