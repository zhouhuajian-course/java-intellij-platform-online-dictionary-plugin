package online.dictionary;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentManager;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class OnlineDctionaryFactory implements ToolWindowFactory {
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        ContentManager contentManager = toolWindow.getContentManager();
        Content content = contentManager.getFactory().createContent(new OnlineDictionaryPanel(),
                                                                    "",
                                                                    true);
        // Content content = contentManager.getFactory().createContent(new JLabel("label123"),
        //                                                             "123",
        //                                                             true);
        // Content content2 = contentManager.getFactory().createContent(new JLabel("label456"),
        //                                                             "456",
        //                                                             false);
        // Content content3 = contentManager.getFactory().createContent(new JLabel("label789"),
        //                                                             "789",
        //                                                             true);
        contentManager.addContent(content);
        // contentManager.addContent(content2);
        // contentManager.addContent(content3);
    }
}
