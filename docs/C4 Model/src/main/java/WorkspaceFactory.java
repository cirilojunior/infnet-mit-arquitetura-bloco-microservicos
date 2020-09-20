import com.structurizr.Workspace;

public class WorkspaceFactory {

    public Workspace create() {
        final Workspace workspace = new Workspace("Infnet", "Modelagem do Trabalho sobre Microsserviços.");
        return workspace;
    }

}
