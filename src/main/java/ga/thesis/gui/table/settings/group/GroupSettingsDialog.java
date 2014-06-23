package ga.thesis.gui.table.settings.group;

import ga.thesis.gui.table.settings.common.AbstractSettingsDialog;
import ga.thesis.gui.table.settings.common.Editor;
import ga.thesis.hibernate.entities.Group;
import ga.thesis.hibernate.service.CRUDService;
import ga.thesis.hibernate.service.PersistenceConfig;

import java.awt.*;

public class GroupSettingsDialog extends AbstractSettingsDialog<Group> {

    public GroupSettingsDialog(Frame owner, SaveListener<Group> saveListener) {
        super(owner, saveListener);
    }

    @Override
    public Editor<Group> getEditor() {
        return new GroupSettingsEditor();
    }

    @Override
    public CRUDService<Group, ?> getService() {
        return PersistenceConfig.getInstance().getGroupService();
    }
}
