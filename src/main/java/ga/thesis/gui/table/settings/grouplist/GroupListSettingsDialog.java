package ga.thesis.gui.table.settings.grouplist;

import ga.thesis.gui.table.settings.common.AbstractSettingsDialog;
import ga.thesis.gui.table.settings.common.Editor;
import ga.thesis.hibernate.entities.GroupList;
import ga.thesis.hibernate.service.CRUDService;
import ga.thesis.hibernate.service.PersistenceConfig;

import java.awt.*;

public class GroupListSettingsDialog extends AbstractSettingsDialog<GroupList> {

    public GroupListSettingsDialog(Frame owner, SaveListener<GroupList> saveListener) {
        super(owner, saveListener);
    }

    @Override
    public Editor<GroupList> getEditor() {
        return new GroupListSettingsEditor();
    }

    @Override
    public CRUDService<GroupList, ?> getService() {
        return PersistenceConfig.getInstance().getGroupListService();
    }
}
