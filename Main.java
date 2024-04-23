import com.ahmz.test.tester.MTester;
import view.AppView;

public class Main {
    public static void main(String[] args) throws Exception {
        // Usage 1: For Testing Code with a testcase
        try {
            MTester.initTestcaseConsumer("C:\\Users\\Sam\\IdeaProjects\\pokemon-master\\tests\\",
                    "inputs1\\inputDasti.txt",
                    "outputs1\\outputDasti.txt",
                    "myOut\\myOut1.txt");
        } catch (Exception e) {
            throw e;
            // This occurs when code is judging in quera
            // Therefore, There is no need to remove or comment this section of code when uploading.
        }
        (new AppView()).run();
    }
}
