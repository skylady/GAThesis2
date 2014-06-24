package ga.thesis.gui.table.settings.groupcode;

import ga.thesis.gui.table.settings.common.AbstractSettingsDialog;
import ga.thesis.gui.table.settings.common.Editor;
import ga.thesis.hibernate.entities.Group;
import ga.thesis.hibernate.entities.GroupCode;
import ga.thesis.hibernate.service.CRUDService;
import ga.thesis.hibernate.service.GroupCodeService;
import ga.thesis.hibernate.service.PersistenceConfig;

import java.awt.*;

public class GroupCodeSettingsDialog extends AbstractSettingsDialog<GroupCode> {

    public GroupCodeSettingsDialog(Frame owner, SaveListener<GroupCode> saveListener) {
        super(owner, saveListener);
    }

    @Override
    public Editor<GroupCode> getEditor() {
        return new GroupCodeSettingsEditor();
    }

    @Override
    public CRUDService<GroupCode, ?> getService() {
        return PersistenceConfig.getInstance().getGroupCodeService();
    }
}
