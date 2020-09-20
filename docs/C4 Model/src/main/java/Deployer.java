import com.structurizr.Workspace;
import com.structurizr.api.StructurizrClient;
import com.structurizr.api.StructurizrClientException;

public class Deployer {

    private final LoadCredentials loadCredentials;

    public Deployer() {
        loadCredentials = new LoadCredentials();
    }

    public void deploy(Workspace workspace) throws StructurizrClientException {
        final StructurizrClient structurizrClient = new StructurizrClient(loadCredentials.getApiKey(), loadCredentials.getApiSecret());
        structurizrClient.putWorkspace(loadCredentials.getWorkspaceID(), workspace);
    }

}
