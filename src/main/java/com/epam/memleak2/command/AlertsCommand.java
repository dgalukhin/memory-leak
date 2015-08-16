package com.epam.memleak2.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.memleak2.model.Alert;
import com.epam.memleak2.model.Entry;
import com.epam.memleak2.user.User;

public class AlertsCommand implements Command {

    private static final Logger LOG = LoggerFactory.getLogger(User.class);

    @Override
    public void execute(User user) {
        Alert alert = user.getController().getAlerts(user.getLocation());
        user.setAlert(alert);
    }

    @Override
    public void report(User user) {
        Alert alert = user.getAlert();
        int id = user.getId();
        Entry location = user.getLocation();
        if (alert != null) {
            if (alert.isHazard()) {
                LOG.info("User {} reports alert in {} at {} is {}", id, location.getAddress(), location.getDate(), alert.getAlert());
            } else {
                LOG.info("User {} reports no alerts in {} at {}", id, location.getAddress(), location.getDate());
            }
        } else {
            LOG.info("User {} unable to get alerts in {}", id, location.getAddress());
        }
        
    }

}
