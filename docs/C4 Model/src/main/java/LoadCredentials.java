import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadCredentials {

    private Integer workspaceID;
    private String apiKey;
    private String apiSecret;

    public LoadCredentials() {
        try {
            load();
        } catch (IOException e) {
            System.out.println("Falha ao ler dados de autenticação");
            e.printStackTrace();
        }
    }

    private void load() throws IOException {
        final Properties credenciais = new Properties();
        try (final InputStream stream = this.getClass().getResourceAsStream("acesso.properties")) {
            credenciais.load(stream);
        }
        workspaceID = Integer.valueOf(credenciais.getProperty("structurizr.workspace.id"));
        apiKey = credenciais.getProperty("structurizr.api.key");
        apiSecret = credenciais.getProperty("structurizr.api.secret");

        if ((workspaceID == null) && (apiKey == null) && (apiSecret == null)) {
            throw new NullPointerException("Informe suas credenciais. Deve-se ter conta no Structurizer!!!");
        }
    }

    public Integer getWorkspaceID() {
        return workspaceID;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getApiSecret() {
        return apiSecret;
    }
}
