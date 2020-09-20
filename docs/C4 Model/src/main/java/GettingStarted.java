import com.structurizr.Workspace;
import com.structurizr.api.StructurizrClient;
import com.structurizr.model.Model;
import com.structurizr.model.Person;
import com.structurizr.model.SoftwareSystem;
import com.structurizr.model.Tags;
import com.structurizr.view.Shape;
import com.structurizr.view.Styles;
import com.structurizr.view.SystemContextView;
import com.structurizr.view.ViewSet;

/**
 * A "getting started" example that illustrates how to
 * create a software architecture diagram using code.
 *
 * The live workspace is available to view at https://structurizr.com/share/25441
 */
public class GettingStarted {

//    private static final long WORKSPACE_ID = 58367;
//    private static final String API_KEY = "a40b5751-9581-4192-b292-8cad976da988";
//    private static final String API_SECRET = "b8eb0e6f-8eee-42ea-baf9-7b785de7ceaa";

//    public static void main(String[] args) throws Exception {
//        // all software architecture models belong to a workspace
//        Workspace workspace = new Workspace("Getting Started", "This is a model of my software system.");
//        Model model = workspace.getModel();
//
//        // create a model to describe a user using a software system
//        Person user = model.addPerson("User", "A user of my software system.");
//        SoftwareSystem softwareSystem = model.addSoftwareSystem("Software System", "My software system.");
//        user.uses(softwareSystem, "Uses");
//
//        // create a system context diagram showing people and software systems
//        ViewSet views = workspace.getViews();
//        SystemContextView contextView = views.createSystemContextView(softwareSystem, "SystemContext", "An example of a System Context diagram.");
//        contextView.addAllSoftwareSystems();
//        contextView.addAllPeople();
//
//        // add some styling to the diagram elements
//        Styles styles = views.getConfiguration().getStyles();
//        styles.addElementStyle(Tags.SOFTWARE_SYSTEM).background("#1168bd").color("#ffffff");
//        styles.addElementStyle(Tags.PERSON).background("#08427b").color("#ffffff").shape(Shape.Person);
//
//        // upload to structurizr.com (you'll need your own workspace ID, API key and API secret)
//        StructurizrClient structurizrClient = new StructurizrClient(API_KEY, API_SECRET);
//        structurizrClient.putWorkspace(WORKSPACE_ID, workspace);
//    }

}