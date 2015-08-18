package com.epam.memleak.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.memleak.model.Alert;
import com.epam.memleak.model.Entry;
import com.epam.memleak.user.User;

public class AlertsCommand implements Command {

    private static final Logger LOG = LoggerFactory.getLogger(User.class);

    public void execute(final User user) {
        Alert alert = user.getController().getAlerts(user.getEntry());
        user.setAlert(alert);
    }

    public void report(final User user) {
        Alert alert = user.getAlert();
        int id = user.getId();
        Entry entry = user.getEntry();
        if (alert != null) {
            if (alert.isHazard()) {
                LOG.info("User {} reports alert in {} at {} is {}", id, entry.getAddress(), entry.getDate(), alert.getAlert());
            } else {
                LOG.info("User {} reports no alerts in {} at {}", id, entry.getAddress(), entry.getDate());
            }
        } else {
            LOG.info("User {} unable to get alerts in {}", id, entry.getAddress());
        }
        
    }

}
